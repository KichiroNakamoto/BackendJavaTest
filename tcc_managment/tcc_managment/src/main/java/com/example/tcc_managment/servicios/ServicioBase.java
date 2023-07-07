package com.example.tcc_managment.servicios;
import com.example.tcc_managment.entities.Producto;
import java.util.List;

public interface ServicioBase<E> {

    public List<E> buscarTodo() throws Exception;

    public List<E> buscarPorlugarAlmacenaje(String lugarAlmacenaje) throws Exception;
    public Producto buscarPorId(Integer id) throws Exception;

    public Producto registrarProducto(Producto datosARegistrar) throws Exception;

    public Producto actualizarProdcuto(Integer id, E datosNuevos) throws Exception;

    public boolean eliminarProducto(Integer id) throws Exception;


}
