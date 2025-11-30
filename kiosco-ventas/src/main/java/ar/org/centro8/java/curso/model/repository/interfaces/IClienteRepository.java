package ar.org.centro8.java.curso.model.repository.interfaces;

import java.sql.SQLException;
import java.util.List;

import ar.org.centro8.java.curso.model.entity.Cliente;

public interface IClienteRepository {
    List<Cliente> findAll() throws SQLException;
    Cliente findById(int id) throws SQLException;
    void save(Cliente c) throws SQLException;
    void update(Cliente c) throws SQLException;
    void delete(int id) throws SQLException;
}