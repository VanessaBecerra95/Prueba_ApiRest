package cl.praxis.reportes_inmobiliaria.models.repositories;

import cl.praxis.reportes_inmobiliaria.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
