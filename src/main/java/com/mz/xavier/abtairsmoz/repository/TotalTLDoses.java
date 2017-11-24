/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mz.xavier.abtairsmoz.model.TotaisTlDos;
import com.mz.xavier.abtairsmoz.repository.helper.totaisTLDos.TotalTLDosesQueries;

/**
 * @author langar
 *
 */
@Repository
public interface TotalTLDoses extends JpaRepository<TotaisTlDos, Long>, TotalTLDosesQueries{

 



}
