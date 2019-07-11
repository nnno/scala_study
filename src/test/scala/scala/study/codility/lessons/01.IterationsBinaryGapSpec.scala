package scala.study.codility.lessons

import org.scalatest.FunSpec

class BinaryGapSpec extends FunSpec {
  it("Example test N=1041 returns 5") {
    assert(BinaryGap.solution(1041) == 5)
  }
  it("Example test N=15 returns 0") {
    assert(BinaryGap.solution(15) == 0)
  }
  it("Example test N=32 returns 0") {
    assert(BinaryGap.solution(32) == 0)
  }
}

