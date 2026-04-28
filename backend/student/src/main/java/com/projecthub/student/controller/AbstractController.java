package com.projecthub.student.controller;


import com.projecthub.student.entity.AbstractEntity;
import com.projecthub.student.repositary.AbstractRepositary;
import com.projecthub.student.repositary.StudentAbstractProjection;
import com.projecthub.student.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("abstract")
public class AbstractController {
    @Autowired
    AbstractService abstractService;

        @PostMapping
        public void submitAbstract(@RequestBody AbstractEntity abstractEntity){
            abstractService.submitAbstract(abstractEntity);
        }

        @GetMapping("/{id}")
        public List<AbstractEntity> get(@PathVariable Long id){
            return abstractService.get(id);
        }

        @GetMapping("/department/{department}")
        public List<AbstractEntity> getByDepartment(@PathVariable String department){
            return abstractService.getByDepartment(department);
        }

        @GetMapping("status/{userId}")
        public List<StudentAbstractProjection> returnStatus(@PathVariable Long userId){
            return abstractService.showStatus(userId);
        }

        @GetMapping("dashboard/{department}")
        public AbstractRepositary.DashboardProjection dashboard(@PathVariable String department){
            return abstractService.dashboard(department);
        }
        @GetMapping("/departmentAi/{department}")
        public String getPastAbstractsForAI(@PathVariable String department){
            return abstractService.getPastAbstractsForAI(department);
        }


        @GetMapping("/history/{department}")
        public List<AbstractEntity> department(@PathVariable String department){
          return abstractService.department(department);
        }

    @PatchMapping("/update/{id}")
    public AbstractEntity updateAbstract(@PathVariable Long id,
                                         @RequestBody AbstractEntity abstractEntity) {
        return abstractService.updateAbstract(id, abstractEntity);
    }



    @DeleteMapping("/delete/{id}")
    public void deleteAbstract(@PathVariable Long id){
            abstractService.deleteAbstract(id);
    }

}
