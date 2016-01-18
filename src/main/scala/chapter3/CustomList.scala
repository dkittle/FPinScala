package chapter3

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x,xs) => x * product(xs)
  }

  def apply[A](as: A*) :List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def tail[A](items: List[A]): List[A] = items match {
    case Nil => Nil
    case Cons(_,xs) => xs
  }

  def setHead[A](h: A, i: List[A]): List[A] = i match {
    case Nil => Nil
    case Cons(_,xs) => Cons(h, xs)
  }

  def drop[A](l: List[A], n: Int): List[A] = {
    if (n < 1) l
    else l match {
      case Nil => Nil
      case Cons(_,xs) => drop(xs, n - 1)
    }
  }

//  OLD
//  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
//    case Nil => Nil
//    case Cons(x,xs) if !f(x) => dropWhile(xs, f)
//    case _ => l
//  }

  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(x,xs) if !f(x) => dropWhile(xs)(f)
    case _ => l
  }

  def init[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(_,Nil) => Nil
    case Cons(x,xs) => Cons(x,init(xs))
  }

  def foldRight[A,B](as: List[A], z: B)(f: (A,B) => B): B =
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  def sum2(ns: List[Int]) =
    foldRight(ns, 0)((x,y) => x + y)

  def product2(ns: List[Double]) =
    foldRight(ns, 1.0)(_ * _)

  def length[A](i: List[A]): Int = {
    List.foldRight(i, 0)((_,a) => a + 1)
  }

  
}

