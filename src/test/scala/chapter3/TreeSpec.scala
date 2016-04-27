package chapter3

import org.scalatest.{FlatSpec, Matchers}

class TreeSpec extends FlatSpec with Matchers {


  "A tree" should "have size 3" in {
    val f = Branch(Leaf(1), Leaf(2))
    Tree.size(f) should be (3)
  }

  it should "have size 1" in {
    val f = Leaf(99)
    Tree.size(f) should be (1)
  }

  it should "size 7" in {
    val f = Branch(Branch(Leaf(0), Leaf(123)), Branch(Leaf(2), Leaf(4)))
    Tree.size(f) should be (7)
  }

  it should "sum to 12" in {
    val f = Leaf(12)
    Tree.sum(f) should be (12)
  }

  it should "sum to 5" in {
    val f = Branch(Leaf(2), Leaf(3))
    Tree.sum(f) should be (5)
  }

  it should "sum to 129" in {
    val f =   Branch(Branch(Leaf(0), Leaf(123)), Branch(Leaf(2), Branch(Leaf(0), Leaf(4))))
    Tree.sum(f) should be (129)
  }

  it should "have a depth of 1" in {
    val f = Leaf("13")
    Tree.depth(f) should be (1)
  }

  it should "have a depth of 3" in {
    val f =   Branch(Leaf(43), Branch(Leaf(1), Leaf(2)))
    Tree.depth(f) should be (3)
  }

  it should "have a depth of 4" in {
    val f = Branch(Branch(Leaf(1), Branch(Leaf(2), Leaf(3))), Branch(Leaf(14), Leaf(15)))
    Tree.depth(f) should be (4)
  }

  it should "have a hightest value 14" in {
    val f = Branch(Branch(Leaf(1), Branch(Leaf(2), Leaf(3))), Branch(Leaf(14), Leaf(15)))
    Tree.highestValue(f) should be (15)
  }

}
