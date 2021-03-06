package chapter3

/**
 * Created by don on 2016-01-18.
 */

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  def size[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(l, r) => size(l) + 1 + size(r)
  }

  def highestValue(t: Tree[Int]): Int = t match {
    case Leaf(v) => v
    case Branch(l, r) => highestValue(l) max highestValue(r)
  }

  def sum(t: Tree[Int]): Int = t match {
    case Leaf(v) => v
    case Branch(l, r) => sum(l) + sum(r)
  }

  def depth[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case (Branch(l, r)) => (depth(l) + 1) max (depth(r) + 1)
  }


}