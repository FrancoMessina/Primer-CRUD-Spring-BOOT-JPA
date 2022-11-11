package com.capacitacioncrud.Primer.crud.service;

import com.capacitacioncrud.Primer.crud.domain.Empleado;
import com.capacitacioncrud.Primer.crud.model.EmpleadoDTO;

import java.util.List;

public interface IEmpleadoDTOService {
    public EmpleadoDTO convertToDto(Empleado employee);
}
