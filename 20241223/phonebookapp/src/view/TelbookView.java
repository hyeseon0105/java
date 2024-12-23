package view;

import dto.SearchResultDTO;
import dto.TelBookDTO;
import exception.InputValidation;
import exception.MyException;
import service.PhoneBookService;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TelbookView implements ViewInterface{
    Scanner scanner = new Scanner(System.in);
    PhoneBookService bookService = new PhoneBookService();
    //입력 확인 용 인스턴스 생성
    InputValidation validation = new InputValidation();

    @Override
    public void insertView() {
     //   System.out.println("[PhoneBookTelbookView]-insertView");
        System.out.println("=== 전화번호 등록 ===");

        boolean check = true;
        //빈연락처 클래스 ->채워서 서비스로 전달 -> 저장
        TelBookDTO dto = new TelBookDTO();
        //이름 입력 처리
        while (check) {
            try {
                System.out.println("이름 : ");
                String name = scanner.next();
                check = validation.nameCheck(name);
                dto.setName(name);

            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }


//나이확인
        check =true;
        while (check) {
            try {
                System.out.println("나이 : ");
                int age = scanner.nextInt();
                check = validation.ageCheck(age);
                dto.setAge(age);

            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
//주소입력받기
        System.out.println("주소 : ");
        String address = scanner.next();
        dto.setAddress(address);
        //전화번호 입력처리
        check =true;

        while (check) {
            try {
                System.out.println("전화번호 : ");
                String phone = scanner.next();
                check = validation.phoneCheck(phone);
                dto.setPhone(phone);

            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
        //신규입력이니까 생성일 저장
        dto.setCreatedAt(LocalDateTime.now());
        //서비스로 dto 전달
        int result = bookService.insertService(dto);
        if (result > 0) {
            System.out.println("자료가 저장되었습니다.");
        } else {
            System.out.println("실패했습니다. 관리자에게 문의하세요.");
        }
    }


    @Override
    public void updateView() {
       // System.out.println("[PhoneBookTelbookView]-updateView");
        System.out.println("수정할 전화번호부의 ID를 입력하세요");
        Long updateNum = scanner.nextLong();
        //수정할 ID의 레코드를 찾아온다. 찾아온 데이터
        TelBookDTO originalDto = bookService.findByIdService(updateNum);
        //수정할 dto정의(빈깡통)
        TelBookDTO updateDto = new TelBookDTO();
        //아이디는 출력만 (수정불가)
        System.out.println("수정 ID : " + originalDto.getId());
        //원본이름 출력
        System.out.println("수정 전 이름 : " + originalDto.getName());
        boolean check = true;
        //수정 대상 아이디를 updateDTO.id에 저장
        updateDto.setId(originalDto.getId());
        //수정할 이름 입려 받고 validation 체크
        while (check) {
            try {
                System.out.println("수정할 이름 : ");
                String name = scanner.next();
                check = validation.nameCheck(name);
                updateDto.setName(name);

            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("수정 전 나이 : " + originalDto.getAge());
        check = true;
        //수정할 이름 입력 받고 validation 체크
        while (check) {
            try {
                System.out.println("수정할 나이 : ");
                int age = scanner.nextInt();
                check = validation.ageCheck(age);
                updateDto.setAge(age);

            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
        //원본주소 출력
        System.out.println("수정 전 주소 : " + originalDto.getAddress());
        System.out.println("수정 할 수조 : ");
        String address = scanner.next();
        updateDto.setAddress(address);
        //전화번호 수정 작업
        check =true;

        while (check) {
            try {
                System.out.println("수정 전 전화번호 : ");
                System.out.println(originalDto.getPhone());
                String phone = scanner.next();
                check = validation.phoneCheck(phone);
                updateDto.setPhone(phone);

            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
        //입력 날짜는 수정 안되니까 옮겨서 그냥 저장
        updateDto.setCreatedAt(originalDto.getCreatedAt());
        //수정 날짜는 강제로 오늘 날짜로 변경
        updateDto.setUpdateAt(LocalDateTime.now());
        //서비스로 수정 데이터 전송 후 성공 유무 확인
       int result = bookService.updateService(updateDto);
       //성공 유무처리
        if (result > 0) {
            System.out.println("정상적으로 수정되었습니다.");
        } else {
            System.out.println("수정 실패하였습니다. 관리자에게 문의하세요.");
        }
    }

    @Override
    public void deleteView() {
       // System.out.println("[PhoneBookTelbookView]-deleteView");
        System.out.println("삭제할 전화번호부의 ID를 입력하세요.");
        Long deleteId = scanner.nextLong();

        if (bookService.deleteService(deleteId) > 0) {
            System.out.println("ID : " + deleteId + "의 데이터가 삭제되었습니다.");
        } else {
            System.out.println("삭제에 실패했습니다. 관리자에게 문의하세요.");
        }
    }

    @Override
    public void searchAllView() {
       // System.out.println("[PhoneBookTelbookView]-searchAllView");
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
    public void printSearchTitle() {

        System.out.println(" 이름\t 나이 \t 주소 \t \t \t전화번호 \t\t ");
    }

    @Override
    public void searchNameView() {
      //  System.out.println("[PhoneBookTelbookView]-searchNameView");
        System.out.println("이름으로 검색하는 화면입니다.");
        System.out.println("검색할 이름의 일부나 전체를 입력하세요.");
        String keyword = scanner.next();
        List<SearchResultDTO> result = bookService.findByNameService(keyword);
        linePrint();
        printTitle();
        if (result.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");

        } else {
            result.forEach(x-> System.out.println(x));
        }

        linePrint();
    }

    @Override
    public void searchPhoneView() {
      //  System.out.println("[PhoneBookTelbookView]-searchPhoneView");
        System.out.println("전화번호로 검색하는 화면입니다.");
        System.out.println("검색할 전화번호의 일부나 전체를 입력하세요.");
        String keyword = scanner.next();
        List<SearchResultDTO> result = bookService.findByphoneService(keyword);
        linePrint();
        printSearchTitle();
        linePrint();
        if (result.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");

        } else {
            result.forEach(x -> System.out.println(x));
        }
        linePrint();
    }
}
