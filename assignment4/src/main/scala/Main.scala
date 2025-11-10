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

  def listConcat[A](list0: Option[List[A]], list1: Option[List[A]]): Option[List[A]] = {
    (list0, list1) match {
      case (Some(l0), Some(l1)) => Some(l0 ::: l1)
      case _ => None
    }
  }

  @cask.postJson("/listConcat")
  def listConcatEndpoint(list0: List[Int] = null, list1: List[Int] = null): cask.Response[ujson.Value] = {
    val result = listConcat(Option(list0), Option(list1))
    result match {
      case Some(newList) =>
        val arr = ujson.Arr(newList.map(n => ujson.Num(n)): _*)
        cask.Response(arr, statusCode = 200)
      case None =>
        cask.Response(ujson.Obj("error" -> "Incorrect input. Please provide two valid lists."), statusCode = 400)
    }
  }

  def mojeMap[A,B,C](a: Option[A], b: Option[B])(f:(A,B)=>C):Option[C] = {
    a.flatMap(newA => b.map(newB => f(newA, newB)))
  }

  @cask.postJson("/mojeMap")
  def mojeMapEndpoint(a: Int, b: Int): cask.Response[ujson.Value] = {
    val result = mojeMap(Some(a), Some(b))((x: Int, y: Int) => x + y)
    result match {
      case Some(newValue) =>
        cask.Response(ujson.Num(newValue), statusCode = 200)
      case None =>
        cask.Response(ujson.Obj("error" -> "Incorrect input. Please provide two valid integers."), statusCode = 400)
    }
  }

  def mean(list: List[Double]): Either[String, Double] = {
    list.isEmpty match {
      case true => Left("Please provide a non-empty list.")
      case false => Right( list.sum / list.length)
    }
  }

  @cask.postJson("/mean")
  def meanEndpoint(list: List[Double]): cask.Response[ujson.Value] = {
    val result = mean(list)
    result match {
      case Left(err) =>
        cask.Response(ujson.Obj("error" -> "Please provide a non-empty list."), statusCode = 400)
      case Right(newValue) =>
        cask.Response(ujson.Num(newValue), statusCode = 200)
    }
  }

  @cask.get("/")
  def hello(): String = {
    println(s"Server is running at: http://localhost:8080/")
    "Cask application is ready. Use POST routes."
  }

  initialize()
}