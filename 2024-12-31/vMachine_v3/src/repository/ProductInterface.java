package repository;

import dto.ProductDto;

import java.util.List;

public interface ProductInterface {
    List<ProductDto> getAllProduct();

    public ProductDto getProductbyId(int productId);

    public int updateProductStock(int productId, int quantity);

    public int decreaseProductStock(int productId);

    public int deductUserBalance(String userId, int money);
}
