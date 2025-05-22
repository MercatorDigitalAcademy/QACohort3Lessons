package Mon

object MonCodeAlong extends App {
  //VAL = BEST PRACTICE!!
  val melons = 5 * 50
  val apples = 2 * 10
  val fizzyDrink = 6 * (100 * 1.20)
  //  val total = melons + apples + fizzyDrink

  //VAR - mutable (not best practice)
  var total: Double = 0
  total = total + apples
  println(total)
  total = total + melons
  println(total)
  total = total + fizzyDrink
  println(total)

  println(melons)
  println(apples)
  println(fizzyDrink)
  println(total)

  //TYPES
  val wholeNumber: Int = 6483
  val littleNumber: Short = 68 // RARE - JUST USE INT
  val bigNumber: Long = 354748462538498L //MUST PUT L
  val littleDecimal: Float = 2.464748f //MUST PUT f (RARE)
  val decimal: Double = 46465.936 //USE THIS!!
  val text: String = "Hello world!"
  val trueFalse: Boolean = true //false
  val falseTrue: Boolean = true
  println(trueFalse == falseTrue)

  //OPERATORS

  val a: Int = 10
  val b: Int = 5
  val c: Int = 3

  val add: Int = a + b
  println(add)
  val subtract: Int = a - b
  val divide: Double = a / c
  val multiply:Int = a * b
  val modulus: Int = a % c // 10 % 3 (what is the remainder)
  println(modulus)
  val even: Int = a % 2 //left with 0 = even
  println(even)

  //Relational
  val equality: Boolean = a == a // true/false
  println(equality)
  val inequality: Boolean = a != b // NOT EQUAL TO
  val lessThan: Boolean = b<c
  val lessThanEqualTo: Boolean = b<=c
  val greaterThan: Boolean = b>c
  val greaterThanEqualsTo: Boolean = b>=c

  //LOGICAL
  val and: Boolean = true && true //both must be true to return true
  val or: Boolean = true || false //either side can be true to return true
  val not: Boolean = !false

  //METHODS
  def makeACupOfTea(sugar:Int, milk:Boolean): String = {
    s"You have made a cup of tea with $sugar spoons of sugar. Your milk selection is: $milk"
  }
println(makeACupOfTea(7, milk = true)) //calling the method
println(makeACupOfTea(1, milk = false)) //calling the method

  val vat: Double = 1.2 //function - can't pass in parameters
  //Write me a method that calculates the final price of a product with VAT.
  def priceWithVAT(price: Double): Double = {
    price * vat
  }
  println(priceWithVAT(10.0))

  // CLASSES (think of these as a type)

  //THIS IS MY INSTRUCTION - Doesn't mean a lot by itself
  class Dog (val name:String, val age:Int, val likesBananas:Boolean){
    val hasEars: Boolean = true //default parameters
    def speak:String = "woof" //declared in advance as it is the same for every Dog
  }
  //Use the class to make objects (e.g Dog)
  //Object of type Dog
  val loki:Dog = new Dog("Loki", 5, true)
  //How do I access?
  println(loki.speak)
  println(loki.name)

  //Type safety - makes things clearer if they have the same type
  class Name(name:String)
  class Surname(surname: String)

  class Cat (val name: Name, val surname: Surname, val age: Int){
    val likesMilk:Boolean = true
  }
  //Cat Object
  val Henry:Cat = new Cat (new Name("Henry"), new Surname("Jones"), 5)

  Henry.age
  Henry.likesMilk



}
