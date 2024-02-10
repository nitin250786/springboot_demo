package net.javaguides.departmentservice.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String depatmentCode);

    DepartmentDto getDepartmentById(Long depatmentId);
}
