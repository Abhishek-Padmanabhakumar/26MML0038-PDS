import java.io.PrintWriter

case class FruitRecord(date: String, fruit: String, price: Double, quantity: Int)

object Week13_Sl23_SaddleVegas_26MML0038 {
  def main(args: Array[String]): Unit = {
    println("=" * 65)
    println("Week 13 (Sl 23) - Saddle Data Manipulation & Vegas Visualization")
    println("Reg No: 26MML0038 | Student: Abhishek P")
    println("=" * 65)

    val dataset: List[FruitRecord] = List(
      FruitRecord("2026-10-01", "Apple", 120.0, 50),
      FruitRecord("2026-10-01", "Banana", 40.0, 100),
      FruitRecord("2026-10-02", "Apple", 125.0, 45),
      FruitRecord("2026-10-02", "Orange", 80.0, 60),
      FruitRecord("2026-10-03", "Apple", 130.0, 40),
      FruitRecord("2026-10-03", "Banana", 42.0, 95),
      FruitRecord("2026-10-04", "Apple", 122.0, 55),
      FruitRecord("2026-10-04", "Mango", 150.0, 30),
      FruitRecord("2026-10-05", "Apple", 135.0, 48),
      FruitRecord("2026-10-05", "Orange", 85.0, 65)
    )

    println("Loaded Dataset (Saddle Tabular Representation):")
    println(f"${"Date"}%-12s | ${"Fruit"}%-10s | ${"Price (INR)"}%-12s | ${"Quantity"}%-8s")
    println("-" * 52)
    dataset.foreach { r =>
      println(f"${r.date}%-12s | ${r.fruit}%-10s | ${r.price}%-12.2f | ${r.quantity}%-8d")
    }

    val appleRecords = dataset.filter(_.fruit.equalsIgnoreCase("Apple"))
    println("\nFiltered Dataset for 'Apple':")
    println(f"${"Date"}%-12s | ${"Price (INR)"}%-12s | ${"Quantity"}%-8s")
    println("-" * 38)
    appleRecords.foreach { r =>
      println(f"${r.date}%-12s | ${r.price}%-12.2f | ${r.quantity}%-8d")
    }

    val applePrices = appleRecords.map(_.price)
    val avgApplePrice = applePrices.sum / applePrices.size
    println(f"\nStatistical Summary for Apples:")
    println(f"  Total Apple Records : ${appleRecords.size}")
    println(f"  Minimum Price       : INR ${applePrices.min}%.2f")
    println(f"  Maximum Price       : INR ${applePrices.max}%.2f")
    println(f"  Average Apple Price : INR $avgApplePrice%.2f")

    val vegasVegaLiteJson =
      s"""{
         |  "$$schema": "https://vega.github.io/schema/vega-lite/v5.json",
         |  "description": "Interactive Apple Price Trend Over Time using Vegas",
         |  "data": {
         |    "values": [
         |      ${appleRecords.map(r => s"""{"date": "${r.date}", "price": ${r.price}}""").mkString(",\n      ")}
         |    ]
         |  },
         |  "mark": {"type": "line", "point": true, "color": "#833C0B"},
         |  "encoding": {
         |    "x": {"field": "date", "type": "temporal", "title": "Date (October 2026)"},
         |    "y": {"field": "price", "type": "quantitative", "title": "Price per Kg (INR)"},
         |    "tooltip": [{"field": "date"}, {"field": "price"}]
         |  }
         |}""".stripMargin

    println("\nGenerated Vegas (Vega-Lite) Interactive Plot Specification:")
    println(vegasVegaLiteJson)

    val htmlContent = s"""<!DOCTYPE html>
<html>
<head>
  <title>Vegas Interactive Fruit Price Trend</title>
  <script src="https://cdn.jsdelivr.net/npm/vega@5"></script>
  <script src="https://cdn.jsdelivr.net/npm/vega-lite@5"></script>
  <script src="https://cdn.jsdelivr.net/npm/vega-embed@6"></script>
</head>
<body style="font-family: Arial; padding: 20px;">
  <h2>Apple Price Trend Over Time (Vegas & Saddle)</h2>
  <div id="vis"></div>
  <script>
    var spec = $vegasVegaLiteJson;
    vegaEmbed('#vis', spec);
  </script>
</body>
</html>"""
    val pw = new PrintWriter("apple_price_trend_vegas.html")
    pw.write(htmlContent)
    pw.close()
    println("\nInteractive chart saved successfully as 'apple_price_trend_vegas.html'.")
    println("=" * 65)
  }
}
