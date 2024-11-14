package com.ogarotodevback.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogarotodevback.dslist.entities.Game;

//camada de repositórios faz consultas no banco de dados/acessa os dados
public interface GameRepository extends JpaRepository<Game, Long>{
	
	

}
