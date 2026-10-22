object Week12_Sl21_Combinators_26MML0038 {
  def main(args: Array[String]): Unit = {
    println("=" * 60)
    println("Week 12 - Advanced Functional Combinators (Reg No: 26MML0038)")
    println("=" * 60)

    val originalList: List[Int] = (1 to 10).toList
    println(s"Original List (1 to 10): $originalList")

    val evenList: List[Int] = originalList.filter(x => x % 2 == 0)
    println(s"Filtered List (Even numbers only): $evenList")

    val mappedList: List[Int] = originalList.map(x => x * 3)
    println(s"Mapped List (Each element multiplied by 3): $mappedList")

    val flatMappedTuples: List[(Int, Int)] = originalList.flatMap(x => List((x, x * x)))
    println("\nFlatMapped List of Tuples (Element, Element^2):")
    flatMappedTuples.foreach { case (n, sq) =>
      println(f"  Integer: $n%2d  ==>  Square: $sq%3d")
    }

    val productOfAll: Long = originalList.foldLeft(1L)((acc, elem) => acc * elem)
    println(s"\nProduct of all elements (1 to 10) using foldLeft: $productOfAll (10! = 3,628,800)")

    val productOfEvens: Long = evenList.foldLeft(1L)(_ * _)
    println(s"Product of even elements using foldLeft: $productOfEvens")
    println("=" * 60)
  }
}
