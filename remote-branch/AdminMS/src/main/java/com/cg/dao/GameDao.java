package com.cg.dao;

/**
-File Name          : GameDao
-Author Name        : Capgemini
-Description        : Interface for Game Repository
-Creation Date		: 12/04/2021
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Game;

@Repository("gameDao")
public interface GameDao extends JpaRepository<Game, Integer> {

}
