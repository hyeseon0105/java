package repository;

import db.DBcon;
import dto.ProductDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements ProductInterface{
    Connection dbcon = DBcon.getConnection();

    @Override
    public List<ProductDto> getAllProduct() {
        String sql = "SELECT * FROM product";
        List<ProductDto> productList = new ArrayList<>();
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                ProductDto product = new ProductDto();
                product.setProductId(rs.getInt("P_id"));
                product.setProductName(rs.getString("p_name"));
                product.setPrice(rs.getInt("p_price"));
                product.setStock(rs.getInt("p_stock"));
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public ProductDto getProductbyId(int productId) {
        String sql = "SELECT * FROM product WHERE p_id = ?";
        try (
                PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            psmt.setInt(1, productId);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                ProductDto product = new ProductDto();
                product.setProductId(rs.getInt("p_id"));
                product.setProductName(rs.getString("p_name"));
                product.setPrice(rs.getInt("p_price"));
                product.setStock(rs.getInt("p_stock"));
                return product;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateProductStock(int productId, int quantity) {
        String sql = "UPDATE product SET p_stock = p_stock - ? WHERE p_id = ? AND p_stock >=?";
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            psmt.setInt(1, quantity); // 차감할 재고
            psmt.setInt(2, productId); // 제품 ID
            psmt.setInt(3, quantity);// 재고가 충분할 때만 차감
            int updated = psmt.executeUpdate();
            if (updated == 0) {
                System.out.println("재고가 부족하거나 제품 ID가 유효하지 않습니다" + productId);
            }
            return updated;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int decreaseProductStock(int productId) {
        String sql = "UPDATE product SET p_stock = p_stock -1 WHERE p_id = ? AND p_stock >0";
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            psmt.setInt(1, productId);
            return psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deductUserBalance(String userId, int money) {
        String sql = "UPDATE user SET money = money -? WHERE u_id = ? AND money >=?";
        try (PreparedStatement psmt = dbcon.prepareStatement(sql)) {
            psmt.setInt(1, money);
            psmt.setString(2, userId);
            psmt.setInt(3, money);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
