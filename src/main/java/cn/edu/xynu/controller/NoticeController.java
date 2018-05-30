package cn.edu.xynu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cn.edu.xynu.dao.NoticeDao;
import cn.edu.xynu.entity.Notice;

@Controller
public class NoticeController {
	
	@Autowired
	public NoticeDao noticeDao;

	//跳转公告列表
	@GetMapping("/notice/list")
	public String list(Notice notice, Model model){
		model.addAttribute("notices",noticeDao.findAll());
		return "notice/list";
	}
	// 删除公告
	@GetMapping("/notice/delete")
	public String delete(Integer id, Model model){	
		noticeDao.deleteById(id);
		return "redirect:/notice/list";
	}
	//跳转编辑公告页面
	@GetMapping("/notice/edit")
	public String edit(Integer id, Model model){
		model.addAttribute("notice", noticeDao.getOne(id));
		return "notice/edit";
	}
	//更新公告
	@PostMapping("/notice/update")
	public String update(Notice notice, BindingResult bindingResult, Model model){
		noticeDao.save(notice);
		return "redirect:/notice/list";
	}
	//跳转添加公告页面
	@GetMapping("/notice/add")
	public String add(Notice notice, Model model){
		return "notice/add";
	}
	//保存新公告
	@PostMapping("/notice/insert")
	public String insert(Notice notice,BindingResult bindingResult, Model model){
		noticeDao.save(notice);
		return "redirect:/notice/list";
	}
	
	//教师或学生登录时显示公告信息
	@GetMapping("/notice/show")
	public String show(Integer role, Notice notice, Model model ){
		model.addAttribute("notices", noticeDao.findByRole(role));
		return "notice/show";
	}
	
	// 查询公告
	@PostMapping("/nsearch")
    public String search(String keyword, int searchField,  Model model) {
		if(searchField == 0){
			model.addAttribute("notices",noticeDao.findAllNoticeByTitle("%" + keyword +"%"));
		}else {
			model.addAttribute("notices",noticeDao.findAllNoticeByContent("%" + keyword +"%"));
		}
		return "notice/show";
	}
}
