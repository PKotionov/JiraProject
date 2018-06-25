package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JiraPage extends AbstractPage {
    private final String BASE_URL = "https://jira.epam.com/";

    @FindBy(xpath = "//a[@href='/jira/issues/']")
    WebElement issuesOption;

    @FindBy(id = "filter_lnk_my_lnk")
    WebElement myIssuesItem;

    @FindBys(@FindBy(xpath = "//a[@class='issue-link']"))
    public List<WebElement> allIssues;

    @FindBy(xpath = "//td[4]/p/a[not(contains(text(), 'axi.com'))]")
    WebElement issue;

    @FindBy(xpath = "//span[contains(text(), 'Workflow')]")
    WebElement workflowOption;

    @FindBy(id = "action_id_31")
    WebElement closeOption;

    @FindBy(id = "resolution")
    WebElement resolutionField;

    @FindBy(xpath = "//option[@value='3']")
    WebElement duplicateOption;

    @FindBy(id = "issue-workflow-transition-submit")
    WebElement closeButton;

    public JiraPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(BASE_URL);
    }

    public void openIssuesOption() {
        issuesOption.click();
    }

    public void chooseMyIssues() {
        myIssuesItem.click();
    }

    public List<WebElement> getAllIssues() {
        return allIssues;
    }

    public WebElement getIssue() {
        return issue;
    }

    public void clickOnWorkFlow() {
        workflowOption.click();
    }


    public void clickOnCloseOption() {
        closeOption.click();
    }


    public void clickOnResolution() {
        resolutionField.click();
    }

    public void choseDuplicate() {
        duplicateOption.click();
    }

    public void clickOnCloseButton() {
        closeButton.click();
    }
}
