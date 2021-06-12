package org.iesalixar.jmoreno.proyecto.repository;

import org.iesalixar.jmoreno.proyecto.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findById(long id);
}
