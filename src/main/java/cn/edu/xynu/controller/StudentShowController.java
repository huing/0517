package cn.edu.xynu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cn.edu.xynu.dao.CourseDao;
import cn.edu.xynu.dao.NoticeDao;
import cn.edu.xynu.dao.ScoreDao;
import cn.edu.xynu.dao.StudentDao;
import cn.edu.xynu.dao.UserDao;
import cn.edu.xynu.entity.Score;

@Controller
public class StudentShowController {
	
	@Autowired
	public NoticeDao noticeDao;
	@Autowired
	public ScoreDao scoreDao;
	@Autowired
	public CourseDao courseDao;
	@Autowired
	public StudentDao studentDao;
	@Autowired
	public UserDao userDao;
	// 显示成绩信息
	@GetMapping("/score")
	public String scoreList(String uno, Score score, Model model ){
		model.addAttribute("scores", scoreDao.findAllScoreBySno(uno));
		return "score/show";
	}
	// 选课
	@GetMapping("/curriculaVariable")
	public String detail(String uno,Model model){
		model.addAttribute("courses",courseDao.findCourseByUno(uno));
		return "course/curriculaVariable";
	}
	// 添加选课
	@GetMapping("/course/plus")
	public String plus(Integer tnoId, Integer snoId, String sno, Score score, Model model){	
		Score result = scoreDao.findBySnoIdAndTnoId(snoId,tnoId);
		if(result == null){
			score.setSnoId(snoId);
			score.setTnoId(tnoId);
			score.setMark(0.00);
			score.setPass(0);
			score.setRole(1);
			scoreDao.save(score);
		}else {
			model.addAttribute("scoremsg", "你已选过此课");
		}
		model.addAttribute("courses",courseDao.findCourseByUno(sno));
		return "course/curriculaVariable";
	}
	// 显示已选课
	@GetMapping("/courseShow")
	public String showScore(String uno, Model model){
		int snoId = studentDao.findIdByUno(uno);
		List<Object[]> courses = scoreDao.findBySnoId(snoId);
		model.addAttribute("courses", courses);
		model.addAttribute("snoId", snoId);
		return "course/show";
	}
	// 查找必修课程
	@GetMapping("/compulsoryCourse")
	public String compulsoryCourse(Integer snoId, Model model){
		model.addAttribute("courses", scoreDao.findcompulsoryCourse(snoId));
		model.addAttribute("snoId", snoId);
		return "course/compulsoryCourse";
	}
	// 查找选修课程
	@GetMapping("/optionalCourse")
	public String optionalCourse(Integer snoId, Model model){
		model.addAttribute("courses", scoreDao.findoptionalCourse(snoId));
		model.addAttribute("snoId", snoId);
		return "course/optionalCourse";
	}
	// 删除选修课
	@GetMapping("/courseDelete")
	public String courseDelete(Integer id,Integer snoId, Model model){
		
		scoreDao.deleteById(id);
		model.addAttribute("courses", scoreDao.findoptionalCourse(snoId));
		model.addAttribute("snoId", snoId);
		return "course/optionalCourse";
	}
}
