package com.duoc.RopaStore.service;

import com.duoc.RopaStore.model.Ventas;
import com.duoc.RopaStore.repository.VentasRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentasService {

    private final VentasRepository repository;

    public VentasService(VentasRepository repository) {
        this.repository = repository;
    }

    //Obtenemos todas las venta
    public List<Ventas> obtenerVentas() {
        return repository.findAll();
    }


    //Buscarmos una venta por su codigo de boleta
    public Optional<Ventas> obtenerPorCodigoBoleta(String codigoBoleta) {
        return repository.findByCodigoBoleta(codigoBoleta);
    }

    //Creamos nueva venta
    public Ventas guardarVenta(Ventas venta) {
        return repository.save(venta);
    }

    //Actualizamos una venta
    public Ventas actualizarVenta(String codigoBoleta, Ventas venta) {
        return repository.update(codigoBoleta, venta);
    }

    // Eliminamos una venta
    public boolean eliminarVenta(String codigoBoleta) {
        return repository.deleteByCodigoBoleta(codigoBoleta);
    }
}