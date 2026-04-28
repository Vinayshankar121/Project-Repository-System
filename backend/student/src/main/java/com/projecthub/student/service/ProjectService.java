package com.projecthub.student.service;

import com.projecthub.student.entity.AbstractEntity;
import com.projecthub.student.entity.ProjectEntity;
import com.projecthub.student.repositary.ProjectRepositary;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
@NoArgsConstructor
public class ProjectService {
    @Autowired
    private ProjectRepositary projectRepositary;

    public void addProjects(ProjectEntity entity){
        projectRepositary.save(entity);
    }

    public List<ProjectEntity> getAllProjects(){
        return projectRepositary.findAll();
    }

    public List<ProjectEntity> getById(long id){
       return projectRepositary.findByUserId(id);
    }

    @Transactional
    public ProjectEntity updateProject(Long id, ProjectEntity projectEntity) {

        ProjectEntity existingProject = projectRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        if (projectEntity.getProjectTitle() != null) {
            existingProject.setProjectTitle(projectEntity.getProjectTitle());
        }

        if (projectEntity.getAbstractText() != null) {
            existingProject.setAbstractText(projectEntity.getAbstractText());
        }

        if (projectEntity.getDepartment()!= null) {
            existingProject.setDepartment(projectEntity.getDepartment());
        }

        if (projectEntity.getYear() != 0) {
            existingProject.setYear(projectEntity.getYear());
        }

        if (projectEntity.getTechnologies() != null) {
            existingProject.setTechnologies(projectEntity.getTechnologies());
        }

        if (projectEntity.getGithubLink() != null) {
            existingProject.setGithubLink(projectEntity.getGithubLink());
        }

        if (projectEntity.getUserId() != null) {
            existingProject.setUserId(projectEntity.getUserId());
        }



        return projectRepositary.save(existingProject);
    }

    public void deleteProject(Long id){
        projectRepositary.deleteById(id);
    }

}
