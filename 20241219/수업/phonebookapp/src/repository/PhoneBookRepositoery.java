package repository;

import db.DBConn;
import dto.TelBookDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookRepositoery implements RepositoryInterface{
    int result = 0;
    Connection dbConn = DBConn.getConnection();
    PreparedStatement psmt = null;
    String sql;

    @Override
    public int insertData(TelBookDTO dto) {
        System.out.println("[PhoneBookRepositoery]-insertData");

        return 0;
    }

    @Override
    public int updateData(TelBookDTO dto) {
        System.out.println("[PhoneBookRepositoery]-updateData");
        return 0;
    }

    @Override
    public int deleteData(long id) {
        System.out.println("[PhoneBookRepositoery]-deleteData");
        return 0;
    }

    @Override
    public List<TelBookDTO> getAllList() {
        System.out.println("[PhoneBookRepositoery]-getAllList");
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
                dto.setAddres(rs.getString("address"));
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
        System.out.println("[PhoneBookRepositoery]-findById");
        return null;
    }

    @Override
    public List<TelBookDTO> findByName(String name) {
        System.out.println("[PhoneBookRepositoery]-findByName");
        return List.of();
    }

    @Override
    public List<TelBookDTO> findByphone(String phone) {
        System.out.println("[PhoneBookRepositoery]-findByphone");
        return List.of();
    }
}
