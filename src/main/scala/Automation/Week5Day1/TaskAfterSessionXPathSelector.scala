package Automation.Week5Day1

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver}

object TaskAfterSessionXPathSelector extends App {

        val driver: WebDriver = new ChromeDriver()

        driver.get("https://the-internet.herokuapp.com/login")

        val usernameInput = driver.findElement(By.xpath("//input[@id='username']"))
        usernameInput.sendKeys("tomsmith")

        val passwordInput = driver.findElement(By.xpath("//input[@id='password']"))
        passwordInput.sendKeys("SuperSecretPassword!")

        val loginButton = driver.findElement(By.xpath("//button[@type='submit']"))
        loginButton.click()

        val loginMessage = driver.findElement(By.xpath("//div[@id='flash']"))
        println("Login Message: " + loginMessage.getText.trim)

        driver.quit()
}