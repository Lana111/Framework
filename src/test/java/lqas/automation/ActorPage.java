/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lqas.automation;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author Sveta
 */
public class ActorPage {
  
  WebDriver driver;
  
  public ActorPage(WebDriver driver) {
	this.driver = driver;
  }
  
  public String getNameOfAutor() {
	return driver.getTitle();
  }
  
}
