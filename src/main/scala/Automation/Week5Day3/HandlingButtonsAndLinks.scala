package Automation.Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object HandlingButtonsAndLinks extends App {

  //Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver: WebDriver = new ChromeDriver()

  //Accessing the web url for testing
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  driver.manage().window().maximize()

  val button: WebElement =driver.findElement(By.cssSelector("[type=\"submit\"]"))
  if (button.isEnabled){

    println("button text - "+button.getText)
    button.click()

  } else{
    println("Button is not enabled")
  }


  // Handling Hyperlinks

  driver.get("https://www.selenium.dev/")

  val myLink = driver.findElement(By.linkText("Documentation"))

  val myLinkUrl= myLink.getAttribute("href")

  println("Destination URl - " +myLinkUrl)

}
