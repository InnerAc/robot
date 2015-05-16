package com.dag.robot.entities;

// Generated 2015-5-13 19:55:40 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Expert generated by hbm2java
 */
@Entity
@Table(name = "expert", catalog = "db_expert_robot")
public class Expert implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer expertId;
	private String name;
	private String gender;
	private String email;
	private String address;
	private String homepage;
	private int paperNum;
	private int patentNum;
	private int paperReferedNum;
	private String prize;
	private String experience;
	private String info;
	private String achievement;
	private String activity;
	private Set<RelExpertPatent> relExpertPatents = new HashSet<RelExpertPatent>(
			0);
	private Set<RelExpertTopic> relExpertTopics = new HashSet<RelExpertTopic>(0);
	private Set<RelExpertField> relExpertFields = new HashSet<RelExpertField>(0);
	private Set<User> users = new HashSet<User>(0);
	private Set<RelExpertOrg> relExpertOrgs = new HashSet<RelExpertOrg>(0);
	private Set<RelExpertPaper> relExpertPapers = new HashSet<RelExpertPaper>(0);

	public Expert() {
	}

	public Expert(String name, String gender, int paperNum, int patentNum,
			int paperReferedNum) {
		this.name = name;
		this.gender = gender;
		this.paperNum = paperNum;
		this.patentNum = patentNum;
		this.paperReferedNum = paperReferedNum;
	}
	
	
	public Expert(String name, String gender, String email, String address,
			String homepage, String experience, String info,
			String achievement) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.homepage = homepage;
		this.experience = experience;
		this.info = info;
		this.achievement = achievement;
	}

	public Expert(String name, String gender, String email, String address,
			String homepage, int paperNum, int patentNum, int paperReferedNum,
			String prize, String experience, String info, String achievement,
			String activity, Set<RelExpertPatent> relExpertPatents,
			Set<RelExpertTopic> relExpertTopics,
			Set<RelExpertField> relExpertFields, Set<User> users,
			Set<RelExpertOrg> relExpertOrgs, Set<RelExpertPaper> relExpertPapers) {
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.homepage = homepage;
		this.paperNum = paperNum;
		this.patentNum = patentNum;
		this.paperReferedNum = paperReferedNum;
		this.prize = prize;
		this.experience = experience;
		this.info = info;
		this.achievement = achievement;
		this.activity = activity;
		this.relExpertPatents = relExpertPatents;
		this.relExpertTopics = relExpertTopics;
		this.relExpertFields = relExpertFields;
		this.users = users;
		this.relExpertOrgs = relExpertOrgs;
		this.relExpertPapers = relExpertPapers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "expertId", unique = true, nullable = false)
	public Integer getExpertId() {
		return this.expertId;
	}

	public void setExpertId(Integer expertId) {
		this.expertId = expertId;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "gender", nullable = false, length = 20)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "address", length = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "homepage", length = 50)
	public String getHomepage() {
		return this.homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	@Column(name = "paperNum", nullable = false)
	public int getPaperNum() {
		return this.paperNum;
	}

	public void setPaperNum(int paperNum) {
		this.paperNum = paperNum;
	}

	@Column(name = "patentNum", nullable = false)
	public int getPatentNum() {
		return this.patentNum;
	}

	public void setPatentNum(int patentNum) {
		this.patentNum = patentNum;
	}

	@Column(name = "paperReferedNum", nullable = false)
	public int getPaperReferedNum() {
		return this.paperReferedNum;
	}

	public void setPaperReferedNum(int paperReferedNum) {
		this.paperReferedNum = paperReferedNum;
	}

	@Column(name = "prize", length = 65535)
	public String getPrize() {
		return this.prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	@Column(name = "experience", length = 65535)
	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	@Column(name = "info", length = 65535)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "achievement", length = 65535)
	public String getAchievement() {
		return this.achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	@Column(name = "activity", length = 65535)
	public String getActivity() {
		return this.activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expert")
	public Set<RelExpertPatent> getRelExpertPatents() {
		return this.relExpertPatents;
	}

	public void setRelExpertPatents(Set<RelExpertPatent> relExpertPatents) {
		this.relExpertPatents = relExpertPatents;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expert")
	public Set<RelExpertTopic> getRelExpertTopics() {
		return this.relExpertTopics;
	}

	public void setRelExpertTopics(Set<RelExpertTopic> relExpertTopics) {
		this.relExpertTopics = relExpertTopics;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expert")
	public Set<RelExpertField> getRelExpertFields() {
		return this.relExpertFields;
	}

	public void setRelExpertFields(Set<RelExpertField> relExpertFields) {
		this.relExpertFields = relExpertFields;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "experts")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expert")
	public Set<RelExpertOrg> getRelExpertOrgs() {
		return this.relExpertOrgs;
	}

	public void setRelExpertOrgs(Set<RelExpertOrg> relExpertOrgs) {
		this.relExpertOrgs = relExpertOrgs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expert")
	public Set<RelExpertPaper> getRelExpertPapers() {
		return this.relExpertPapers;
	}

	public void setRelExpertPapers(Set<RelExpertPaper> relExpertPapers) {
		this.relExpertPapers = relExpertPapers;
	}

}
