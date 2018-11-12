package com.chendongdong.offer.daoImpl;

import com.chendongdong.offer.doMain.User;
import com.chendongdong.offer.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserMapper {

    @Resource UserMapper userMapper;

    @Override
    public List<Map<String, Object>> getAll() {
        List<Map<String, Object>> all = userMapper.getAll();
        return all;
    }

    @Transactional
    public void insertBatchUser(List<User> userList) {
        userMapper.insertBatchUser(userList);
    }
}
