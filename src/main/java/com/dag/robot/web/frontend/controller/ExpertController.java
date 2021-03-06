package com.dag.robot.web.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.entities.Expert;

@Controller
@RequestMapping("/expert")
public class ExpertController {

	@Autowired
	@Qualifier("expertDao")
	ExpertDao expertDao;

	public ExpertController() {
		super();
	}

	@RequestMapping(value = "/{expertId}", method = RequestMethod.GET)
	public String getAll(@PathVariable int expertId, Model model) {
		Expert expert = expertDao.getById(expertId);
		model.addAttribute("exeprt", expert);
		return "index";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addAll(){
		
		return "index";
	}

}
