/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mz.xavier.abtairsmoz.model.Bairro;
import com.mz.xavier.abtairsmoz.model.Localidade;
import com.mz.xavier.abtairsmoz.repository.helper.bairro.BairrosQueries;



/**
 * @author langar
 *
 */
@Repository
public interface Bairros extends JpaRepository<Bairro, Long>, BairrosQueries{
	public Optional<Bairro> findByNomeIgnoreCase(String nome);
	public List<Bairro> findByLocalidadeCodigo(Long codigoLocalidade);
	public Optional<Bairro> findByNomeAndLocalidade(String nome, Localidade localidade);

}
