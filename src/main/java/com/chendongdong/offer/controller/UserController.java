package com.chendongdong.offer.controller;

import com.chendongdong.offer.daoImpl.UserService;
import com.chendongdong.offer.doMain.User;
import com.chendongdong.offer.japmapper.UserJpaDao;
import com.chendongdong.offer.mapper.UserMapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private UserJpaDao userJpaDao;

    @RequestMapping(value="/getUserAll", method= RequestMethod.POST)
    public List<Map<String,Object>> getUserAll() {
        List<Map<String, Object>> all = userService.getAll();
        return all;
    }

    @RequestMapping(value="/insertBatchUser", method= RequestMethod.POST)
    public void insertBatchUser() {
        List<User> userList = new ArrayList<User>();
        for (int i = 100;i > 90;i--){
            User user = new User();
            user.setName(i + "");
            user.setPassword(i + "");
            userList.add(user);
        }
        userService.insertBatchUser(userList);
    }

    @RequestMapping(value="/getPageUser", method= RequestMethod.POST)
    public PageInfo<Map<String,Object>> getPageUser(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String,Object>> all = userService.getAll();
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(all);
        return pageInfo;
    }

    @RequestMapping(value="/getJpaUser", method= RequestMethod.POST)
    public List<User> getJpaUser() {
        List<User> all = userJpaDao.findAll();
        return all;
    }

    @RequestMapping(value="/getJpaUserByName", method= RequestMethod.POST)
    public User getJpaUserByName(String name) {
        User user = userJpaDao.findByName(name);
        return user;
    }
}
