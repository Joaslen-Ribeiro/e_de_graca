package com.Edg.BackENdEdg.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Edg.BackENdEdg.model.Usuario;
import com.Edg.BackENdEdg.model.UsuarioLogin;
import com.Edg.BackENdEdg.repository.UsuarioRepository;

@Service
public class UsuarioService {
//regras de negocios: senha criptografada e token pra acessar
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	// cadastrar usuario 
	
	public Optional<Usuario> cadastrarUsuario (Usuario usuario){
		
		if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
			return Optional.ofNullable(null);
			
			
			//throw new ResponseStatusException(HttpStatus.BAD_REQUEST,  "Email ja cadastrado", null);
		
			
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		
		return Optional.of(usuarioRepository.save(usuario));

	}
	
	//atualizar
	public Optional<Usuario> atualizarUsuario(Usuario usuario){
		
		if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			String senhaEncoder = encoder.encode(usuario.getSenha());
			usuario.setSenha(senhaEncoder);
			
			return Optional.of(usuarioRepository.save(usuario));
		}else {
			return Optional.ofNullable(null);
			
		//	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado", null);
			
		}
		
	}
	
	// metodo logar onde vai gerar o token
	public Optional<UsuarioLogin> loginUsuario(Optional<UsuarioLogin> usuarioLogin){
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioLogin.get().getEmail());
		if(usuario.isPresent()) {
			if(encoder.matches(usuarioLogin.get().getSenha(),usuario.get().getSenha())) {
				
				// gerar o token-- 
				String auth = usuarioLogin.get().getEmail() + ":" + usuarioLogin.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String (encodeAuth);// isso é o token
				
				usuarioLogin.get().setId(usuario.get().getId());
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setSenha(usuario.get().getSenha());
				usuarioLogin.get().setEmpresa(usuario.get().isEmpresa());
				usuarioLogin.get().setToken(authHeader);
				
				return usuarioLogin;
			}
		}
		return Optional.ofNullable(null);
		
		//throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "E-mail ou senha inválidos", null);
			}
		
				
	}
	
	

