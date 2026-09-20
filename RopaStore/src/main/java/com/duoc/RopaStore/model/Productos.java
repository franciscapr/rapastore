package com.duoc.RopaStore.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productos {

    private Long id;
    private String nombre;
    private String descripcion;
    private Integer precio;


}
