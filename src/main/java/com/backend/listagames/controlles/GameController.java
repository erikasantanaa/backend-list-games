package com.backend.listagames.controlles;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.listagames.entities.dto.GameMinDTO;
import com.backend.listagames.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	//injetar o service no controler
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	private List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
}
