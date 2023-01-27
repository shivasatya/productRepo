package com.dailycodebuffer.productService.service;

import com.dailycodebuffer.productService.model.ProductRequest;

public interface ProductService {
	public Object addProduct(ProductRequest productRequest);
	public Object getDataByProductId(Long productId);
}
