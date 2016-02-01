package chapter4

import scala.{Some => _, None => _, Option => _, Either => _, _}

sealed trait Option[+A] {

  def map[B](f: A => B): Option[B] = this match {
    case None => None
    case Some(x) => Some(f(x))
  }

  def getOrElse[B >: A](default: => B): B = this match{
    case None => default
    case Some(x) => x
  }

  def flatMap[B](f: A => Option[B]) : Option[B] = {
    map(f).getOrElse(None)
  }

  def filter(f: A => Boolean): Option[A] = this match {
    case Some(x) if f(x) => this
    case _ => None
  }

//  def orElse[B >: A](ob: => Option[B]): Option[B] = ???

}

case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]

