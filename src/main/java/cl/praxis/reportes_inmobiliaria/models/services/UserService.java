package cl.praxis.reportes_inmobiliaria.models.services;

import cl.praxis.reportes_inmobiliaria.models.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    boolean create(User user);
    boolean update(User user);
    boolean delete(Integer id);
}
