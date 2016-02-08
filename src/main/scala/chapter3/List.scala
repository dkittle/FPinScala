package chapter3

import scala.annotation.tailrec

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]


object List {

  def init[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(x,Nil) => Nil
    case Cons(x,y) => Cons(x,init(y))
  }

  @tailrec
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(x,y) if f(x) => dropWhile(y,f)
    case _ => l
  }

  @tailrec
  def drop[A](l: List[A], n: Int): List[A] = l match {
    case Nil => Nil
    case Cons(x,y) if (n > 0) => drop(y,n-1)
    case _ => l
  }

  def setHead(e: Int, l: List[Int]): List[Int] = l match {
    case Nil => Cons(e, Nil)
    case Cons(x,y) => Cons(e,y)
  }

  def tail(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case Cons(x,y) => y
  }


  def sum(ints: List[Int]): Int = {
    @tailrec
    def sumr(i: List[Int], acc: Int): Int = i match {
      case Nil => acc
      case Cons(e,t) => sumr(t,e + acc)
    }
    sumr(ints,0)
  }

  def product(ds: List[Double]): Double = {
    @tailrec
    def productr(d: List[Double], acc: Double): Double = d match {
      case Nil => acc
      case Cons(0.0,_) => 0.0
      case Cons(e,t) => productr(t,e * acc)
    }
    productr(ds,1.0)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

}
