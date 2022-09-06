package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProjectDetailsDto;
import com.example.demo.entity.ProjectDetails;
import com.example.demo.exception.ProjectDetailException;

public interface ProjectDetailsService {

	public void addProjectDetails(ProjectDetailsDto p);
	
	public void updateProjectDetais(int projectDetailsId) throws ProjectDetailException;
	
	public void deleteProjectDetails(int projectDetailsId) throws ProjectDetailException;
	
	public List<ProjectDetailsDto> listProjectDetails() throws ProjectDetailException;
}
 