package fr.limayrac.messagerie.service;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.limayrac.messagerie.model.Utilisateur;
 

 
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
 
	@Autowired
	private UtilisateurService userService;
 

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
		if (username.trim().isEmpty()) {
			throw new UsernameNotFoundException("username is empty");
		}
 
		Utilisateur user = userService.FindUsernameByMail(username);
 
		if (user == null) {
			throw new UsernameNotFoundException("User " + username + " not found");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getMotDePasse(),getGrantedAuthorities(user));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(Utilisateur user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}
 
}
