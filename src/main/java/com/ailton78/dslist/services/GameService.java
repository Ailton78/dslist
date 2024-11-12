package com.ailton78.dslist.services;

import com.ailton78.dslist.dto.GameMiniDTO;
import com.ailton78.dslist.entities.Game;
import com.ailton78.dslist.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameMiniDTO> findAll(){
        List<Game> result =  gameRepository.findAll();
        List<GameMiniDTO> gameDto = result.stream().map(x -> new GameMiniDTO(x)).toList();
      /* esse código faz o que alinha acima faz.
       List<GameMiniDTO> gameList = new ArrayList<>();
        GameMiniDTO gameMiniDTO;
        for(Game i : result){
            gameMiniDTO =new GameMiniDTO(i);
            gameList.add(gameMiniDTO);
        } */
        return gameDto;
    }
}
