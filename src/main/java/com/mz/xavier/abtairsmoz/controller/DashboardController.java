/**
 * 
 */
package com.mz.xavier.abtairsmoz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author langar
 *
 */
@Controller
public class DashboardController {
	
	@GetMapping("/")
	public ModelAndView dashboard() {
		ModelAndView mv = new ModelAndView("Dashboard");
		return mv;
	}

}
