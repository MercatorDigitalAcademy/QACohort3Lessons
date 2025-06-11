package Automation.Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, WebDriver}

object HandlingDropDown extends App {

  //Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver: WebDriver = new ChromeDriver()

  //Accessing the web url for testing
  driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select")

  driver.switchTo().frame("iframeResult")

  val dropdown = driver.findElement(By.name("cars"))

  val select = new Select(dropdown)

  select.selectByVisibleText("Opel")

  println("selected by Visible Text - " + select.getFirstSelectedOption.getText)

  select.selectByValue("volvo")

  println("selected by Value - " + select.getFirstSelectedOption.getText)

  select.selectByIndex(3)

  println("selected by Index - " + select.getFirstSelectedOption.getText)




  driver.quit()

}
