/**
  * https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
  */
package scala.study.codility.lessons

import scala.math._

object TimeComplexityTapeEquilibrium {

  def solution(a: Array[Int]): Int = {
    val total   = a.foldLeft(0)(_ + abs(_))
    var forward = a(0)
    var best    = abs(total - (2 * forward))
    var test    = 0

    for (i <- 1 to (a.length - 1)) {
      forward = forward + a(i)
      test = abs(total - (2 * forward))
      if (test < best) {
        best = test
      }
    }
    best
  }

}
