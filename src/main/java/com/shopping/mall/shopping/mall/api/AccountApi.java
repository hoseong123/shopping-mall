package com.shopping.mall.shopping.mall.api;

import com.shopping.mall.shopping.mall.aop.annotation.LogAspect;
import com.shopping.mall.shopping.mall.dto.CMRespDto;
import com.shopping.mall.shopping.mall.dto.RegisterReqDto;
import com.shopping.mall.shopping.mall.dto.validation.ValidationSequence;
import com.shopping.mall.shopping.mall.exception.CustomValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/account")
@RestController
public class AccountApi {

    @LogAspect
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult) {

        return ResponseEntity.created(null).body(new CMRespDto<>("회원가입 성공", registerReqDto));

    }

}
