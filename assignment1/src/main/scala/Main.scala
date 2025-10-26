import cask.model.Response


object Main extends cask.MainRoutes {

  override def host: String = "0.0.0.0"
  override def port: Int = 8080

  private def isSorted[A](list: List[A], compare: (A, A) => Boolean): Boolean = {
    if (list.length < 2) return true
    val pairs = list.zip(list.tail)
    pairs.forall {
      case (a, b) => compare(a, b)
    } // ostatnie wyrazenie dziala jak return (staje sie wynikem funkcji)
  }

  def sumList(list0: List[Int], list1: List[Int], list2: List[Int]): List[Int] = {
    list0.zip(list1).zip(list2).map {
      case ((a, b), c) => a + b + c
    }
  }

  def setHead[A](list: List[A], element: A): List[A] = {
    element :: list
  }

  def append[A](list: List[A], index: Int, element: A): List[A] = {
    val (front, back) = list.splitAt(index)
    front ::: (element :: back)
  }


  //list1 = (1, 2,3) i list2 = (4,5,6) to outem sa tuple z kwadratami
  def squareList(list0: List[Int], list1: List[Int]): List[(Int, Int)] = {
    val pairs = list0.zip(list1)
    pairs.map { case (a, b) => (a * a, b * b) }
  }

  @cask.post("/is_sorted")
  def isSortedEndpoint(request: cask.Request): Response[ujson.Value] = {
    try {
      val data = ujson.read(request.text())
      val list = data("list").arr.toList.map(_.num.toInt)
      val increasing: (Int, Int) => Boolean = (a, b) => a <= b
      val result = isSorted(list, increasing)
      cask.Response(ujson.Obj("isSorted result: " -> result), statusCode = 200)
    } catch {
      case e: Exception => cask.Response(ujson.Obj("error" -> e.getMessage), statusCode = 400)
    }
  }

  @cask.post("/sum_list")
  def sumListEndpoint(request: cask.Request): Response[ujson.Value] = {
    try {
      val data = ujson.read(request.text())
      val l0 = data("list0").arr.toList.map(_.num.toInt)
      val l1 = data("list1").arr.toList.map(_.num.toInt)
      val l2 = data("list2").arr.toList.map(_.num.toInt)
      val result = sumList(l0, l1, l2)
      val arr = ujson.Arr(result.map(n => ujson.Num(n)): _*)
      cask.Response(arr, statusCode = 200)
    } catch {
      case e: Exception => cask.Response(ujson.Obj("error" -> e.getMessage), statusCode = 400)
    }
  }

  @cask.post("/square_list")
  def squareListEndpoint(request: cask.Request): Response[ujson.Value] = {
    try {
      val data = ujson.read(request.text())
      val l0 = data("list0").arr.toList.map(_.num.toInt)
      val l1 = data("list1").arr.toList.map(_.num.toInt)
      val result = squareList(l0, l1)
      val arr = ujson.Arr(result.map { case (a, b) => ujson.Arr(a, b) }: _*)
      cask.Response(arr, statusCode = 200)
    } catch {
      case e: Exception => cask.Response(ujson.Obj("error" -> e.getMessage), statusCode = 400)
    }
  }

  @cask.post("/set_head")
  def setHeadEndpoint(request: cask.Request): Response[ujson.Value] = {
    try {
      val data = ujson.read(request.text())
      val list = data("list").arr.toList.map(_.num.toInt)
      val element = data("element").num.toInt
      val result = setHead(list, element)
      val arr = ujson.Arr(result.map(n => ujson.Num(n)): _*)
      cask.Response(arr, statusCode = 200)
    } catch {
      case e: Exception => cask.Response(ujson.Obj("error" -> e.getMessage), statusCode = 400)
    }
  }

  @cask.post("/append")
  def appendEndpoint(request: cask.Request): Response[ujson.Value] = {
    try {
      val data = ujson.read(request.text())
      val list = data("list").arr.toList.map(_.num.toInt)
      val index = data("index").num.toInt
      val element = data("element").num.toInt
      val result = append(list, index, element)
      val arr = ujson.Arr(result.map(n => ujson.Num(n)): _*)
      cask.Response(arr, statusCode = 200)
    } catch {
      case e: Exception => cask.Response(ujson.Obj("error" -> e.getMessage), statusCode = 400)
    }
  }

  @cask.get("/")
  def hello(): String = "Aplikacja Cask gotowa. Użyj tras POST."
  println(s"Serwer działa pod adresem: http://localhost:8080/")
  initialize()

}