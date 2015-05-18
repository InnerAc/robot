package com.dag.robot.entities;

// Generated 2015-5-18 21:02:56 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * CoreJournal generated by hbm2java
 */
@Entity
@Table(name = "coreJournal", catalog = "db_expert_robot")
public class CoreJournal implements java.io.Serializable {

	private Integer coreJournalId;
	private String name;
	private int rate = 0;
	private Set<Paper> papers = new HashSet<Paper>(0);

	public CoreJournal() {
	}

	public CoreJournal(String name, int rate) {
		this.name = name;
		this.rate = rate;
	}

	public CoreJournal(String name, int rate, Set<Paper> papers) {
		this.name = name;
		this.rate = rate;
		this.papers = papers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "coreJournalId", unique = true, nullable = false)
	public Integer getCoreJournalId() {
		return this.coreJournalId;
	}

	public void setCoreJournalId(Integer coreJournalId) {
		this.coreJournalId = coreJournalId;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "rate", nullable = false)
	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "coreJournals")
	public Set<Paper> getPapers() {
		return this.papers;
	}

	public void setPapers(Set<Paper> papers) {
		this.papers = papers;
	}

}
