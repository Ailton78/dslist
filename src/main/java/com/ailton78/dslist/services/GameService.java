package com.ailton78.dslist.services;

import com.ailton78.dslist.dto.GameDTO;
import com.ailton78.dslist.dto.GameMiniDTO;
import com.ailton78.dslist.entities.Game;
import com.ailton78.dslist.projections.GameMinProjection;
import com.ailton78.dslist.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMiniDTO> findAll(){
        List<Game> result =  gameRepository.findAll();
        return result.stream().map(x -> new GameMiniDTO(x)).toList();
    }
    @Transactional(readOnly = true)
    public List<GameMiniDTO> findByList(Long listID){
        List<GameMinProjection> result =  gameRepository.searchByList(listID);
        return result.stream().map(x -> new GameMiniDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        //fazer tratamento de exeção caso não exista o id
        return new GameDTO(result);
    }

}
