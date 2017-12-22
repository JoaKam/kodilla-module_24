package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrelloValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloFacade.class);

    public List<TrelloBoard> validateTrelloBoards(final List<TrelloBoard> trelloBoards) {

        LOGGER.info("Starting filtering");
        List<TrelloBoard> filteredBoards = trelloBoards.stream()
                .filter(trelloBoard -> trelloBoard.getName().equalsIgnoreCase("test"))
                .collect(Collectors.toList());
        LOGGER.info("Filtered. Size: " + filteredBoards.size());

        return filteredBoards;
    }

    public void validateCard(final TrelloCard trelloCard) {

        if (trelloCard.getName().contains("test")) {
            LOGGER.info("Someone is testing");
        } else {
            LOGGER.info("Properly used");
        }

    }
}
