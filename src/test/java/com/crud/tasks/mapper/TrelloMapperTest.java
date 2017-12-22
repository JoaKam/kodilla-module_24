package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloMapperTest {

    @Test
    public void trelloMapperToDtoTest() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "test_list", false));

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "test", trelloLists));

        TrelloCard trelloCard = new TrelloCard("Card name", "testing card", "top", "455");

        //When
        List<TrelloListDto> mappedTrelloListsDto = trelloMapper.mapToListDto(trelloLists);
        List<TrelloBoardDto> mappedTrelloBoardsDto = trelloMapper.mapToBoardDto(trelloBoards);
        TrelloCardDto mappedTrelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        Assert.assertEquals(mappedTrelloListsDto.get(0).getName(), "test_list");
        Assert.assertEquals(mappedTrelloBoardsDto.get(0).getLists().get(0).isClosed(), false);
        Assert.assertEquals(mappedTrelloBoardsDto.get(0).getName(), "test");
        Assert.assertEquals(mappedTrelloCardDto.getDescription(), "testing card");
    }

    @Test
    public void trelloMapperFromDtoTest() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(new TrelloListDto("1", "test_list", false));

        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(new TrelloBoardDto("1", "test", trelloListsDto));

        TrelloCardDto trelloCardDto = new TrelloCardDto("Card name", "testing card", "top", "455");

        //When
        List<TrelloList> mappedTrelloLists = trelloMapper.mapToList(trelloListsDto);
        List<TrelloBoard> mappedTrelloBoards = trelloMapper.mapToBoard(trelloBoardsDto);
        TrelloCard mappedTrelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        Assert.assertEquals(mappedTrelloLists.get(0).getName(), "test_list");
        Assert.assertEquals(mappedTrelloBoards.get(0).getLists().get(0).isClosed(), false);
        Assert.assertEquals(mappedTrelloBoards.get(0).getName(), "test");
        Assert.assertEquals(mappedTrelloCard.getDescription(), "testing card");
    }

}