package com.Edg.BackENdEdg.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Edg.BackENdEdg.model.Usuario;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID =1L;
	
	private String userName;	
	private String password;
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl (Usuario usuario) {
		this.userName = usuario.getEmail();
		this.password = usuario.getSenha();
	}
	public UserDetailsImpl() {}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}
