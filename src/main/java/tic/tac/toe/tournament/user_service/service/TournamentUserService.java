package tic.tac.toe.tournament.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import tic.tac.toe.tournament.user_service.beans.TournamentUser;
import tic.tac.toe.tournament.user_service.beans.TournamentUserJPA;
import tic.tac.toe.tournament.user_service.dao.TournamentUserRepository;
import tic.tac.toe.tournament.user_service.exceptions.UserNotFoundException;

@Service
public class TournamentUserService {
	@Autowired
	private TournamentUserRepository repository;
	
	public List<TournamentUser> findAll(){
		return repository.findAll().stream().map(this::toRecord).toList();
	}

	public TournamentUser getUserById( Long id) throws UserNotFoundException {
		return toRecord(repository.findById(id).orElseThrow(()->new UserNotFoundException()));
	}

	public void createUser(TournamentUser user) {
		repository.save(toJPA(user));
	}

	public void updateUser(TournamentUser user) throws UserNotFoundException {
		repository.findById(user.id()).orElseThrow(() -> new UserNotFoundException());
		repository.save(toJPA(user));
	}

	public void deleteUser(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	private TournamentUserJPA toJPA (TournamentUser user) {
		return new TournamentUserJPA(user);
	}
	
	private TournamentUser toRecord (TournamentUserJPA user) {
		return new TournamentUser(user.getId(), user.getFullName(), user.getEmail()); 
	}
}
