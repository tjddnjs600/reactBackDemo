package com.back.demo.account.controller;

import com.back.demo.account.service.AccountService;
import com.back.demo.account.vo.AccountVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/account")
public class AccountController {

    private AccountService accountService;

    @GetMapping("/chkId/{id}")
    public String checkId(@PathVariable String id){
        return this.accountService.checkId(id);
    }

    @PostMapping("/regist")
    public AccountVo accountRegist(@RequestBody AccountVo accountVo) throws InvocationTargetException, IllegalAccessException {
       return this.accountService.accountRegist(accountVo);
    }

    @PostMapping("/login")
    public AccountVo getLogin(@RequestBody AccountVo accountVo, HttpServletRequest request) throws InvocationTargetException, IllegalAccessException {
        AccountVo resVo = this.accountService.getLogin(accountVo);

        if(StringUtils.isEmpty(resVo.getMsg())){
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("loginId", resVo.getId());

            log.info(httpSession.getAttribute("loginId").toString());
        }

        return resVo;
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();   // 세션 날림
        }

    }
}
