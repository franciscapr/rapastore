package com.duoc.RopaStore.service;


import com.duoc.RopaStore.model.Sucursal;
import com.duoc.RopaStore.repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    private SucursalRepository repository;

    public SucursalService(SucursalRepository repository) {
        this.repository = repository;
    }

    //Obtenemos todas las sucursales
    public List<Sucursal> obtenerSucursales(){
        return repository.findAll();
    }

    //Obtenemos sucursal por orden alfabetico
    public List<Sucursal> ordenarPorNombre(){
        List<Sucursal> sucursales = new ArrayList<>(repository.findAll());

        sucursales.sort(
                (p1, p2)-> p1.getNombre().compareToIgnoreCase(p2.getNombre())
        );
        return sucursales;
    }

    //Buscarmos sucursal por ID
    public Optional<Sucursal> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    //Creamos nueva sucursal
    public Sucursal guardarSucursal(Sucursal sucursal) {
        return repository.save(sucursal);
    }

    //Actualizamos una sucursal
    public Sucursal actualizarSucursal(Long id, Sucursal sucursal) {
        return repository.update(id, sucursal);
    }

    // Eliminamos una sucursal
    public boolean eliminarSucursal(Long id) {
        return repository.deleteById(id);
    }


}
