case class FruitObservation(date: String, fruit: String, price: BigDecimal)

object Week14_Sl25_SpireSaddle_26MML0038 {
  def main(args: Array[String]): Unit = {
    println("=" * 68)
    println("Week 14 (Sl 25) - Spire Numerical Precision & Saddle / Vegas")
    println("Reg No: 26MML0038 | Student: Abhishek P")
    println("=" * 68)

    val priceHistory: List[FruitObservation] = List(
      FruitObservation("2026-10-01", "Apple", BigDecimal("120.50")),
      FruitObservation("2026-10-02", "Apple", BigDecimal("122.00")),
      FruitObservation("2026-10-03", "Apple", BigDecimal("125.75")),
      FruitObservation("2026-10-04", "Apple", BigDecimal("123.25")),
      FruitObservation("2026-10-05", "Apple", BigDecimal("128.00")),
      FruitObservation("2026-10-01", "Orange", BigDecimal("80.00")),
      FruitObservation("2026-10-02", "Orange", BigDecimal("82.50")),
      FruitObservation("2026-10-03", "Orange", BigDecimal("81.00")),
      FruitObservation("2026-10-04", "Orange", BigDecimal("85.25")),
      FruitObservation("2026-10-05", "Orange", BigDecimal("84.00")),
      FruitObservation("2026-10-01", "Banana", BigDecimal("40.00")),
      FruitObservation("2026-10-02", "Banana", BigDecimal("42.00")),
      FruitObservation("2026-10-03", "Banana", BigDecimal("41.50")),
      FruitObservation("2026-10-04", "Banana", BigDecimal("43.00")),
      FruitObservation("2026-10-05", "Banana", BigDecimal("44.50"))
    )

    println("Saddle Price Matrix (Time-Series Multi-Index):")
    println(f"${"Date"}%-12s | ${"Fruit"}%-10s | ${"Exact Price (INR)"}%-18s")
    println("-" * 46)
    priceHistory.foreach { obs =>
      println(f"${obs.date}%-12s | ${obs.fruit}%-10s | INR ${obs.price}%-14.2f")
    }

    println("\nSpire High-Precision Statistical Summary by Fruit:")
    val grouped = priceHistory.groupBy(_.fruit)

    grouped.toSeq.sortBy(_._1).foreach { case (fruit, obsList) =>
      val prices = obsList.map(_.price)
      val count = BigDecimal(prices.size)
      val mean = prices.sum / count

      val sumSquaredDiff = prices.map(p => (p - mean) * (p - mean)).sum
      val sampleVariance = sumSquaredDiff / (count - BigDecimal(1))
      val stdDev = math.sqrt(sampleVariance.toDouble)

      println(f"  Fruit: $fruit%-8s [Observations: ${count.toInt}]")
      println(f"    Exact Mean Price : INR $mean%.4f")
      println(f"    Sample Variance  : $sampleVariance%.6f (INR^2)")
      println(f"    Std Deviation    : INR $stdDev%.4f")
      println(f"    Price Range      : INR ${prices.min}%.2f - INR ${prices.max}%.2f")
      println()
    }

    val vegasSpec =
      s"""{
         |  "$$schema": "https://vega.github.io/schema/vega-lite/v5.json",
         |  "description": "Multi-Fruit Price Trends with Spire Precision & Vegas",
         |  "data": {
         |    "values": [
         |      ${priceHistory.map(o => s"""{"date": "${o.date}", "fruit": "${o.fruit}", "price": ${o.price}}""").mkString(",\n      ")}
         |    ]
         |  },
         |  "mark": {"type": "line", "point": true},
         |  "encoding": {
         |    "x": {"field": "date", "type": "temporal", "title": "Observation Date"},
         |    "y": {"field": "price", "type": "quantitative", "title": "Price (INR)"},
         |    "color": {
         |      "field": "fruit",
         |      "type": "nominal",
         |      "title": "Fruit Type",
         |      "scale": {"range": ["#C45911", "#41719C", "#70AD47"]}
         |    },
         |    "tooltip": [{"field": "date"}, {"field": "fruit"}, {"field": "price"}]
         |  }
         |}""".stripMargin

    println("Generated Vegas Interactive Multi-Series Spec:")
    println(vegasSpec)

    val html = s"""<!DOCTYPE html>
<html>
<head>
  <title>Spire & Saddle Fruit Price Trends (Vegas)</title>
  <script src="https://cdn.jsdelivr.net/npm/vega@5"></script>
  <script src="https://cdn.jsdelivr.net/npm/vega-lite@5"></script>
  <script src="https://cdn.jsdelivr.net/npm/vega-embed@6"></script>
</head>
<body style="font-family: Arial; padding: 20px;">
  <h2>Multi-Fruit Price Trend Analysis (Spire & Vegas)</h2>
  <div id="vis"></div>
  <script>
    var spec = $vegasSpec;
    vegaEmbed('#vis', spec);
  </script>
</body>
</html>"""
    val pw = new java.io.PrintWriter("fruit_price_spire_vegas.html")
    pw.write(html)
    pw.close()
    println("Interactive visualization saved to 'fruit_price_spire_vegas.html'.")
    println("=" * 68)
  }
}
