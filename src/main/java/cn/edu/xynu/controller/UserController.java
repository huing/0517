package cn.edu.xynu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cn.edu.xynu.dao.UserDao;
import cn.edu.xynu.entity.User;

@Controller
public class UserController {
	
	@Autowired
	public UserDao userDao;
	
	//登录
	@PostMapping("/login")
	public String login(User user, Model model) {
		User result = userDao.findByUnoAndPasswordAndRole(user.getUno(),user.getPassword(),user.getRole());		
		if (result == null) {	
			model.addAttribute("msg", "输入信息有误!");
			return "index";	
		} else {			
			model.addAttribute("account", userDao.findAccountByUno(user.getUno()));		
			model.addAttribute("role", user.getRole());	
			model.addAttribute("uno", user.getUno());
			return "main";
		}
	}	
	//退出
	@GetMapping("/logout")
	public String logout(User user, Model model ){
		
		return "index";
	}
	//用户信息
	@GetMapping("/user/list")
	public String u_list(User user, Model model){
		model.addAttribute("users",userDao.findAll());
		return "user/list";
	}
	// 删除用户信息
	@GetMapping("/user/delete")
	public String u_delete(Integer id, Model model){		
		userDao.deleteById(id);		
		return "redirect:/user/list";
	}
	//跳转编辑用户信息页面
	@GetMapping("/user/edit")
	public String u_edit(Integer id, Model model){
		model.addAttribute("user", userDao.getOne(id));
		return "user/edit";
	}
	//更新用户信息
	@PostMapping("/user/update")
	public String u_update(User user, BindingResult bindingResult, Model model){
		userDao.save(user);
		return "redirect:/user/list";
	}
	//跳转添加用户信息页面
	@GetMapping("/user/add")
	public String u_add(){
		return "user/add";
	}
	//保存新用户信息
	@PostMapping("/user/insert")
	public String u_insert(User user, BindingResult bindingResult, Model model){
		userDao.save(user);
		return "redirect:/user/list";
	}
	
	//跳转个人信息页面
	@GetMapping("/user/detail")
	public String detail(String uno, Model model){
		model.addAttribute("user", userDao.findByUno(uno));
		return "user/detail";
	}
	//跳转修改个人信息页面
	@GetMapping("/user/change")
	public String change(String uno, Model model){
		model.addAttribute("user", userDao.findByUno(uno));
		return "user/change";
	}
	//保存修改信息
	@PostMapping("/userChange")
	public String userChange(User user, Model model){
		userDao.save(user);
		model.addAttribute("user", user);
		return "user/detail";
	}

}
