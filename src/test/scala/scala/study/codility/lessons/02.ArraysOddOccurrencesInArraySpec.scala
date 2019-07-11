package scala.study.codility.lessons

import org.scalatest.FunSpec

class ArraysOddOccurrencesInArraySpec extends FunSpec {
  it("Example test Array(9, 3, 9, 3, 9, 7, 9) returns 7") {
    val input  = Array(9, 3, 9, 3, 9, 7, 9)
    val except = 7

    assert(ArraysOddOccurrencesInArray.solution(input) == except)
  }
}

