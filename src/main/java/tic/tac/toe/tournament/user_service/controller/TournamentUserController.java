package tic.tac.toe.tournament.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tic.tac.toe.tournament.user_service.beans.TournamentUser;
import tic.tac.toe.tournament.user_service.exceptions.UserNotFoundException;
import tic.tac.toe.tournament.user_service.service.TournamentUserService;


@RestController
public class TournamentUserController {
	
	@Autowired
	private TournamentUserService repository;
	
	@GetMapping("/users")
	public List<TournamentUser> getAllUsers(){
		return repository.findAll();
	}
	
	
	@GetMapping("/users/{id}")
	public TournamentUser getUserById(@PathVariable Long id) throws UserNotFoundException {
		return repository.getUserById(id);
	}
	
	@PostMapping("/users")
	public void createUser(@RequestBody TournamentUser user) {
		repository.createUser(user);
	}
	
	@PutMapping("/users")
	public void updateUser(@RequestBody TournamentUser user) throws UserNotFoundException {
		repository.updateUser(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		repository.deleteUser(id);
	}

}
