package com.capacitacioncrud.Primer.crud.service;

import com.capacitacioncrud.Primer.crud.domain.Empleado;
import com.capacitacioncrud.Primer.crud.model.EmpleadoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoDTOService implements IEmpleadoDTOService {
    private ModelMapper modelMapper;


    @Override
    public EmpleadoDTO convertToDto(Empleado employee) {
        modelMapper = new ModelMapper();
        EmpleadoDTO employeeDTO = modelMapper.map(employee, EmpleadoDTO.class);
        employeeDTO.setApellido(employee.getApellido());
        employeeDTO.setDni(employee.getDni());
        employeeDTO.setNombre(employee.getNombre());
        employeeDTO.setEdad(employee.getEdad());
        employeeDTO.setSueldo(employee.getSueldo());
        return employeeDTO;
    }
}
