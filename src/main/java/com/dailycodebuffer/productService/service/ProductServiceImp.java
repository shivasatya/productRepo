package com.dailycodebuffer.productService.service;

import java.util.Optional;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.dailycodebuffer.productService.entity.ProductEntity;
import com.dailycodebuffer.productService.exception.ProductServiceExceptionHandler;
import com.dailycodebuffer.productService.model.ProductRequest;
import com.dailycodebuffer.productService.model.ProductResponse;
import com.dailycodebuffer.productService.repository.ProductDao;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductDao productDao;

	public static final  String log_Info_Class = "productServiceImp:";

	@Override
	public Object addProduct(ProductRequest productRequest) {
		String mesaage = "SuccesFully Created";
		log.info(log_Info_Class + "addProduct:creatingProduct");
		try {
			ProductEntity productEntity = ProductEntity.builder().productName(productRequest.getProductName())
					.price(productRequest.getPrice()).quality(productRequest.getQuality()).build();
			productDao.save(productEntity);
			log.info(log_Info_Class , "{} addProduct: Creating Product is sucessFully");
			return mesaage;
		} catch (Exception e) {
			log.info(log_Info_Class + "addProduct:Error In CreatingProduct {}", e.getMessage());
			mesaage = "Error In Creating Product";
		}
		return mesaage;
	}

	
	@Override
	public ProductResponse getDataByProductId(Long productId) {
		log.info( log_Info_Class,"{} getDataByProductId : getingProductId");
		ProductEntity  productData = productDao.findById(productId).orElseThrow(() -> new ProductServiceExceptionHandler("They is No Data with this Id","Product_NoT_FOund"));
		ProductResponse productResponse = new ProductResponse();
		 BeanUtils.copyProperties( productData,productResponse);
		 log.info( log_Info_Class,"{} getDataByProductId : sucessFullyGetingData");
		return productResponse;
	}

	public void reduceQuantity(Long orderId, Long quality) {
		log.info( log_Info_Class,"{} reduceQuantity : please wait reducing productQuantity...");
		ProductEntity  productData = productDao.findById(orderId).orElseThrow(() ->
		new ProductServiceExceptionHandler("They is no order with this Id","order_NoT_FOund"));
		if(quality>productData.getQuality()) {
			log.info( log_Info_Class,"{} reduceQuantity :failed to  reducing productQuantity...");
		throw	new ProductServiceExceptionHandler("They is no enough quality","quality_NoT_FOund");
		}
		else {
			productData.setQuality(productData.getQuality() - quality);		
			productDao.save(productData);
			log.info( log_Info_Class,"{} reduceQuantity : reducing productQuantity is SuccessFully  ...");
		}
		
	}
}
