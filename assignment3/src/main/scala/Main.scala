object Main extends cask.MainRoutes {

  override def host: String = "0.0.0.0"

  override def port: Int = 8080

  private def tail[A](list: List[A]): List[A] = {
    list.tail
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

  def dropWhile[A](list: DoubleLinkedList[A], predicate: A => Boolean): DoubleLinkedList[A] = {
    def dropWhileSupport(remaining: DoubleLinkedList[A]): DoubleLinkedList[A] = {
      val remainingList = remaining.toList
      remainingList match {
        case Nil => remaining
        case _ if predicate(remainingList.last) =>
          remaining.pop_back()
          dropWhileSupport(remaining)
        case _ => remaining
      }
    }

    dropWhileSupport(list)
  }

  @cask.postJson("/tail")
  def tailEndpoint(list: List[Int]): cask.Response[ujson.Value] = {

    if (list.isEmpty) {
      cask.Response(
        ujson.Obj("error" -> "Cannot get tail of an empty list"),
        statusCode = 400
      )
    } else {
      val tail = list.tail
      val jsonList = tail.map(x => ujson.Num(x.toDouble))
      cask.Response(ujson.Obj("tail result" -> jsonList), statusCode = 200)
    }
  }

  @cask.postJson("/drop")
  def dropEndpoint(list: List[Int], n: Int): cask.Response[ujson.Value] = {
    if (n > list.length) {
      cask.Response(
        ujson.Obj("error" -> "n is larger than the list size"),
        statusCode = 400
      )
    } else if (n < 0) {
      cask.Response(
        ujson.Obj("error" -> "n must be positive"),
        statusCode = 400
      )
    } else {
    val dll = new DoubleLinkedList[Int](list)
    drop(dll, n)
    val resultJson = ujson.Arr(dll.toList.map(x => ujson.Num(x.toDouble)): _*)
    cask.Response(ujson.Obj("drop result" -> resultJson), statusCode = 200)
      }
  }

  @cask.postJson("/dropWhile")
  def dropWhileEndpoint(list: List[Int], predicate: String): ujson.Value = {
    val pred: Int => Boolean = predicate match {
      case "even" => (x: Int) => x % 2 == 0
      case "odd" => (x: Int) => x % 2 != 0
      case "positive" => (x: Int) => x > 0
      case "negative" => (x: Int) => x < 0
      case s"div_$y" => (x: Int) => x % y.toInt == 0
      case s"<$y" => (x: Int) => x < y.toInt
      case s">$y" => (x:Int) => x > y.toInt
      case _ => throw new IllegalArgumentException("Unsupported predicate type")
    }

    val dll = new DoubleLinkedList[Int](list)
    dropWhile(dll, pred)
    ujson.Obj("dropWhile result" -> ujson.Arr(dll.toList.map(x => ujson.Num(x.toDouble)): _*))
  }

  @cask.get("/")
  def hello(): String = {
    println(s"Server is running at: http://localhost:8080/")
    "Cask application is ready. Use POST routes."
  }

  initialize()
}