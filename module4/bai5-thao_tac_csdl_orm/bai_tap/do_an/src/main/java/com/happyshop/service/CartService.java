package com.happyshop.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.happyshop.dao.ProductDAO;
import com.happyshop.entity.Product;

@SessionScope 
@Service
public class CartService {

	@Autowired
	ProductDAO dao;

	Map<Integer, Product> map = new HashMap<>();//Hien thi danh sach gio hangf

	public void add(Integer id) {//Chon san pham
		Product p = map.get(id);
		if (p == null) {
			p = dao.findById(id);
			p.setQuantity(1);
			map.put(id, p);
		} else {
			p.setQuantity(p.getQuantity() + 1);
		}
	}

	public void remove(Integer id) {//Xoa theo id san pham
		map.remove(id);
	}

	public void update(Integer id, int qty) {//Cap nhat san pham
		Product p = map.get(id);
		p.setQuantity(qty);
	}

	public void clear() {//Xoa tat ca san pham
		map.clear();
	}

	public int getCount() {//Hien thi so luong
		Collection<Product> ps = this.getItems();
		int count = 0;
		for (Product p : ps) {
			count += p.getQuantity();
		}
		return count;
	}

	public double getAmount() {//Tinh tong
		Collection<Product> ps = this.getItems();
		double amount = 0;
		for (Product p : ps) {
			amount += p.getQuantity() * p.getUnitPrice() * (1 - p.getDiscount());
		}
		return amount;
	}

	public Collection<Product> getItems() {//Hien thi danh sach da chon
		return map.values();
	}
}
