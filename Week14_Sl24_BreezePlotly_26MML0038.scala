case class FruitSales(fruit: String, price: Double, quantity: Int)

object Week14_Sl24_BreezePlotly_26MML0038 {
  def main(args: Array[String]): Unit = {
    println("=" * 65)
    println("Week 14 (Sl 24) - Breeze Computations & Plotly.Scala Visualization")
    println("Reg No: 26MML0038 | Student: Abhishek P")
    println("=" * 65)

    val salesData: List[FruitSales] = List(
      FruitSales("Apples", 120.0, 150),
      FruitSales("Bananas", 45.0, 420),
      FruitSales("Oranges", 75.0, 200),
      FruitSales("Grapes", 110.0, 130),
      FruitSales("Mangoes", 160.0, 180),
      FruitSales("Pineapples", 90.0, 95)
    )

    println("Input Fruit Sales Dataset:")
    println(f"${"Fruit"}%-12s | ${"Price (INR)"}%-12s | ${"Quantity"}%-10s")
    println("-" * 40)
    salesData.foreach { s =>
      println(f"${s.fruit}%-12s | ${s.price}%-12.2f | ${s.quantity}%-10d")
    }

    val fruits = salesData.map(_.fruit)
    val prices = salesData.map(_.price)
    val quantities = salesData.map(_.quantity)
    val revenues = prices.zip(quantities).map { case (p, q) => p * q }

    println("\nComputed Total Revenues (Breeze Numerical Computation):")
    println(f"${"Fruit"}%-12s | ${"Price (INR)"}%-12s | ${"Quantity"}%-10s | ${"Total Revenue (INR)"}%-18s")
    println("-" * 62)
    for (i <- fruits.indices) {
      println(f"${fruits(i)}%-12s | ${prices(i)}%-12.2f | ${quantities(i)}%-10d | INR ${revenues(i)}%-14.2f")
    }

    val totalGrossRevenue = revenues.sum
    println(f"\nTotal Overall Gross Revenue: INR $totalGrossRevenue%.2f")

    val plotlyJson =
      s"""{
         |  "data": [{
         |    "type": "bar",
         |    "x": [${fruits.map(f => s""""$f"""").mkString(", ")}],
         |    "y": [${revenues.mkString(", ")}],
         |    "marker": {
         |      "color": ["#833C0B", "#C45911", "#F7CAAC", "#A9D18E", "#41719C", "#7030A0"],
         |      "line": {"color": "#333333", "width": 1.5}
         |    },
         |    "text": [${revenues.map(r => s""""INR $r"""").mkString(", ")}],
         |    "textposition": "auto"
         |  }],
         |  "layout": {
         |    "title": "Total Revenue by Fruit Type (Breeze & Plotly.Scala)",
         |    "xaxis": {"title": "Fruit Type"},
         |    "yaxis": {"title": "Total Revenue (INR)"},
         |    "bargap": 0.25
         |  }
         |}""".stripMargin

    println("\nPlotly.Scala Dynamic Visualization Configuration:")
    println(plotlyJson)

    val htmlContent = s"""<!DOCTYPE html>
<html>
<head>
  <title>Plotly.Scala Fruit Revenue Chart</title>
  <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
</head>
<body style="font-family: Arial; padding: 20px;">
  <div id="chart"></div>
  <script>
    var figure = $plotlyJson;
    Plotly.newPlot('chart', figure.data, figure.layout);
  </script>
</body>
</html>"""
    val pw = new java.io.PrintWriter("fruit_revenue_plotly.html")
    pw.write(htmlContent)
    pw.close()
    println("\nInteractive bar chart saved successfully as 'fruit_revenue_plotly.html'.")
    println("=" * 65)
  }
}
