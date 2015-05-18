package com.bigbear.model;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import com.bigbear.entity.Product;
import com.bigbear.util.EntityUtil;

public class ProductModel extends LoadableDetachableModel<Product> {
	private String id;
	public ProductModel(String id) {
		this.id=id;
	}
	public ProductModel(Product obj) {
		super(obj);
	}
	private static final long serialVersionUID = 1L;

	@Override
	protected Product load() {
		return EntityUtil.getProductById(id);
	}

}
