package com.projecthub.student.repositary;

import com.projecthub.student.dto.PastAbstractDTO;
import com.projecthub.student.entity.AbstractEntity;
import com.projecthub.student.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AbstractRepositary  extends JpaRepository<AbstractEntity,Long> {

    List<AbstractEntity> findByUserId(Long aLong);

    List<AbstractEntity> findByDepartment(String department);

//    List<AbstractEntity> findByDepartment(String department);

    //<AbstractEntity> findByUserId(Long userId);
    @Query(value="""
           select 
           ab.abstract_id,
           ab.title,
           re.action,
           re.remarks
           from abstracts as ab
           left join abstract_reviews re
           on ab.abstract_id=re.abstract_id
           where ab.user_id=:userId
                """, nativeQuery = true)
                                 List<StudentAbstractProjection> findStudentAbstractsNative(
                                     @Param("userId") Long userId
           );


    @Query(value = """
    SELECT s.*
    FROM abstracts s
    LEFT JOIN abstract_reviews r
        ON s.abstract_id = r.abstract_id
    WHERE s.department = :department
      AND r.abstract_id IS NULL
    """, nativeQuery = true)
    List<AbstractEntity> findPendingAbstractsByDepartment(
            @Param("department") String department
    );


    @Query(value = """
    SELECT 
        COUNT(*) AS total,
        SUM(CASE WHEN r.abstract_id IS NULL THEN 1 ELSE 0 END) AS pending,
        SUM(CASE WHEN r.action = 'APPROVED' THEN 1 ELSE 0 END) AS approved,
        SUM(CASE WHEN r.action = 'REJECTED' THEN 1 ELSE 0 END) AS rejected
    FROM abstracts s
    LEFT JOIN abstract_reviews r ON s.abstract_id = r.abstract_id
    WHERE s.department = :department
    """, nativeQuery = true)
    DashboardProjection getDashboardCounts(@Param("department") String department);
    public interface DashboardProjection {
        Long getTotal();
        Long getPending();
        Long getApproved();
        Long getRejected();
    }


    @Query(value = """
    SELECT 
        a.title AS title,
        a.abstract_text AS abstractText,
        a.technologies AS technologies
    FROM abstracts a
    INNER JOIN abstract_reviews r 
        ON a.abstract_id = r.abstract_id
    WHERE a.department = :department
      AND r.action = 'APPROVED'
    ORDER BY r.reviewed_at DESC
    LIMIT :limit
""", nativeQuery = true)
    List<PastAbstractDTO> findPastAbstractsForAI(
            @Param("department") String department,
            @Param("limit") int limit
    );






}
