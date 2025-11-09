object Main extends cask.MainRoutes {

  override def host: String = "0.0.0.0"
  override def port: Int = 8080

  def InsertAt[A](list: List[A], index: Int, element: A): Option[List[A]] = {
    if (index < 0 || index > list.length) {
      None
    } else {
      val (front, back) = list.splitAt(index)
      Some(front ::: (element :: back))
    }
  }

  @cask.postJson("/insertAt")
  def appendNewEndpoint(list: List[Int], index: Int, element: Int): cask.Response[ujson.Value] = {
    val result = InsertAt(list, index, element)
    result match {
      case Some(newList) =>
        val arr = ujson.Arr(newList.map(n => ujson.Num(n)): _*)
        cask.Response(arr, statusCode = 200)
      case None =>
        cask.Response(ujson.Obj("error" -> s"Index $index is invalid. List length is ${list.length}"), statusCode = 400)
    }
  }

  def variance (list: List[Double]) : Option[Double] = {
    if (list.isEmpty || list.length < 2) {
      None
    } else {
      val mean = list.sum / list.length
      val sumOfSquares = list.map(x => math.pow(x - mean, 2))
      Some(sumOfSquares.sum / (list.length - 1))
    }
  }

  @cask.postJson("/variance")
  def varianceEndpoint(list: List[Double]): cask.Response[ujson.Value] = {
    val result = variance(list)
    result match {
      case Some(newValue) =>
        cask.Response(ujson.Num(newValue), statusCode = 200)
      case None =>
        cask.Response(ujson.Obj("error" -> s"Incorrect input list for variance calculation."), statusCode = 400)
    }
  }

  @cask.get("/")
  def hello(): String = {
    println(s"Server is running at: http://localhost:8080/")
    "Cask application is ready. Use POST routes."
  }

  initialize()
}