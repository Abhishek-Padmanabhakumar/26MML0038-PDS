case class Person(name: String, age: Int, city: String)

object Week13_Sl22_CaseClasses_26MML0038 {
  def filterOlderThan30(people: List[Person]): List[Person] = {
    people.filter(_.age <= 30)
  }

  def groupByCity(people: List[Person]): Map[String, List[Person]] = {
    people.groupBy(_.city)
  }

  def formatPerson(person: Person): String = {
    s"${person.name} is ${person.age} years old and lives in ${person.city}"
  }

  def sortByAgeAscending(people: List[Person]): List[Person] = {
    people.sortBy(_.age)
  }

  def main(args: Array[String]): Unit = {
    println("=" * 60)
    println("Week 13 - Case Classes in Scala (Reg No: 26MML0038)")
    println("=" * 60)

    val people: List[Person] = List(
      Person("Abhishek", 24, "Vellore"),
      Person("Priya", 32, "Bangalore"),
      Person("Rahul", 28, "Chennai"),
      Person("Sneha", 35, "Bangalore"),
      Person("Karan", 22, "Vellore")
    )

    println("Original List of People:")
    people.foreach(p => println(s"  $p"))

    val youngPeople = filterOlderThan30(people)
    println("\nFiltered List (Age <= 30, older than 30 filtered out):")
    youngPeople.foreach(p => println(s"  ${p.name} (Age: ${p.age})"))

    val peopleByCity = groupByCity(people)
    println("\nGrouped by City:")
    peopleByCity.foreach { case (city, group) =>
      val names = group.map(_.name).mkString(", ")
      println(s"  $city -> [$names]")
    }

    println("\nFormatted Person Descriptions:")
    val descriptions = people.map(formatPerson)
    descriptions.foreach(d => println(s"  $d"))

    val sortedByAge = sortByAgeAscending(people)
    println("\nSorted by Age (Ascending):")
    sortedByAge.foreach(p => println(f"  ${p.name}%-10s : ${p.age} years old (${p.city})"))
    println("=" * 60)
  }
}
