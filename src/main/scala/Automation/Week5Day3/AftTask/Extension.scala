package Automation.Week5Day3.AftTask

import org.openqa.selenium._
import org.openqa.selenium.chrome.ChromeDriver

object Extension extends App {

  val driver = new ChromeDriver()

  driver.manage().window().maximize()

  // 1. Handle Alerts

  driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php")
  println("Extension Q1\nNavigated to page")

  // Simple alert
  driver.findElement(By.xpath("//button[text()='Alert']")).click() // Click the button to trigger the alert
  val simpleAlert = driver.switchTo().alert() // Switch to alert and accept it
  println("Alert Text: " + simpleAlert.getText)
  simpleAlert.accept()
  println("Handled simple alert")

  // Confirm alert
  driver.findElement(By.cssSelector("button.btn.btn-primary[onclick='myDesk()']")).click() // Click the button to trigger the confirm alert
  val confirmAlert = driver.switchTo().alert() // Switch to alert
  println("\nConfirm Alert Text: " + confirmAlert.getText)
  confirmAlert.dismiss() // Dismiss alert
  println("Handled confirm alert (dismissed)")

  // Prompt alert
  driver.findElement(By.cssSelector("button.btn.btn-primary[onclick='myPromp()']")).click() // Click the button to trigger the prompt alert
  val alert = driver.switchTo().alert() // Switch to alert
  println("\nPrompt Alert Text: " + alert.getText)
  alert.sendKeys("Scala Test") // Send text
  alert.accept() // Accept alert
  println("Handled prompt alert with input")

  // 2. Handle Frames

  driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe")
  println("\nExtension Q2\nNavigated to page")

  driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe")

  driver.switchTo().frame("iframeResult") // Switch to the iframe by name or ID

  driver.switchTo().frame(0) // Now switch to the nested iframe inside iframeResult

  val heading = driver.findElement(By.tagName("h1")) // Perform actions inside the frame
  println("Heading inside frame: " + heading.getText)

  driver.switchTo().defaultContent() // Switch back to the main content

  // 2. Handle Nested Frames

  driver.get("https://www.tutorialspoint.com/selenium/practice/nestedframes.php")
  println("\nNavigated to nested tests page")
  driver.switchTo().frame("frame1") // Switch to the outer frame
  println("Inside outer frame")
// We don't need to switch to `frame2` here as it isn't a traditional nested iframe, it is part of the html content which makes up `frame1`
  val innerText = driver.findElement(By.tagName("body")).getText // Interact with an element inside the nested frame
  println(s"Text inside nested frame:\n$innerText")
  driver.switchTo().defaultContent() // Switch back to the main content

  driver.close()
  driver.quit()
}
