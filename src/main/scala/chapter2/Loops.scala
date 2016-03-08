package chapter2

import scala.annotation.tailrec

object Loops {

  // Exercise 2.1
  def fib(n:Int): Int = {
    @tailrec
    def rec(x: Int, p1: Int, p2: Int): Int = {
      if (x <= 1) 0 + p1 else
        rec(x - 1, p2 + p1, p1)
    }
    if (n <= 1) 0 else
      rec(n - 1, 1, 0)
  }


}
