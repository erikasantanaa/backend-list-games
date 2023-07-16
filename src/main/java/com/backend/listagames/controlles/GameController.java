package com.backend.listagames.controlles;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.listagames.entities.dto.GameDTO;
import com.backend.listagames.entities.dto.GameListDTO;
import com.backend.listagames.entities.dto.GameMinDTO;
import com.backend.listagames.services.GameListService;
import com.backend.listagames.services.GameService;

@RestController
@RequestMapping(value = "/Lists")
public class GameController {
	//injetar o service no controler
	
	@Autowired
	private GameListService gameListService;
	
	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
}
