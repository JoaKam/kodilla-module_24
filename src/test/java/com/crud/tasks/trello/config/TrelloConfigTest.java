package com.crud.tasks.trello.config;

import com.crud.tasks.domain.TrelloCard;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrelloConfigTest {

    TrelloConfig trelloConfig = new TrelloConfig();

    @Test
    public void getTrelloApiEndpoint() throws Exception {
        //Given
        //When
        String apiEndpoint = trelloConfig.getTrelloApiEndpoint();

        //Then
        Assert.assertEquals(apiEndpoint, null);
    }

    @Test
    public void getTrelloAppKey() throws Exception {
        //Given
        //When
        String appKey = trelloConfig.getTrelloAppKey();

        //Then
        Assert.assertEquals(appKey, null);
    }

    @Test
    public void getTrelloAppToken() throws Exception {
        //Given
        //When
        String appToken = trelloConfig.getTrelloAppToken();

        //Then
        Assert.assertEquals(appToken, null);
    }

}