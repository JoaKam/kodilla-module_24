package com.kodilla.testing2.facebook;

import com.kodilla.testing2.google.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_BIRTHDAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    public static final String XPATH_BIRTHMONTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";
    public static final String XPATH_BIRTHYEAR = "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        WebElement selectBirthDay = driver.findElement(By.xpath(XPATH_BIRTHDAY));
        Select birthDay = new Select (selectBirthDay);
        birthDay.selectByIndex(19);

        WebElement selectBirthMonth = driver.findElement(By.xpath(XPATH_BIRTHMONTH));
        Select birthMonth = new Select (selectBirthMonth);
        birthMonth.selectByIndex(6);

        WebElement selectBirthYear = driver.findElement(By.xpath(XPATH_BIRTHYEAR));
        Select birthYear = new Select (selectBirthYear);
        birthYear.selectByValue("1992");
    }
}



// XPath-Relative oraz obiektów klasy Select