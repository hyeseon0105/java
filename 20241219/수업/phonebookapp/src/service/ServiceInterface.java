package service;

import dto.TelBookDTO;

import java.util.List;

public interface ServiceInterface {
    int insertService(TelBookDTO dto);

    int updateService(TelBookDTO dto);

    int deleteService(long id);

    //전체 데이터 읽어오기
    List<TelBookDTO> getAllListService();

    // id로 검색
    TelBookDTO findByIdService(Long id);

    //이름으로 검색
    List<TelBookDTO> findByNameService(String name);

    //전화번호로 검색
    List<TelBookDTO> findByphoneService(String phone);

}
