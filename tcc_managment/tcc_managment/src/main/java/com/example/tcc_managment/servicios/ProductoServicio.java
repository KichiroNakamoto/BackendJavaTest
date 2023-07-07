package com.example.tcc_managment.servicios;

import com.example.tcc_managment.entities.Producto;
import com.example.tcc_managment.repository.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio implements ServicioBase<Producto> {

    @Autowired
    public ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> buscarTodo() throws Exception {
        try {
            return productoRepositorio.findAll();

        } catch (Exception error){
            throw new Exception(error.getMessage());

        }

    }
    @Override
    public List<Producto> buscarPorlugarAlmacenaje(String lugarAlmacenaje) throws Exception {
        return null;
    }

    @Override
    public Producto buscarPorId(Integer id) throws Exception {
        try {
          Optional<Producto> productoOpcionalid = productoRepositorio.findById(id);
           if(productoOpcionalid.isPresent()){
               return productoOpcionalid.get();
           }else{
             throw new Exception("Id del Producto no existe");
           }

        } catch (Exception error){
            throw new Exception(error.getMessage());

        }

    }

    @Override
    public Producto registrarProducto(Producto datosARegistrar) throws Exception {
        try {
            return productoRepositorio.save(datosARegistrar);

        } catch (Exception error){
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public Producto actualizarProdcuto(Integer id, Producto datosNuevos) throws Exception {
        try {
            Optional<Producto> productoOpcionalid = productoRepositorio.findById(id);
            if(productoOpcionalid.isPresent()){
               Producto productoExistente = productoOpcionalid.get();
               productoExistente.setNombre(datosNuevos.getNombre());
               productoExistente.setVolumen(datosNuevos.getVolumen());
               Producto productoActualizado = productoRepositorio.save(productoExistente);
               return productoActualizado;
            }else{
                throw new Exception("Id del Producto no existe");
            }

        } catch (Exception error){
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public boolean eliminarProducto(Integer id) throws Exception {
        try {
            Optional<Producto> productoOpcionalid = productoRepositorio.findById(id);
            if(productoOpcionalid.isPresent()){
                productoRepositorio.deleteById(id);

                return false;
            }else{
                throw new Exception("Id del Producto no existe");
            }

        } catch (Exception error){
            throw new Exception(error.getMessage());

        }
    }
}
