package com.shopping.mall.service;

import com.shopping.mall.dto.CheckoutRespDto;
import com.shopping.mall.dto.CollectionListRespDto;
import com.shopping.mall.dto.ProductRespDto;

import java.util.List;

public interface ProductService {
    public List<CollectionListRespDto> getProductList(String category, int page) throws Exception;
    public ProductRespDto getProduct(int pdtId) throws Exception;
    public CheckoutRespDto getCheckoutProduct(int pdtDtlId) throws Exception;