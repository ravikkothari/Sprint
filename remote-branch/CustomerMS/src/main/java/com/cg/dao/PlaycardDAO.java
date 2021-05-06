package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.PlayCard;

@Repository("PlaycardDAO")
public interface PlaycardDAO extends JpaRepository<PlayCard, Integer> {

}
