package com.innov.atelier16exceptions.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.innov.atelier16exceptions.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
	
}
