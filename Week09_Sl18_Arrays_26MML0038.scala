object Week09_Arrays_26MML0038 {
  def sumArray(arr: Array[Int]): Int = {
    var sum = 0
    for (elem <- arr) { sum += elem }
    sum
  }

  def concatenateFruits(fruits: Array[String]): String = {
    fruits.mkString(", ")
  }

  def main(args: Array[String]): Unit = {
    println("=" * 60)
    println("Week 9 - Arrays in Scala (Reg No: 26MML0038)")
    println("=" * 60)

    val intArray: Array[Int] = Array(2, 5, 9, 14, 20)
    println("Integer Array: " + intArray.mkString("[", ", ", "]"))

    val totalSum: Int = sumArray(intArray)
    println(s"Sum of array elements: $totalSum")

    val fruitArray: Array[String] = Array("Apple", "Banana", "Cherry", "Mango", "Orange")
    println("\nFruit Array: " + fruitArray.mkString("[", ", ", "]"))

    val concatenated: String = concatenateFruits(fruitArray)
    println(s"Concatenated Fruit String: $concatenated")

    println("\nIterating over integer array elements:")
    for (i <- intArray.indices) {
      println(s"Element at index $i: ${intArray(i)}")
    }
    println("=" * 60)
  }
}
