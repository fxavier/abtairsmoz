/**
 * 
 */
package com.mz.xavier.abtairsmoz.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mz.xavier.abtairsmoz.controller.page.PageWrapper;
import com.mz.xavier.abtairsmoz.model.DetalheDos;
import com.mz.xavier.abtairsmoz.repository.ActorTypes;
import com.mz.xavier.abtairsmoz.repository.Actores;
import com.mz.xavier.abtairsmoz.repository.Bairros;
import com.mz.xavier.abtairsmoz.repository.DetalheDoses;
import com.mz.xavier.abtairsmoz.repository.Distritos;
import com.mz.xavier.abtairsmoz.repository.Localidades;
import com.mz.xavier.abtairsmoz.repository.TotalTLDoses;
import com.mz.xavier.abtairsmoz.repository.filter.DetalheDosFilter;


/**
 * @author langar
 *
 */
@Controller
@RequestMapping("/detalhesDos")
public class DetalhesDosController {
		

	@Autowired
	private DetalheDoses detalheDoses;
	
	@Autowired
	private Actores actores;
	
		
	@Autowired
	private Distritos distritos;

	@Autowired
	private ActorTypes actorTypes;	
	
	@Autowired
	private Localidades localidades;
	
	@Autowired
	private Bairros bairros;
	
	@Autowired
	private TotalTLDoses totalDoses;
	
		
	
	@RequestMapping("/novo")
	public ModelAndView novo(DetalheDos detalhesTlDos) {
		ModelAndView mv = new ModelAndView("dos/CadastroDetalhesDos");
	    mv.addObject("actores", actores.findByActorTypeCodigo(new Long(1)));
	    mv.addObject("distritos", distritos.findAll());
		mv.addObject("actorTypes", actorTypes.listarPorBSTL());
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid DetalheDos detalhesTlDos, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(detalhesTlDos);
		}
		
		Long codigoToatais = totalDoses.obtrCodigoTotalDoses(detalhesTlDos.getData(),detalhesTlDos.getBairro());
			detalhesTlDos.setUUID(UUID.randomUUID().toString());
			detalhesTlDos.setCodigoTotalDos(codigoToatais);
			detalheDoses.save(detalhesTlDos);
			attributes.addFlashAttribute("mensagem", "Detalhe lancado com sucesso");
			
		
	//	System.out.println("Codigo:"+ totalDoses.obtrCodigoTotalDoses(detalhesTlDos.getData(),detalhesTlDos.getBairro()));
							
		
		return new ModelAndView("redirect:/detalhesDos/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(DetalheDosFilter detalheDosFilter, BindingResult result, 
			 @PageableDefault(size = 5) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("dos/PesquisaDetalhesDos");
		 mv.addObject("actores", actores.listarSupervisores());
		 mv.addObject("distritos", distritos.findAll());
		 mv.addObject("actorTypes", actorTypes.listarPorBSTL());
		 mv.addObject("localidades", localidades.findAll());
		 mv.addObject("bairros", bairros.findAll());
		 PageWrapper<DetalheDos> pageWrapper = new PageWrapper<>(detalheDoses.filtrar(detalheDosFilter, pageable),
				 httpServletRequest);
		 mv.addObject("pagina", pageWrapper);
		return mv;
	}
	

	
	
	

}
