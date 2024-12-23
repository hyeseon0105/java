package service;

import dto.SearchResultDTO;
import dto.TelBookDTO;
import repository.PhoneBookRepositoery;

import java.util.List;

public class PhoneBookService implements ServiceInterface{
    PhoneBookRepositoery bookRepositoery = new PhoneBookRepositoery();

    @Override
    public int insertService(TelBookDTO dto) {
      //  System.out.println("[PhoneBookService]-insertService");
        return bookRepositoery.insertData(dto);
    }

    @Override
    public int updateService(TelBookDTO dto) {
      //  System.out.println("[PhoneBookService]-updateService");
        return bookRepositoery.updateData(dto);
    }

    @Override
    public int deleteService(long id) {
     //   System.out.println("[PhoneBookService]-deleteService");
        return bookRepositoery.deleteData(id);

    }

    @Override
    public List<TelBookDTO> getAllListService() {
      //  System.out.println("[PhoneBookService]-getAllListService");
        return bookRepositoery.getAllList();
    }

    @Override
    public TelBookDTO findByIdService(Long id) {
     //   System.out.println("[PhoneBookService]-findByIdService");
        return bookRepositoery.findById(id);
    }


    @Override
    public List<SearchResultDTO> findByNameService(String name) {
     //   System.out.println("[PhoneBookService]-getAllListService");
        return bookRepositoery.findByName(name);
    }

    @Override
    public List<SearchResultDTO> findByphoneService(String phone) {
      //  System.out.println("[PhoneBookService]-findByIdService");
        return bookRepositoery.findByphone(phone);
    }

}
