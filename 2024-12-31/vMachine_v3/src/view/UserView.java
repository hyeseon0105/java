package view;

import dto.ProductDto;
import dto.UserDto;
import repository.AdminRepository;
import repository.ProductRepository;
import repository.VmRepository;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserView implements UserInterface {
    UserDto dto = new UserDto();
    Scanner scanner = new Scanner(System.in);
    UserService userService = new UserService();
    VmRepository vmRepository = new VmRepository();
    AdminRepository adminRepository = new AdminRepository();
    ProductRepository productRepository = new ProductRepository();
    Adminview adminview = new Adminview();

    @Override
    public void signUp() {
        System.out.println("=== 회원가입 ===");
        System.out.println("가입하실 아이디 입력하세요 : ");
        String id = scanner.next();
        dto.setId(id);

        System.out.println("가입하실 비밀번호를 입력하세요 :");
        String passWord = scanner.next();
        dto.setPassWord(passWord);

        System.out.println("가입하실 닉네임을 입력하세요 :");
        String nickname = scanner.next();
        dto.setNickname(nickname);

        System.out.println("가입하실 전화번호를 입력하세요 :");
        String phone = scanner.next();
        dto.setPhone(phone);

        int result = userService.signUpService(dto);

        if (result > 0) {
            System.out.println("자료가 저장되었습니다.");
        } else {
            System.out.println("실패했습니다. 관리자에게 문의하세요.");
        }


    }

    @Override
    public void login() {
        System.out.println("=== 로그인 창 ===");
        System.out.println("아이디를 입력하세요 : ");
        String id = scanner.next();
        System.out.println("비밀번호를 입력하세요 : ");
        String passWord = scanner.next();

        if (userService.isadmin(id, passWord)) {
            System.out.println("관리자 계정으로 로그인 성공 ☆ ");
            adminview.adminMenu();
            return;
        }
        if (userService.validateUser(id, passWord)) {
            System.out.println("로그인 성공 ★");
            userMenu(id);
            return;
        }
        System.out.println("회원정보를 찾을 수 없습니다. 회원가입을 진행합니다.");
        signUp();

    }



    @Override
    public void userMenu(String userid) {
        while (true) {
            System.out.println("=== 메뉴 ===");
            System.out.println("1. 금액충전 2. 메뉴선택 3. 잔돈반환 4. 로그아웃 ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("충전 할 금액을 입력하세요. (천원 단위)");
                    int money = scanner.nextInt();
                    boolean success = userService.rechange(userid, money);
                    if (!success) {
                        System.out.println("충전이 실패하였습니다. 다시 시도해주세요. ");
                    }
                    break;
                }
                case 2 -> {
                    viewProducts();
                    purchaseProduct(userid);
                    break;
                }
                case 3 -> {
                    System.out.println("잔돈 반환을 진행합니다.");
                    int change = userService.returnchange(userid);
                    System.out.println("반환된 잔돈 : " + change + "원");
                    break;

                }
                case 4 -> {
                    System.out.println("로그아웃 되었습니다.");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
        }
    }

    @Override
    public void viewProducts() {
        System.out.println("=== 제품 목록 ===");
        List<ProductDto> productDtoList = userService.getAllProduct();
        for (ProductDto product : productDtoList) {
            System.out.printf("ID: %d | 이름: %s | 가격 %d원 | 재고: %d개%n",
             product.getProductId(), product.getProductName(), product.getPrice(), product.getStock());
        }

    }

    @Override
    public void purchaseProduct(String userId) {
        System.out.print("구매할 제품 ID를 입력하세요: ");
        int productId = scanner.nextInt();
        boolean result = userService.purchaseProduct(userId, productId);
    }
}
