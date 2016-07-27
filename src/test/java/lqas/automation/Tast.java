/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lqas.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 *
 * @author Sveta
 */
public class Tast {
  WebDriver driver;
  
  @BeforeSuite
  public void entrance() {
	System.setProperty("webdriver.chrome.driver", "D:\\Java\\Lits Дз\\SeleniumTests\\src\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://my-hit.org");
  }
  
  public Tast() {
  }

  @Test
  public void hello() {
	MainPage mp = new MainPage(driver);
	String expectedAutor = "Стивен Амелл";
	String expectedAutor2 = "Пола Паттон";
	
	String actualAutor = mp.chooseFilm("Код 8").chooseActor(1).getNameOfAutor();
	String actualAutor2 = mp.chooseFilm("Варкрафт").chooseActor(2).getNameOfAutor();
	
	assertEquals(actualAutor, expectedAutor);
	assertEquals(actualAutor2, expectedAutor2);
	
	
	
  }
  
  @AfterSuite
  public void close() {
	driver.quit();
  }
}
