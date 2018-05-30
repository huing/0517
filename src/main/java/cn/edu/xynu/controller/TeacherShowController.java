package cn.edu.xynu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cn.edu.xynu.dao.CourseDao;
import cn.edu.xynu.dao.ScoreDao;
import cn.edu.xynu.entity.Course;
import cn.edu.xynu.entity.Score;

@Controller
public class TeacherShowController {
	
	@Autowired
	public ScoreDao scoreDao;
	@Autowired
	public CourseDao courseDao;
	
	//跳转成绩列表
	@GetMapping("/teacher/list")
	public String list(String uno, Model model){
		model.addAttribute("scores", scoreDao.findAllScoreByTno(uno));	
		return "teacher/list";
	}
	
	@GetMapping("/teacher/edit")
	public String edit(Integer id, Model model){
		model.addAttribute("score", scoreDao.getOne(id));
		return "teacher/edit";
	}
	
	@PostMapping("/teacher/update")
	public String update(Score score,Course course, Model model){
		Integer tnoId = score.getTnoId();
		String tno=courseDao.findTnoByScoreId(tnoId);

		scoreDao.save(score);
		
		model.addAttribute("scores", scoreDao.findAllScoreByTno(tno));
		return "teacher/list";
	}
	//添加成绩列表
	@GetMapping("/teacher/add")
	public String add(Integer id, Integer snoId, Integer tnoId,Integer role, Model model){
		model.addAttribute("id", id);
		model.addAttribute("snoId", snoId);
		model.addAttribute("tnoId", tnoId);
		model.addAttribute("role", role);
		return "teacher/add";
	}
	//保存成绩
	@PostMapping("/teacher/insert")
	public String insert(Score score, BindingResult bindingResult, Model model){	
		scoreDao.save(score);
		Integer tnoId = score.getTnoId();
		String tno=courseDao.findTnoByScoreId(tnoId);
		model.addAttribute("scores", scoreDao.findAllScoreByTno(tno));
		return "teacher/list";
	}
}
