package Automation.Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver}

object HandlingRadioButtonAndCheckBox extends App {

  //Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver: WebDriver = new ChromeDriver()

  //Accessing the web url for testing
  driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html")


  driver.quit()

}
