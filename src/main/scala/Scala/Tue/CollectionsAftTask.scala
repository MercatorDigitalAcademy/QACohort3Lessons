package Scala.Tue

object
CollectionsAftTask extends App {
  // MVP
  // 1. Seq of forenames:
  val taxpayerForenames: Seq[String] = Seq("April", "Chay", "April", "Andy", "Anjali")

  // 2. Print full list:
  println(s"Full list of taxpayer submissions: $taxpayerForenames")

  // 3. Count submissions by April:
  def nameCount(inputName: String): Int = taxpayerForenames.count(name => name == inputName)

  // 4. Print the amount of times a specific person submitted:
  println("April submitted " + nameCount("April") + " times.")

  // 5. Convert to Set to remove duplicates:
  val uniqueTaxpayers: Set[String] = taxpayerForenames.toSet

  // 6. Unique list:
  println(s"Unique taxpayers: $uniqueTaxpayers")

  // 7. Refactor counting method to count for any inputted collection:
  def nameCountRefactor(x: String, forenames: Iterable[String]): Int = forenames.count(name => name == x)

  // 8. Print the count submissions by April in the Seq and Set:
  println("I'm counting 'April' in the Seq: " + nameCountRefactor("April", taxpayerForenames))
  println("I'm counting 'April' in the Set: " + nameCountRefactor("April", uniqueTaxpayers))

  //9a.Write a Map[String, Int] to represent the number of failed attempts for each user.
  val failedLogins: Map[String, Int] = Map(
    "april" -> 2,
    "anjali" -> 1,
    "chay" -> 0,
    "andy" -> 4,
    "paige" -> 1,
    "joe" -> 2
  )
  //9b. Print the number of failed attempts for the user at index position 0.
  val firstUserFailedAttempts: Int = failedLogins.toSeq.head._2 //if i didn't convert to a Seq the Map would be unordered and index(0) would change.
  println(firstUserFailedAttempts)
  //9c.
  val updatedUser: Map[String, Int] = failedLogins + ("sue" -> 3)
  println(updatedUser)
  // 9d. Update the user at index position 1 to have a further failed attempt.
  val userAtIndex1: String = failedLogins.toSeq(1)._1
  val updatedLogins: Map[String, Int] = failedLogins.updated(userAtIndex1, failedLogins(userAtIndex1) + 1)
  println(updatedLogins)
  //9e. Remove the user at index position 5.
  val userAtIndex5: String = failedLogins.toSeq(5)._1
  val removeIndex5: Map[String, Int] = failedLogins - userAtIndex5
  println(removeIndex5)


  //Extension
  // 1. 2 Sets:
  val day1Submissions: Set[String] = Set("Chay", "Andy", "Anjali")
  val day2Submissions: Set[String] = Set("April", "Chay", "Andy")
  // a. Who submitted on both days
  val bothDays = day1Submissions intersect day2Submissions
  println(s"Submitted on both days: $bothDays")
  // b. Who submitted only on the first day
  val onlyDay1 = day1Submissions diff day2Submissions
  println(s"Only submitted on Day 1: $onlyDay1")
  val onlyDay2 = day2Submissions diff day1Submissions //extra: second day only. Notice the only change is the order.
  println(s"Only submitted on Day 2: $onlyDay2")
  // c. A combined list of all unique submitters
  val allSubmitters = day1Submissions union day2Submissions
  println(s"All unique submitters: $allSubmitters")

  //Research:
  /** Research task 1:
   * Understanding Set vs Seq is important for testers because the choice affects how tests behave. For example, if a test is checking a list of results where order matters, Seq is the right choice. But if the goal is just to verify uniqueness or membership, a Set is safer and clearer. Using the wrong type can lead to false negatives in tests (e.g., failing because order changed but data is correct). It also helps when setting up test data — avoiding duplicates can prevent subtle bugs. Knowing this lets testers write better, more reliable tests and understand developer intentions more clearly.
   */

  //2a/b.i. Map.get - returns an option, you either get it (Some) or you don't (None). This makes it safe to use when a key might not exist.
  println(failedLogins.get("andy")) //returns the value of the inputted key wrapped in a `Some`
  println(failedLogins.get("sarah")) //not in the list so returns a None
  //2a/b.ii. Map(key) - returns the value directly for the inputted key. Will throw an exception if it isn't there (not as safe).
  println(failedLogins("andy")) //returns the value of the inputted key
  //  println(failedLogins("sarah")) //throws an exception and cannot continue code execution
  //2a/b.iii. Map.getOrElse(key, default) - this means if the key isn't there it will return the default value that is given.
  println(failedLogins.getOrElse("andy", 0))
  println(failedLogins.getOrElse("sarah", 0))

  //2c. In testing, when might it be dangerous to use Map(key) directly?
  /** Using Map(key) is dangerous to use in test as a missing key will cause your code to throw a NoSuchElementException, which could:
   * 1. Crash your test suite
   * 2. Mask other issues by stopping execution
   * 3. Create flaky tests that only fail in some environments
   * Always best to use getOrElse
   */

}


