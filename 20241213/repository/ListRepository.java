package repository;

import myinterface.ArrayListInterface;
import vo.Product;

import java.util.ArrayList;
import java.util.List;

public class ListRepository implements ArrayListInterface {
//상품목록(상품명,금액,재고)정보를 담는 저장공간

    @Override
    public boolean insert(Product product) {
        InitArrayList.productList.add(product);
        System.out.println(InitArrayList.productList);
        return true;
    }

    @Override
    public boolean update(int index, Product product) {
        InitArrayList.productList.set(index, product);
        return false;
    }

    @Override
    public boolean delete(int index) {
        InitArrayList.productList.remove(index);
        return false;
    }

    @Override
    public Product findByName(String name) {
        for (Product x : InitArrayList.productList) {
            if (x.getItem().equals(name)) {
                return x;

            }
        }
        return null;
    }

    @Override
    public int findIndex(String name) {
        for (Product x : InitArrayList.productList) {
            if (x.getItem().equals(name)) {
                return InitArrayList.productList.indexOf(x);
            }
        }
        return -1;
    }

    @Override
    public List <Product> findall() {
        return InitArrayList.productList;
    }
}
