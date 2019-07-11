/**
  * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
  */
package scala.study.codility.lessons

object ArraysOddOccurrencesInArray {
  // Note:
  // 単純に全ての重複チェック結果を格納するとパフォーマンスが出ない
  // XOR演算するのがミソらしい。勉強になった。
  def solution(a: Array[Int]): Int = {
    var result = 0
    a.foreach { v =>
      result = result ^ v
    }
    result
  }
}
