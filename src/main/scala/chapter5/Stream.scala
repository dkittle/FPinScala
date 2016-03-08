package chapter5

import Stream._
import scala.annotation.tailrec


sealed trait Stream[+A] {

  def headOption: Option[A] =
    foldRight(Option.empty[A])((a, _) => Some(a))

  def toList: List[A] = {
    @tailrec
    def go(s: Stream[A], acc: List[A]): List[A] = s match {
      case Cons(h, t) => go(t(), acc :+ h())
      case _ => acc
    }
    go(this, List())
  }

  /*
  Write the function take(n) for returning the first n elements of a Stream, and
  drop(n) for skipping the first n elements of a Stream.
   */
  def take(n: Int): Stream[A] = this match {
    case Cons(h, t) if n > 0 => cons(h(), t().take(n-1))
    case _ => empty
  }

  def takeUnfold(n: Int): Stream[A] = {
    Stream.unfold((this, n))({
      case (Cons(h, t), n) if n > 0 => Some(h(), (t(), n + 1))
      case _ => None
    })
  }

  def drop(n: Int): Stream[A] = {
    @tailrec
    def go(s: Stream[A], count: Int): Stream[A] = s match {
      case Cons(h, t) if count > 0 => go(t(), count - 1)
      case _ => s
    }
    go(this, n)
  }

  def exists1(p: A => Boolean): Boolean = this match {
    case Cons(h, t) => p(h()) || t().exists1(p)
    case _ => false
  }

  def foldRight[B](z: => B)(f: (A, => B) => B): B = this match {
    case Cons(h, t) => f(h(), t().foldRight(z)(f))
    case _ => z
  }

  def takeWhile(p: A => Boolean): Stream[A] =
    foldRight(Stream[A]())((a, b) => if (p(a)) cons(a, b) else Empty)

  def takeUnfoldWhile(f: A => Boolean): Stream[A] = {
    Stream.unfold(this)({
      case Cons(h, t) if f(h()) => Some((h(), t()))
      case _ => None
    })
  }

  def exists(p: A => Boolean): Boolean =
    foldRight(false)((a,b) => p(a) || b)

  /*
  Implement forAll, which checks that all elements in the Stream match a given predicate.
  Your implementation should terminate the traversal as soon as it encounters a
  nonmatching value.
   */
  def forAll(p: A => Boolean): Boolean =
    foldRight(true)((a,b) => p(a) && b)


  def map[B](f: A => B): Stream[B] =
    foldRight(Stream[B]())((a,b) => cons(f(a), b))

  def mapUnfold[B](f: A => B): Stream[B] =
    Stream.unfold(this)({
      case Cons(h, t) => Some((f(h()), t()))
      case _ => None
    })

  def filter(f: A => Boolean): Stream[A] =
    foldRight(Stream[A]())((a,b) => if (f(a)) cons(a, b) else b)

  def append[B>:A](s: => Stream[B]): Stream[B] =
    foldRight(s)((a,b) => cons(a, b))

  def flatMap[B](f: A => Stream[B]): Stream[B] =
    foldRight(Stream[B]())((a,b) => f(a) append(b))

  def ones: Stream[Int] = cons(1, ones)

  def constant[A](a: A): Stream[A] = cons(a, constant(a))

  def from(n: Int): Stream[Int] =
    cons(n, from(n+1))

  /*
  Write a more general stream-building function called unfold. It takes an initial state,
and a function for producing both the next state and the next value in the generated
stream.
   */


}

case object Empty extends Stream[Nothing]
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

object Stream {

  def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = {
    f(z) match {
      case Some((a, zprime)) => cons(a, unfold(zprime)(f))
      case _ => Stream.empty
    }
  }

  def fibs: Stream[Int] = {
    def go(n1: Int, n2: Int): Stream[Int] =
      cons(n1, go(n2, n1 + n2))
    go(0, 1)
  }

  def fibsFrom(from: Int): Stream[Int] = {
    fibs.drop(from)
  }

  // Smart constructor that ensures hunks are only evaluated once by memoizing by-name arguments with a lazy val
  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
    lazy val head = hd
    lazy val tail = tl
    Cons(() => head, () => tail)
  }

  def empty[A]: Stream[A] = Empty

  def apply[A](as: A*): Stream[A] =
    if (as.isEmpty) empty else cons(as.head, apply(as.tail: _*))

}
