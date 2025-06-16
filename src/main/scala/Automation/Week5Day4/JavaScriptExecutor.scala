package Automation.Week5Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}

object JavaScriptExecutor extends App {

  // Create ChromeDriver instance
  val driver: WebDriver = new ChromeDriver()

  // Navigate to the website
  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

  driver.manage().window().maximize()

  // Locate email address by ID and enter text
  val emailAddress: WebElement = driver.findElement(By.id("email"))
  emailAddress.sendKeys("example@gmail.com")
  println("Found the ID locator for the email address - Passed")

  // Locate password field by ID and enter text
  val password: WebElement = driver.findElement(By.id("password"))
  password.sendKeys("password123")
  println("Found the ID locator for the password - Passed")

  val submitButton = driver.findElement(By.id("login"))

  // Casts the WebDriver instance to JavascriptExecutor so you can execute custom JavaScript in the browser.
  // This is necessary because not all WebDriver instances directly expose JavaScript execution.
  val js = driver.asInstanceOf[JavascriptExecutor]

  // Scrolls the `submitButton` element into the visible area of the browser window using JavaScript.
  // This helps ensure the button is visible before interacting with it (prevents ElementNotInteractableException).
  js.executeScript("arguments[0].scrollIntoView(true);", submitButton)

  // Clicks on the `submitButton` element using JavaScript instead of the usual WebDriver `.click()` method.
  // Useful when the normal `.click()` fails due to overlays, hidden elements, or other UI issues.
  js.executeScript("arguments[0].click();", submitButton)

  println("Clicked the submit button using Javascript Executor")

  val headerText = driver.findElement(By.tagName("h2")).getText
  assert(headerText == "Thank You!")

  // Close browser
  driver.quit()
}
