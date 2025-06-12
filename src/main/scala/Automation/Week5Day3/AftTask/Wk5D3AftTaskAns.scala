package Automation.Week5Day3.AftTask

import org.openqa.selenium._
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.Select

object Wk5D3AftTaskAns extends App {

  // Set up ChromeDriver
  val driver = new ChromeDriver()

  // 1. Navigate to the main page
  driver.get("https://testpages.herokuapp.com/styled/index.html")
  driver.manage().window().maximize()
  println("1.\nNavigated to the main page")

  // 2. Click the link to the HTML Form Example
  val formLink = driver.findElement(By.linkText("HTML Form Example"))
  formLink.click()
  println("2.\nClicked on 'HTML Form Example' link")
  // Fill in text boxes
  val username = driver.findElement(By.name("username"))
  username.sendKeys("testuser")
  println("Entered username")
  val password = driver.findElement(By.name("password"))
  password.sendKeys("password123")
  println("Entered password")

  // 3. Locate the checkbox
  val checkbox1 = driver.findElement(By.cssSelector("input[name='checkboxes[]'][value='cb1']"))
  println("3.\nCheckbox 1 located")
  // Click the checkbox if not already selected
  if (!checkbox1.isSelected) {
    checkbox1.click()
  }
  println("Checkbox 1 selected: " + checkbox1.isSelected)

  // 4. Select a radio button
  val radio = driver.findElement(By.cssSelector("input[value='rd2']"))
  radio.click()
  println("4.\nSelected radio button")

  // 5. Select an option from the dropdown
  val dropdown = new Select(driver.findElement(By.name("dropdown")))
  dropdown.selectByVisibleText("Drop Down Item 4")
  println("5.\nSelected item from dropdown")

  // 6. Click the submit button
  val submit = driver.findElement(By.cssSelector("input[type='submit']"))
  submit.click()
  println("6.\nClicked submit button")

  // 7. Click the link to return to the home page
  val homeLink = driver.findElement(By.xpath("//*[@id='back_to_form']"))
  homeLink.click()
  println("7.\nClicked 'Index' link to return to homepage")

  driver.quit()
}





