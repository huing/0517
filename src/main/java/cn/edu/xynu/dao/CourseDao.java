package cn.edu.xynu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.edu.xynu.entity.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {
	
	@Query(nativeQuery=true,value="select course.tno from `course` where course.id= ?1 ;")
	String findTnoByScoreId(Integer tnoId);
	
	// 查找可选课程
	@Query(nativeQuery=true,value="select c.id cnoId, c.tno, c.tname, c.cname, c.dept, c.sc, c.grade, c.semester, stu.id snoId, stu.sno "
			+ "from `course` c,`student` stu where c.grade = stu.grade and stu.sno= ?1 ;")
	List<Object> findCourseByUno(String uno);

	/*@Query(nativeQuery=true,value="select * from `course` group by tno,cname,dept,sc,grade having count(*)>=1; ")
	Course findMulCourse();*/

}
