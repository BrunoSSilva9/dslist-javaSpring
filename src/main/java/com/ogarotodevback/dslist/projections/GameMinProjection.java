package com.ogarotodevback.dslist.projections;

//classe que funciona como uma tela de projeção, onde cada metodo tem
//que o nome ser igual ao atributo q é retornado na consulta SQL na *GameRepository
public interface GameMinProjection {
	
	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
}
