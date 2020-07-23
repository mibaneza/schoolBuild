package com.school.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestAPIs {
	
	@GetMapping("/api/test/student")
	@PreAuthorize("hasRole('STUDENT') or hasRole('ADMIN')")
	public String estuddentAccess() {
		return ">>> STUDENT Contents!";
	}
	
	@GetMapping("/api/test/professor")
	@PreAuthorize("hasRole('PROFESSOR') or hasRole('ADMIN')")
	public String professorAccess() {
		return ">>> PROFESSOR Contents!";
	}

	@GetMapping("/api/test/secrary")
	@PreAuthorize("hasRole('SECRETARY') or hasRole('ADMIN')")
	public String projectManagementAccess() {
		return ">>> SECRETARY Management Project";
	}
	
	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> ADMIN Contents";
	}
}