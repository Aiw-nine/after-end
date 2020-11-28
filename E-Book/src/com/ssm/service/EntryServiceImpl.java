package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.entity.Entry;
import com.ssm.entity.EntryExample;
import com.ssm.mapper.EntryMapper;

@Service
public class EntryServiceImpl implements EntryService {
	@Autowired
	private EntryMapper mapper;

	// @Override
	// public List<Entry> getAll() {
	// return mapper.selectByExample(null);
	// }

	@Override
	public List<Entry> getAll(EntryExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public Entry getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean insert(Entry entry) {
		return mapper.insertSelective(entry) > 0;
	}

	@Override
	public boolean updateById(Entry entry) {
		return mapper.updateByPrimaryKeySelective(entry) > 0;
	}

	@Override
	public boolean delete(Integer id) {
		return mapper.deleteByPrimaryKey(id) > 0;
	}

}
