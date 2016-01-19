package chapter3

/**
 * Created by don on 2016-01-18.
 */

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

//  def apply[A](l: Tree[A], r: Tree[A]): Tree[A] = {
//
//  }

//  def size[A](t: Tree[A]): Int = {
//    def count[A](t: Tree[A], acc: Int): Int = t match {
//      case Leaf(_) => _
//      case Branch(l,r) => size(l) + size(r)
//    }
//    count(t, 0)
//  }
}


