package Automation.Week5Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}

import java.time.Duration

object ExplicitWait extends App {

                val driver: WebDriver = new ChromeDriver()
                driver.get("https://www.w3schools.com/howto/howto_css_custom_checkbox.asp")

                val explicitWait = new WebDriverWait(driver, Duration.ofMinutes(10))

                // Wait until the first checkbox span is clickable
                val checkbox = explicitWait.until(
                        ExpectedConditions.elementToBeClickable(By.xpath("(//label[@class='container'])[1]/span"))
                )

                checkbox.click()
                println("Checkbox clicked!")

                driver.quit()

}
