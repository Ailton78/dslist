package com.ailton78.dslist.controllers;

import com.ailton78.dslist.dto.GameDTO;
import com.ailton78.dslist.dto.GameMiniDTO;
import com.ailton78.dslist.entities.Game;
import com.ailton78.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMiniDTO> findALl(){
        List<GameMiniDTO> result = gameService.findAll();
        return result;
    }
    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
      GameDTO result = gameService.findById(id);
      return result;
    }
}
