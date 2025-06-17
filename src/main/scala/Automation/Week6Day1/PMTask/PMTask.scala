package Automation.Week6Day1.PMTask

import Automation.Utilities.ScreenshotUtil.takeScreenshot
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}

import java.io.File
import java.time.format.DateTimeFormatter
import java.time.{Duration, LocalDateTime}

object PMTask extends App {


    // Configure ChromeOptions for headless mode
    val chromeOptions = new ChromeOptions()
    chromeOptions.addArguments("--headless=new")
    chromeOptions.addArguments("--disable-gpu")
    chromeOptions.addArguments("--window-size=1920,1080")

    var driver: WebDriver = null // Declare driver outside try for finally block access
    val timestamp: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss"))
    val screenshotsDir = new File("screenshots")
    if (!screenshotsDir.exists()) screenshotsDir.mkdirs() // Create screenshots directory

    try {
      driver = new ChromeDriver(chromeOptions)
      val wait = new WebDriverWait(driver, Duration.ofSeconds(10)) // Max 10-second wait

      // Navigate to the login page
      driver.get("https://the-internet.herokuapp.com/login")
      println("Navigated to login page.")

      // Enter credentials
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("tomsmith")
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("SuperSecretPassword!")
      println("Entered credentials.")

      // Click login button
      wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginbutton"))).click()
      println("Clicked login button.")

      // Check login status and take screenshot
      val flashMessageText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash"))).getText
      val status = if (flashMessageText.contains("You logged into a secure area!")) "success" else "failure"
      println(s"Login status: $status - Message: $flashMessageText")

      takeScreenshot(driver, s"screenshots/login-$status-$timestamp.png")
      println(s"Screenshot saved for $status.")

    } catch {
      case e: Exception =>
        println(s"An error occurred: ${e.getClass.getSimpleName} - ${e.getMessage}")
        // Take a screenshot on any exception
        takeScreenshot(driver, s"screenshots/error-exception-$timestamp.png")
        println("Screenshot saved for error.")
        e.printStackTrace() // Print stack trace for debugging

    } finally {
      // Always close the browser
      if (driver != null) {
        println("Closing browser.")
        driver.quit()
      }
    }
}