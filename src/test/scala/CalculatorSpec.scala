import org.scalatest.flatspec.AnyFlatSpec

import scala.language.postfixOps

class CalculatorSpec extends AnyFlatSpec {

  val calc: Calculator = new Calculator // make a new object of our Class so we can access all the methods within it.

  "add" should "add 2 Int's together" in{
    val input = calc.add(1,2)
    val expectedResult = 3 //1+2
    assert(input == expectedResult) // assert(calc.add(1,2) == 3)
  }

  "multiply" should "multiply 2 Int's together" in {
    val input = calc.multiply(2,3)
    val expectedResult = 6
    assert(input == expectedResult)
  }

  "subtract" should "subtract y from x" in {
    assert(calc.subtract(1,2) == -1)
  }

}
