package com.chendongdong.offer.mapper;

import com.chendongdong.offer.doMain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface UserMapper{
    List<Map<String,Object>> getAll();

    void insertBatchUser(List<User> userList);
}
