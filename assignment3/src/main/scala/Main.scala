import cask.model.Response


object Main extends cask.MainRoutes {

  override def host: String = "0.0.0.0"
  override def port: Int = 8080

  private def tail[A](list: List[A]): List[A] = {
    list match {
      case Nil => throw new NoSuchElementException("Your list is empty!")
      case _ :: tail => tail
    }
  }

  def drop[A](list: DoubleLinkedList[A], n: Int): DoubleLinkedList[A] = {
    if (n < 0) throw new IllegalArgumentException("n must be non-negative")
    if (n > list.getSize) throw new IllegalArgumentException("n is larger than the list size")
    var i = 0

    while (i < n && !list.isEmpty) {
      list.pop_back()
      i += 1
    }
    list
  }

  @cask.post("/tail")
  def tailEndpoint(request: cask.Request): Response[ujson.Value] = {
    try {
      val data = ujson.read(request.text())
      val list = data("list").arr.toList.map(_.num.toInt)
      val result = tail(list)
      cask.Response(ujson.Obj("tail result: " -> result), statusCode = 200)
    } catch {
      case e: Exception => cask.Response(ujson.Obj("error" -> e.getMessage), statusCode = 400)
    }
  }

  @cask.post("/drop")
  def dropEndpoint(request: cask.Request): Response[ujson.Value] = {
    try {
      val data = ujson.read(request.text())
      val listData = data("list").arr.toList.map(_.num.toInt)
      val n = data("n").num.toInt
      val list = new DoubleLinkedList[Int](listData)
      drop(list, n)

      val resultList = list.toList
      cask.Response(
      ujson.Obj("drop result" -> ujson.Arr(resultList.map(x => ujson.Num(x.toDouble)): _*)),
      statusCode = 200)
    }
    catch {
    case e: Exception => 
      cask.Response(ujson.Obj("error" -> e.getMessage), statusCode = 400)
    }
  }

  @cask.get("/")
  def hello(): String = {
    println(s"Server is running at: http://localhost:8080/")
    "Cask application is ready. Use POST routes."
  }

  initialize()
}