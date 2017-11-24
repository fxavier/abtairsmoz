/**
 * 
 */
package com.mz.xavier.abtairsmoz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mz.xavier.abtairsmoz.service.CadastroActorTypeService;



/**
 * @author langar
 *
 */
@Configuration
@ComponentScan(basePackageClasses = CadastroActorTypeService.class)
public class ServiceConfig {

}
