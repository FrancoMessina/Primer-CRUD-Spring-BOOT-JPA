package com.capacitacioncrud.Primer.crud.service;

import com.capacitacioncrud.Primer.crud.domain.Empleado;
import com.capacitacioncrud.Primer.crud.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements  IEmpleadoService{
    @Autowired
    IEmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> getEmployees() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado saveEmployee(Empleado employee) {
        Empleado empleado = empleadoRepository.save(employee);
        return empleado;
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        if(id == null) return false;
        empleadoRepository.deleteById(id);
        return true;
    }

    @Override
    public Empleado findEmployee(Long id) {
        Empleado employee = empleadoRepository.findById(id).orElse(null);
        return employee;
    }
    @Override
    public Empleado editEmployee(Long id, int newDni,
                             String newName, String newSurname,
                             int newAge, float newSalary) {
        //Buscamos el empleado
        Empleado employee = this.findEmployee(id);
        //Le agregamos los nuevos datos
        if(newDni > 1000000)
            employee.setDni(newDni);
        if(newName.length() > 3)
            employee.setNombre(newName);
        if(newSurname.length() > 3)
            employee.setApellido(newSurname);

        if(newSalary > 45000)
            employee.setSueldo(newSalary);
        if(newAge > 17)
            employee.setEdad(newAge);
        //Guardamos los cambios
        this.saveEmployee(employee);
        return employee;
    }
}
