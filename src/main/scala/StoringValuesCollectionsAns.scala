object StoringValuesCollectionsAns extends App {
  //MVP
  //1a. Three plus four, times fifty-seven is less than three-hundred
  3 + 4 * 57 < 300
  //1b. One-hundred and forty-four, divided by 12 is greater than twelve or equal to twelve
  144 / 12 >= 12
  //1c. Cat is less than Dog (strings)
  "Cat" < "Dog"
  //1d. Rabbit is less than Hamster (strings)
  "rabbit" < "hamster"
  //1e. Seventeen is odd (modulus)
  17 % 2 != 0
  //1f. Seventy-five divided by nine is less than thirty and eighty-nine divided by six is less than twenty
  75 / 9 < 30 && 89 / 6 < 20

  //2. “I love scala already” - has a value of type string. It’s a string literal. Print line is an expression – a side effect as it prints to console – returns a unit (not a string!).

  //3.	Write a method to calculate the square of an `Int`. It should have an `Int` input parameter and `Int` return type.
  def newSquared (number: Int): Int = number * number

  //4.	Write a method to check if a number is odd. It should have an `Int` input parameter and `Boolean` return type.
  def isOdd(number: Int): Boolean  = number % 2 != 0

  //5. Consider a Library, there are many books. Write a Class called ‘Book’. What class parameters will your book need? Can you include any class methods in the body? Can you consider type sensitivity in your class parameter(s) type(s) (and what needs to be made here if you do…)?

 class Book (val title: Title, val genre: Genre, val pageCount:Int) {
    def read (x: Int) = s"I've read $x pages!"
  }
  class Title (title:String)
  class Genre (genre: String)

  //Object of type Book
  val newBook:Book = new Book (new Title("New Book"), new Genre("Horror"), 673)

  //Extension

  //1. Convert a lowercase string to uppercase.
  val uppercase = "hello".toUpperCase

  //2. Convert on the first letter of a string to uppercase.
  val onlyFirstLetter = "hello".capitalize

  //3. ”STRING” == “string” True or false? Why?
  val areYouEqual = "STRING" == "string"
  //No - case sensitive

  //4. Can you simply convert the `String` “one” to the `Int` 1?
  // Not simply (we can't just use .toInt). The compiler doesn't know that "one" is the same as 1. We would need to look at mapping to be able to do this, hold this thought.

  //5. Can you simply convert the `Int` 1 to `String` “one”?
  //No, same as above.

  //6. Can you simply convert `Int` 1 to type `String`? Is the result as you would expect?
  val convertToString = 1.toString
  //Gives "1" as a string. Not one.

  //Research
  //1. Make a val called new which is type string. Why doesn’t this compile? What do we need to do within our code to make it work? Are there any other words that you cannot use?

  // val new:String = "I'm a new string"
  // new is a keyword - this means it is protected. Use backticks if calling a val a keyword is unavoidable. lots of keywords, just look them up.
  //2. Use backticks
  val `new`:String = "I'm a new string"
  //other keywords include: object, if, abstract, class.... (search scala keywords online and you'll find a big list!)

  //3. In Scala, case class is typically used for modelling immutable data because it automatically generates useful methods like toString, equals, hashCode, and copy, making your code shorter and more readable. It also supports pattern matching, which is useful when working with collections or algebraic data types. In contrast, a regular class requires you to write more boilerplate code and is better suited for scenarios where you need mutable state or more complex behaviour. In general, use case class for simple data structures and class for logic-heavy or mutable components.

}
