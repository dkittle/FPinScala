import chapter3.{Cons, List, Nil}

List.foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_))
