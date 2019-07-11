/**
  * https://app.codility.com/programmers/lessons/4-counting_elements/perm_check
  */
package scala.study.codility.lessons

object CountingElementsPermCheck {

  def solution(a: Array[Int]): Int = {
    // 入力値に重複があるかをチェックし、重複があれば0を返す
    val s: Set[Int] = a.toSet
    if (a.length != s.size) {
      0
    } else {
      // 要素を合算したものと、添え字(Int)を合算したものの結果が一致すれば1を返す
      val total = a.sum
      val sum = (1 to a.length).foldLeft(0)((z, n) => z + n)
      if (total == sum) 1 else 0
    }
  }
}
