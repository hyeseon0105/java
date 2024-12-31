package service;

import dto.ProductDto;
import dto.UserDto;
import repository.AdminRepository;
import repository.ProductRepository;
import repository.VmRepository;

import java.util.List;

public class UserService implements UserInterface {
    VmRepository vmRepository = new VmRepository();
    ProductRepository productRepository = new ProductRepository();
    AdminRepository adminRepository = new AdminRepository();

    private final String ADMIN_ID = "admin";
    private final String ADMIN_PASSWORD = "admin123";

    @Override
    public int signUpService(UserDto dto) {
        return vmRepository.signUpData(dto);
    }

    @Override
    public boolean isadmin(String id, String password) {
        return ADMIN_ID.equals(id) && ADMIN_PASSWORD.equals(password);
    }

    @Override
    public boolean validateUser(String id, String password) {
        UserDto user = vmRepository.getUserById(id);
        return user != null && user.getPassWord().equals(password);
    }

    @Override
    public boolean rechange(String userid, int money) {
        if (money <= 0 || money % 1000 != 0) {
            System.out.println("충전 금액은 양수이고 천원 단위이어야 합니다. ");
            return false;
        }
        int result = vmRepository.updateUser(userid, money);
        if (result > 0) {
            System.out.println("충전 성공 ★ 충천 금액 : " + money + "원");
            return true;
        } else {
            System.out.println("충전 실패, 관리자에게 문의하세요. ");
            return false;
        }
    }

    @Override
    public boolean purchaseProduct(String userId, int productId) {
        ProductDto product = productRepository.getProductbyId(productId);
        if (product == null) {
            System.out.println("유효하지 않은 제품 ID 입니다. ");
            return false;
        }
        if (product.getStock() <= 0) {
            System.out.println("해당 제품의 재고가 부족합니다. ");
            return false;
        }
        if (productRepository.deductUserBalance(userId, product.getPrice()) == 0) {
            System.out.println("충전 금액이 부족합니다. 충전 후 다시 시도해주세요.");
            return false;
        }
        if (productRepository.updateProductStock(productId, 1) > 0) {
            System.out.println("구매완료 ★ 구매한 제품 : " + product.getProductName());
            adminRepository.savePurchaseRecord(userId, productId, product.getPrice());
            // sales table 구매 내역 저장
            return true;
        }
        return false;
    }

    @Override
    public int returnchange(String userId) {
        int currentBalance = vmRepository.getUserBalance(userId);
        System.out.println("조회된 현재 잔액 : " +currentBalance);
        int result = vmRepository.updateUserBalance(userId, - currentBalance);
        if (result > 0) {
            System.out.println("잔돈" + currentBalance + "원이 반환되었습니다");

        } else {
            System.out.println("잔돈 반환 실패. 관리자에게 문의하세요.");
        }
        return currentBalance;
    }

    @Override
    public List<ProductDto> getAllProduct() {
        return productRepository.getAllProduct();
    }
}
