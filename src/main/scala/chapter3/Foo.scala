package chapter3

/**
  * Created by dkittle on 2016-01-18.
  */
sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]


object List {

  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }


  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ints: List[Double]): Double = ints match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def tail[A](i: List[A]): List[A] = i match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  def setHead[A](a: A, l: List[A]): List[A] = l match {
    case Nil => Cons(a, Nil)
    case Cons(_, xs) => Cons(a, xs)
  }

  def prepend[A](a: A, l: List[A]): List[A] = Cons(a, l)

  def drop[A](l: List[A], n: Int): List[A] = (l, n) match {
    case (Nil, _) => Nil
    case (l, 0) => l
    case (Cons(h, t), n) => drop(t, n - 1)
  }

  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(h, xs) if f(h) =>
      dropWhile(xs, f)
    case _ => l
  }

  def init[A](l: List[A]): List[A] = {
    l match {
      case Nil => Nil
      case Cons(h, Nil) => Nil
      case Cons(h, xs) => Cons(h, init(xs))
    }
  }

  def filter[A](l: List[A], f: A => Boolean): List[A] =
    l match {
      case Nil => Nil
      case Cons(h, xs) if (f(h)) => Cons(h, filter(xs, f))
      case Cons(_, xs) => filter(xs, f)
    }

k
  }
}
