package chapter5

import org.scalatest.{Matchers, FlatSpec}
import Lazy._

class LazySpec extends FlatSpec with Matchers {

  "An if2" should "execute a the correct function when passed a conditional" in {
    if2(true, () => "true", () => "false") should be ("true")
    if2(false, () => "true", () => "false") should be ("false")
  }

  "An if2" should "not error out" in {
    if2(false, () => sys.error("fail"), () => 3) should be (3)
  }

  "A parameter to maybeTwice()" should "be evaluated twice" in {
    maybeTwice(true, { println("foo"); 1 + 41 }) should be (84)
  }

  "A parameter to maybeTwice2()" should "be evaluated once" in {
    maybeTwice2(true, { println("bar"); 1 + 41 }) should be (84)
  }

  "A Stream(1,2,3).exists1(_ == 2)" should "be true" in {
    Stream(1,2,3).exists1(_ == 2) should be (true)
  }

  "A Stream(1,2,3).exists1(_ == 4)" should "be false" in {
    Stream(1,2,3).exists1(_ == 4) should be (false)
  }

  "A Stream(1,2,3,4).exists(_ == 3)" should "be true" in {
    Stream(1,2,3,4).exists(_ == 3) should be (true)
  }

  "A Stream(1,2,3)" should "be a List(1,2,3)" in {
    Stream(1,2,3).toList should be (List(1,2,3))
  }

  "A Stream(1,2,3).append(Stream(4))" should "be a List(1,2,3,4) when converted" in {
    Stream(1,2,3).append(Stream(4)).toList should be (List(1,2,3,4))
  }

  "A Stream(1,2,3,4)" should "be a List(12,14)" in {
    Stream(1,2,3,4).map(_ + 10).filter(_ % 2 == 0).toList
  }

}
