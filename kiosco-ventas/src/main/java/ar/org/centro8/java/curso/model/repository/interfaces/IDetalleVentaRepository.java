package ar.org.centro8.java.curso.model.repository.interfaces;

import java.sql.SQLException;
import java.util.List;

import ar.org.centro8.java.curso.model.entity.DetalleVenta;

public interface IDetalleVentaRepository {
    List<DetalleVenta> findByVenta(int idVenta) throws SQLException;
    void save(DetalleVenta d) throws SQLException;
    void deleteByVenta(int idVenta) throws SQLException;
}