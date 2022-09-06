package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProjectDetailsDto;
import com.example.demo.exception.ProjectDetailException;
import com.example.demo.service.ProjectDetailsService;

@RestController
@RequestMapping(value = "/project")
public class ProjectDetailsController {

	@Autowired
	private ProjectDetailsService projectDetailsService;

	@PostMapping("/projectDetails")
	public ResponseEntity<String> addProjectDetails(@RequestBody ProjectDetailsDto pdo) {

		projectDetailsService.addProjectDetails(pdo);

		return new ResponseEntity<String>("Project Details has been successfully added", HttpStatus.CREATED);
	}

	@PutMapping("/projectDetails/{id}")
	public ResponseEntity<String> updateProjectDetails(@PathVariable int id) throws ProjectDetailException {
		projectDetailsService.updateProjectDetais(id);
		return new ResponseEntity<String>("Project Details Updated Successfully", HttpStatus.OK);
	}

	@DeleteMapping("/projectDetails/{id}")
	public ResponseEntity<String> deleteProjectDetails(@PathVariable int id) throws ProjectDetailException {
		projectDetailsService.deleteProjectDetails(id);
		return new ResponseEntity<String>("Project Details deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/projectDetails")
	public ResponseEntity<List<ProjectDetailsDto>> getAllProjectDetails() throws ProjectDetailException {
		List<ProjectDetailsDto> projectDetailsDtos = projectDetailsService.listProjectDetails();
		return new ResponseEntity(projectDetailsDtos, HttpStatus.OK);
	}
}
