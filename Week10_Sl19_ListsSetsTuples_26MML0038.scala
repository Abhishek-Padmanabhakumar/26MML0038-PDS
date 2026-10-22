object Week10_Sl19_ListsSetsTuples_26MML0038 {
  def squareList(primes: List[Int]): List[Int] = {
    primes.map(x => x * x)
  }

  def intersectSets(setA: Set[Char], setB: Set[Char]): Set[Char] = {
    setA.intersect(setB)
  }

  def main(args: Array[String]): Unit = {
    println("=" * 60)
    println("Week 10 - Lists, Sets, and Tuples in Scala (Reg No: 26MML0038)")
    println("=" * 60)

    val primeList: List[Int] = List(2, 3, 5, 7, 11)
    println(s"List of first 5 prime numbers: $primeList")

    val squaredPrimes: List[Int] = squareList(primeList)
    println(s"Squared prime numbers list: $squaredPrimes")

    val str1: String = "hello world"
    val charSet1: Set[Char] = str1.toSet
    println(s"\nSet of unique characters from '$str1': $charSet1")

    val str2: String = "world wide web"
    val charSet2: Set[Char] = str2.toSet
    println(s"Set of unique characters from '$str2': $charSet2")

    val intersectionSet: Set[Char] = intersectSets(charSet1, charSet2)
    println(s"Intersection of both character sets: $intersectionSet")

    val sampleTuple: (Int, String, Boolean) = (26, "Scala Programming", true)
    println(s"\nTuple: $sampleTuple")
    println(s"First element (Integer): ${sampleTuple._1}")
    println(s"Second element (String): ${sampleTuple._2}")
    println(s"Third element (Boolean): ${sampleTuple._3}")
    println("=" * 60)
  }
}
