package com.devspring.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devspring.dslist.entities.GameList;


/**
 * Camada de Acesso a Dados.
 * Interface para fornecer métodos adicionais para gerenciar a entidade Game no banco de dados.
 * CRUD (Create, Read, Update, Delete)relacionadas a entidades Game.
 */
public interface GameListRepository extends JpaRepository<GameList, Long> {

}
