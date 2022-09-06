package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProjectDetailsDto;
import com.example.demo.entity.ProjectDetails;
import com.example.demo.exception.ProjectDetailException;
import com.example.demo.repository.ProjectDetailsRepository;

@Service
@Transactional
public class ProjectDetailsServiceImpl implements ProjectDetailsService {

	@Autowired
	private ProjectDetailsRepository projectRepo;
	
	@Override
	public void addProjectDetails(ProjectDetailsDto p) {
		
		ProjectDetails prod = new ProjectDetails();
		prod.setTitle(p.getTitle());
		prod.setBudget(p.getBudget());
		prod.setTeamSize(p.getTeamSize());
		prod.setDuration(p.getDuration());
		prod.setEndDate(p.getEndDate());
		prod.setManagerName(p.getManagerName());
	    
	    projectRepo.save(prod);
	    
	}

	@Override
	public void updateProjectDetais(int projectDetailsId) throws ProjectDetailException {
		
		Optional<ProjectDetails> pd = projectRepo.findById(projectDetailsId);
		ProjectDetails p = pd.orElseThrow(() -> new ProjectDetailException("Project Detail Does not exist with this ID"));
	
		p.setBudget(90000);
	}

	@Override
	public void deleteProjectDetails(int projectDetailsId) throws ProjectDetailException {
		Optional<ProjectDetails> pd = projectRepo.findById(projectDetailsId);
		ProjectDetails p = pd.orElseThrow(() -> new ProjectDetailException("Project Detail Does not exist with this ID"));
		
	     projectRepo.deleteById(projectDetailsId);
	     
	}

	@Override
	public List<ProjectDetailsDto> listProjectDetails() throws ProjectDetailException{
		Iterable<ProjectDetails> projectDetails = projectRepo.findAll();
		List<ProjectDetailsDto> pdo = new ArrayList<ProjectDetailsDto>();
		
		projectDetails.forEach(pd -> {
			ProjectDetailsDto pdto = new ProjectDetailsDto();
			pdto.setProjectId(pd.getProjectId());
			pdto.setTitle(pd.getTitle());
			pdto.setBudget(pd.getBudget());
			pdto.setDuration(pd.getDuration());
			pdto.setTeamSize(pd.getTeamSize());
			pdto.setEndDate(pd.getEndDate());
			pdto.setManagerName(pd.getManagerName());
			pdo.add(pdto);
		});
		
		if(pdo.isEmpty()) {
			throw new ProjectDetailException("No record found");
		}
		return pdo;
	}

}
