object Main extends cask.MainRoutes {

  override def host: String = "0.0.0.0"
  override def port: Int = 8080

  def counter(list: List[Int]): Map[Int, Int] = {
    val groupedList = list.map((_, 1)).groupBy(_._1)
    groupedList.map { 
      case (k, v) => (k, v.map(_._2).sum)
    }
  }

  @cask.postJson("/counter")
  def counterEndpoint(list: List[Int]): cask.Response[ujson.Value] = {
    val result = counter(list)
    val output = ujson.Obj.from(result.map { case (k, v) => (k.toString, ujson.Num(v)) })
    cask.Response(output, statusCode = 200)
  }

  @cask.get("/")
  def hello(): String = {
    println(s"Server is running at: http://localhost:8080/")
    "Cask application is ready. Use POST routes."
  }

  initialize()
}