/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lqas.automation;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author Sveta
 */
public class MainPage {

  WebDriver driver;
  private List<WebElement> filmsList = new ArrayList();
  String[] windowHandles;
  String thisHandles;

  public MainPage(WebDriver driver) {
	this.driver = driver;
	thisHandles = driver.getWindowHandle();
	if (!driver.getTitle().contains("MY-HIT")) {
	  System.err.println("This is not the main page");
	  this.driver = null;
	}
	collectFilmsList();
  }

  private void collectFilmsList() {
	filmsList = driver.findElements(By.xpath("//div[@class='col-xs-2']"));
	while (filmsList.size() > 55) {
	  filmsList.remove(filmsList.size() - 1);
	}
  }

  public FilmPage chooseFilm(String nameOfFilm) {
	driver.switchTo().window(thisHandles);
	for (int i = 0; i < filmsList.size(); i++) {
	  if (filmsList.get(i).getText().contains(nameOfFilm)) {
		new Actions(driver).keyDown(Keys.CONTROL).click(filmsList.get(i).findElement(By.tagName("a")))
				.keyUp(Keys.CONTROL).build().perform();
		windowHandles = driver.getWindowHandles().toArray(new String[0]);
		driver.switchTo().window(windowHandles[windowHandles.length - 1]);
		return new FilmPage(driver);
	  }
	}
	return null;
  }

  public FilmPage chooseFilm(int numerOfFilm) {
	driver.switchTo().window(thisHandles);
	numerOfFilm--;
	if (numerOfFilm >= 0 && numerOfFilm < filmsList.size()) {
	  new Actions(driver).keyDown(Keys.CONTROL).click(filmsList.get(numerOfFilm).findElement(By.tagName("a")))
				.keyUp(Keys.CONTROL).build().perform();
		windowHandles = driver.getWindowHandles().toArray(new String[0]);
		driver.switchTo().window(windowHandles[windowHandles.length - 1]);
		return new FilmPage(driver);
	}
	return null;
  }

}
