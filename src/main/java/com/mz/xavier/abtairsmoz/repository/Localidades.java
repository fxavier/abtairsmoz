/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mz.xavier.abtairsmoz.model.Localidade;
import com.mz.xavier.abtairsmoz.repository.helper.localidade.LocalidadesQueries;



/**
 * @author langar
 *
 */
@Repository
public interface Localidades extends JpaRepository<Localidade, Long>, LocalidadesQueries{
	public Optional<Localidade> findByNomeIgnoreCase(String nome);
    public List<Localidade> findByDistritoCodigo(Long codigoDistrito);
	
}
