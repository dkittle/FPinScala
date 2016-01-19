import chapter3.{Cons, List, Nil}
import List._

val ex1: List[Double] = Nil
val ex3: List[String] = Cons("a", Cons("b", Nil))

val x = List(1,2,3,4,5) match {
  case Cons(x, Cons(2, Cons(5, _))) => x
  case Nil => 42
  case Cons(x, Cons(y, Cons(3, Cons(5, _)))) => x + y
  case Cons(h, t) => h + sum(t)
  case _ => 101
}

