package Automation.Week5Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object Assertion extends App {

  // Create ChromeDriver instance
  val driver: WebDriver = new ChromeDriver()

  // Navigate to the website
  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

  driver.manage().window().maximize()
  assert(driver.getTitle == "Selenium Element ID Locators Practice Form | Selenium Exercise")

  val headerText = driver.findElement(By.tagName("h1")).getText
  assert(headerText == "Selenium Element ID Locators Practice Form")

  // Locate email address by ID and enter text
  val emailAddress: WebElement = driver.findElement(By.id("email"))
  emailAddress.sendKeys("example@gmail.com")
  println("Found the ID locator for the email address - Passed")
  val emailAddress1 = emailAddress.getAttribute("value")
  println(emailAddress1)

  // Asserts that emailAddress1 is exactly equal to "example@gmail.com"
  // If it is not, it will throw an AssertionError with the custom message "Expected email address match"
  assert(emailAddress1 == "example@gmail.com", s"Expected email address match")

  // Asserts that emailAddress1 is exactly equal to "example@gmail.com"
  // If it is not, it throws a default AssertionError (no custom message)
  assert(emailAddress1 == "example@gmail.com")

  // Asserts that emailAddress1 contains the string "example@gmail.com" as a substring
  // This allows for partial matches, e.g., "Hello example@gmail.com" would pass
  assert(emailAddress1.contains("example@gmail.com"))

  // Locate password field by ID and enter text
  val password: WebElement = driver.findElement(By.id("password"))
  password.sendKeys("password123")

  println("Found the ID locator for the password - Passed")

  // Optionally close the browser
  driver.quit()
}