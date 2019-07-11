/**
  * https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
  */
package scala.study.codility.lessons

object TimeComplexityPermMissingElem {

  def solution(a: Array[Int]): Int = {
    // 配列が空の場合は1を返す
    if (a.length == 0) {
      1
    } else {
      // 入力値が大きいと、計算過程がInt型に収まらないのでLong型で計算する
      val n:     Long = a.length + 1L
      val total: Long = (n + 1) * n / 2
      val sum:   Long = a.sum.toLong
      (total - sum).toInt
    }
  }
}
