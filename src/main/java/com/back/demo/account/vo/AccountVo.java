package com.back.demo.account.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountVo {

    private String id;

    private String pwd;

    private String email;

    private String phone;

    private String up_dt;

    private String reg_dt;

    private String msg;
}
