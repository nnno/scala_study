package scala.study.codility.lessons

import org.scalatest.FunSpec

class CyclicRotationSpec extends FunSpec {
  it("Example test a=Array(3, 8, 9, 7, 6) k=3 returns Array(9, 7, 6, 3, 8)") {
    val a      = Array(3, 8, 9, 7, 6)
    val k      = 3
    val except = Array(9, 7, 6, 3, 8)
    assert(ArraysCyclicRotation.solution(a,k) sameElements except)
  }

  it("Example test a=Array(0,0,0) k=1 returns Array(0,0,0)") {
    val a      = Array(0, 0, 0)
    val k      = 1
    val except = Array(0, 0, 0)
    assert(ArraysCyclicRotation.solution(a,k) sameElements except)
  }

  it("Example test a=Array(1,2,3,4) k=4 returns Array(1,2,3,4)") {
    val a      = Array(1, 2, 3, 4)
    val k      = 4
    val except = Array(1, 2, 3, 4)
    assert(ArraysCyclicRotation.solution(a,k) sameElements except)
  }
}

