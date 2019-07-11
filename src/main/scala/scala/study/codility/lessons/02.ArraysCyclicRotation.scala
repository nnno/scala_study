/**
  * https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
  */
package scala.study.codility.lessons

object ArraysCyclicRotation {
  def solution(a: Array[Int], k: Int): Array[Int] = {
    val size = a.length
    if (size != 0) {
      val k2 = k % size
      val (a1, a2) = a.splitAt(size - k2)
      a2 ++ a1
    } else {
      a
    }
  }
}
