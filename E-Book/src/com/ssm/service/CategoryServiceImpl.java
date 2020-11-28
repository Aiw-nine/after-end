package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.entity.Category;
import com.ssm.entity.CategoryExample;
import com.ssm.mapper.CategoryMapper;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryMapper mapper;

	@Override
	public List<Category> getAll(CategoryExample example) {
		return mapper.selectByExample(null);
	}

}
