package tic.tac.toe.tournament.user_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import tic.tac.toe.tournament.user_service.beans.TournamentUser;
import tic.tac.toe.tournament.user_service.beans.TournamentUserJPA;


public interface TournamentUserRepository extends JpaRepository<TournamentUserJPA, Long> {

}
