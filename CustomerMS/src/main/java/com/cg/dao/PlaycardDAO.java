package com.cg.dao;
/**
-File Name          : PlaycardDAO
-Author Name        : Capgemini
-Description        : Interface for Playcard Repository
-Creation Date		: 12/04/2021
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.PlayCard;

@Repository("PlaycardDAO")
public interface PlaycardDAO extends JpaRepository<PlayCard, Integer> {

}
