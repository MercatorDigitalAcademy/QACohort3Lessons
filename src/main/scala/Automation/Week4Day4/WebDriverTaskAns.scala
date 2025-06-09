package Automation.Week4Day4

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions

import java.time.Duration

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

  //From afternoon task:

  // MVP

  // 1. Elements on W3Schools HTML Examples

  driver.get("https://www.w3schools.com/html/html_examples.asp")

  // a) Identify Button Elements
  val buttons = driver.findElements(By.tagName("button"))
  println(s"Number of buttons: ${buttons.size}")

  // b) Identify Image Elements
  val images = driver.findElements(By.tagName("img"))
  println(s"Number of images: ${images.size}")

  // c) Count of <h1> or <a> elements
  val h1s = driver.findElements(By.tagName("h1"))
  val links = driver.findElements(By.tagName("a"))
  println(s"<h1>: ${h1s.size}, <a>: ${links.size}")

  // d) Loop over multiple tags
  val tags = Array("p", "a", "h1", "button")
  tags.foreach(tag => println(s"$tag count: ${driver.findElements(By.tagName(tag)).size}"))

  // e) Count of all <a> tags (hyperlinks)
  println(s"Hyperlinks count: ${driver.findElements(By.tagName("a")).size}")

  // 2. DemoQA - Locator Edge Cases

  driver.get("https://demoqa.com/text-box")

  // a) Missing ID/Name Attributes
  val fullNameInput = driver.findElement(By.cssSelector("input[placeholder='Full Name']"))
  fullNameInput.sendKeys("Test User")

  // b) Whitespace in Link Text (solution via normalize-space)
  val header = driver.findElement(By.xpath("//*[normalize-space(text())='Text Box']"))
  println("Found header with whitespace correctly handled.")

  /** I CAN'T GET THIS WORKING */
  // c) Hidden Elements (e.g. after clicking Submit)
  //  val waitTen = new WebDriverWait(driver, Duration.ofSeconds(10))
  //  val submit = waitTen.until(ExpectedConditions.elementToBeClickable(By.id("submit")))
  //  submit.click()
  //  println("Submit button clicked after waiting!")

  // Extension: Drag and Drop - Herokuapp

  driver.get("https://the-internet.herokuapp.com/drag_and_drop")

  // Locate Column A - precise selection
  val columnA = driver.findElement(By.cssSelector("#column-a"))
  println("Found Column A using ID.")

  // By.className could also work but may match both A and B
  val columns = driver.findElements(By.className("column"))
  println(s"Total columns found: ${columns.size}")

  driver.quit()

  //Research

  // 1.	Investigate Selenium V4.0 and find out the improvements that have been made and what capabilities are now available.
  //  Selenium 4.0 brings significant improvements, including full compliance with the W3C WebDriver standard, which enhances stability and browser compatibility. It introduces powerful new features like relative locators for more intuitive element targeting, Chrome DevTools Protocol (CDP) support for network and device emulation, and a redesigned Selenium Grid with better scalability, Docker support, and easier setup. The IDE and documentation have also been modernised, making it more accessible to new users.

  // 2. On HRMC you may use `Remote WebDriver` features. Investigate what Remote WebDriver is and the features available.
  //RemoteWebDriver allows tests to run on remote machines or cloud services instead of locally. This is especially useful for organisations like HRMC, where tests need to run across multiple browsers and systems in parallel, often as part of a CI/CD pipeline. It supports scalable, distributed testing and integrates easily with tools like Jenkins and platforms like BrowserStack or Sauce Labs.
}


