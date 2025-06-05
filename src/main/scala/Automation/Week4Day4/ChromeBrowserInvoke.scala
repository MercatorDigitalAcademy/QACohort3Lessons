package Automation.Week4Day4

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object ChromeBrowserInvoke extends App {

   val driver: WebDriver = new ChromeDriver()

  println("Invoking Chrome Browser")

  driver.get("https://www.google.com")

  println("Title of the page: " +driver.getTitle)

  driver.quit()

}


