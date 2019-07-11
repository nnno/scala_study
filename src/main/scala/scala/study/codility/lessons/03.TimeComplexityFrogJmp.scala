/**
  * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
  */
package scala.study.codility.lessons

object TimeComplexityFrog {
  def solution(x: Int, y: Int, d: Int): Int = {
    val a = y - x
    (a % d) match {
      case 0 => a / d
      case _ => a / d + 1
    }
  }
}
