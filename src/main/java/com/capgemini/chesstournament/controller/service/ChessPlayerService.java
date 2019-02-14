package com.capgemini.chesstournament.controller.service;

import com.capgemini.chesstournament.controller.repository.ChessPlayerRepository;
import com.capgemini.chesstournament.model.ChessPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChessPlayerService {

    @Autowired
    private ChessPlayerRepository chessPlayerRepository;

    public Iterable<ChessPlayer> showAllChessPlayers() {
        return chessPlayerRepository.findAll();
    }

    public Optional<ChessPlayer> showChessPlayerById(Long id) {
        return chessPlayerRepository.findById(id);
    }

    public ChessPlayer addChessPlayer(ChessPlayer chessPlayer) {
        return chessPlayerRepository.save(chessPlayer);
    }

    public void removeChessPlayerById(Long id) {
        System.out.println("Deleted chess player id: " + id);
        chessPlayerRepository.deleteById(id);
    }

    public void removeAllChessPlayers(List<ChessPlayer> chessPlayers) {
        System.out.println("All deleted guests: " + chessPlayers);
        chessPlayerRepository.deleteAll(chessPlayers);
    }
}