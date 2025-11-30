package ar.org.centro8.java.curso.model.repository.interfaces;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import ar.org.centro8.java.curso.model.entity.Venta;
import ar.org.centro8.java.curso.model.enums.EstadoVenta;

public interface IVentaRepository {
    List<Venta> findAll() throws SQLException;
    Venta findById(int id) throws SQLException;
    int save(int idCliente, LocalDateTime fecha, EstadoVenta estado, double total) throws SQLException;
    void updateEstadoYTotal(int id, EstadoVenta estado, double total) throws SQLException;
    void delete(int id) throws SQLException;
}