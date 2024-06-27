package tic.tac.toe.tournament.user_service.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TournamentUserJPA {
	private @GeneratedValue @Id Long id;
	private String fullName;
	private String email;
	
	public TournamentUserJPA() {}
	
	
	public TournamentUserJPA(Long id, String fullName, String email) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
	}


	public TournamentUserJPA(TournamentUser user) {
		this(user.id(),user.fullName(),user.email());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
