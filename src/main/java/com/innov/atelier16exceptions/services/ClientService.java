package com.innov.atelier16exceptions.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.innov.atelier16exceptions.entities.Client;
import com.innov.atelier16exceptions.repos.ClientRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAllClients() {
		return (List<Client>) clientRepository.findAll();
	}
	
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}

	public Client getClientById(Long id) {
		return clientRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Client introuvable avec l'ID " + id)); 
	}
	
	public void deleteClient(Long id) {
		if (clientRepository.existsById(id)) {
			clientRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException("Aucun client trouvé avec l'ID " + id);
		}
	}
	
}
