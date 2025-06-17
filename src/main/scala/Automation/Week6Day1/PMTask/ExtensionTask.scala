package Automation.Week6Day1.PMTask

import org.openqa.selenium._
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.io.FileHandler

import java.io.File
import scala.jdk.CollectionConverters._

object ExtensionTask extends App{

    val options = new ChromeOptions()
    options.addArguments("--headless=new")
    options.addArguments("--window-size=1920,1080")

    val driver = new ChromeDriver(options)

    try {
      driver.get("https://the-internet.herokuapp.com/tables")

      // Locate Table 1 and Last Name header (1st column header)
      val table1 = driver.findElement(By.id("table1"))
      val lastNameHeader = table1.findElement(By.cssSelector("th:nth-child(1)"))

      // Helper function to get trimmed, lowercase text of last name column cells
      def getLastNameColumnValues: List[String] = {
        val cells = table1.findElements(By.cssSelector("tbody tr td:nth-child(1)")).asScala
        cells.map(_.getText.trim.toLowerCase).toList
      }

      // Helper to take screenshot on failure
      def takeScreenshot(): Unit = {
        val scrFile = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
        FileHandler.copy(scrFile, new File("/Users/anjali.nair/screenshots/TestResult_Specific.png"))
      }

      // Click header to sort ascending
      lastNameHeader.click()

      val ascValues = getLastNameColumnValues
      println(s"Ascending values: $ascValues")

      // Verify ascending
      if (ascValues == ascValues.sorted) {
        println("Ascending sort verification: ✔️ PASSED")
      } else {
        println("Ascending sort verification: ❌ FAILED")
        takeScreenshot()
      }

      // Click header again to sort descending
      lastNameHeader.click()

      val descValues = getLastNameColumnValues
      println(s"Descending values: $descValues")

      // Verify descending
      if (descValues == descValues.sorted(Ordering[String].reverse)) {
        println("Descending sort verification: ✔️ PASSED")
      } else {
        println("Descending sort verification: ❌ FAILED")
        takeScreenshot()
      }

    } catch {
      case e: Exception =>
        println(s"Test failed with exception: ${e.getMessage}")
        e.printStackTrace()
    } finally {
      driver.quit()
    }

}
