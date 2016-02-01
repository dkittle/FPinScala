package chapter4

import scala.{Some => _, None => _, Option => _, Either => _, _}

import org.scalatest.{Matchers, FlatSpec}
import chapter4.{Option, None, Some }

class OptionSpec extends FlatSpec with Matchers {

  def mean(xs: Seq[Double]): Option[Double] = {
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)
  }

  def variance(xs: Seq[Double]): Option[Double] = {
    if (xs.isEmpty) None
    else {
      val m = mean(xs).getOrElse(1.0)
      val v = xs.map(x => math.pow(x - m, 2))
      mean(v)
    }
  }

  "A mean" should "return an Some(5.0)" in {
    mean(Seq(2.0, 5.0, 8.0)) should be (Some(5.0))
  }

  "A mean" should "return a None" in {
    mean(Seq()) should be (None)
  }

  "An Option" should "return a string with getOrElse" in {
    val foo: Option[String] = Some("foo")
    foo.getOrElse("") should be ("foo")
  }

  "An Option" should "return None with getOrElse" in {
    val foo: Option[String] = None
    foo.getOrElse(None) should be (None)
  }

  "An Option of Some" should "return foo with map" in {
    val foo: Option[String] = Some("foo")
    foo.map(_.toString).getOrElse(None) should be ("foo")
  }

  "An Option of Some" should "return foo with filter" in {
    val foo: Option[String] = Some("foo")
    foo.filter(_ == "foo").getOrElse(None) should be ("foo")
  }

  "A seq of doubles 2, 5, 8" should "have a variance of 6" in {
    variance(Seq(2.0, 5.0, 8.0)) should be (Some(6.0))
  }
}
