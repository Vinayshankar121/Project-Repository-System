package com.projecthub.student.service;

import com.projecthub.student.dto.PastAbstractDTO;
import com.projecthub.student.entity.AbstractEntity;
import com.projecthub.student.repositary.AbstractRepositary;
import com.projecthub.student.repositary.StudentAbstractProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbstractService {
    @Autowired
    AbstractRepositary abstractRepositary;

    public void submitAbstract(AbstractEntity abstractEntity) {

        abstractRepositary.save(abstractEntity);
    }

    public List<AbstractEntity> get(Long id){
      return abstractRepositary.findByUserId(id);
    }

    public List<AbstractEntity> getByDepartment(String department){
        return abstractRepositary.findPendingAbstractsByDepartment(department);

    }

    public List<StudentAbstractProjection> showStatus(Long userId){
        return abstractRepositary.findStudentAbstractsNative(userId);
    }

    public AbstractRepositary.DashboardProjection dashboard(String department){
        return abstractRepositary.getDashboardCounts(department);
    }

    public String getPastAbstractsForAI(String department){



        List<PastAbstractDTO> pastAbstracts= abstractRepositary.findPastAbstractsForAI(department,10);
        if (pastAbstracts == null || pastAbstracts.isEmpty()) {
            return "No previously approved abstracts found for this department.";
        }

        StringBuilder context = new StringBuilder();
        context.append("Past approved project abstracts from the same department:\n\n");

        int index = 1;
        for (PastAbstractDTO dto : pastAbstracts) {
            context.append(index++).append(".\n");
            context.append("Title: ").append(dto.getTitle()).append("\n");
            context.append("Abstract: ").append(dto.getAbstractText()).append("\n");
            context.append("Technologies: ").append(dto.getTechnologies()).append("\n\n");
        }

        return context.toString();

    }

    public AbstractEntity updateAbstract(Long id, AbstractEntity abstractEntity) {

        AbstractEntity existingAbstract = abstractRepositary.findById(id)
                .orElseThrow(() -> new RuntimeException("Abstract not found"));

        if (abstractEntity.getTitle() != null) {
            existingAbstract.setTitle(abstractEntity.getTitle());
        }

        if (abstractEntity.getAbstractText() != null) {
            existingAbstract.setAbstractText(abstractEntity.getAbstractText());
        }

        if (abstractEntity.getTechnologies() != null) {
            existingAbstract.setTechnologies(abstractEntity.getTechnologies());
        }

        if (abstractEntity.getDepartment() != null) {
            existingAbstract.setDepartment(abstractEntity.getDepartment());
        }

        if (abstractEntity.getStatus() != null) {
            existingAbstract.setStatus(abstractEntity.getStatus());
        }

        return abstractRepositary.save(existingAbstract);
    }

    public void deleteAbstract(Long id){
        abstractRepositary.deleteById(id);
    }

    public List<AbstractEntity> department(String department){
        return abstractRepositary.findByDepartment(department);
    }
}
