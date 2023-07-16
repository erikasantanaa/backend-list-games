package com.backend.listagames.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.listagames.entities.Game;
import com.backend.listagames.entities.dto.GameDTO;
import com.backend.listagames.entities.dto.GameMinDTO;
import com.backend.listagames.repositories.GameRepository;

import jakarta.transaction.Transactional;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional()
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	@Transactional()
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); 
		return dto;
		
	}
}
