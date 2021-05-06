package com.cg.dao;
/**
-File Name          : PlaycardDao
-Author Name        : Capgemini
-Description        : Interface for Playcard Repository
-Creation Date		: 12/04/2021
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.PlayCard;

@Repository("playcardDao")
public interface PlaycardDao extends JpaRepository<PlayCard, Integer> {

}
