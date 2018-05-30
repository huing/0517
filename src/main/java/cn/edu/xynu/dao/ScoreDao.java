package cn.edu.xynu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.edu.xynu.entity.Score;

public interface ScoreDao extends JpaRepository<Score, Integer> {

	//学生登录
	@Query(nativeQuery=true, value="select stu.sno,stu.sname,stu.dept stuDept,stu.sc,stu.grade,c.cname,score.role,score.mark,score.pass,"
			+ "c.tname,c.dept courseDept,c.semester from `student` stu,`course` c,`score`"
			+ " where stu.sno= ?1 and score.sno_id=stu.id and score.tno_id=c.id ;")
	List<Object[]> findAllScoreBySno(String uno);
	
	//教师登录
	@Query(nativeQuery=true, value="select score.id, stu.sno, stu.sname,stu.dept stuDept,stu.sc,stu.grade,c.cname,score.role,score.mark,score.pass,"
			+ "c.tname,c.dept courseDept,c.semester,score.sno_id,score.tno_id from `student` stu,`course` c,`score`"
			+ " where c.tno= ?1 and score.sno_id=stu.id and score.tno_id=c.id ;")
	List<Object[]> findAllScoreByTno(String uno);

	Score findBySnoIdAndTnoId(Integer snoId, Integer tnoId);
	
	// 查找选过的课程
	@Query(nativeQuery=true,value="select c.tno,c.tname,c.cname,score.role,c.dept,c.sc,c.grade,c.semester from `course` c,`score` "
			+ "where c.id=score.tno_id and score.sno_id= ?1 ;")
	List<Object[]> findBySnoId(int snoId);
	
	// 查找必修课程
	@Query(nativeQuery=true,value="select c.tno,c.tname,c.cname,score.role,c.dept,c.sc,c.grade,c.semester from `course` c,`score` "
			+ "where c.id=score.tno_id and score.sno_id= ?1 and score.role=0 ;")
	List<Object[]> findcompulsoryCourse(int snoId);
	// 查找选修课程
	@Query(nativeQuery=true,value="select c.tno,c.tname,c.cname,score.role,c.dept,c.sc,c.grade,c.semester, score.id from `course` c,`score` "
			+ "where c.id=score.tno_id and score.sno_id= ?1 and score.role=1 ;")
	List<Object[]> findoptionalCourse(int snoId);
	
	// 查找学生表的Id
	@Query(nativeQuery=true,value="select score.sno_id from `score` where id= ?1 ;")
	int findsnoIdById(Integer id);

	@Query(nativeQuery=true,value="select max(id) from score; ")
	int findlastIndex();
	
	
	//管理员登录 查看所有学生成绩
//	@Query(nativeQuery=true, value="select s.id, s.sno, s.course, s.score, s.pass from `score` s ;")
//	List<Object[]> findAllScore();
//	
	
//	@Query(nativeQuery=true,value="getConnecction().createStatement().executeQuery( ?1 )")
//	void saveAll(Score scores);
	
	
	
	
	
	
	
	
	

	
	
	
	

}
