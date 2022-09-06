package com.example.demo.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProjectDetails")
public class ProjectDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="project_id")
	private int projectId;
	@Column(name="title")
	private String title;
	@Column(name="budget")
	private double budget;
	@Column(name = "team_size")
	private int teamSize;
	@Column(name = "duration")
	private int duration;
	@Column(name = "end_date")
	private LocalDate endDate;
	@Column(name = "manager_name")
	private String managerName;
	
	public ProjectDetails(int projectId, String title, double budget, int teamSize, int duration, LocalDate endDate,
			String managerName) {
		
		this.projectId = projectId;
		this.title = title;
		this.budget = budget;
		this.teamSize = teamSize;
		this.duration = duration;
		this.endDate = endDate;
		this.managerName = managerName;
	}
	public ProjectDetails() {
		
	}
	@Override
	public String toString() {
		return "ProjectDetails [projectId=" + projectId + ", title=" + title + ", budget=" + budget + ", teamSize="
				+ teamSize + ", duration=" + duration + ", endDate=" + endDate + ", managerName=" + managerName + "]";
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
}
