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
public class FilmPage {

  WebDriver driver;
  private List<WebElement> actorsList = new ArrayList();
  String[] windowHandles;
  String thisHandles;

  public FilmPage(WebDriver driver) {
	this.driver = driver;
	thisHandles = driver.getWindowHandle();
	collectActorsList();
  }

  private void collectActorsList() {
	actorsList = driver.findElements(By.xpath("//div[2]/div[7]/div"));
  }

  public ActorPage chooseActor(int numerOfActor) {
	driver.switchTo().window(thisHandles);
	numerOfActor--;
	if (numerOfActor >= 0 && numerOfActor < actorsList.size()) {
	  new Actions(driver).keyDown(Keys.CONTROL).click(actorsList.get(numerOfActor).findElement(By.tagName("a")))
			  .keyUp(Keys.CONTROL).build().perform();
	  windowHandles = driver.getWindowHandles().toArray(new String[0]);
	  driver.switchTo().window(windowHandles[windowHandles.length - 1]);
	  return new ActorPage(driver);
	}
	return null;
  }

}
