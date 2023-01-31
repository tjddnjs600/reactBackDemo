package com.back.demo.account.service.impl;

import com.back.demo.account.entity.AccountEntity;
import com.back.demo.account.repository.AccountReopsoitory;
import com.back.demo.account.service.AccountService;
import com.back.demo.account.vo.AccountVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private AccountReopsoitory accountReopsoitory;

    @Override
    public String checkId(String id) {
        List<AccountEntity> list = this.accountReopsoitory.findAll().stream()
                .filter(obj -> id.equals(obj.getId())).collect(Collectors.toList());

        if(CollectionUtils.isEmpty(list)){
            return "ok";
        } else {
            return "fail";
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AccountVo accountRegist(AccountVo accountVo) throws InvocationTargetException, IllegalAccessException {
        AccountEntity save = new AccountEntity();
        BeanUtils.copyProperties(save, accountVo);

        AccountEntity account = this.accountReopsoitory.save(save);
        if(ObjectUtils.isNotEmpty(account)){
            return accountVo;
        } else {
            accountVo.setMsg("회원가입 실패");
            return accountVo;
        }
    }

    @Override
    public AccountVo getLogin(AccountVo accountVo) throws InvocationTargetException, IllegalAccessException {
        AccountEntity account = this.accountReopsoitory.findById(accountVo.getId()).orElse(null);
        AccountVo resVo = new AccountVo();

        if(ObjectUtils.isEmpty(account)){
            resVo.setMsg("등록된 아이디 없음");
        } else {
            if(!accountVo.getPwd().equals(account.getPwd())) {
                resVo.setMsg("비밀번호 다름");
            } else {
                BeanUtils.copyProperties(resVo, account);
            }
        }

        return resVo;
    }
}
