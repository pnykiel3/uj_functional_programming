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

  @cask.get("/")
  def hello(): String = {
    println(s"Server is running at: http://localhost:8080/")
    "Cask application is ready. Use POST routes."
  }

  initialize()
}