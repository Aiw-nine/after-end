package com.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.entity.Category;
import com.ssm.entity.Entry;
import com.ssm.entity.EntryExample;
import com.ssm.entity.EntryExample.Criteria;
import com.ssm.service.CategoryService;
import com.ssm.service.EntryService;

// 使用@Controller注解表明该类是一个控制器
@Controller
public class EntryController {
	// 使用@Autowired注解为该属性注入所依赖的对象
	@Autowired
	private EntryService service;

	@Autowired
	private CategoryService service2;

	@RequestMapping("/")
	public ModelAndView getAll(Integer categoryid) {
		EntryExample example = new EntryExample();
		example.setOrderByClause("id desc"); // 按照编号降序排列

		if (!(categoryid == null || categoryid == 0)) { // 此时选择分类查询
			Criteria criteria = example.createCriteria();
			criteria.andCategoryidEqualTo(categoryid); // 根据categoryid分类查询
		}

		List<Entry> list = service.getAll(example);
		List<Category> list2 = service2.getAll(null); // 图书分类从分类表中动态读出

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("list", list);
		mv.addObject("list2", list2);
		mv.addObject("categoryid", categoryid); // 使下拉框记忆选择的图书分类
		return mv; // 控制器向视图传参
	}

	@RequestMapping("/toInsert")
	public ModelAndView toInsert() {
		List<Category> list2 = service2.getAll(null); // 查询分类表
		ModelAndView mv = new ModelAndView("insert_update");
		mv.addObject("list2", list2);
		return mv;
	}

	@RequestMapping("/toUpdate")
	public ModelAndView toUpdate(Integer id) {
		Entry entry = service.getById(id);
		List<Category> list2 = service2.getAll(null); // 查询分类表

		ModelAndView mv = new ModelAndView("insert_update");
		mv.addObject("entry", entry);
		mv.addObject("list2", list2);
		return mv;
	}

	@RequestMapping("/save")
	public String save(Entry entry) {
		boolean is;
		if (entry.getId() != null) {
			// 更新
			is = service.updateById(entry);
		} else {
			// 增加
			is = service.insert(entry);
		}
		if (!is) {
			return "操作失败";
		}
		return "redirect:/"; // 返回到首页
	}

	@RequestMapping("/delete")
	public String delete(Integer id, HttpServletRequest request) {
		boolean is = service.delete(id);
		String msg;
		if (is) {
			msg = "删除成功";
		} else {
			msg = "删除失败";
		}
		request.getSession().setAttribute("msg", msg); // 列表下方显示“删除成功”或“删除失败”提示语句
		request.getSession().setMaxInactiveInterval(1); // 设置1秒后失效
		return "redirect:/";
	}
}
