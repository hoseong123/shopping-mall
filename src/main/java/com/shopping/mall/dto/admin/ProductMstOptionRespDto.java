package com.shopping.mall.dto.admin;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductMstOptionRespDto {
    private int pdtId;
    private String category;
    private String pdtName;
}
