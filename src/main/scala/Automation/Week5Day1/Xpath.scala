package Automation.Week5Day1

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object Xpath extends App {

  //Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver: WebDriver = new ChromeDriver()

  //Accessing the web url for testing
  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

//  val emailAddress: WebElement = driver.findElement(By.id("email"))

  //Use the cssSelector for the id locator present in the HTML code
  val emailAddress: WebElement = driver.findElement(By.xpath("//input[@type='email']"))
  emailAddress.sendKeys("test@gmail.com")
  println("Email address entered - Passed")

 // val password: WebElement =driver.findElement(By.id("password"))
 //val password: WebElement =driver.findElement(By.cssSelector("input[type='password']"))

  val password: WebElement =driver.findElement(By.xpath("//input[@type='password']"))
  password.sendKeys("Password123")
  println("Password entered - Passed")

 // val login: WebElement =driver.findElement(By.id("login"))
 val login: WebElement =driver.findElement(By.xpath("//input[@type='submit'][@id='login']"))
  login.click()
  println("Logged in successfully - Passed")

  driver.quit()

}
