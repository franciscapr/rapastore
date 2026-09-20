package com.duoc.RopaStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ventas {

    private String codigoBoleta;
    private String fecha;
    private Integer total;
    private Long clienteId;
    private Long sucursalId;

}