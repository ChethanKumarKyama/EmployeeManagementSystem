package com.empman.service;

import com.empman.entity.Project;

public interface ProjectService {
	void createProject(Project project);
	void deleteProject(Project project);
	void updateProject(Project project);
	void getProject(int id);
	Project getProjectD(int id);
	void getProjects();
	void getprojectMembers();
}
