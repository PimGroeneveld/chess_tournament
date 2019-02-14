package com.capgemini.chesstournament.api;

import com.capgemini.chesstournament.controller.service.ChessPlayerService;
import com.capgemini.chesstournament.model.ChessPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
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
        chessPlayerService.addChessPlayer(chessPlayer);
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
