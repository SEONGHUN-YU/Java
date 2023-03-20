package com.yu.mar201ajax.product;

import java.util.List;

public interface ProductMapper {
	public abstract List<Product> get(ProductSelector ps);
	public abstract int getAllProductCount();
}
