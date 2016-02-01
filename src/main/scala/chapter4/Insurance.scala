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

  def map3[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    for {
      aa <- a
      bb <- b
    } yield f(aa, bb)
  }

  def parseInsuranceQuote(age: String, numberOfSpeedingTickets: String) = {
    val optAge: Option[Int] = Try(age.toInt)
    val optTickets: Option[Int] = Try(numberOfSpeedingTickets.toInt)
    map2(optAge, optTickets)(insuranceRateQuote)
  }

  def parseInsuranceQuote2(age: String, numberOfSpeedingTickets: String) = {
    val optAge: Option[Int] = Try(age.toInt)
    val optTickets: Option[Int] = Try(numberOfSpeedingTickets.toInt)
    map3(optAge, optTickets)(insuranceRateQuote)
  }

  def insuranceRateQuote(age: Int, numberOfSpeedingTickets: Int): Double = {
    age * numberOfSpeedingTickets * 1.23
  }

}
