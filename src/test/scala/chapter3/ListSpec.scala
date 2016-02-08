package chapter3

import org.scalatest.{Matchers, FlatSpec}

class ListSpec extends FlatSpec with Matchers {

  "A List of 1,2,3" should "sum to 6" in {
    List.sum(List(1,2,3)) should be (6)
  }

  "A List of Nil" should "sum to 0" in {
    List.sum(Nil) should be (0)
  }

  "A List that is empty" should "sum to 0" in {
    List.sum(List()) should be (0)
  }

  "A List of 0,1,2,3" should "sum to 6" in {
    List.sum(List(0,1,2,3)) should be (6)
  }

  "A List of 1,2,3,4" should "have a product of 24" in {
    List.product(List(1,2,3,4)) should be (24.0)
  }

  "A List of 1,2,0,3,4" should "have a product of 0.0" in {
    List.product(List(1,2,0,3,4)) should be (0.0)
  }

  "A List of 1,2,3" should "have a tail of 2,3" in {
    List.tail(List(1,2,3)) should be (List(2,3))
  }

  "A List of 1,2,3" should "transform to 0,2,3 when setHead is 0" in {
    List.setHead(0, List(1,2,3)) should be (List(0,2,3))
  }

  "A List of Nil" should "transform to 6 when setHead is 6" in {
    List.setHead(6, Nil) should be (List(6))
  }

  "A List of (4)" should "transform to 6 when setHead is 6" in {
    List.setHead(6, List(4)) should be (List(6))
  }

  "A List of 1,2,3,4,5,6 when 2 elements are dropped" should "be 3,4,5,6" in {
    List.drop(List(1,2,3,4,5,6), 2) should be (List(3,4,5,6))
  }

  "A List of 1,2,3,4,5,6 when 32 elements are dropped" should "be Nil" in {
    List.drop(List(1,2,3,4,5,6), 32) should be (Nil)
  }

  "A List of 1,2,3,4,5,6 when 0 elements are dropped" should "be List(1,2,3,4,5,6)" in {
    List.drop(List(1,2,3,4,5,6), 0) should be (List(1,2,3,4,5,6))
  }

  "A List of 1,2,3,4,5,6 when -1 elements are dropped" should "be List(1,2,3,4,5,6)" in {
    List.drop(List(1,2,3,4,5,6), -1) should be (List(1,2,3,4,5,6))
  }

  "A List of Nil when 1 element is dropped" should "be Nil" in {
    List.drop(Nil, 1) should be (Nil)
  }

  "A List of 1,2,3" should "be (2,3) if we drop elements mod 2 != 0" in {
    List.dropWhile(List(1,2,3), (x: Int) => x % 2 != 0) should be (List(2,3))
  }

  "A List of 1,2,3" should "be (2,3) if we drop elements < 2" in {
    List.dropWhile(List(1,2,3), (x: Int) => x < 2) should be (List(2,3))
  }

  "A List of 1,2,3" should "be (1,2,3) if we drop elements > 3" in {
    List.dropWhile(List(1,2,3), (x: Int) => x > 3) should be (List(1,2,3))
  }

  "A List of 1,2,3" should "be Nil if we drop elements < 4" in {
    List.dropWhile(List(1,2,3), (x: Int) => x < 4) should be (Nil)
  }

  "A List of 1,2,3,4" should "be 1,2,3 if call init" in {
    List.init(List(1,2,3,4)) should be (List(1,2,3))
  }

  "A List of 1" should "be Nil if call init" in {
    List.init(List(1)) should be (Nil)
  }

  "A List of Nil" should "be Nil if call init" in {
    List.init(Nil) should be (Nil)
  }
}