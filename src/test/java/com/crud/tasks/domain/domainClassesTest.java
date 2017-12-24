package com.crud.tasks.domain;

import org.junit.Assert;
import org.junit.Test;

public class domainClassesTest {
    @Test
    public void AttachmentsTest(){
        //Given
        Trello newTrello = new Trello(1, 2);
        AttachmentsByType newAttachment = new AttachmentsByType(newTrello);
        Badges newBadge = new Badges(3, newAttachment);

        //When
        //Then

        Assert.assertEquals(newBadge.getAttachments().getTrello().getBoard(), 1);
    }
}
