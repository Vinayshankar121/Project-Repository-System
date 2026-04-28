package com.projecthub.auth.service;

import com.projecthub.auth.dto.StaffDto;
import com.projecthub.auth.entity.StaffEntity;
import com.projecthub.auth.entity.UserEntity;
import com.projecthub.auth.enums.Role;
import com.projecthub.auth.repository.StaffRepository;
import com.projecthub.auth.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class StaffService {

   private final StaffRepository staffRepository;
   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;
    @Transactional
    public void addStaff(StaffDto staffDto){

        if(userRepository.findByEmail(staffDto.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }

        UserEntity userEntity=new UserEntity();
        userEntity.setEmail(staffDto.getEmail());
        userEntity.setPassword(passwordEncoder.encode(staffDto.getPassword()));
        userEntity.setRole(Role.STAFF);

        UserEntity user=userRepository.save(userEntity);

        StaffEntity staffEntity=new StaffEntity();
        staffEntity.setUser(user);
        staffEntity.setStaff_name(staffDto.getName());
        staffEntity.setStaff_id(staffDto.getStaffId());
        staffEntity.setDepartment(staffDto.getDepartment());
        staffEntity.setDesignation(staffDto.getDesignation());
        staffEntity.setPhone(staffDto.getPhone());

        staffRepository.save(staffEntity);

    }
}
