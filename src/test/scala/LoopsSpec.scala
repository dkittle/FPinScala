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
}
