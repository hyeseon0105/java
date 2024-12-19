package service;

import dto.TelBookDTO;
import repository.PhoneBookRepositoery;

import java.util.List;

public class PhoneBookService implements ServiceInterface{
    PhoneBookRepositoery bookRepositoery = new PhoneBookRepositoery();

    @Override
    public int insertService(TelBookDTO dto) {
        System.out.println("[PhoneBookService]-insertService");
        return 0;
    }

    @Override
    public int updateService(TelBookDTO dto) {
        System.out.println("[PhoneBookService]-updateService");
        return 0;
    }

    @Override
    public int deleteService(long id) {
        System.out.println("[PhoneBookService]-deleteService");
        return 0;
    }

    @Override
    public List<TelBookDTO> getAllListService() {
        System.out.println("[PhoneBookService]-getAllListService");
        return bookRepositoery.getAllList();
    }

    @Override
    public TelBookDTO findByIdService(Long id) {
        System.out.println("[PhoneBookService]-findByIdService");
        return null;
    }


    @Override
    public List<TelBookDTO> findByNameService(String name) {
        System.out.println("[PhoneBookService]-getAllListService");
        return List.of();
    }

    @Override
    public List<TelBookDTO> findByphoneService(String phone) {
        System.out.println("[PhoneBookService]-findByIdService");
        return List.of();
    }



}
