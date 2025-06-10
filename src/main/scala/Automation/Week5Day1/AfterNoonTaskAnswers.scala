package Automation.Week5Day1

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
object AfterNoonTaskAnswers extends App {

    val driver = new ChromeDriver()

    // Step 1: Navigate to the form page
    driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html")

    // Step 2: Enter text using By.id
    val username = driver.findElement(By.name("username")) // <-- students can change this
    username.sendKeys("TestUser")
    println("Entered username using ID")

    // Step 3: Enter password using By.name
    val password = driver.findElement(By.name("password")) // <-- students can change this
    password.sendKeys("secret")
    println("Entered password using Name")

    // Step 4: Enter comment using By.cssSelector
    val commentBox = driver.findElement(By.cssSelector("textarea[name='comments']")) // <-- modify as needed
    commentBox.clear()
    commentBox.sendKeys("This is a test comment.")
    println("Entered comment using CSS Selector")

    // Step 5: Click checkbox using By.className
    val checkbox = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[1]")) // <-- confirm or modify

    checkbox.click()
    println("Clicked checkbox using Class Name")

    // Step 6: Click submit using By.xpath
    val submitBtn = driver.findElement(By.className("styled-click-button"))
    submitBtn.click()
    println("Clicked submit using XPath")

    // Step 7: Click link using By.linkText
    val indexLink = driver.findElement(By.linkText("Index"))
    indexLink.click()
    println("Clicked link using LinkText")

    // Step 8: Click the same link using By.partialLinkText
    val partialLink = driver.findElement(By.partialLinkText("Ind"))
    partialLink.click()
    println("Clicked link using PartialLinkText")

    // Close the browser
    driver.quit()

}
