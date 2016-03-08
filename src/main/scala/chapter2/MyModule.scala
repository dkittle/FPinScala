package chapter2

import scala.annotation.tailrec

object MyModule {

  def abs(n: Int): Int = {
    if (n < 0) -n
    else n
  }

  def factorial(n: Int): Int = {
    @tailrec
    def rec(x: Int, acc: Int): Int =
      if(x <= 0) acc
      else rec(x-1, acc * x)
    rec(n, 1)
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d."
    msg.format(x, abs(x))
  }

  private def formatFactorial(x: Int) = {
    val msg = "The factorial of %d is %d"
    msg.format(x, factorial(x))
  }

  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(formatFactorial(7))
  }
  
}
