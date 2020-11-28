package com.ssm.service;

import java.util.List;

import com.ssm.entity.Category;
import com.ssm.entity.CategoryExample;

public interface CategoryService {
	// 查询所有
	List<Category> getAll(CategoryExample example);
}
