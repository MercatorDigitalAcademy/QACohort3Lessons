package Automation.Week4Day4

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

object WebDriverTaskAns extends App {

  //MVP (from PPT)

  // Create ChromeDriver instance
  val driver: WebDriver = new ChromeDriver()

  // First MVP Task (from ppt): Locator Types on Selenium Web Form

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  // 1. By ID
  val nameField = driver.findElement(By.id("my-text-id"))
  nameField.sendKeys("Alice")

  // 2. By Name
  val passwordField = driver.findElement(By.name("my-password"))
  passwordField.sendKeys("12345")

  // 3. By Class Name
  val commentField = driver.findElement(By.className("form-control"))
  commentField.sendKeys("This is a test comment.")

  // 4. By Tag Name
  val inputElements = driver.findElements(By.tagName("input"))
  println(s"Number of input elements: ${inputElements.size}")

  // 5. By LinkText
  val returnLink = driver.findElement(By.linkText("Return to index"))
  returnLink.click()

  // 6. By PartialLinkText
  driver.navigate().back()
  val partialLink = driver.findElement(By.partialLinkText("Return"))
  partialLink.click()

}


