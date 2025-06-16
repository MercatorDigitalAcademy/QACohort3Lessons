package Automation.Week5Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.FluentWait
import org.openqa.selenium.{By, NoSuchElementException, WebDriver, WebElement}

import java.time.Duration
import java.util.function.Function

object FluentWait extends App {

  // Set up ChromeDriver
  val driver: WebDriver = new ChromeDriver()

  // Go to the test site
  driver.get("https://www.saucedemo.com")
  driver.manage().window().maximize()

  // Fill username
  val username = driver.findElement(By.id("user-name"))
  username.sendKeys("standard_user")

  // Fill password
  val password = driver.findElement(By.id("password"))
  password.sendKeys("secret_sauce")

  // FluentWait for the login button
  val fluentWait = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(10))
    .pollingEvery(Duration.ofSeconds(1))
    .ignoring(classOf[NoSuchElementException])

  val loginButton: WebElement = fluentWait.until(new Function[WebDriver, WebElement] {
    override def apply(driver: WebDriver): WebElement = {
      val btn = driver.findElement(By.id("login-button"))
      if (btn.isDisplayed && btn.isEnabled) btn else null
    }
  })

  // Click the login button
  loginButton.click()
  println("Clicked login button using FluentWait")

  // Wait briefly and print current page title
  println("Page title after login: " + driver.getTitle)

  // Close browser
  driver.quit()
}
