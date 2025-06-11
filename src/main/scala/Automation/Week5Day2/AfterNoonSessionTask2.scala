package Automation.Week5Day2

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object AfterNoonSessionTask2 extends App {

  // 1. Launch the browser using WebDriver
  val driver: WebDriver = new ChromeDriver()

  // 2. Navigate to URL
  driver.navigate().to("https://demoqa.com/automation-practice-form")
  Thread.sleep(1000)

  // 3. Use navigate methods
  driver.navigate().back()
  Thread.sleep(1000)

  driver.navigate().forward()
  Thread.sleep(1000)

  driver.navigate().refresh()
  Thread.sleep(1000)

  // 4. Maximize and minimize the browser window
  driver.manage().window().maximize()
  println("Window maximized")
  Thread.sleep(1000)

  driver.manage().window().minimize()
  println("Window minimized")
  Thread.sleep(1000)

  // 5. Print part of the page source
  val pageSourceSnippet = driver.getPageSource.take(300)
  println("Page Source Snippet:\n" + pageSourceSnippet)
  Thread.sleep(3000)

  // 6. Close current window
  driver.close()

  // 7. End the session
  driver.quit()

}