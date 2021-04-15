package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Game;

@Repository("gameDao")
public interface GameDao extends JpaRepository<Game, Integer> {

}
