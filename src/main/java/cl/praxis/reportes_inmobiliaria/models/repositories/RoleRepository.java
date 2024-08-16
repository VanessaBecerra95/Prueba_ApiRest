package cl.praxis.reportes_inmobiliaria.models.repositories;

import cl.praxis.reportes_inmobiliaria.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
