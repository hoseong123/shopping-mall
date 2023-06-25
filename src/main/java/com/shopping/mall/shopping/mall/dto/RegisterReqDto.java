package com.shopping.mall.shopping.mall.dto;

import com.shopping.mall.shopping.mall.dto.validation.ValidationGroups;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegisterReqDto {

    @NotBlank(message = "이름은 비워둘 수 없습니다", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 1, max = 4 , message = "이름은 4글자까지만 입력 가능합니다", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^[가-힇]*$" , message = "한글만 입력 가능합니다." , groups = ValidationGroups.PatternCheckGroup.class)
    private String name;

    @NotBlank(message = "이메일은 비워 둘 수 없습니다", groups = ValidationGroups.NotBlankGroup.class)
    @Email
    private String email;

    @NotBlank(message = "비밀번호는 비워 둘 수 없습니다", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 8, max = 12, message = "비밀번호는 8자 부터 12자 까지 입력하여야 합니다", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]*$", message = "비밀번호는 특수기호, 영문, 숫자를 모두 포함해야합니다", groups = ValidationGroups.PatternCheckGroup.class)
    private String password;
}
