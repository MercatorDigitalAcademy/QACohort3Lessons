package Automation.Week5Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver}

import scala.jdk.CollectionConverters.CollectionHasAsScala

object HandlingWindow extends App {

        // Setup ChromeDriver
        val driver: WebDriver = new ChromeDriver()

        // Navigate to a site that opens a new window
        driver.get("https://the-internet.herokuapp.com/windows")
        driver.manage().window().maximize()

        // Get the handle of the current (parent) window
        val parentWindow = driver.getWindowHandle
        println(s"Parent Window Handle: $parentWindow")

        // Click the link to open a new window
        driver.findElement(By.linkText("Click Here")).click()

        // Get all window handles after new window opens
        val allWindows: List[String] = driver.getWindowHandles.asScala.toList

        // Loop through all window handles
        // Get an iterator for all available window handles
        val it = allWindows.iterator

        // Iterate through each window handle
        while (it.hasNext) {
           val handle = it.next()

        // Check if the handle is not the parent (original) window
            if (handle != parentWindow) {
                // Switch to the new window
                driver.switchTo().window(handle)
                println(s"Switched to New Window: $handle")

                // Perform action in new window
                println(s"New Window Title: ${driver.getTitle}")

                // Close only the new window
                driver.close()
                println("Closed New Window")
            }
        }

        // Switch back to parent window
        driver.switchTo().window(parentWindow)
        println("Switched back to Parent Window")

        // Quit entire browser session
        driver.quit()

}
