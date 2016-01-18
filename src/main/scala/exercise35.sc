import chapter3.{List}


List.dropWhile(List(1,2,3,4,5,6,7,8,9))( x => x > 4)

List.dropWhile(List(1,2,3,4,5,6,7,8,9))(x => x > 9)

List.dropWhile(List(1,2,3,4,5,6,7,8,9))(x => x > 7)
