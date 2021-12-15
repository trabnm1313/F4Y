package com.example.f4yproject.repository;

import com.example.f4yproject.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, User> {

    @Query(value = "{_id: '?0'}")
    User findUserByID(String ID);

    @Query(value = "{username: '?0'}")
    User findUserByUsername(String username);

    @Query(value = "{nickname: '?0'}")
    User findUserByNickName(String nickname);

    @Query(value = "{username: '?0', password: '?1'}")
    User login(String username, String password);

}
