package cl.praxis.reportes_inmobiliaria.models.services;

import cl.praxis.reportes_inmobiliaria.models.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(Integer id);
    boolean create(Role role);
    boolean update(Role role);
    boolean delete(Integer id);
}
