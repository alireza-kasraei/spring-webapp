package net.devk.usermanagement;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.devk.model.Role;

@Service
class UserManagementServiceImpl implements UserManagementService {

	private RoleRepository roleRepository;

	public UserManagementServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Transactional
	@Override
	public Role createRole(String roleName, String roleDescription) {
		Role roleEntity = new Role();
		roleEntity.setRoleName(roleName);
		roleEntity.setRoleDescription(roleDescription);
		return roleRepository.save(roleEntity);
	}

	@Override
	public List<Role> findAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Number countAllRoles() {
		return roleRepository.count();
	}

}
