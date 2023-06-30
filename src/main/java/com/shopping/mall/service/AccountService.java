package com.shopping.mall.service;

import com.shopping.mall.dto.RegisterReqDto;

public interface AccountService {

    public void register(RegisterReqDto registerReqDto) throws Exception;
}
