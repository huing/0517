package cn.edu.xynu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.edu.xynu.entity.Notice;

public interface NoticeDao extends JpaRepository<Notice, Integer> {
	
	// 查询  按标题搜索	
	@Query(nativeQuery = true, value = "select n.id, n.title, n.content, n.updtime from `notice` n where n.title like ?1 ;")
	List<Object[]> findAllNoticeByTitle(String title);
	// 查询  按内容搜索	
	@Query(nativeQuery = true, value = "select n.id, n.title, n.content, n.updtime from `notice` n where n.content like ?1 ;")
	List<Object[]> findAllNoticeByContent(String content);
	//显示全部公告信息
	@Query(nativeQuery = true, value ="select n.id, n.title, n.content, n.updtime from `notice` n where n.role= ?1 or n.role=0 ;")
	List<Object[]> findByRole(Integer role);
	
/*	//教师登录
	@Query(nativeQuery=true, value="select n.id, n.title, n.content, n.updtime, u.account author "
			+ "from `notice` n ,`user` u where n.tno= ?1 ;")
	List<Object[]> findAllNoticeByTno(String uno);
	//学生登录
	@Query(nativeQuery=true, value="select n.id, n.title, n.content, n.updtime, u.account author "
			+ "from `notice` n ,`user` u where n.sc = (select student.sc from `student` where student.sno= ?1 )"
			+ "and n.tno=u.uno;")
	List<Object[]> findAllNoticeBySno(String uno);
	//管理员登录 查看所有公告
	@Query(nativeQuery=true, value="select n.id, n.title, n.content, n.updtime, u.account author "
			+ "from `notice` n ,`user` u where n.tno=u.uno ;")
	List<Object[]>  findAllNotice();*/
	
/*	// 查询  按标题搜索	
	@Query(nativeQuery = true, value = "select n.id, n.title, n.content, n.updtime, u.account author "
			+ "from `notice` n, `user` u where n.sc = (select s.sc from `student` s where s.sno = ?1 ) "
			+ "and u.account like ?2 and n.tno = u.uno;")
	List<Object[]> findAllNoticeByTitle(String uno, String title);
	// 查询  按内容搜索	
	@Query(nativeQuery = true, value = "select n.id, n.title, n.content, n.updtime, u.account author "
			+ "from `notice` n, `user` u where n.sc = (select s.sc from `student` s where s.sno = ?1 ) "
			+ "and n.content like ?2 and n.tno = u.uno;")
	List<Object[]> findAllNoticeByContent(String uno, String content);*/
	;
}
