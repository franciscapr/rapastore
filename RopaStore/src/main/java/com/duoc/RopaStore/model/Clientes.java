package com.duoc.RopaStore.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientes {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String edad;

}
