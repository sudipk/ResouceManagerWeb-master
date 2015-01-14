package com.sjsu.review.httpclient;

import java.util.ArrayList;

import edu.sjsu.courseapp.domain.Product;
import edu.sjsu.courseapp.services.ProductService;

public interface HttpClientInterface {	
public ArrayList<Product> getBestBuyProductInformations(String name);

public void setProductservice(ProductService productservice);

}
