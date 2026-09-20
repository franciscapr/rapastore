package com.duoc.RopaStore.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sucursal {

    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private Integer disponibilidad;



}
