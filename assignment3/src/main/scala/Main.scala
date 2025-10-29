import cask.model.Response


object Main extends cask.MainRoutes {

  override def host: String = "0.0.0.0"
  override def port: Int = 8080

  private def tail[A](list: List[A]): List[A] = {
    list match {
      case Nil => throw new NoSuchElementException("tail of empty list")
      case _ :: tail => tail
      case 0 => list.tail()
    }
  }

  private def drop[A](lis)

  @cask.post("/tail")
  def isSortedEndpoint(request: cask.Request): Response[ujson.Value] = {
    try {
      val data = ujson.read(request.text())
      val list = data("list").arr.toList.map(_.num.toInt)
      val result = tail(list)
      cask.Response(ujson.Obj("tail result: " -> result), statusCode = 200)
    } catch {
      case e: Exception => cask.Response(ujson.Obj("error" -> e.getMessage), statusCode = 400)
    }
  }


  @cask.get("/")
  def hello(): String = "Aplikacja Cask gotowa. Użyj tras POST."
  println(s"Serwer działa pod adresem: http://localhost:8080/")
  initialize()

}