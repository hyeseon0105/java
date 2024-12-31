package repository;

import db.DBcon;
import dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VmRepository implements VmRepositoryInterface {
    int result = 0;
    PreparedStatement psmt = null;
    Connection dbcon = DBcon.getConnection();
    String sql;

    @Override
    public int signUpData(UserDto dto) {
       try {
           String sql = "INSERT INTO user (u_id, password, nickname, phone) VALUES (?, ?, ?, ?)";
           psmt = dbcon.prepareStatement(sql);
           psmt.setString(1, dto.getId());
           psmt.setString(2, dto.getPassWord());
           psmt.setString(3, dto.getNickname());
           psmt.setString(4, dto.getPhone());
           return psmt.executeUpdate();

       } catch (SQLException e) {
           e.printStackTrace();
       }
        return 0;

    }

    @Override
    public UserDto getUserById(String id) {
        String sql = "SELECT * FROM user WHERE u_id = ?";
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            psmt.setString(1, id);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                UserDto user= new UserDto();
                user.setId(rs.getNString("u_id"));
                user.setPassWord(rs.getNString("password"));
                user.setNickname(rs.getNString("nickname"));
                user.setPhone(rs.getString("phone"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateUser(String userid, int money) {
        String sql = "UPDATE user SET money = money + ? WHERE u_id = ?";
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            psmt.setInt(1, money);
            psmt.setString(2, userid);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public int updateUserBalance(String userId, int money) {
        String sql = "UPDATE user SET money = 0 WHERE u_id =?";
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            psmt.setString(1, userId);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getUserBalance(String userId) {
        String sql = "SELECT money FROM user WHERE u_id = ?";
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            psmt.setString(1, userId);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("money");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
