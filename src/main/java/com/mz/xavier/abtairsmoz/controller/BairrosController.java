/**
 * 
 */
package com.mz.xavier.abtairsmoz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mz.xavier.abtairsmoz.controller.page.PageWrapper;
import com.mz.xavier.abtairsmoz.model.Bairro;
import com.mz.xavier.abtairsmoz.repository.Bairros;
import com.mz.xavier.abtairsmoz.repository.Distritos;
import com.mz.xavier.abtairsmoz.repository.Localidades;
import com.mz.xavier.abtairsmoz.repository.exception.CadastroNomeBairroException;
import com.mz.xavier.abtairsmoz.repository.exception.ImpossivelExcluirEntidadeException;
import com.mz.xavier.abtairsmoz.repository.filter.BairroFilter;
import com.mz.xavier.abtairsmoz.service.CadastroBairroService;


/**
 * @author langar
 *
 */
@Controller
@RequestMapping("/bairros")
public class BairrosController {

	@Autowired
	private CadastroBairroService cadastroBairroService;
	
	@Autowired
	private Distritos distritos;
	
	@Autowired
	private Bairros bairros;
	
	@Autowired
	private Localidades localidades;
	
	
	
	@RequestMapping("/novo")
	public ModelAndView novo(Bairro bairro) {
		ModelAndView mv = new ModelAndView("bairro/CadastroBairro");
		mv.addObject("distritos", distritos.findAll());
		return mv;
	}
	
	@RequestMapping(value = { "/novo", "{//d+}" } , method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Bairro bairro, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(bairro);
		}
		
		try {
			cadastroBairroService.salvar(bairro);
		} catch(CadastroNomeBairroException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(bairro);
		}
		
		attributes.addFlashAttribute("mensagem", "Bairro adicinado com sucesso");
		return new ModelAndView("redirect:/bairros/novo");
		
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Bairro> pesquisarPorCodigoLocalidade(
			@RequestParam(name = "localidade", defaultValue = "-1") Long codigoLocalidade){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) { }
			return bairros.findByLocalidadeCodigo(codigoLocalidade);
	}
	
	
	@GetMapping
	public ModelAndView pesquisar(BairroFilter bairroFilter, BindingResult result, 
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest){
		ModelAndView mv = new ModelAndView("bairro/PesquisaBairros");
		mv.addObject("localidades", localidades.findAll());
		PageWrapper<Bairro> pageWrapper = new PageWrapper<>(bairros.filtrar(bairroFilter, pageable), httpServletRequest);
		mv.addObject("pagina", pageWrapper);
		return mv;
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable Long codigo){
		Bairro bairro = bairros.findOne(codigo);
		ModelAndView mv = novo(bairro);
		mv.addObject(bairro);
		return mv;
	}
	
	@DeleteMapping("/{codigo}")
    public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Long codigo){
		try{
			cadastroBairroService.excluir(codigo);
		} catch(ImpossivelExcluirEntidadeException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok().build();
	}	
	
}
