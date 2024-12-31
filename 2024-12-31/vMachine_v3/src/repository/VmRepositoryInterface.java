package repository;

import dto.UserDto;

public interface VmRepositoryInterface {
    int signUpData(UserDto dto);

    UserDto getUserById(String id);

     int updateUser(String userid, int money);

     int updateUserBalance(String userId, int money);

     int getUserBalance(String userId);




}
