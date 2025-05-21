
object WedHandlingMultipleOptions extends App {

  val weather:String = "rainy"

  //IF/ELSE
  if (weather == "rainy") {
    println("Take a coat with a hood")
  } else if (weather == "sunny") { //you can have as many else/if as you need
    println("Wear sun cream")
  } else if (weather == "cold") {
    println("Wear a warm coat")
  } else { //catch for anything not defined in the else/if
    println("Not a valid weather option")
  }

  //PATTERN MATCH
  weather match {
    case "rainy" => println("Take a coat with a hood")
    case "sunny" => println("Wear sun cream")
    case "cold" => println("Wear a warm coat")
    case _ => println("Not a valid weather option")
  }

  val season: String = "winter"
  //How we approach this when we have multiple options:
  if (weather == "cold" || season == "winter") {
    println("Take a coat")
  } else {
    println("A light jacket fine")
  }

  (weather, season) match {
    case (weather, season) if weather == "cold" || season == "winter" => println("Take a coat")
    case _ => println("A light jacket fine")
  }

  // INT - slightly more careful
  val age: Int = 0

  if (age < 0){
    println("Enter a positive number")
  } else if (age >= 18){
    println(s"You are an adult because you are $age")
  } else {
    println(s"You are a child because you are $age")
  }

  age match {
    case age if age <0 => println("Enter a positive number")
    case age if age < 18 => println(s"You are a child because you are $age")
    case age if age >= 18 => println(s"You are an adult because you are $age")
  }

  //TASK 1
  val studentGrade: Int = -59

  if (studentGrade >= 90 && studentGrade <= 100) {
    println("A! Well done!")
  } else if (studentGrade >= 80 && studentGrade <= 89) {
    println("B")
  } else if (studentGrade >= 70 && studentGrade <= 79) {
    println("C")
  } else if (studentGrade >= 60 && studentGrade <= 69) {
    println("D")
  } else if (studentGrade >= 50 && studentGrade <= 59) {
    println("E")
  } else if (studentGrade >= 40 && studentGrade <= 49) {
    println("F")
  } else if (studentGrade >= 0 && studentGrade <= 39) {
    println(s"$studentGrade is a U grade")
  } else {
    println(s"$studentGrade is not valid")
  }

  studentGrade match {
    case grade if grade >= 90 && grade <= 100 => println("A! Well done!")
    case grade if grade >= 80 && grade <= 89 => println("B")
    case grade if grade >= 70 && grade <= 79 => println("C")
    case grade if grade >= 60 && grade <= 69 => println("D")
    case grade if grade >= 50 && grade <= 59 => println("E")
    case grade if grade >= 40 && grade <= 49 => println("F")
    case grade if grade >= 0 && grade <= 39 => println(s"$grade is a U grade")
    case grade => println(s"$grade is not valid")
  }

  //TASK 2
  val givenAge: Int = 3

  if (givenAge >= 18) {
    println("Films ratings: U, PG, 12A, 15 or 18")
  } else if (givenAge >= 15) {
    println("Films ratings: U, PG, 12A or 15")
  } else if (givenAge >= 12) {
    println("Films ratings: U, PG or 12A")
  } else if (givenAge >= 8) {
    println("Films ratings: U or PG")
  } else if (givenAge >= 4) {
    println("Films ratings: U only")
  } else {
    println(s"$givenAge is too young to attend the cinema")
  }
  // this will only work in this order. If we swap the order it will catch the first one it satisfies.
  // Swap the 18 and 15 round and set age to 19. Show it'll hit the first one despite being more that 18.

  givenAge match {
    case age if age >= 18 => println("Films ratings: U, PG, 12A, 15 or 18")
    case age if age >= 15 => println("Films ratings: U, PG, 12A or 15")
    case age if age >= 12 => println("Films ratings: U, PG or 12A")
    case age if age >= 8 => println("Films ratings: U or PG")
    case age if age >= 4 => println("Films ratings: U only")
    case age => println(s"$age is too young to attend the cinema")
  }

  //OPTIONS (getOrElse)
  val name: Option[String] = Some("April")
  val emptyName: Option[String] = None
  println(name)
  println(emptyName)

  //getOrElse is used when we want to return a default value if the None is returned.
  //It will also take the Some away, leaving us with just the internals.
  def getName(name: Option[String]): String = name.getOrElse("This user has left the field empty")
  println(getName(name)) //Some("April)
  println(getName(emptyName)) //None

  //TASK FROM PPT
  class ChocolateBar(val filling: Option[String])

  val plainChocolate: ChocolateBar = new ChocolateBar(None)
  val caramelChocolate: ChocolateBar = new ChocolateBar(Some("Caramel"))

  def getFilling(chocolateBar: ChocolateBar): String =
    chocolateBar.filling.getOrElse("Just chocolate")

  println(getFilling(plainChocolate))
  println(getFilling(caramelChocolate))

  //TRY/CATCH

  try {
    //ALL LOGIC - If/else, pattern match, def, val
    val number = "one".toInt //I want to change the input to a Int from a String
    println(s"The number is $number")
  } catch {
    case error: NumberFormatException => println(s"$error was not a valid input") //often see error as 'e'
  }

  //EXTRA
  //Combine if/else with try/catch

  val salaryInput: String = "notANumber" // Try changing to "45000"

  try {
    val salary = salaryInput.toInt

    if (salary < 12570) {
      println("You pay no income tax.")
    } else if (salary <= 50270) {
      println("You pay 20% tax.")
    } else {
      println("You pay 40% or more tax.")
    }
  } catch {
    case _: NumberFormatException =>
      println(s"Invalid salary input: '$salaryInput'. Please enter a number.")
  }


}
