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

  "A List of 1,2,3,4" should "multiply to 24" in {
    List.product(List(1,2,3,4)) should be (24)
  }

  "A List of 13" should "multiply to 13" in {
    List.product(List(13)) should be (13)
  }

  "A List of no elements" should "multiply to 1" in {
    List.product(List()) should be (1)
  }

  "A List of Nil" should "multiply to 1" in {
    List.product(Nil) should be (1)
  }

}
