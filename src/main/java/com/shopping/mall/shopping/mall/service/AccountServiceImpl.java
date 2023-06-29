package com.shopping.mall.shopping.mall.service;

import com.shopping.mall.shopping.mall.domain.User;
import com.shopping.mall.shopping.mall.dto.RegisterReqDto;
import com.shopping.mall.shopping.mall.exception.CustomValidationException;
import com.shopping.mall.shopping.mall.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    @Override
    public void register(RegisterReqDto registerReqDto) throws Exception {
        User user = accountRepository.findUserByEmail(registerReqDto.getEmail());
        if(user != null){
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("email", "이미 사용중인 이메일 주소입니다");

            throw new CustomValidationException("Duplicate email", errorMap);
        }
    }
}
