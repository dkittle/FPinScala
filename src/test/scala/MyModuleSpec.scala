import org.scalatest.{Matchers, FlatSpec}
import chapter2.MyModule._

class MyModuleSpec extends FlatSpec with Matchers {

  "factorial(3)" should "return 3" in {
    factorial(3) should be (6)
  }

  "factorial(0)" should "return 1" in {
    factorial(0) should be (1)
  }

  "factorial(1)" should "return 1" in {
    factorial(1) should be (1)
  }

}
