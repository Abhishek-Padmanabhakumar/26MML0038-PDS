import scala.collection.mutable

object Week11_Sl20_HashMaps_26MML0038 {
  def mergeHashMapsHigherGrade(map1: Map[String, Int], map2: Map[String, Int]): Map[String, Int] = {
    val allKeys = map1.keySet ++ map2.keySet
    allKeys.map { key =>
      val grade1 = map1.get(key)
      val grade2 = map2.get(key)
      val finalGrade = (grade1, grade2) match {
        case (Some(g1), Some(g2)) => math.max(g1, g2)
        case (Some(g1), None)     => g1
        case (None, Some(g2))     => g2
        case _                    => 0
      }
      key -> finalGrade
    }.toMap
  }

  def insertWithChaining(entries: List[(String, Int)]): Map[String, List[Int]] = {
    val chainedMap = mutable.Map[String, List[Int]]()
    for ((name, grade) <- entries) {
      if (chainedMap.contains(name)) {
        chainedMap(name) = chainedMap(name) :+ grade
      } else {
        chainedMap(name) = List(grade)
      }
    }
    chainedMap.toMap
  }

  def main(args: Array[String]): Unit = {
    println("=" * 60)
    println("Week 11 - HashMaps & Collision Handling (Reg No: 26MML0038)")
    println("=" * 60)

    var studentGrades = Map[String, Int](
      "Abhishek" -> 85,
      "Priya"    -> 92,
      "Rahul"    -> 78,
      "Sneha"    -> 88
    )
    println("Initial Student Grades Map:")
    studentGrades.foreach { case (k, v) => println(s"  $k -> $v") }

    println("\nInserting duplicate key 'Abhishek' with updated grade 95:")
    studentGrades = studentGrades + ("Abhishek" -> 95)
    println("Map after standard update (overwrites previous value):")
    studentGrades.foreach { case (k, v) => println(s"  $k -> $v") }

    val exam1Grades = Map("Abhishek" -> 88, "Priya" -> 92, "Karan" -> 75, "Rohan" -> 82)
    val exam2Grades = Map("Abhishek" -> 96, "Priya" -> 90, "Karan" -> 85, "Ananya" -> 91)

    println("\nExam 1 Grades: " + exam1Grades)
    println("Exam 2 Grades: " + exam2Grades)

    val mergedGrades = mergeHashMapsHigherGrade(exam1Grades, exam2Grades)
    println("\nMerged HashMap (Resolving conflicts by taking Higher Grade):")
    mergedGrades.toSeq.sortBy(_._1).foreach { case (k, v) =>
      println(f"  $k%-10s -> Final Grade: $v")
    }

    val rawEntries = List(
      ("Abhishek", 88),
      ("Priya", 92),
      ("Abhishek", 96),
      ("Rahul", 78),
      ("Abhishek", 91),
      ("Priya", 95),
      ("Sneha", 84)
    )
    println("\nRaw Entry Stream with Collisions: " + rawEntries)
    val chainedResults = insertWithChaining(rawEntries)
    println("\nHashMap with Collision Chaining (List of values per key):")
    chainedResults.toSeq.sortBy(_._1).foreach { case (name, grades) =>
      println(f"  $name%-10s -> All Recorded Grades: ${grades.mkString("[", ", ", "]")}")
    }
    println("=" * 60)
  }
}
