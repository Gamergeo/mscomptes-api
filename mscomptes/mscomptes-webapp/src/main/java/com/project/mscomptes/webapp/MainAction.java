package com.project.mscomptes.webapp;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.mscomptes.business.AssetService;

/**
 * General action (header, menu,...)
 */
@RequestMapping("main")
@Controller
public class MainAction extends AbstractAction {
	
	private final Logger LOGGER = LogManager.getLogger(MainAction.class);
	
	@Autowired
	AssetService assetService;

	@GetMapping("view")
	public ModelAndView view() {
		LOGGER.info("Application démarée");
		ModelAndView model = new ModelAndView("main");
		
		model.addObject("assetList", assetService.findAll());
		
		return model;
	}
	
	@GetMapping("generate")
	public @ResponseBody String generate() throws URISyntaxException, IOException {
		assetService.generateCsv();
		return "ok";
	}	
	
}
