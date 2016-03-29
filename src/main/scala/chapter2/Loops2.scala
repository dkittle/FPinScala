package chapter2

import scala.annotation.tailrec

object Loops2 {


  def fib(n: Int): Int = {
    @tailrec
    def go(n: Int, secondLast: Int, last: Int): Int = {
       if (n <= 0) secondLast
       else go(n-1, last, secondLast + last)
    }
    go(n, 0, 1)
  }

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

  def findFirst2[A](a: Array[A], p: A => Boolean): Int = {
    @tailrec
    def go(index: Int): Int = {
      if (index >= a.length) -1
      else if (p(a(index))) index
      else
        go(index + 1)
    }
    go(0)
  }

  def isSorted[A](a: Array[A], p: (A, A) => Boolean): Boolean = {
    if (a.length <= 1) true
    else if (!p(a(0), a(1))) false
    else isSorted(a.tail, p)
  }

  val isLessThan = new Function2[Int, Int, Boolean] {
    def apply(a: Int, b: Int) = a < b
  }

  def curry[A,B,C](f: (A,B) => C): A => (B => C) = a => b => f(a,b)

  def uncurry[A,B,C](f: A => B => C): (A, B) => C = (a,b) => f(a)(b)

  def compose[A,B,C](f: B => C, g: A => B): A => C = a => f(g(a))

  val func = (x: Double) => math.Pi / 2 - x

  val cos = math.sin _ compose func

}
