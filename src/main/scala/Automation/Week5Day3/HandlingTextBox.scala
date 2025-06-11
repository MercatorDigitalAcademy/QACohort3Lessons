package Automation.Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object HandlingTextBox extends App {

  //Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver: WebDriver = new ChromeDriver()

  //Accessing the web url for testing
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  val text = driver.findElement(By.id("my-text-id"))
  text.sendKeys("Welcome to Mercator")
  println("The value has been entered")

  val text1 =text.getAttribute("value")
  println("The attribute value: " +text1)

  val text2 =text.getText
  println("The attribute value: " +text2)

  driver.quit()

}
