package com.ogarotodevback.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ogarotodevback.dslist.entities.GameList;

//camada de repositórios faz consultas no banco de dados/acessa os dados
//Retorna/Acessa as duas listas de games, RPG e PLATAFORMA
public interface GameListRepository extends JpaRepository<GameList, Long>{
	
	
	@Modifying //usado quando é uma consulta que altera o banco de dados
	@Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
