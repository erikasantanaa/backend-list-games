package com.backend.listagames.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.listagames.entities.Game;
import com.backend.listagames.entities.GameList;
import com.backend.listagames.entities.dto.GameDTO;
import com.backend.listagames.entities.dto.GameListDTO;
import com.backend.listagames.entities.dto.GameMinDTO;
import com.backend.listagames.projections.GameMinProjection;
import com.backend.listagames.repositories.GameListRepository;
import com.backend.listagames.repositories.GameRepository;

import jakarta.transaction.Transactional;

@Service
public class GameListService {
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public List<GameListDTO> findAll() {
		
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList(); 
		return dto;
	}
	
	//mover o position quando um game mudar de lugar
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
