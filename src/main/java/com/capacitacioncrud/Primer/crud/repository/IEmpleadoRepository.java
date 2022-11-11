package com.capacitacioncrud.Primer.crud.repository;

import com.capacitacioncrud.Primer.crud.domain.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> {
}
