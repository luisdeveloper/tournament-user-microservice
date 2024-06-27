package tic.tac.toe.tournament.user_service.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public record TournamentUser(@GeneratedValue @Id Long id, String fullName, String email) {
	public TournamentUser(String fullName, String email) {
		this(null,fullName,email);
	}
}
