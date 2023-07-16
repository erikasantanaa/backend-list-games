package com.backend.listagames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.listagames.entities.Game;
import com.backend.listagames.entities.GameList;

public interface GameListRepository  extends JpaRepository<GameList, Long> {

}
