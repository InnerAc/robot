package com.dag.robot.entities;

// Generated 2015-5-13 19:55:40 by Hibernate Tools 4.3.1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RelExpertOrg generated by hbm2java
 */
@Entity
@Table(name = "rel_expert_org", catalog = "db_expert_robot")
public class RelExpertOrg implements java.io.Serializable {

	private RelExpertOrgId id;
	private Expert expert;
	private Orgnization orgnization;
	private String job;

	public RelExpertOrg() {
	}

	public RelExpertOrg(RelExpertOrgId id, Expert expert,
			Orgnization orgnization) {
		this.id = id;
		this.expert = expert;
		this.orgnization = orgnization;
	}

	public RelExpertOrg(RelExpertOrgId id, Expert expert,
			Orgnization orgnization, String job) {
		this.id = id;
		this.expert = expert;
		this.orgnization = orgnization;
		this.job = job;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "expertId", column = @Column(name = "expertId", nullable = false)),
			@AttributeOverride(name = "orgId", column = @Column(name = "orgId", nullable = false)) })
	public RelExpertOrgId getId() {
		return this.id;
	}

	public void setId(RelExpertOrgId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "expertId", nullable = false, insertable = false, updatable = false)
	public Expert getExpert() {
		return this.expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orgId", nullable = false, insertable = false, updatable = false)
	public Orgnization getOrgnization() {
		return this.orgnization;
	}

	public void setOrgnization(Orgnization orgnization) {
		this.orgnization = orgnization;
	}

	@Column(name = "job", length = 20)
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
