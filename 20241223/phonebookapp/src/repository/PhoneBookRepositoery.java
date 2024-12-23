package repository;

import db.DBConn;
import dto.SearchResultDTO;
import dto.TelBookDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneBookRepositoery implements RepositoryInterface{
    int result = 0;
    Connection dbConn = DBConn.getConnection();
    PreparedStatement psmt = null;
    String sql;

    @Override
    public int insertData(TelBookDTO dto) {
     //   System.out.println("[PhoneBookRepositoery]-insertData");
        //db에 저장하기
        try {
            sql = "INSERT INTO phone_book(name, age, address, phone, created_at)";
            sql = sql + "VALUES (?,?,?,?,?)";
            psmt = dbConn.prepareStatement(sql);
            //전달할 인가값을 psmt에 추가
            psmt.setString(1,dto.getName());
            psmt.setInt(2,dto.getAge());
            psmt.setString(3, dto.getAddress());
            psmt.setString(4, dto.getPhone());
            psmt.setTimestamp(5, Timestamp.valueOf(dto.getCreatedAt()));
            //db에 저장요청
           return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int updateData(TelBookDTO dto) {
       // System.out.println("[PhoneBookRepositoery]-updateData");
        //수정 작업
        sql = "UPDATE phone_book SET ";
        sql = sql + "name = ?, ";
        sql = sql + "age = ?, ";
        sql = sql + "address = ?, ";
        sql = sql + "phone = ?, ";
        sql = sql + "created_at = ?, ";
        sql = sql + "updated_at = ? ";
        sql = sql + "WHERE id = ? ";

        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1,dto.getName());
            psmt.setInt(2,dto.getAge());
            psmt.setString(3,dto.getAddress());
            psmt.setString(4,dto.getPhone());
            psmt.setTimestamp(5,
                    Timestamp.valueOf(dto.getCreatedAt()));
            psmt.setTimestamp(6,Timestamp.valueOf(dto.getUpdateAt()));
            psmt.setLong(7, dto.getId());
            result = psmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteData(long id) {
      //  System.out.println("[PhoneBookRepositoery]-deleteData");
        sql = "DELETE FROM phone_book WHERE id =?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setLong(1,id);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<TelBookDTO> getAllList() {
      //  System.out.println("[PhoneBookRepositoery]-getAllList");
        List<TelBookDTO> dtolist = new ArrayList<>();

        ResultSet rs = null;
        try {
            sql = "SELECT * FROM phone_book ORDER BY id ASC";
            psmt = dbConn.prepareStatement(sql);
            //쿼리 실행해야 할 결과 > resultset
            rs = psmt.executeQuery();
            //restltset의 내용을 하나씩 읽어서 dtolist에 담는다.
            while (rs.next()) {
                //resultset에 있는 레코드를 하나씩 읽어서 담을 dto
                TelBookDTO dto = new TelBookDTO();
                //레코드를 하나씩 읽어서 dto에 담는 직업
                dto.setId(rs.getLong("id"));
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getInt("age"));
                dto.setPhone(rs.getString("phone"));
                dto.setAddress(rs.getString("address"));
                dto.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                if (rs.getTimestamp("updated_at") != null) {
                    dto.setUpdateAt(rs.getTimestamp("updated_at").toLocalDateTime());
                }
                //담는 dto 리스트에 담는다
                dtolist.add(dto);
            }
            //resultSet닫기
            rs.close();
            //preparedStatement담기
            psmt.close();
        } catch (Exception e) {
         e.printStackTrace();
        }

        return dtolist;
    }

    @Override
    public TelBookDTO findById(Long id) {
       // System.out.println("[PhoneBookRepositoery]-findById");
        TelBookDTO dto = new TelBookDTO();
        ResultSet rs = null;
        sql = "SELECT * FROM phone_book WHERE id = ?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setLong(1,id);
            rs = psmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    dto.setId(rs.getLong("id"));
                    dto.setName(rs.getString("name"));
                    dto.setAge(rs.getInt("age"));
                    dto.setAddress(rs.getString("address"));
                    dto.setPhone(rs.getString("phone"));
                    dto.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                    if (rs.getTimestamp("updated_at")!= null) {
                        dto.setUpdateAt(rs.getTimestamp("updated_at").toLocalDateTime());

                    }
                }
            }
            return dto;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<SearchResultDTO> findByName(String name) {
      //  System.out.println("[PhoneBookRepositoery]-findByName");
        List<SearchResultDTO> dtoList = new ArrayList<>();


        sql = "SELECT name, age, address, phone FROM phone_book WHERE ";
        sql = sql + "name LIKE CONCAT('%',?,'%') ";
        sql = sql + "ORDER BY name ASC ";
        ResultSet rs = null;
        String searchName = "";
        int searchAge = 0;
        String searchAddress = "";
        String searchPhone = "";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, name);
            rs = psmt.executeQuery();
            /// 읽어온 reustset를 하나씪 읽어 리스트에 담기
            while (rs.next()) {
                searchName = rs.getString("name");
                searchAge = rs.getInt("age");
                searchAddress = rs.getString("address");
                searchPhone = rs.getString("phone");
                //생성자를 이용해서 dto를 생성 후
                //리스트에 추가
                dtoList.add(new SearchResultDTO(
                        searchName,
                        searchAge,
                        searchAddress,
                        searchPhone
                ));
            }
            rs.close();
            psmt.close();
            return dtoList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public List<SearchResultDTO> findByphone(String phone) {
      //  System.out.println("[PhoneBookRepositoery]-findByphone");
        List<SearchResultDTO> list = new ArrayList<>();

        sql = "SELECT name, age, address, phone FROM phone_book ";
        sql = sql + "WHERE phone LIKE CONCAT('%',?,'%') ";
        sql = sql + "ORDER BY phone";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, phone);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                String searchName = rs.getString("name");
                int searchAge = rs.getInt("age");
                String searchAddress = rs.getString("address");
                String searchphone = rs.getString("phone");
                list.add(new SearchResultDTO(
                        searchName,
                        searchAge,
                        searchAddress,
                        searchphone
                ));
            }
            rs.close();
            psmt.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
