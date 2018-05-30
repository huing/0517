package cn.edu.xynu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cn.edu.xynu.dao.CourseDao;
import cn.edu.xynu.dao.ScoreDao;
import cn.edu.xynu.dao.StudentDao;
import cn.edu.xynu.entity.Score;

@Controller
public class ScoreController {
	
	@Autowired
	public ScoreDao scoreDao;
	@Autowired
	public StudentDao studentDao;
	@Autowired
	public CourseDao courseDao;
	//跳转成绩列表
	@GetMapping("/score/list")
	public String list(Score score, Model model){
		
		List<Object[]> addScores = studentDao.findAllStudentAndCourse();
		Score result;
		Object[] obj ;
		int size = 0; 
		for(int i=0;i<addScores.size();i++){
			obj = addScores.get(i);
			result = scoreDao.findBySnoIdAndTnoId((Integer) obj[0], (Integer) obj[1]);
			size = scoreDao.findlastIndex();
			if(result == null){
				score.setId(size+1);
				score.setSnoId((Integer) obj[0]);
				score.setTnoId((Integer) obj[1]);
				score.setMark(0.00);
				score.setPass(0);
				score.setRole(0);
				scoreDao.save(score);
			}					
			//	Object obj1 = addScores.get(i)[0];
			//	Object obj2 = addScores.get(i)[2];
		}
		model.addAttribute("scores", studentDao.findAllCourse());
		return "score/list";
	}

	@GetMapping("/addScore")
	public String add(Integer id, Integer snoId, Integer tnoId,Integer role, Model model){
		model.addAttribute("id", id);
		model.addAttribute("snoId", snoId);
		model.addAttribute("tnoId", tnoId);
		model.addAttribute("role", role);
		return "score/addScore";
	}
	@PostMapping("/scoreInsert")
	public String scoreInsert(Score score,BindingResult bindingResult, Model model){
		scoreDao.save(score);
		return "redirect:/score/list";
	}
	@GetMapping("/score/edit")
	public String edit(Integer id, Model model){
		model.addAttribute("score", scoreDao.getOne(id));
		return "score/edit";
	}
	
	@PostMapping("/score/update")
	public String update(Score score, BindingResult bindingResult, Model model){
		scoreDao.save(score);
		return "redirect:/score/list";
	}
	
	@GetMapping("/score/delete")
	public String delete(Integer id) {
		scoreDao.deleteById(id);
		return "redirect:/score/list";
	}
	
	@GetMapping("/score/add")
	public String add(Score score, Model model){
		return "score/add";
	}
	//插入成绩
	@PostMapping("/score/insert")
	public String t_insert(Score score,BindingResult bindingResult, Model model){
		scoreDao.save(score);
		return "redirect:/score/list";
	}
}
