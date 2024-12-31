package repository;

import dto.ProductDto;
import dto.UserDto;

import java.util.List;
import java.util.Map;

public interface AdminInterface {
    int addProduct(ProductDto productDto);

    int updateProduct(ProductDto productDto);

    int deleteProduct(int productId);

    List<ProductDto> getAllProduct();

    int addMember(UserDto user);

    int updateMember(UserDto userDto);

    int deleteMember(String userId);

    List<UserDto> getAllMember();

    List<Map<String, Object>> getProductSales();

    List<Map<String, Object>> getMemberSales();

    int savePurchaseRecord(String userId, int productId, int price);

    boolean recordPurchase(String userId, int productId, int purchasePrice);
}
