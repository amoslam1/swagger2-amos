package org.amos.swagger2.gen;

import java.util.ArrayList;
import java.util.List;

public class TestCodeGenerator {

	private static final String PATH = "src/main/resources/WEB-INF/generator/generate-code.properties";
	public static void main(String[] args) {
		
		BLOWCodeGenerator blowCG = new BLOWCodeGenerator();

		List<GenCodeGenerator> gcg = new ArrayList<GenCodeGenerator>();

		GenCodeGenerator userGen = new GenCodeGenerator();
		userGen.setTableName("user");
		userGen.setAliasName("User");
		userGen.setModelName("permissions");
		userGen.setTableRemarks("用户");
		gcg.add(userGen);
		
		GenCodeGenerator roleGen = new GenCodeGenerator();
		roleGen.setTableName("role");
		roleGen.setAliasName("Role");
		roleGen.setModelName("permissions");
		roleGen.setTableRemarks("角色");
		gcg.add(roleGen);
		
		GenCodeGenerator userRoleGen = new GenCodeGenerator();
		userRoleGen.setTableName("user_role_rel");
		userRoleGen.setAliasName("UserRoleRel");
		userRoleGen.setModelName("permissions");
		userRoleGen.setTableRemarks("用户角色关联");
		gcg.add(userRoleGen);
		
		GenCodeGenerator permissionsGen = new GenCodeGenerator();
		permissionsGen.setTableName("permissions");
		permissionsGen.setAliasName("Permissions");
		permissionsGen.setModelName("permissions");
		permissionsGen.setTableRemarks("权限");
		gcg.add(permissionsGen);
		
		GenCodeGenerator rolePermissionsGen = new GenCodeGenerator();
		rolePermissionsGen.setTableName("role_permissions_rel");
		rolePermissionsGen.setAliasName("RolePermissionsRel");
		rolePermissionsGen.setModelName("permissions");
		rolePermissionsGen.setTableRemarks("用户");
		gcg.add(rolePermissionsGen);

		for (GenCodeGenerator enCodeGenerator : gcg) {

			/**
			 * params 1 properties路径
			 * params 2 表名，如BG_user
			 * params 3 表别名（映射出来的实体名...）,可以为null，为null取表名进行驼峰
			 * params 4 模块名
			 */
			blowCG.genCode(PATH, enCodeGenerator.getTableName(), enCodeGenerator.getAliasName()
					,enCodeGenerator.getModelName());
		}
	}
}
