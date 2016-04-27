package chapter3

import scala.annotation.tailrec

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def sum(l: List[Int]): Int = l match {
    case Nil => 0
    case Cons(e,t) => e + sum(t)
  }

  def product(l: List[Double]): Double = l match {
    case Nil => 1.0
    case Cons(0.0,_) => 0.0
    case Cons(e,t) => e * product(t)
  }

  def tail[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(_,t) => t
  }

  def setHead[A](l: List[A], e: A): List[A] =
    Cons(e, tail(l))


  @tailrec
  def drop[A](l: List[A], n: Int): List[A] = n match {
    case 0 => l
    case _ => drop(tail(l), n - 1)
  }

  @tailrec
  def dropWhile[A](l: List[A], p: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(h,t) if (p(h)) => dropWhile(t, p)
    case _ => l
  }

  def init[Z](l: List[Z]): List[Z] = l match {
    case Nil => Nil
    case Cons(e,Nil) => Nil
    case Cons(e,t) => Cons(e,init(t))
  }

  def foldRight[A,B](as: List[A], i: B)(f: (A, B) => B): B = as match {
    case Nil => i
    case Cons(x,xs) => f(x, foldRight(xs, i)(f))
  }

  def sum2(l: List[Int]) =
    foldRight(l, 0)(_ + _)

  def product2(l: List[Double]) =
    foldRight(l, 1.0)(_ * _)

  def length[A](l: List[A]): Int =
    foldRight(l, 0)((a,b) => 1 + b)

  @tailrec
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(e,t) => foldLeft(t, f(z, e))(f)
  }

  def sum3(l: List[Int]): Int =
    foldLeft(l, 0)(_ + _)

  def reverse[A](l: List[A]): List[A] =
    foldLeft(l, Nil:List[A])((a,b) => Cons(b,a))

//  def sum(ints: List[Int]): Int = ints match {
//    case Nil => 0
//    case Cons(x, xs) => x + sum(xs)
//  }
//
//  def product(ds: List[Double]): Double = ds match {
//    case Nil => 1.0
//    case Cons(0.0, _) => 0.0
//    case Cons(x, xs) => x * product(xs)
//  }
//
//  def tail[A](as: List[A]): List[A] = as match {
//    case Nil => Nil
//    case Cons(h, t) => t
//  }
//
//  def setHead[A](as: List[A], a: A): List[A] = as match {
//    case Nil => Cons(a, Nil)
//    case Cons(h, t) => Cons(a, t)
//  }
//
//  @tailrec
//  def drop[A](l: List[A], n: Int): List[A] = l match {
//    case Nil => Nil
//    case l if n > 0 => drop(tail(l), n - 1)
//    case l => l
//  }
//
//  @tailrec
//  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
//    case Cons(h, t) if f(h) => dropWhile(t, f)
//    case _ => l
//  }
//
//  def append[A](a1: List[A], a2: List[A]): List[A] = a1 match {
//    case Nil => a2
//    case Cons(h, t) => Cons(h, append(t, a2))
//  }
//
//  def init[A](l: List[A]): List[A] = l match {
//    case Nil => Nil
//    case Cons(h, Nil) => Nil
//    case Cons(h, t) => Cons(h, init(t))
//  }
//
//  def dropWhile2[A](as: List[A])(f: A => Boolean): List[A] = as match {
//    case Cons(h,t) if f(h) => dropWhile2(t)(f)
//    case _ => as
//  }
//
//  def filter[A](l: List[A], f: A => Boolean): List[A] = l match {
//    case Nil => Nil
//    case Cons(h, t) if (f(h)) => Cons(h, filter(t, f))
//    case Cons(_, t) => filter(t, f)
//  }
//
//  def foldr[A, B](l: List[A], f: (A, B) => B, i: B): B = l match {
//    case Nil => i
//    case Cons(h, xs) => f(h, foldr(xs, f, i))
//  }
//
//  def foldRight[A,B](as: List[A], i: B)(f: (A, B) => B): B = as match {
//    case Nil => i
//    case Cons(x,xs) => f(x, foldRight(xs, i)(f))
//  }
//
//  def sum2(l: List[Int]) =
//    foldRight(l, 0)((x, y) => x + y)
//
//  def product2(l: List[Double]) =
//    foldRight(l, 1.0)(_ * _)

}