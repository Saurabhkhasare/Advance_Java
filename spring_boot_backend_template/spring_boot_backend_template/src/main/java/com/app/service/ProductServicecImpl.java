package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ProductDao;
import com.app.pojos.Product;

@Service
public class ProductServicecImpl implements ProductService {
	@Autowired
	private ProductDao pDao;

	@Override
	public List<Product> getAllProds() {
		return pDao.findAll();
	}

}
