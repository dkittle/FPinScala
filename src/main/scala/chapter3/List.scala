package chapter3

import scala.annotation.tailrec

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def tail[A](as: List[A]): List[A] = as match {
    case Nil => Nil
    case Cons(h, t) => t
  }

  def setHead[A](as: List[A], a: A): List[A] = as match {
    case Nil => Cons(a, Nil)
    case Cons(h, t) => Cons(a, t)
  }

  @tailrec
  def drop[A](l: List[A], n: Int): List[A] = l match {
    case Nil => Nil
    case l if n > 0 => drop(tail(l), n - 1)
    case l => l
  }

  @tailrec
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(h, t) if f(h) => dropWhile(t, f)
    case _ => l
  }

  def append[A](a1: List[A], a2: List[A]): List[A] = a1 match {
    case Nil => a2
    case Cons(h, t) => Cons(h, append(t, a2))
  }

  def init[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(h, Nil) => Nil
    case Cons(h, t) => Cons(h, init(t))
  }

  def filter[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(h, t) if (f(h)) => Cons(h, filter(t, f))
    case Cons(_, t) => filter(t, f)
  }

  def foldr[A, B](l: List[A], f: (A, B) => B, i: B): B = l match {
    case Nil => i
    case Cons(h, xs) => f(h, foldr(xs, f, i))
  }
}