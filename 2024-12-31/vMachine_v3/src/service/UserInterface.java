package service;

import dto.ProductDto;
import dto.UserDto;

import java.util.List;

public interface UserInterface {

    int signUpService(UserDto dto) ;

    public boolean isadmin(String id, String password);

    public boolean validateUser(String id, String password);

    public boolean rechange(String userid, int money);

    public boolean purchaseProduct(String userId, int productId);

    public int returnchange(String userId);

    public List<ProductDto> getAllProduct();

}

