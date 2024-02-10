package net.javaguides.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.exception.ErrorDetails;
import net.javaguides.departmentservice.exception.ResourceNotFoundException;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
        return  new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
    }

    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("departmentCode") String departmentCode){
        DepartmentDto savedDepartmentDto = departmentService.getDepartmentByCode(departmentCode);
        return  new ResponseEntity<>(savedDepartmentDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("getDepartmentById/{departmentId}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("departmentId") Long departmenId){
        DepartmentDto savedDepartmentDto = departmentService.getDepartmentById(departmenId);
        return  new ResponseEntity<>(savedDepartmentDto, HttpStatus.ACCEPTED);
    }

    /*@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                resourceNotFoundException.getMessage(),
                webRequest.getDescription(false),
                "Department Id Not Found"
        );
        return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }*/
}
