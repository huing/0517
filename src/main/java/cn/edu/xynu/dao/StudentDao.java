package cn.edu.xynu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.edu.xynu.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {
	
/*	//教师搜索添加学生成绩的列表
	@Query(nativeQuery=true, value="select s.sno, c.tno, c.cname from `student` s, `course` c "
			+ "where c.tno= ?1 and c.dept=s.dept and c.sc=s.sc and c.grade=s.grade ;")
	List<Object[]> findAllStuByTno(String uno);
	//管理员搜索添加学生成绩的列表
	@Query(nativeQuery=true, value="select s.sno, c.tno, c.cname from `student` s, `course` c "
			+ "where c.dept=s.dept and c.sc=s.sc and c.grade=s.grade ;")
	List<Object[]> findAllStu();*/
	
	//查找学号对应的Id
	@Query(nativeQuery=true,value="select stu.id from `student` stu where stu.sno= ?1 ;")
	int findIdByUno(String uno);

	// 查找所有课程
	@Query(nativeQuery=true,value=" select s.sno,s.sname,s.dept studentDept,s.sc,s.grade,c.tno,c.tname,"
			+ "c.cname,c.dept courseDept,score.role,score.mark,score.pass,c.semester,score.id,score.sno_id snoId,score.tno_id tnoId "
			+ "from `student` s,`course` c,`score` where s.id=score.sno_id and c.id=score.tno_id ;")
	List<Object[]> findAllCourse();
	
	// 管理员登录，搜索添加必修课程
	@Query(nativeQuery=true,value=" select s.id snoId,c.id tnoId from `student` s,`course` c where s.dept=c.dept and s.sc=c.sc and s.grade=c.grade ;")
	List<Object[]> findAllStudentAndCourse();

}
