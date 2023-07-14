package com.backend.listagames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.listagames.entities.Game;

public interface GameRepository  extends JpaRepository<Game, Long> {

}
