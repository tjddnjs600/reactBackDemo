package com.back.demo.account.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@DynamicInsert
@Table(name = "tb_account")
public class AccountEntity {

    @Id
    private String id;

    private String pwd;

    private String email;

    private String phone;

    private String up_dt;

    private String reg_dt;
}
