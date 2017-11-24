package com.mz.xavier.abtairsmoz.repository.helper.usuario;

import java.util.List;
import java.util.Optional;

import com.mz.xavier.abtairsmoz.model.Usuario;
import com.mz.xavier.abtairsmoz.repository.filter.UsuarioFilter;



public interface UsuariosQueries {

	public Optional<Usuario> porEmailEAtivo(String email);
	
	public List<String> permissoes(Usuario usuario);
	
	public List<Usuario> filtrar(UsuarioFilter filtro);
	
	public Usuario buscarComGrupos(Long codigo);
	
	
}
