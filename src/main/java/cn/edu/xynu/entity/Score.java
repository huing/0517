package cn.edu.xynu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class Score {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	private Integer snoId;	 //学号
	private Integer tnoId;	 //工号
	@Column(name="mark")
	private Double mark;	 //分数
	private Integer pass;	 //是否通过
	private Integer role;
	private Date updtime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSnoId() {
		return snoId;
	}
	public void setSnoId(Integer snoId) {
		this.snoId = snoId;
	}
	public Integer getTnoId() {
		return tnoId;
	}
	public void setTnoId(Integer tnoId) {
		this.tnoId = tnoId;
	}
	public Double getMark() {
		return mark;
	}
	public void setMark(Double mark) {
		this.mark = mark;
	}
	public Integer getPass() {
		return pass;
	}
	public void setPass(Integer pass) {
		this.pass = pass;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Date getUpdtime() {
		return updtime;
	}
	public void setUpdtime(Date updtime) {
		this.updtime = updtime;
	}
	
	
}
