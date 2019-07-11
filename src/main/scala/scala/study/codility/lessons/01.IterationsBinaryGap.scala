/**
  * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
  */
package scala.study.codility.lessons

object BinaryGap {
  def solution(n: Int): Int = {
    // Note: 正規表現の先読み, 後読み
    val list = "(?<=1)0+(?=1)".r.findAllIn(n.toBinaryString).toList
    if (list.isEmpty) 0
    else list.maxBy(_.length).length
  }
}