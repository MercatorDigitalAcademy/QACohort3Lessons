import WedHandlingMultipleOptions.age

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







}
