import service.UserService;
import view.Adminview;
import view.UserView;

import java.util.Scanner;

public class VmachineMain {


    public static void main(String[] args) {
        UserView userView = new UserView();
        UserService userService = new UserService();
        Adminview adminview = new Adminview();
        Scanner scanner = new Scanner(System.in);

        int num = 0;
        while (true) {
            System.out.println("1. 회원가입 2.로그인 3.종료");
            num = scanner.nextInt();
            switch (num) {
                case 1:
                    userView.signUp();
                    System.out.println("회원가입");
                    break;
                case 2:
                    userView.login();
                    System.out.println("로그인");
                    break;
                case 3:
                    System.out.println("종료");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
                    break;
            }
        }
    }
}
