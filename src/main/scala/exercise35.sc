import chapter3.{List}


List.dropWhile(List(1,2,3,4,5,6,7,8,9), (x: Int) => x % 2 == 1)

List.filter(List(1,2,3,4,5,6,7,8,9), (x: Int) => true)

List.filter(List("cat", "apple", "meetup"), (x: String) => x.contains("m"))

//List.dropWhile(List(1,2,3,4,5,6,7,8,9),x => x > 9)

//List.dropWhile(List(1,2,3,4,5,6,7,8,9))(x => x > 7)
