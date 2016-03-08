package chapter5

import org.scalatest.{Matchers, FlatSpec}
import Lazy._
import Stream._
import collection.immutable.{Stream=> FOO}

class LazySpec extends FlatSpec with Matchers {

  def isEven(x: Int) =
    x % 2 == 0

  def isOdd(x: Int) =
    x % 2 != 0

  def addNum(x: Int) =
    Stream[Int](x)

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

  "A Stream(1, 2, 3, 4, 5).take(n)" should "return n elements from the stream" in {
    Stream(1, 2, 3, 4, 5).take(3).toList should be (List(1, 2, 3))
  }

  "A Stream(1, 2, 3, 4, 5).drop(n)" should "drop n elements from the stream" in {
    Stream(1, 2, 3, 4, 5).drop(3).toList should be (List(4, 5))
  }

  "A Stream(4, 2, 6, 2, 8).forAll" should "break and return true with predicate from the stream" in {
    Stream(1, 3, 5, 7).forAll((a: Int) => {a % 2 != 0}) should be (true)
  }

  "A Stream(4, 2, 6, 2, 5).forAll" should "break and return false with predicate from the stream" in {
    Stream(4, 2, 6, 2, 5).forAll(isEven) should be (false)
  }

  "A Stream(4, 2, 6, 2, 5).takeWhile" should "with predicate from the stream" in {
    Stream(4, 2, 6, 2, 5).takeWhile(isEven).toList should be (List(4, 2, 6, 2))
  }

  "A Stream(4, 2, 6, 2, 5).headOption" should "should return Some(4)" in {
    Stream(4, 2, 6, 2, 5).headOption should be (Some(4))
  }

  "A Stream(4, 2, 6, 2, 5).headOption" should "should return empty" in {
    Stream[Int]().headOption should be (None)
  }

  "A Stream(4, 2, 6, 2, 5).map" should "should return map" in {
    Stream(4, 2, 6, 2, 5).map(_ + 1).toList should be (List(5, 3, 7, 3, 6))
  }

  "A Stream(4, 2, 6, 2, 5).append" should "should return appended stream" in {
    Stream(5).append(Stream(1,2,3)).toList should be (List(5, 1, 2, 3))
  }

  "A Stream(4, 2, 6, 2, 5).filter" should "should return filtered stream" in {
    Stream(4, 2, 6, 2, 5).filter(isOdd).toList should be (List(5))
  }

  "A Stream(4, 2, 6, 2, 5).flatMap" should "should return flatMap" in {
    Stream(1, 2, 3).flatMap(addNum(_)).toList should be (List(1, 2, 3))
  }

  "constants" should "return stream of 2" in {
    Stream().constant(2).take(5).toList should be (List(2, 2, 2, 2, 2))
  }

  "from" should "generate a stream of integers starting from n" in {
    Stream().from(5).take(6).toList should be (List(5, 6, 7, 8, 9, 10))
  }

  "fibs.take(6)" should "return Stream(0, 1, 1, 2, 3, 5)" in {
    fibs.take(6).toList should be (List(0, 1, 1, 2, 3, 5))
  }

  "fibsFrom(5).take(2)" should "return Stream(5, 8)" in {
    fibsFrom(5).take(2).toList should be (List(5, 8))
  }

  "unfold constant" should "return Stream(0, 1, 2)" in {
    unfold(1)((x) => Some((x, x))).take(3).toList should be (List(1, 1, 1))
  }

  "unfold fib" should "return Stream(0, 1, 1, 2, 3, 5)" in {
    unfold((0, 1))((x) => Some((x._1, (x._2, x._1 + x._2)))).take(6).toList should be (List(0, 1, 1, 2, 3, 5))
  }

  "unfold from" should "return Stream(0, 1, 2, 3, 4, 5)" in {
    unfold(0)(x => Some((x, x + 1))).take(6).toList should be (List(0, 1, 2, 3, 4, 5))
  }

  "unfold takeUnfold" should "return Stream(1, 2, 3)" in {
    Stream(1, 2, 3).takeUnfold(3).toList should be (List(1, 2, 3))
  }

  "unfold takeWhile" should "return Stream(1, 2, 3)" in {
    Stream(1, 2, 3, 4, 5, 6, 7).takeUnfoldWhile(_ <= 5).toList should be (List(1, 2, 3, 4, 5))
  }
}
