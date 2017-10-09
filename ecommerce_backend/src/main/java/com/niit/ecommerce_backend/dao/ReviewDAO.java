package com.niit.ecommerce_backend.dao;

import java.util.ArrayList;

import com.niit.ecommerce_backend.model.Review;

public interface ReviewDAO {
	public ArrayList<Review> getrevbyprid(int pr);
	public void savereview(Review r);

}