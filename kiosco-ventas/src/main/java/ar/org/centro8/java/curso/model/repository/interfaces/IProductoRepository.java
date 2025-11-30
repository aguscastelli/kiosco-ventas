package ar.org.centro8.java.curso.model.repository.interfaces;

import java.sql.SQLException;
import java.util.List;

import ar.org.centro8.java.curso.model.entity.Producto;

public interface IProductoRepository {
    List<Producto> findAll() throws SQLException;
    Producto findById(int id) throws SQLException;
    void save(Producto p) throws SQLException;
    void update(Producto p) throws SQLException;
    void delete(int id) throws SQLException;
}