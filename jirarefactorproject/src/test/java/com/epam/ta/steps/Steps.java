package com.epam.ta.steps;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class Steps {
    private WebDriver driver;

    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeDriver() {
        DriverSingleton.closeDriver();
    }


    public void jiraRefactor() {
        JiraPage jiraPage = new JiraPage(driver);
        List<String> issueNames = new ArrayList<String>();
        try {
            while (true) {
                jiraPage.openPage();
                jiraPage.openIssuesOption();
                jiraPage.chooseMyIssues();
                WebElement issue = jiraPage.getIssue();
                issueNames.add(issue.getText());
                issue.click();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                jiraPage.clickOnWorkFlow();
                jiraPage.clickOnCloseOption();
                jiraPage.clickOnResolution();
                jiraPage.choseDuplicate();
                jiraPage.clickOnCloseButton();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("________________________________________________________________");
            System.out.println("Issue status was changed at [" + issueNames.size() + "] issues.");
            System.out.println("----------------------------------------------------------------");
            System.out.println("There are:");
            for (String issueName : issueNames) {
                System.out.println(issueName);
            }
            System.out.println("_______________________________________________________________");
        }
    }
}


