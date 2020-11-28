package com.ssm.service;

import java.util.List;

import com.ssm.entity.Entry;
import com.ssm.entity.EntryExample;

public interface EntryService {
	// 查询所有
	// List<Entry> getAll();

	// 根据分类查询
	List<Entry> getAll(EntryExample example);

	// 查询单个
	Entry getById(Integer id);

	// 增加
	boolean insert(Entry entry);

	// 更新
	boolean updateById(Entry entry);

	// 删除
	boolean delete(Integer id);
}
