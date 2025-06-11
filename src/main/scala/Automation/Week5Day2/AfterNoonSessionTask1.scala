package Automation.Week5Day2

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object AfterNoonSessionTask1 extends App {

  // 1. Launch the browser using WebDriver
  val driver: WebDriver = new ChromeDriver()

  // 2. Navigate to the test URL
  val testUrl = "https://demoqa.com/browser-windows"
  driver.get(testUrl)

  // 3. Fetch and print
  println("Page Title: " + driver.getTitle)
  println("Current URL: " + driver.getCurrentUrl)
  println("Window Handle: " + driver.getWindowHandle)

  driver.quit()

}