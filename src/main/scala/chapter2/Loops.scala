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

  // Section 2.5.1
  def findFirst(as: Array[String], key: String): Int = {
    @tailrec
    def rec(as: Array[String], k: String, i: Int): Int = {
      if (i >= as.length)
        -1
      else if (as(i) == k)
        i
      else
        rec(as, k, i + 1)
    }
    rec(as, key, 0)
  }

  // Now make it a polymorphic function
  def findFirst[A](a: Array[A], p: A => Boolean): Int = ???

}
