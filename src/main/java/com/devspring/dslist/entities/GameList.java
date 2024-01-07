package com.devspring.dslist.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_game_list")
public class GameList implements Serializable {
	
	/**
     * Identificador de versão serial para garantir a compatibilidade durante a serialização.
     * Este valor deve ser mantido consistente para evitar erros de desserialização.
     */
    private static final long serialVersionUID = 1L;
	
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	private String name;

	public GameList() {
	}

	public GameList(Long id, String name) {
		this.id = id;
		this.name = name;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

	@Override
	public String toString() {
		return "GameList [id=" + id + ", name=" + name + "]";
	}
	
	
}