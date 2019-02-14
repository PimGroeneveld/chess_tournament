package com.capgemini.chesstournament.controller.repository;

import com.capgemini.chesstournament.model.ChessPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ChessPlayerRepository extends JpaRepository<ChessPlayer, Long> {
}
