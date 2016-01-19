import chapter3.{List, Nil}

List.sum(List(1,2,3,4))

//List.sum2(List(1,2,3,4))

List.product(List(1,2,3,4))

//List.product2(List(1,2,3,4))

List.foldr(Nil, (x: Int, y: Int) => x+y, 42)
List.foldr(List(1,2,3), (x: Int, y: Int) => x+y, 0)
List.foldr(List(), (x: Int, y: Int) => x+y, 43)

List.foldr(List(1,0,3,4), (x: Int, y: Int) => x*y, 1)

// solution_to_short_circuit = ???

