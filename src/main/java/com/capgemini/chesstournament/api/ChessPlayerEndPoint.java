package com.capgemini.chesstournament.api;

import com.capgemini.chesstournament.controller.service.ChessPlayerService;
import com.capgemini.chesstournament.model.ChessPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/tournament")
public class ChessPlayerEndPoint {

    @Autowired
    private ChessPlayerService chessPlayerService;

    @GetMapping("/allplayers")
    public Iterable<ChessPlayer> getAllChessPlayers() {
        Iterable<ChessPlayer> chessPlayers = chessPlayerService.showAllChessPlayers();
        return chessPlayers;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @PostMapping("/allplayers/add")
    public void addChessPlayer(@RequestBody ChessPlayer chessPlayer) {
        System.out.println(chessPlayer.getDateOfBirth());
        chessPlayerService.addChessPlayer(chessPlayer);
    }

    @GetMapping("/dbfill")
    public void fillDBChessPlayer() {
        ChessPlayer chessPlayer1 = new ChessPlayer("Pim", "Groeneveld", "", LocalDate.of(1992, 2,
                11), 5, 4, 2);

        ChessPlayer chessPlayer2 = new ChessPlayer("Magnus", "Carlsen", "", LocalDate.of(1990, 11,
                30), 300, 0, 0);

        ChessPlayer chessPlayer3 = new ChessPlayer("Jackie", "Witt", "de", LocalDate.of(1980, 5,
                15), 25, 5, 6);
        chessPlayerService.addChessPlayer(chessPlayer1);
        chessPlayerService.addChessPlayer(chessPlayer2);
        chessPlayerService.addChessPlayer(chessPlayer3);
    }

    @GetMapping("/allplayers/{id}")
    public ChessPlayer getChessPlayerById(@PathVariable Long id) {
        Optional<ChessPlayer> chessPlayer = chessPlayerService.showChessPlayerById(id);
        return chessPlayer.get();
    }

    @DeleteMapping("/allplayers/{id}/delete")
    public void deleteGuest(@PathVariable Long id) {
        chessPlayerService.removeChessPlayerById(id);
        System.out.println("Deleted chess player endPoint id: " + id);
    }


}
