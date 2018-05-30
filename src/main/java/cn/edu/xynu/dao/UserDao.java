package cn.edu.xynu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.edu.xynu.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

	 User findByUnoAndPasswordAndRole(String uno, String password, Integer role);
	 
	 User findByUno(String uno);

	 @Query(nativeQuery=true,value="select user.account from `user` where user.uno= ?1 ;")
	 String findAccountByUno(String uno);

/*	 @Query(nativeQuery=true,value="select user.role from `user` where user.uno= ?1 ;")
	 int findByTno(String tno);
	 
	 @Query(nativeQuery=true,value="select u.role from `user` u,`notice` n where n.id= ?1 and n.tno=u.uno;")
	 int findByDelId(Integer id);*/

	


}
