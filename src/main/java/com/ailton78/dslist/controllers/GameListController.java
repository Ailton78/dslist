package com.ailton78.dslist.controllers;

import com.ailton78.dslist.dto.GameListDTO;
import com.ailton78.dslist.dto.GameMiniDTO;
import com.ailton78.dslist.services.GameListService;

import com.ailton78.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findALl(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
    @GetMapping(value = "/{listId}/games")
    public List<GameMiniDTO> findByList(@PathVariable Long listId){
        List<GameMiniDTO> result = gameService.findByList(listId);
        return result;
    }
}
