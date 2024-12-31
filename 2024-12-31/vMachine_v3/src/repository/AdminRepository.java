package repository;

import db.DBcon;
import dto.ProductDto;
import dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminRepository implements AdminInterface {
    Connection dbcon = DBcon.getConnection();

    @Override
    public int addProduct(ProductDto productDto) {
        String sql = "INSERT INTO product (p_name, p_price, p_stock) VALUES(?, ?, ?)";
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            psmt.setString(1, productDto.getProductName());
            psmt.setInt(2, productDto.getPrice());
            psmt.setInt(3, productDto.getStock());
            return psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateProduct(ProductDto productDto) {
        String sql = "UPDATE product SET p_name = ?, p_price = ?, p_stock = ? WHERE p_id = ?";
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            psmt.setString(1, productDto.getProductName());
            psmt.setInt(2, productDto.getPrice());
            psmt.setInt(3, productDto.getStock());
            psmt.setInt(4, productDto.getProductId());
            return psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteProduct(int productId) {
        String sql = "DELETE FROM product WHERE p_id = ?";
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            psmt.setInt(1, productId);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<ProductDto> getAllProduct() {
        String sql = "SELECT * FROM product";
        List<ProductDto> productDtoList = new ArrayList<>();
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                ProductDto productDto = new ProductDto();
                productDto.setProductId(rs.getInt("p_id"));
                productDto.setProductName(rs.getString("p_name"));
                productDto.setPrice(rs.getInt("p_price"));
                productDtoList.add(productDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productDtoList;
    }

    @Override
    public int addMember(UserDto user) {
        String sql = "INSERT INTO USER (u_id, password, nickname, phone, money) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            psmt.setString(1, user.getId());
            psmt.setString(2, user.getPassWord());
            psmt.setString(3, user.getNickname());
            psmt.setString(4, user.getPhone());
            psmt.setInt(5, user.getMoney());
            return psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateMember(UserDto user) {
        String sql = "UPDATE user SET password = ?, nickname = ?, phone = ?, money = ? WHERE u_id = ?";
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            psmt.setString(1, user.getPassWord());
            psmt.setString(2, user.getNickname());
            psmt.setString(3, user.getPhone());
            psmt.setInt(4, user.getMoney());
            psmt.setString(5, user.getId());
            return psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public int deleteMember(String userId) {
        String sql = "DELETE FROM user WHERE u_id = ?";
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            psmt.setString(1, userId);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<UserDto> getAllMember() {
        String sql = "SELECT * FROM user";
        List<UserDto> userDto = new ArrayList<>();
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                UserDto user = new UserDto();
                user.setId(rs.getString("u_id"));
                user.setPhone(rs.getString("phone"));
                user.setNickname(rs.getString("nickname"));
                user.setMoney(rs.getInt("money"));
                userDto.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDto;
    }

    @Override
    public List<Map<String, Object>> getProductSales() {
        String sql = "SELECT p.p_name AS 제품명, COUNT(s.p_id) AS 판매수량, SUM(s.s_price) AS 판매금액 " +
                "FROM sales s " +
                "JOIN product p ON s.p_id = p.p_id " +
                "GROUP BY s.p_id";
        List<Map<String, Object>> salesData = new ArrayList<>();
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("제품명", rs.getString("제품명"));
                row.put("판매수량", rs.getInt("판매수량"));
                row.put("판매금액", rs.getInt("판매금액"));
                salesData.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return salesData;
    }

    @Override
    public List<Map<String, Object>> getMemberSales() {
        String sql = "SELECT u.u_id AS 회원아이디, u.nickname AS 회원명, \n" +
                "       SUM(s.s_price) AS 구매금액, u.money AS 충전잔액\n" +
                "FROM sales s\n" +
                "LEFT JOIN user u ON s.u_id = u.u_id\n" +
                "GROUP BY s.u_id;";
        List<Map<String, Object>> memberSales = new ArrayList<>();
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("회원아이디", rs.getString("회원아이디"));
                row.put("회원명", rs.getString("회원명"));
                row.put("구매금액", rs.getInt("구매금액"));
                row.put("충전잔액", rs.getInt("충전잔액"));
                memberSales.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberSales;

    }

    @Override
    public int savePurchaseRecord(String userId, int productId, int price) {
        String sql = "INSERT INTO sales (u_id, p_id, s_price, sale_date) " +
                "VALUES (?, ?, ?, NOW())";

        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {

            psmt.setString(1, userId);
            psmt.setInt(2, productId);
            psmt.setInt(3, price);
            return psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean recordPurchase(String userId, int productId, int purchasePrice) {
        String sql = "INSERT INTO sales (u_id, p_id, s_price, sale_date) " +
                "VALUES (?, ?, ?, CURRENT_DATE)";

        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            psmt.setString(1, userId);
            psmt.setInt(2, productId);
            psmt.setInt(3, purchasePrice);

            int rowsAffected = psmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("구매 기록이 저장되었습니다.");
                return true;
            } else {
                System.out.println("구매 기록 저장에 실패했습니다.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    }

