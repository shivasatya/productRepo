package com.dailycodebuffer.productService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.productService.model.ProductRequest;
import com.dailycodebuffer.productService.model.ProductResponse;
import com.dailycodebuffer.productService.repository.ProductDao;
import com.dailycodebuffer.productService.service.ProductServiceImp;

/**
 * @author Shiva
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServiceImp productServiceImp;


	@PostMapping("creatingProduct")
	public ResponseEntity<Object> addProduct(@RequestBody ProductRequest productRequest) {
		Object productMessage = productServiceImp.addProduct(productRequest);
		return new ResponseEntity<>(productMessage, HttpStatus.OK);

	}

	@GetMapping("getProductById/{id}")
	public ResponseEntity<ProductResponse> getProductDetails(@PathVariable("id")   Long productId){
	ProductResponse productResponse =	productServiceImp.getDataByProductId(productId);
		return new ResponseEntity<>(productResponse,HttpStatus.OK);
		
	}
	@GetMapping("reduceQuantity/{id}")
	public  ResponseEntity reduceQuantity(@PathVariable("id") Long orderId, @RequestParam(required = true) Long quality){
		productServiceImp.reduceQuantity(orderId,quality);
		return  new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/data")
	public  ResponseEntity example(){
		
		return  new ResponseEntity<>("Strrfdsgfye",HttpStatus.OK);
	}
	
}
