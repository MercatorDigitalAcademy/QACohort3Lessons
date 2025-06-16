package Automation.Week5Day4

import org.openqa.selenium._
import org.openqa.selenium.chrome.ChromeDriver

import java.time.Duration

object ImplicitWait extends App{

        // Create ChromeDriver instance
        val driver: WebDriver = new ChromeDriver()

        // Apply implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))  // new syntax after Selenium4.0+

        // Navigate to the Selenium test page
        driver.get("https://www.selenium.dev/selenium/web/web-form.html")

        // Maximize the window
        driver.manage().window().maximize()

        // Locate the text box by name
        val textBox = driver.findElement(By.name("my-text"))

        // Enter text into the text box
        textBox.sendKeys("Testing text input in Scala.")

        // Clear the text box
        textBox.clear()

        // Enter a new value
        textBox.sendKeys("Final input done.")

        // Optionally close the browser
        driver.quit()

}