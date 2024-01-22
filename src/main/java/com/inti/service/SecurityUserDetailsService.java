package com.inti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inti.model.Utilisateur;
import com.inti.repository.IUtilisateurRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	
	@Autowired
	IUtilisateurRepository iUtilisateurRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur = iUtilisateurRepository.findByIdentifiant(username);
		System.out.println(utilisateur);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		return new User(utilisateur.getIdentifiant(), utilisateur.getMotDePasse(), authorities);
	}

}
