package chapter3

import org.scalatest.{Matchers, FlatSpec}

class ListSpec extends FlatSpec with Matchers {

  "A List of 1,2,3" should "sum to 6" in {
    List.sum(List(1,2,3)) should be (6)
  }

  "A List of 13" should "sum to 13" in {
    List.sum(List(13)) should be (13)
  }

  "A List of no elements" should "sum to 0" in {
    List.sum(List()) should be (0)
  }

  "A List of Nil" should "sum to 0" in {
    List.sum(Nil) should be (0)
  }

}
