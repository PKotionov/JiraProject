package com.epam.ta.pages;

import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public abstract class AbstractPage{
	protected WebDriver driver;

//	private static String PATH_TO_SAVE_SCREENSHOTS = "target\\screenshots";
//	File screenshotDir = new File(PATH_TO_SAVE_SCREENSHOTS);
//	{
//		screenshotDir.mkdirs();
//	}

	public abstract void openPage();

	public AbstractPage(WebDriver driver)
	{
		this.driver = driver;
		setWebDriver(driver);
	}

//	@Rule
//	public ScreenShooter screenShooter = ScreenShooter.failedTests().to(screenshotDir.getAbsolutePath());

}
