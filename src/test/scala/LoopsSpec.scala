import chapter2.Loops
import org.scalatest.{Matchers, FlatSpec}

import Loops._

class LoopsSpec extends FlatSpec with Matchers {

  "fib(1)" should "return 0" in {
    fib(1) should be (0)
  }

  "fib(2)" should "return 1" in {
    fib(2) should be (1)
  }

  "fib(3)" should "return 1" in {
    fib(3) should be (1)
  }

  "fib(4)" should "return 2" in {
    fib(4) should be (2)
  }

  "fib(5)" should "return 3" in {
    fib(5) should be (3)
  }

  "fib(6)" should "return 5" in {
    fib(6) should be (5)
  }

  "findFirst" should "return 0" in {
    findFirst(Array("hi","there","scala"), "hi") should be (0)
  }

  "findFirst" should "return 1" in {
    findFirst(Array("hi","there","scala"), "there") should be (1)
  }

  "findFirst" should "return 2" in {
    findFirst(Array("hi","there","scala"), "scala") should be (2)
  }

  "findFirst" should "return -1" in {
    findFirst(Array("hi","there","scala"), "hello") should be (-1)
  }

  "findFirst with an empty array" should "return -1" in {
    findFirst(Array[String](), "hello") should be (-1)
  }
  
}
