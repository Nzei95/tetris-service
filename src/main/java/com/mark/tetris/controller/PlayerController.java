package com.mark.tetris.controller;

import com.mark.tetris.dtos.PlayerDTO;
import com.mark.tetris.service.PlayerService;
import com.mark.tetris.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping(value = "/savePlayer")
    public PlayerDTO savePlayer(@RequestBody PlayerDTO playerDTO){
        return playerService.savePlayer(playerDTO);
    }

    @GetMapping(value = "/getById/{id}")
    public PlayerDTO getById(@PathVariable Long id){
        return playerService.getById(id);
    }

    @GetMapping(value = "/deletePlayer/{id}")
    public Response deleteById(@PathVariable Long id){
        return playerService.deleteById(id);
    }

}
