package com.chendongdong.offer.japmapper;

import com.chendongdong.offer.doMain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaDao  extends JpaRepository<User,Integer> {
    User findByName(String name);
}
