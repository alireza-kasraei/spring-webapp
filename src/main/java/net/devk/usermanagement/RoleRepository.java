package net.devk.usermanagement;

import org.springframework.data.jpa.repository.JpaRepository;

import net.devk.model.Role;

interface RoleRepository extends JpaRepository<Role, Long> {

}
