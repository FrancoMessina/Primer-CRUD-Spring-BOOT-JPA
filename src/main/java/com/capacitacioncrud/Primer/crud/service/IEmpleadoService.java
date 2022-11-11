package com.capacitacioncrud.Primer.crud.service;

import com.capacitacioncrud.Primer.crud.domain.Empleado;
import com.capacitacioncrud.Primer.crud.model.EmpleadoDTO;

import java.util.List;

public interface IEmpleadoService {
    //TODO Read
    public List<Empleado> getEmployees();
    //TODO Create
    public Empleado saveEmployee(Empleado employee);
    //TODO Delete
    public Boolean deleteEmployee(Long id);
    //TODO find employee
    public Empleado findEmployee(Long id);
    //TODO Update
    public Empleado editEmployee(Long id, int newDni,
                                String newName, String newSurname,
                                int newAge, float newSalary);
}
