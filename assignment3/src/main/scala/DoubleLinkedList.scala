
class DoubleLinkedList[A](elements: List[A] = List()) {

  private class Node(var data: A) {
    var prev: Option[Node] = None
    var next: Option[Node] = None
  }

  private var head: Option[Node] = None
  private var tail: Option[Node] = None
  private var size: Int = 0

  elements.foreach(push_back)

  def push_back (element: A): Unit = {
    val newNode = new Node(element)
    tail match {
      case None =>
        head = Some(newNode)
        tail = Some(newNode)
      case Some(something) =>
        something.next = Some(newNode)
        newNode.prev = Some(something)
        tail = Some(newNode)
    }
    size += 1
  }

  def push_front (element: A): Unit = {
    val newNode = new Node(element)
    head match {
      case None =>
        head = Some(newNode)
        tail = Some(newNode)
      case Some(something) =>
        something.prev = Some(newNode)
        newNode.next = Some(something)
        head = Some(newNode)
    }
    size += 1
  }

  def pop_back(): A = {
    tail match {
      case None => throw new NoSuchElementException("Your list is empty!")
      case Some(something) =>
        val data = something.data
        tail = something.prev
        tail match {
          case None => head = None
          case Some(prevNode) => prevNode.next = None
        }
        size -= 1
        data
    }
  }

  def pop_front(): A = {
    head match {
      case None => throw new NoSuchElementException("Your list is empty!")
      case Some(something) =>
        val data = something.data
        head = something.next
        head match {
          case None => tail = None
          case Some(nextNode) => nextNode.prev = None
        }
        size -= 1
        data
    }
  }

  def printList(): Unit = {
    var current = head
    print("List: ")
    while (current.isDefined) {
      print(current.get.data + " ")
      current = current.get.next
    }
    println()
  }

  def isEmpty: Boolean = size == 0

  def getSize: Int = size

  def toList: List[A] = {
    var result = List[A]()
    var current = head
    while (current.isDefined) {
      result = result :+ current.get.data
      current = current.get.next
    }
    result
  }

}

