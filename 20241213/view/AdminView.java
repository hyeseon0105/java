package view;

import service.AdminSernice;
import vo.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminView {

     AdminSernice adminSernice = new AdminSernice() ;

    Scanner scanner = new Scanner(System.in);



    public void insertMenu() {
        //비어있는 product 하나 생성
       // Product product = new Product();
        String item;
        int price;
        int stock;

        System.out.println("자판기 메뉴등록");
        System.out.println("제품 이름을 입력하세요.");
        item = scanner.next();
        System.out.println("제품의 가격?(숫자만 입력)");
        price = scanner.nextInt();
        System.out.println("제고 등록 (채울개수)");
        stock = scanner.nextInt();
//        product.setItem(item);
//        product.setPrice(price);
//        product.setStock(stock);
        Product product = new Product(item, price, stock);
        adminSernice.insertItem(product);


    }

    public void deleteMenu() {
        //삭제하기 전 목록확인
        viewAllList();

        System.out.println("삭제할 제품명 입력 : ");
        String itemName = scanner.next();
        boolean result = adminSernice.deldtdItem(itemName);
        //삭제 성공 혹은 실패처리
        if (result) {
            System.out.println("삭제 완료");
        } else {
            System.out.println("삭제 실패");
        }
        viewAllList();
    }

    public void updateMenu() {

        System.out.println("수정 할 제품명 입력");
        String item = scanner.next();

        //수정할 제품이 있는지 먼저 검사
        int index = adminSernice.existItem(item);
        if (index == -1) {
            System.out.println("수정할 제품이 없습니다.");
            return;
        } else {
            System.out.println("(수정) 메뉴 이름 ?");
            String newItem = scanner.next();
            System.out.println("(수정) 메뉴 가격 ?(숫자만 입력)");
            int newprice = scanner.nextInt();
            System.out.println("(수정) 재고 수량 ?(숫자만 입력)");
            int newstock = scanner.nextInt();

            Product newproduct = new Product(newItem, newprice, newstock);
            adminSernice.updateItem(index, newproduct);
            System.out.println("수정완료");
            viewAllList();
        }
    }

    public void updateStock() {
        viewAllList();
        System.out.println("재고를 수정 할 제품명 입력");
        String itemName = scanner.next();
        System.out.println("(수정) 재고수량? (숫자만 입력)");
        int updateStock = scanner.nextInt();

        boolean result = adminSernice.updateStock(itemName,updateStock);
        if (result) {
            System.out.println("재고가 수정되었습니다.");
            viewAllList();
        } else {
            System.out.println("재고 수정 실패하였습니다.");
        }
    }

    public void viewAllList() {
        List<Product> productList = new ArrayList<>();

       printHeader();
        //출력
        //1.서비스에 전체 리스트 요청
         productList = adminSernice.getAllList();
         //2. 상품 리스트가 비어있을 경우
        if (productList.size() == 0) {
            System.out.println("현재 자판기에 상품이 없습니다.");
        } else {
            //3.받은 리스트를 출력
            for (Product x : productList) {
                System.out.println(x);
            }
        }

        printLine();
    }

    public void printHeader() {
        System.out.println("=======================메뉴=======================");
    }

    public void printLine() {
        System.out.println("=================================================");
    }
}
