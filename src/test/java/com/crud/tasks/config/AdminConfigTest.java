package com.crud.tasks.config;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminConfigTest {
    @Test
    public void emailGetTest() {
        //Given
        AdminConfig adminConfig = new AdminConfig();

        //When
        String mail = adminConfig.getAdminMail();

        //Then
        Assert.assertEquals(mail, null);

    }
}