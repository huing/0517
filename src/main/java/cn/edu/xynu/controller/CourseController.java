package cn.edu.xynu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cn.edu.xynu.dao.CourseDao;
import cn.edu.xynu.entity.Course;


@Controller
public class CourseController {
	
	@Autowired
	public CourseDao courseDao;
	
	// 课程信息
	@GetMapping("/course/list")
	public String list(Course course, Model model){
		model.addAttribute("courses",courseDao.findAll());
		return "course/list";
	}
	// 删除课程信息
	@GetMapping("/course/delete")
	public String delete(Integer id, Model model){		
		courseDao.deleteById(id);		
		return "redirect:/course/list";
	}
	// 跳转编辑课程信息页面
	@GetMapping("/course/edit")
	public String edit(Integer id, Model model){
		model.addAttribute("course", courseDao.getOne(id));
		return "course/edit";
	}
	// 更新课程信息
	@PostMapping("/course/update")
	public String update(Course course, BindingResult bindingResult, Model model){
		/*Course res = courseDao.findMulCourse();
		if(res == null){
			courseDao.save(course);
		}else {
			model.addAttribute("msg", "信息重复！");
		}*/
		courseDao.save(course);
		return "redirect:/course/list";
	}
	// 跳转添加课程信息页面
	@GetMapping("/course/add")
	public String add(Course course, Model model){
		return "course/add";
	}
	// 保存新课程信息
	@PostMapping("/course/insert")
	public String insert(Course course, BindingResult bindingResult, Model model){
		courseDao.save(course);
		return "redirect:/course/list";
	}

}
