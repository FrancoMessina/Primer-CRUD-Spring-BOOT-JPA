package com.capacitacioncrud.Primer.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private float sueldo;
}
