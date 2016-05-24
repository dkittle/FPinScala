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

  def findFirst2[A](a: Array[A], p: A => Boolean): Int = {
    @tailrec
    def rec(a: Array[A], i: Int, p: A => Boolean): Int = {
      if (i >= a.length) -1
      else if (p(a(i))) i
      else rec(a, i + 1, p)
    }
    rec(a, 0, p)
  }

  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    @tailrec
    def rec(a: Array[A], i: Int, f: (A,A) => Boolean): Boolean = {
      if (i >= a.length - 1) true
      else if (f(a(i), a(i + 1)) == false) false
      else rec(a, i + 1, f)
    }
    if (as.length < 2) true
    else rec(as, 0, ordered)
  }

  val isLessThan = new Function2[Int, Int, Boolean] {
    def apply(a: Int, b: Int) = a < b
  }

  def partial1[A,B,C](a: A, f: (A,B) => C): B => C =
    (b: B) => f(a, b)

  def curry[A,B,C](f: (A, B) => C): A => (B => C) =
    (a: A) => (b: B) => f(a,b)

  def uncurry[A,B,C](f: A => B => C): (A, B) => C =
    (a, b) => f(a)(b)

  def compose[A,B,C](f: B => C, g: A => B): A => C =
    a => f(g(a))

  val func = (x: Double) => math.Pi / 2 - x

  val cos = math.sin _ compose func

}
