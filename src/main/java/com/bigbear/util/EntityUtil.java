package com.bigbear.util;

import java.util.ArrayList;
import java.util.List;

import com.bigbear.entity.Product;

public class EntityUtil {
	public static final List<Product> products;
	static{
		products=new ArrayList<Product>();
		for(int i=1; i<=1000; i++){
			products.add(new Product(i+"", "Mobile"+i, "Kg"));
		}
		
	}
	public static Product getProductById(String id){
		for(Product p:products){
			if(p.getId().equalsIgnoreCase(id)){
				return p;
			}
		}
		return null;
	}
	public static String getProductsListData(){
		StringBuilder data=new StringBuilder();
		data.append("var data=[");
		for(Product product:products){
			data.append("{");
			data.append("id:'"+product.getId()+"', ");
			data.append("text:'"+product.getName()+"'");
			data.append("}, ");
		}
		data.append("];");
		return data.toString();
	}
}
