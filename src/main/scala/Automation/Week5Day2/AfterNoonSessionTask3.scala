package Automation.Week5Day2

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver}

object AfterNoonSessionTask3 extends App {

    val driver: WebDriver = new ChromeDriver()

    // Step 2: Navigate to the test URL
    driver.get("https://demoqa.com/automation-practice-form")
    println("Navigated to the demo QA form.")

    // Step 3: Locate elements
    val firstNameField = driver.findElement(By.id("firstName"))
    val hobbiesCheckbox = driver.findElement(By.id("hobbies-checkbox-1"))
    val submitButton = driver.findElement(By.id("submit"))

    // Step 4a: Check First Name field
    if (firstNameField.isDisplayed && firstNameField.isEnabled) {
      println("First Name input is displayed and enabled.")
      firstNameField.sendKeys("John")
      println("Entered name: John")
    } else {
      println("First Name input is not ready for input.")
    }

    // Step 4b: Check Hobbies checkbox
    if (!hobbiesCheckbox.isSelected) {
      println("Hobbies checkbox is not selected. Selecting it now.")
      // Scroll into view first
      val js = driver.asInstanceOf[JavascriptExecutor]
      js.executeScript("arguments[0].scrollIntoView(true);", hobbiesCheckbox)
      Thread.sleep(500)

      // Click using JS to avoid interception
      js.executeScript("arguments[0].click();", hobbiesCheckbox)
    } else {
      println("Hobbies checkbox is already selected.")
    }

    // Step 4c: Check Submit button
    if (submitButton.isDisplayed && submitButton.isEnabled) {
      println("Submit button is displayed and enabled. Clicking it.")
      submitButton.click()
    } else {
      println("Submit button is not clickable.")
    }

  // Optional wait to observe the result before closing
  //  Thread.sleep(3000)

    // Step 6: Close the browser
    println("Closing the browser.")
    driver.quit()

}
