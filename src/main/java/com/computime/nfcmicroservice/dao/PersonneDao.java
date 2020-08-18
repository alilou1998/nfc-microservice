package com.computime.nfcmicroservice.dao;

import com.computime.nfcmicroservice.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneDao extends JpaRepository<Personne,Integer> {
}
