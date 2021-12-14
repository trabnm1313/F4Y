package com.example.f4yproject.repository;

import com.example.f4yproject.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, User> {

    @Query(value = "{_id: '?0'}")
    public User findUserByID(String ID);

    @Query(value = "{username: '?0'}")
    public User findUserByUsername(String username);

    @Query(value = "{nickname: '?0'}")
    public User findUserByNickName(String nickname);

}
