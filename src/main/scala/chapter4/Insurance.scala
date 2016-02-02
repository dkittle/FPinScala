



package chapter4

object Insurance {

  def Try[A](a: => A): Option[A] = {
    try Some (a)
    catch { case e: Exception => None }
  }

  def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    a flatMap (aa =>
      b map (bb =>
        f(aa, bb)))
  }

  def mapOfHell[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Either[List[String], C] = {
    (a, b) match {
      case (None, None) => Left(List("age is invalid","number of tickets is invalid"))
      case (None, _) => Left(List("age is invalid"))
      case (_, None) => Left(List("number of tickets is invalid"))
      case (Some(a),Some(b)) => Right(f(a,b))
    }
  }

  def map3[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[Either[List[String], C]] = {
    import InsuranceErrors._
    for {
      aa <- a
      bb <- b
    } yield {
      print(s"foo ${aa} ${bb}")
      (aa,bb) match {
        case (None, None) => Left(List(NoAge, NoTickets))
        case (None, _) => Left(List(NoAge))
        case (_, None) => Left(List(NoTickets))
        case _ => Right(f(aa,bb))
      }
    }
  }

  def parseInsuranceQuote(age: String, numberOfSpeedingTickets: String) = {
    val optAge: Option[Int] = Try(age.toInt)
    val optTickets: Option[Int] = Try(numberOfSpeedingTickets.toInt)
    map2(optAge, optTickets)(insuranceRateQuote)
  }

  def parseInsuranceQuoteHell(age: String, numberOfSpeedingTickets: String) = {
    val optAge: Option[Int] = Try(age.toInt)
    val optTickets: Option[Int] = Try(numberOfSpeedingTickets.toInt)
    mapOfHell(optAge, optTickets)(insuranceRateQuote)
  }

  def insuranceRateQuote(age: Int, numberOfSpeedingTickets: Int): Double = {
    age * numberOfSpeedingTickets * 1.23
  }

}

object InsuranceErrors extends Enumeration {
  type InsuranceErrors = Value
  val NoAge = "age is invalid"
  val NoTickets = "number of tickets is invalid"
}
