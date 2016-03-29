import chapter2.Loops2
import org.scalatest.{Matchers, FlatSpec}

import Loops2._

class LoopsSpec extends FlatSpec with Matchers {

  "fib" should "return 0" in {
    fib(0) should be (0)
  }

  it should "return 1" in {
    fib(1) should be (1)
  }

  it should "also return 1" in {
    fib(2) should be (1)
  }

  it should "return 5" in {
    fib(5) should be (5)
  }

  it should "return 0 as an error" in {
    fib(-1) should be (0)
  }



  "findFirst" should "return 1" in {
    findFirst(Array("hi","there","scala"), "there") should be (1)
  }

  "findFirst2" should "return 2" in {
    findFirst2[Int](Array[Int](1,2,3,4,5), (x: Int) => x == 3) should be (2)
  }

  it should "return 1" in {
    findFirst2(Array("hi","there","scala"), (x: String) => x == "there") should be (1)
  }

  it should "also return 2" in {
    findFirst2(Array("hi","there","scala"), (x: String) => x == "scala") should be (2)
  }

  it should "return -1" in {
    findFirst2(Array("hi","there","scala"), (x: String) => x == "hello") should be (-1)
  }



  "findFirst2 with no numbers" should "return -1" in {
    findFirst2[Int](Array[Int](), _ == 3) should be (-1)
  }

  "isSorted" should "return true" in {
    isSorted(Array(1,2,3), (x: Int,y: Int) => x <= y) should be (true)
  }


  "isSorted with two numbers desc" should "return false" in {
    isSorted(Array(3,2), (x: Int,y: Int) => x <= y) should be (false)
  }

  "isSorted with one number" should "return true" in {
    isSorted(Array(2), (x: Int,y: Int) => x <= y) should be (true)
  }


  "isLessThan with two asc numbers" should "return true" in {
    isLessThan(2,3) should be (true)
  }


  "isLessThan with two desc numbers" should "return false" in {
    isLessThan(3,2) should be (false)
  }

  "isLessThan with the same number" should "return false" in {
    isLessThan(3,3) should be (false)
  }



  "cos of 30" should "be 0.15425144988758235" in {
    cos(30) should be (0.15425144988758235)
  }

}
