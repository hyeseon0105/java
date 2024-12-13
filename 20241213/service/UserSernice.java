package service;

import repository.ListRepository;
import view.UserView;
import vo.Product;

public class UserSernice {
    ListRepository repository = new ListRepository();

    public boolean serveItem(int userMoney, String itemName) {
        //찾는 제품이 있는지 확인
        Product findItem = repository.findByName(itemName);
        //재품이 있고, 잔돈이 충분한지 확인하고
        if (findItem != null && findItem.getPrice() <= userMoney && findItem.getStock() > 0) {
            //제품을 구매
            findItem.setStock(findItem.getStock() -1);
            //수정 처리
            repository.update(repository.findIndex(itemName),
            findItem);
            //사용자 잔액 차감
            UserView.userMoney = UserView.userMoney - findItem.getPrice();
            return true;
        } else if (findItem == null) {
            //제품이 없을 때
            System.out.println("찾는 제품이 없습니다.");
            return false;
        } else if (findItem.getPrice() > userMoney) {
            //잔돈이 부족할때
            System.out.println("잔액이 부족합니다.");
            return false;
        } else if (findItem.getStock() == 0) {
            System.out.println("제품이 없습니다.");
            return false;
        } else return false;
    }
}

