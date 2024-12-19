package view;

import dto.TelBookDTO;
import service.PhoneBookService;

import java.util.List;

public class TelbookView implements ViewInterface{
    PhoneBookService bookService = new PhoneBookService();

    @Override
    public void insertView() {
        System.out.println("[PhoneBookTelbookView]-insertView");
    }

    @Override
    public void updateView() {
        System.out.println("[PhoneBookTelbookView]-updateView");

    }

    @Override
    public void deleteView() {
        System.out.println("[PhoneBookTelbookView]-deleteView");

    }

    @Override
    public void searchAllView() {
        System.out.println("[PhoneBookTelbookView]-searchAllView");
        List<TelBookDTO> dtolist = bookService.getAllListService();
        //출력해보기
        linePrint();
        printTitle();
        linePrint();
        for (TelBookDTO dto : dtolist) {
            System.out.println(dto);
        }
        linePrint();
    }

    public void linePrint() {
        System.out.println("====================================================================================");
    }

    public void printTitle() {

        System.out.println("ID \t 이름\t 나이 \t 주소 \t \t \t전화번호 \t\t 입력 \t \t\t\t수정");
    }

    @Override
    public void searchNameView() {
        System.out.println("[PhoneBookTelbookView]-searchNameView");

    }

    @Override
    public void searchPhoneView() {
        System.out.println("[PhoneBookTelbookView]-searchPhoneView");

    }
}
