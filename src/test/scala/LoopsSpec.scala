import chapter2.Loops
import org.scalatest.{Matchers, FlatSpec}

import Loops._

class LoopsSpec extends FlatSpec with Matchers {

  "factorial(3)" should "return 3" in {
    factorial(3) should be (6)
  }

  "factorial(0)" should "return 1" in {
    factorial(0) should be (1)
  }

  "factorial(1)" should "return 1" in {
    factorial(1) should be (1)
  }

  "fibonacci(1)" should "return 0" in {
    fibonacci(1) should be (0)
  }

  "fibonacci(2)" should "return 1" in {
    fibonacci(2) should be (1)
  }

  "fibonacci(3)" should "return 1" in {
    fibonacci(3) should be (1)
  }

  "fibonacci(4)" should "return 2" in {
    fibonacci(4) should be (2)
  }

  "fibonacci(5)" should "return 3" in {
    fibonacci(5) should be (3)
  }

  "fibonacci(6)" should "return 5" in {
    fibonacci(6) should be (5)
  }
}
