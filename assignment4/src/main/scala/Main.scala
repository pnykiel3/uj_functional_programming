object Main extends cask.MainRoutes {

  override def host: String = "0.0.0.0"
  override def port: Int = 8080

  @cask.get("/")
  def hello(): String = {
    println(s"Server is running at: http://localhost:8080/")
    "Cask application is ready. Use POST routes."
  }

  initialize()
}