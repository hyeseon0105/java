package view;

import dto.ProductDto;
import dto.UserDto;
import repository.AdminRepository;
import repository.ProductRepository;
import repository.VmRepository;
import service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Adminview implements AdminInterface{
    UserDto dto = new UserDto();
    ProductDto productDto = new ProductDto();
    UserService userService = new UserService();
    VmRepository vmRepository = new VmRepository();
    AdminRepository adminRepository = new AdminRepository();
    ProductRepository productRepository = new ProductRepository();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void adminMenu() {
        while (true) {
            System.out.println("=== 관리자 메뉴 ===");
            System.out.println("1. 자판기 관리 2. 회원관리 3. 판매관리 4. 종료");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    vMachine();
                    break;

                }
                case 2 -> {
                    member();
                    break;

                }
                case 3 -> {
                    viewSalesReports();
                    break;

                }
                case 4 -> {
                    System.out.println("관리자 메뉴를 종료합니다.");
                    return;
                }
                default -> {
                    System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
                }
            }
        }

    }

    @Override
    public void vMachine() {
        while (true) {
            System.out.println("=== 관리자 관리 ===");
            System.out.println("1. 입력 2. 수정 3. 삭제 4. 조회 5. 돌아가기");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    addProduct();
                    break;
                }
                case 2 -> {
                    updateProduct();
                    break;
                }
                case 3 -> {
                    deleteProduct();
                    break;
                }
                case 4 -> {
                    viewProduct();
                    break;
                }
                case 5 -> {
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return;
                }default -> System.out.println("잘못된 입력입니다. 다시 입력하세요.");
            }
        }

    }

    @Override
    public void addProduct() {
        System.out.println("제품 추가---.");
        System.out.println("제품 이름 : ");
        String name = scanner.next();
        System.out.println("제품 가격 : ");
        int price = scanner.nextInt();
        System.out.println("제품 재고 : ");
        int stock = scanner.nextInt();

        ProductDto productDto1 = new ProductDto();
        productDto1.setProductName(name);
        productDto1.setPrice(price);
        productDto1.setStock(stock);

        int result = adminRepository.addProduct(productDto1);
        if (result > 0) {
            System.out.println("제품 추가 성공 ^ㅇ^");
        } else {
            System.out.println("제품 추가 실패 ㅠㅇㅠ");
        }
    }

    @Override
    public void updateProduct() {
        System.out.println("[제품 수정]");
        System.out.println("수정할 제품 ID : ");
        int productID = scanner.nextInt();
        ProductDto productDto1 = productRepository.getProductbyId(productID);
        if (productDto1 == null) {
            System.out.println("존재하지 않는 제품입니다.");
            return;
        }
        System.out.println("새로운 이름 : ");
        String name = scanner.next();
        System.out.println("새로운 가격 : ");
        int price = scanner.nextInt();
        System.out.println("새로운 재고 : ");
        int stock = scanner.nextInt();
        productDto1.setProductName(name);
        productDto1.setPrice(price);
        productDto1.setStock(stock);

        int result = adminRepository.updateProduct(productDto1);
        if ((result > 0)) {
            System.out.println("제품 수정 성공 ^ㅁ^");

        } else {
            System.out.println("제품 수정 실패 ㅜㅁㅜ");
        }
    }

    @Override
    public void deleteProduct() {
        System.out.println("[제품 삭제]");
        System.out.println("삭제할 제품 ID : ");
        int productId = scanner.nextInt();
        int result = adminRepository.deleteProduct(productId);
        if (result > 0) {
            System.out.println("제품 삭제 성공 ^ㅅ^");

        } else {
            System.out.println("제품 삭제 실패 ㅠㅅㅠ");
        }
    }

    @Override
    public void viewProduct() {
        System.out.println("[제품 조회]");
        List<ProductDto> productDtoList = productRepository.getAllProduct();
        if (productDtoList.isEmpty()) {
            System.out.println("등록된 제품이 없습니다.");
            return;
        }
        System.out.printf("%-10s %-15s %-10s %-10s%n", "ID", "이름", "가격", "재고");
        for (ProductDto product : productDtoList) {
            System.out.printf("%-10d %-15s %-10d %-10d%n",
                    product.getProductId(), product.getProductName(), product.getPrice(), product.getStock());
        }
    }

    @Override
    public void member() {
        while (true) {
            System.out.println("=== 회원관리 ===");
            System.out.println("1. 회원 입력 2. 회원 수정 3. 회원 삭제 4. 회원 조회 5. 돌아가기");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    addMember();
                    break;
                }
                case 2 -> {
                    updateMember();
                    break;
                }
                case 3 -> {
                    deleteMember();
                    break;

                }
                case 4 -> {
                    viewMember();
                    break;
                }
                case 5 -> {
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return;
                }default -> System.out.println("잘못된 입력입니다. 다시 입력하세요.");
            }
        }

    }

    @Override
    public void addMember() {
        System.out.println("회원 입력---.");
        System.out.println("회원 아이디 : ");
        String id = scanner.next();
        System.out.println("비밀번호 : ");
        String password = scanner.next();
        System.out.println("닉네임 : ");
        String nickname = scanner.next();
        System.out.println("전화번호 : ");
        String phone = scanner.next();
        System.out.println("충전 금액");
        int money = scanner.nextInt();

        UserDto user = new UserDto();
        user.setId(id);
        user.setPassWord(password);
        user.setNickname(nickname);
        user.setPhone(phone);
        user.setMoney(money);
        int result = adminRepository.addMember(user);
        if (result > 0) {
            System.out.println("회원 입력 성공 ><");
        } else {
            System.out.println("회원 입력 실패 ㅡㅡ");
        }
    }

    @Override
    public void updateMember() {
        System.out.println("[회원 수정]");
        System.out.println("수정할 회원 아이디 : ");
        String id = scanner.next();
        UserDto user = vmRepository.getUserById(id);
        if (user == null) {
            System.out.println("존재하지 않는 회원입니다.");
            return;
        }
        System.out.println("새로우 비밀번호 : ");
        String password = scanner.next();
        System.out.println("새로운 닉네임 : ");
        String nickname = scanner.next();
        System.out.println("새로운 전화번호 : ");
        String phone = scanner.next();
        System.out.println("새로운 잔액 : ");
        int money = scanner.nextInt();

        user.setPassWord(password);
        user.setNickname(nickname);
        user.setPhone(phone);
        user.setMoney(money);
        int result = adminRepository.updateMember(user);
        if (result > 0) {
            System.out.println("회원 수정 성공 >0<");

        } else {
            System.out.println("회원 수정 실패 -0-");
        }
    }

    @Override
    public void deleteMember() {
        System.out.println("[회원 삭제]");
        System.out.println("삭제할 회원 아이디 : ");
        String id = scanner.next();
        int result = adminRepository.deleteMember(id);
        if (result > 0) {
            System.out.println("회원 삭제 성공 !!");
        } else {
            System.out.println("회원 삭제 실패 !!");
        }
    }

    @Override
    public void viewMember() {
        System.out.println("[회원 조회]");
        List<UserDto> members = adminRepository.getAllMember();
        if (members.isEmpty()) {
            System.out.println("등록된 회원이 없습니다.");
            return;
        }
        System.out.printf("%-15s %-15s %-15s %-10s %-10s%n", "아이디", "닉네임", "전화번호", "충전금", "잔액");
        for (UserDto member : members) {
            System.out.printf("%-15s %-15s %-15s %-10d%n",
                    member.getId(),member.getNickname(),member.getPhone(),member.getMoney());
        }
    }

    @Override
    public void viewSalesReports() {
        System.out.println("=== 판매 관리 ===");
        System.out.println("1. 제품별 판매현황 2. 회원별 판매현황 3. 돌아가기");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                viewProductSales();
                break;
            }
            case 2 -> {
                viewMemberSales();
                break;
            }
            case 3 -> {
                System.out.println("판매 관리 메뉴를 종료합니다.");
                return;

            }
            default -> System.out.println("잘못된 입력입니다. 다시 입력하세요.");


        }


    }
    @Override
    public void viewProductSales () {
        System.out.println("[제품별 판매현황]");
        List<Map<String, Object>> sales = adminRepository.getProductSales();
        if (sales.isEmpty()) {
            System.out.println("제품별 판매현황 데이터가 없습니다.");
        } else {
            System.out.printf("%-15s %-15s %-15s%n", "제품명", "판매수량", "판매금액");
            for (Map<String, Object> sale : sales) {
                System.out.printf("%-15s %-15d %-15d%n",
                        sale.get("제품명"), sale.get("판매수량"), sale.get("판매금액"));
            }
        }
    }

    @Override
    public void viewMemberSales () {
        System.out.println("[회원별 판매현황]");
        List<Map<String, Object>> sales = adminRepository.getMemberSales();

        if (sales.isEmpty()) {
            System.out.println("회원별 판매현황 데이터가 없습니다.");
        } else {
            System.out.printf("%-15s %-15s %-15s %-10s%n", "아이디", "닉네임", "구매금액", "잔액");
        }
        for (Map<String, Object> sale : sales) {
            String userId = (String) sale.get("회원아이디");
            String nickname = (String) sale.get("회원명");
            Integer purchaseAmount = (Integer) sale.get("구매금액");
            Integer balance = (Integer) sale.get("충전잔액");

            System.out.printf("%-15s %-15s %-15d %-10d%n",
                    (userId != null ? userId : "정보 없음"),
                    (nickname != null ? nickname : "정보 없음"),
                    (purchaseAmount != null ? purchaseAmount : 0),
                    (balance != null ? balance : 0));
        }

    }
}
