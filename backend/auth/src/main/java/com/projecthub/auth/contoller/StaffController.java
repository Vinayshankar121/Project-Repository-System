package com.projecthub.auth.contoller;

import com.projecthub.auth.dto.StaffDto;
import com.projecthub.auth.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("auth/staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @PostMapping
    public void addStaff(@RequestBody StaffDto staffDto){
        staffService.addStaff(staffDto);

    }
}
