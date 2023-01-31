package com.back.demo.account.service;

import com.back.demo.account.vo.AccountVo;

import java.lang.reflect.InvocationTargetException;

public interface AccountService {

    String checkId(String id);

    AccountVo accountRegist(AccountVo accountVo) throws InvocationTargetException, IllegalAccessException;

    AccountVo getLogin(AccountVo accountVo) throws InvocationTargetException, IllegalAccessException;
}
