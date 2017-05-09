package net.devk.usermanagement;

import java.util.List;

import net.devk.model.Role;

public interface UserManagementService {

	public Role createRole(String roleName, String roleDescription);

	public List<Role> findAllRoles();

	public Number countAllRoles();

}
