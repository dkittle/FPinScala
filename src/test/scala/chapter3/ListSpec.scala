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

  "A List of 1,2,0,4" should "multiply to 0" in {
    List.product(List(1,2,0,4)) should be (0)
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

  "Tail of List(1,2,3)" should "be List(2,3)" in {
    List.tail(List(1,2,3)) should be (List(2,3))
  }

  "Tail of List(1)" should "be Nil" in {
    List.tail(List(1)) should be (Nil)
  }

  "Tail of Nil" should "be Nil" in {
    List.tail(Nil) should be (Nil)
  }

  "SetHead of List(1,2,3) with 4" should "be List(4,2,3)" in {
    List.setHead(List(1,2,3), 4) should be (List(4,2,3))
  }

  "SetHead of List(1) with 4" should "be List(4)" in {
    List.setHead(List(1), 4) should be (List(4))
  }

  "SetHead of Nil with 4" should "be List(4)" in {
    List.setHead(Nil, 4) should be (List(4))
  }

  "Drop 2 from List(1,2,3,4,5)" should "be List(3,4,5)" in {
    List.drop(List(1,2,3,4,5), 2) should be (List(3,4,5))
  }

  "Drop 3 from List(1,2)" should "be Nil" in {
    List.drop(List(1,2), 3) should be (Nil)
  }

  "Drop 1 from Nil" should "be Nil" in {
    List.drop(Nil, 1) should be (Nil)
  }

  "DropWhile _ < 4 with List(1,2,3,4,5,6)" should "be List(4,5,6)" in {
    List.dropWhile(List(1,2,3,4,5,6), (x: Int) => x < 4) should be (List(4,5,6))
  }

  "Some crazy stuff" should "be List(1,2,3)" in {
    List.foldRight(List(1,2,3),Nil:List[Int])(Cons(_,_)) should be (List(1,2,3))
  }

  "Init of List(1,2,3,4)" should "be List(1,2,3)" in {
    List.init(List(1,2,3,4)) should be (List(1,2,3))
  }

  "length of List(1,2,3,4,5)" should "be 5" in {
    List.length(List(1,2,3,4,5)) should be (5)
  }

  "sum3 of List(7,8,9)" should "be 24" in {
    List.sum3(List(7,8,9)) should be (24)
  }

  "reverse of List(1,2,3)" should "be List(3,2,1)" in {
    List.reverse(List(1,2,3)) should be (List(3,2,1))
  }
}
