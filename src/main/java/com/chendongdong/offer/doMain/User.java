package com.chendongdong.offer.doMain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@Table(name = "oms_test")
public class User {

    @Id
    private Integer id;
    private String name;
    private String password;
}
