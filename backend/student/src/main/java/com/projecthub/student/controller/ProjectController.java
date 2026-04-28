package com.projecthub.student.controller;

import com.projecthub.student.entity.AbstractEntity;
import com.projecthub.student.entity.ProjectEntity;
import com.projecthub.student.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("project")
public class ProjectController {

@Autowired
private ProjectService projectService;
    @PostMapping("addidea")
    public void submitIdea(@RequestBody ProjectEntity entity){

        projectService.addProjects(entity);
    }
    @GetMapping
    public List<ProjectEntity> getAllProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping("{id}")
    public List<ProjectEntity> getByid(@PathVariable long id){
        return projectService.getById(id);
    }


    @PatchMapping("/update/{id}")
    public ProjectEntity updateAbstract(@PathVariable Long id,
                                         @RequestBody ProjectEntity projectEntity) {
        return projectService.updateProject(id, projectEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
    }
}
