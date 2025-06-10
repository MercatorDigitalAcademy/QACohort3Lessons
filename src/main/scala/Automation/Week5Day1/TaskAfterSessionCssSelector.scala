package Automation.Week5Day1

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

object TaskAfterSessionCssSelector extends App {
    // Setup WebDriver (make sure chromedriver is in your PATH)
    val driver = new ChromeDriver

      driver.get("https://www.selenium.dev/selenium/web/web-form.html")
      // 1. Locate text input by ID
      val username = driver.findElement(By.cssSelector("input#my-text-id"))
      username.sendKeys("TestUser")
      // 2. Locate password input by name
      val password = driver.findElement(By.cssSelector("input[name='my-password']"))
      password.sendKeys("Secret123")
      // 3. Locate and click submit button by class and type attribute
      val submitButton = driver.findElement(By.cssSelector("button.btn[type='submit']"))
      submitButton.click()
      driver.quit()
}