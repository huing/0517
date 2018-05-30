package cn.edu.xynu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cn.edu.xynu.dao.StudentDao;
import cn.edu.xynu.entity.Student;

@Controller
public class StudentController {
	
	@Autowired
	public StudentDao studentDao;
	
	//学生信息
	@GetMapping("/student/list")
	public String s_list(Student student, Model model){
		model.addAttribute("students",studentDao.findAll());
		return "student/list";
	}
	// 删除学生信息
	@GetMapping("/student/delete")
	public String s_delete(Integer id, Model model){		
		studentDao.deleteById(id);		
		return "redirect:/student/list";
	}
	//跳转编辑学生信息页面
	@GetMapping("/student/edit")
	public String s_edit(Integer id, Model model){
		model.addAttribute("stu", studentDao.getOne(id));
		return "student/edit";
	}
	//更新学生信息
	@PostMapping("/student/update")
	public String s_update(Student student, BindingResult bindingResult, Model model){
		studentDao.save(student);
		return "redirect:/student/list";
	}
	//跳转添加学生信息页面
	@GetMapping("/student/add")
	public String s_add(Student student, Model model){
		return "student/add";
	}
	//保存新学生信息
	@PostMapping("/student/insert")
	public String s_insert(Student student,BindingResult bindingResult, Model model){
		studentDao.save(student);
		return "redirect:/student/list";
	}

}
