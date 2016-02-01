package chapter4

import scala.{Option => _, Either => _, _}

import org.scalatest.{Matchers, FlatSpec}
import chapter4.{Option, None, Some }

class OptionSpec extends FlatSpec with Matchers {

  "A mean" should "return an Option[Double]" in {
    def mean(xs: Seq[Double]): Option[Double] = {
      if (xs.isEmpty) None
      else Some(xs.sum / xs.length)
    }
  }

}
