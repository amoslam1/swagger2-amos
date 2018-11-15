package org.amos.swagger2.service.custom.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.amos.framework.utils.ConvertUtils;
import org.amos.swagger2.model.auto.user.User;
import org.amos.swagger2.model.custom.permissions.PMSUser;
import org.amos.swagger2.service.auto.user.UserAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserAutoService userAutoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userAutoService.getBy("username", username);
        if(user == null){
        	
            throw new UsernameNotFoundException(username);
        }
        

        List<String> roles = new ArrayList<String>();
        roles.add("ADMIN");
        
        List<String> permissions = new ArrayList<String>();
        permissions.add("userInfo");
        
        PMSUser pbsUser = ConvertUtils.convertObject(user, PMSUser.class);
        pbsUser.setRoles(roles);
        pbsUser.setPermissions(permissions);
        
        return pbsUser;
    }
}
