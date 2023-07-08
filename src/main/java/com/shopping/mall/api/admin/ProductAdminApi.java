package com.shopping.mall.api.admin;

import com.shopping.mall.aop.annotation.LogAspect;
import com.shopping.mall.dto.CMRespDto;
import com.shopping.mall.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class ProductAdminApi {
    @RestController
    @RequestMapping("/api")
    @RequiredArgsConstructor
    public class ProductApi {

        private final ProductService productService;

        @LogAspect
        @GetMapping("/collections/{category}")
        public ResponseEntity<?> getCollections(@PathVariable String category, int page) throws Exception {

            return ResponseEntity.ok(new CMRespDto<>("Successfully", productService.getProductList(category, page)));
        }

        @GetMapping("/product/{pdtId}")
        public ResponseEntity<?> getProduct(@PathVariable int pdtId) throws Exception {

            return ResponseEntity.ok(new CMRespDto<>("Successfully", productService.getProduct(pdtId)));
        }

    }
}
