package com.devspring.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.devspring.dslist.entities.GameList;

public class GameListDTO {
	
	private Long id;
    
	private String name;
	
	public GameListDTO() {
	}
	
	public GameListDTO(GameList game) {
		BeanUtils.copyProperties(game, this);
	}

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
}
