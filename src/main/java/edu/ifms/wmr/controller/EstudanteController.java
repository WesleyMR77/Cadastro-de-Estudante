package edu.ifms.wmr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.ifms.wmr.model.Estudante;
import edu.ifms.wmr.model.EstudanteRepository;

@Controller
public class EstudanteController {
	
	@Autowired
	private EstudanteRepository repo;
	
	@GetMapping("/estudantes")
	public String showForm(Model model) {
		Estudante estudante = new Estudante();
		model.addAttribute("estudante", estudante);
		return "estudantesform"; 
	}

	@PostMapping("/estudantes")
	public String create(Estudante estudante) {
		repo.save(estudante);
		
		return "estudantesform";
	}
}
