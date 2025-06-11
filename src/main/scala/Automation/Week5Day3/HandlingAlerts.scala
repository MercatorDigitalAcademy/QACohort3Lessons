package Automation.Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver}

object HandlingAlerts extends App {

  //Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver: WebDriver = new ChromeDriver()

  //Accessing the web url for testing
  driver.get("https://the-internet.herokuapp.com/javascript_alerts")

  // Simple Alert code
  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click()

  val alert = driver.switchTo().alert()

  println("Alert Text = "+alert.getText)
  alert.accept()

  println("Simple Alert Passed")

  // Confirmation Alert code

  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click()
  driver.switchTo().alert().dismiss()
  println("Confirmation Alert Passed")

  // Prompt Alert code

  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click()
  val alert1 = driver.switchTo().alert()
  println(alert1.getText)
  alert1.sendKeys("Welcome")
  alert1.accept()

  driver.quit()

}
