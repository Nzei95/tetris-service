package com.mark.tetris.service;

import com.mark.tetris.dtos.PlayerDTO;
import com.mark.tetris.model.Player;
import com.mark.tetris.repository.PlayerRepository;
import com.mark.tetris.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    /**
     * Creates a new player
     * @param player
     * @return
     */
    @Transactional
    public PlayerDTO savePlayer(PlayerDTO player){
        try{
            Player player1 = Player.builder().playerName(player.getPlayerName()).score(Integer.parseInt(player.getScore())).build();
            return getPlayerDTO(playerRepository.save(player1));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    // update score
    // reset leaderboard
    // retrieve all players

    /**
     * Returns a player with the id passed
     * @param id
     * @return
     */
    public PlayerDTO getById(Long id){
        return getPlayerDTO(playerRepository.getOne(id));
    }

    /**
     * Deletes a player by id
     * @param id
     * @return
     */
    public Response deleteById(Long id){
        try{
         playerRepository.deleteById(id);
         Response response = Response.builder().responseCode("000").responseMessage("Deleted Successfully").build();
         return response;
        }catch (Exception e){
            e.printStackTrace();
        }
        Response response = Response.builder().responseCode("999").responseMessage("Unsuccessful").build();
        return response;
    }



    /**
     * Returrns the user details list based on the name
     * @param
     * @return
     */



    public PlayerDTO getPlayerDTO(Player player){
        PlayerDTO playerDTO = PlayerDTO.builder().id(player.getId().toString()).playerName(player.getPlayerName()).score(player.getScore().toString()).build();
        return playerDTO;
    }
}
