package com.dailycodebuffer.productService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {
	private String productName;
	private Long price;
	private Long quality;
}
