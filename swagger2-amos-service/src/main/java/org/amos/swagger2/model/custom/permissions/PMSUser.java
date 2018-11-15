package org.amos.swagger2.model.custom.permissions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.amos.swagger2.model.auto.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class PMSUser extends User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6556366249361483877L;
	
	private static String ROLE_PREFIX = "ROLE_";
	
	public PMSUser(List<String> roles, List<String> permissions) {
		super();
		this.roles = roles;
		this.permissions = permissions;
	}

	/**
	 * 角色
	 */
	private List<String> roles;
	
	/**
	 * 权限
	 */
	private List<String> permissions;


	public PMSUser() {
		super();
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		
	}
	
	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        List<String> splicingRoles = new ArrayList<String>();
        for (String role : roles) {
			
        	splicingRoles.add(ROLE_PREFIX + role);
		}
        
        List<String> authorize = new ArrayList<String>();
    	authorize.addAll(splicingRoles);
    	authorize.addAll(permissions);
    	
        return mapToGrantedAuthorities(authorize);
    }
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

	// 账户是否未过期
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	// 账户是否未锁定
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	 // 密码是否未过期
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	 // 账户是否激活
	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
	
}
