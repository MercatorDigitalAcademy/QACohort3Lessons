package Automation.Week5Day2

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object BrowserControlMethods extends App {
    // Set path to your ChromeDriver executable (update this as needed)
    System.setProperty("webdriver.chrome.driver", "/Users/anjali.nair/IdeaProjects/Browser/chromedriver")

    // Create a new instance of ChromeDriver
    val driver: WebDriver = new ChromeDriver()

    // Open a website
    driver.get("https://the-internet.herokuapp.com/windows")

    // ======== Commonly Used WebDriver 'browser control' Methods ========

    // Maximize the browser window
    driver.manage().window().maximize()

    // Navigate to the first URL using .navigate().to()
    driver.navigate().to("https://example.com")

    // Navigate to a second URL
    driver.navigate().to("https://the-internet.herokuapp.com")

    // Go back in browser history
    driver.navigate().back()

    // Move forward in browser history
    driver.navigate().forward()

    // Refresh the current page
    driver.navigate().refresh()

    // Close the current browser window
    driver.close()

    // Optionally quit the WebDriver session completely if multiple windows were opened
    // driver.quit()

}
