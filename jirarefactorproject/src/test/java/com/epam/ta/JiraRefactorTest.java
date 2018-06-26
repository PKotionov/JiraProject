package com.epam.ta;

import com.epam.ta.steps.Steps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JiraRefactorTest {
    private Steps steps;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }


    @Test
    public void closeMyIssue() {
        steps.jiraRefactor();

    }



    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }

}
