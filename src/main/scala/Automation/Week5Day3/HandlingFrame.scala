package Automation.Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver}

object HandlingFrame extends App {

  //Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver: WebDriver = new ChromeDriver()

  //Accessing the web url for testing
  driver.get("https://the-internet.herokuapp.com/nested_frames")

  driver.switchTo().frame("frame-top")
  driver.switchTo().frame("frame-middle")

  val middleText = driver.findElement(By.id("content")).getText
  println("Middle Text = "+middleText)

  driver.switchTo().defaultContent()

  driver.switchTo().frame(1)

  val bottomText = driver.findElement(By.tagName("body")).getText
  println("Bottom Text = "+bottomText)

  driver.switchTo().defaultContent()

  val frameTop = driver.findElement(By.name("frame-top"))
  driver.switchTo().frame(frameTop)
  driver.switchTo().frame("frame-left")
  val leftText = driver.findElement(By.tagName("body")).getText
  println("Left text -"+leftText)

  driver.quit()

}
