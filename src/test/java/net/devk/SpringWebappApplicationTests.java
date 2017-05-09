package net.devk;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import net.devk.model.Role;
import net.devk.usermanagement.UserManagementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringWebappApplicationTests {

	private static final String SAMPLE_ROLE = "sample role";
	@Autowired
	private UserManagementService userManagementService;

	@Test
	public void testCreateRole() {
		Role adminRole = userManagementService.createRole("ROLE_1", SAMPLE_ROLE);
		Assert.assertNotNull(adminRole);
	}

	@Test
	public void testCreateRoleAndFindAll() {
		userManagementService.createRole("ROLE_2", SAMPLE_ROLE);
		List<Role> allRoles = userManagementService.findAllRoles();
		Assert.assertNotEquals(0, allRoles.size());
	}

	@Test
	public void testCreateRoleAndCountAll() {
		userManagementService.createRole("ROLE_3", SAMPLE_ROLE);
		Number count = userManagementService.countAllRoles();
		Assert.assertNotEquals(0, count.intValue());
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testCreationFailedByUniqueConstaint() {
		userManagementService.createRole("ROLE_4", SAMPLE_ROLE);
		userManagementService.createRole("ROLE_4", SAMPLE_ROLE);
		Number count = userManagementService.countAllRoles();
		Assert.assertNotEquals(0, count.intValue());
	}

}
