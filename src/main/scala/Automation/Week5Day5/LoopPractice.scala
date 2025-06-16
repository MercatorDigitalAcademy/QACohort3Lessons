package Automation.Week5Day5

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

import scala.jdk.CollectionConverters.CollectionHasAsScala

object LoopPractice extends App {

  //for comprehension
  /**
   * for (item <- collection){
   * //DO SOMETHING TO EVERY ITEM
   * }
   */

  //SCALA
  val fruits: List[String] = List("Apple", "Banana", "Cherry", "Melon")

  for (fruit <- fruits) {
    println(fruit)
  }

  //TURNED INTO SELENIUM:
  /**
   * .asScala -> turn it into Scala from Java
   * for (fruit <- fruits.asScala){
   * println(fruit.getText)
   * }
   */

  //EXAMPLE - WON'T RUN

  val driver = new ChromeDriver()
  driver.get("https://example.com")

  //loop through a list of elements
  val items = driver.findElements(By.id("i")) //Elements WITH AN S - it is a list. Find element by the id, using inspect.
  for (item <- items.asScala) { //loop over each WebElement in the items collection (but this is a Java list - currently can't use the <- until we turn it into Scala).
    println(item.getText) //Get the text, and print it.
  }

  //click all buttons within a selection
  val buttons = driver.findElements(By.cssSelector(".my-buttons"))
  for (button <- buttons.asScala) {
    button.click()
  }

  //find a specific element (within a loop - collection of a types)
  //Need to use an `if` within the for comp
  val links = driver.findElements(By.tagName("a")) //find all the links on the URL from L35
  //I want to find the 'contact us' link
  for (link <- links.asScala) {
    if (link.getText.contains("Contact".toLowerCase)) {
      link.click()
    } else
      println("No links containing `contact` were found.")
  }

  //TABLES
/*  <table>
    <tr>
      <td>Apple</td> <td>Red</td>
    </tr>
    <tr>
      <td>Banana</td> <td>Yellow</td>
    </tr>
  </table> */

  //loop through table rows
  val rows = driver.findElements(By.tagName("tr")) //find all elements contained with 'tr' tags (rows)
  for ((row, index) <- rows.asScala.zipWithIndex){
    val cells = row.findElements(By.tagName("td")) //this is taking all of the rows that have been found, going inside those rows, and pulling out every 'td' tag.
    //cell = List("Apple", "Red", "0", "Banana", "Yellow", "1")
    cells.asScala.map(_.getText).mkString("! , ".trim) //"Apple! , Red! , 0! , Banana! , Yellow! , 1"
  }

  //zipWithIndex Method
  //Pair each row with its index (starting from 0)
  //Row 0: Apple | Red
  //Row 1: Banana | Yellow

  // Does a value exist?
  val doesBananaExist = rows.asScala.exists{ row =>
    val cells = row.findElements(By.tagName("td")).asScala
    cells.exists(_.getText == "Banana")
  }
  assert(doesBananaExist, "Yay bananas!")

}
