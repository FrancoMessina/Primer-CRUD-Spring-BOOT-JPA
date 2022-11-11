package com.capacitacioncrud.Primer.crud.controller;

import com.capacitacioncrud.Primer.crud.domain.Empleado;
import com.capacitacioncrud.Primer.crud.model.EmpleadoDTO;
import com.capacitacioncrud.Primer.crud.service.IEmpleadoDTOService;
import com.capacitacioncrud.Primer.crud.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmpleadoController {
    @Autowired
    private IEmpleadoService empleadoService;
    @Autowired
    private IEmpleadoDTOService empleadoDTOService;

    @GetMapping("/employees")
    @ResponseBody
    public List<EmpleadoDTO> getEmployees(){
        List<Empleado> listEmployees = empleadoService.getEmployees();//Empleados comunes
        return listEmployees.stream()
                .map(empleadoDTOService::convertToDto)
                .collect(Collectors.toList());
    }
    @PostMapping("/employees/create")
    @ResponseStatus(HttpStatus.CREATED)
    //Response Entity
    public EmpleadoDTO saveEmployee(@RequestBody Empleado empleado){
         Empleado employee =  empleadoService.saveEmployee(empleado);
         EmpleadoDTO empleadoDTO = empleadoDTOService.convertToDto(employee);
         return empleadoDTO;
    }
    @DeleteMapping("/employees/delete/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String deleteEmployee(@PathVariable Long id){
        if(empleadoService.deleteEmployee(id))
            return "Empleado eliminado correctamente";
        return "No se pudo eliminar el empleado";
    }
    @PutMapping("/employees/edit/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Empleado editEmployee(@PathVariable Long id,
                                 @Nullable @RequestParam (required = false, value = "dni", defaultValue = "0", name = "dni")int newDni,
                                 @Nullable @RequestParam (required = false, value = "nombre", defaultValue = " ", name = "nombre")String newName,
                                 @Nullable @RequestParam (required = false, value = "apellido", defaultValue = " ", name = "apellido")String newSurname,
                                 @Nullable @RequestParam (required = false, value = "edad", defaultValue = "0", name = "edad")int newAge,
                                 @Nullable @RequestParam (required = false, value = "salario", defaultValue = "0", name = "salario")float newSalary){

        empleadoService.editEmployee(id,newDni,newName,newSurname,newAge,newSalary);
        Empleado employee = empleadoService.findEmployee(id);
        return  employee;
    }
}
