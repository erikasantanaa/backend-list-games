package com.backend.listagames.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_game_list")
public class GameList {
	
	//nome das entidades
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	//construtor vazio - estanciar onjeto desse tipo sem informar nada para ele
	public GameList() {
	}

	//btn direito + source + generate constructor using field..
	public GameList(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	//btn direito + source + gerenate getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Comparar um item com o outro (marcar so o ID): btn direito + source + gerenate hashCode() and equals()...
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameList other = (GameList) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
