import chapter3.{Cons, List, Nil}

List.setHead(0, List(1,2,3))

List.setHead(4, List(1,2,3))

List.setHead(42, Nil)

List.setHead("a", List("c", "a", "t"))

List.prepend("a", List("c", "a", "t"))

List.prepend("a", Nil)