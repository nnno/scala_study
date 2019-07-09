/**
  * 言語処理100本ノック 2015
  * 第1章: 準備運動
  *
  * http://www.cl.ecei.tohoku.ac.jp/nlp100/#ch1
  */
package scala.study.nlp100

import org.scalatest.{FunSpec, Matchers}

class Chapter01Spec extends FunSpec with Matchers {

  it("00. 文字列の逆順") {
    assert("stressed".reverse == "desserts")
  }

  it("01. 「パタトクカシーー」") {
    val r1 = "パタトクカシーー".zipWithIndex.collect {
      case (c, i) if i % 2 == 0 => c
    }.mkString
    assert(r1 == "パトカー")

    val r2 = for {
      (c, i) <- "パタトクカシーー".zipWithIndex if i % 2 == 0
    } yield c
    assert(r2.mkString == "パトカー")
  }

  it("02. 「パトカー」＋「タクシー」＝「パタトクカシーー」") {
    val r1 = ("パトカー" zip "タクシー").flatMap { case (v1, v2) => Seq(v1, v2) }.mkString
    assert(r1 == "パタトクカシーー")
  }

  it("03. 円周率") {
    val input = "Now I need a drink, alcoholic of course, after the heavy lectures involving quantum mechanics."
    val expect = Seq(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9)

    val result = input.split("""\W+""").map(_.length).toList
    assert(result == expect)
  }

  it("04. 元素記号") {
    val input = "Hi He Lied Because Boron Could Not Oxidize Fluorine. New Nations Might Also Sign Peace Security Clause. Arthur King Can."
    val expect = Map(
       1 -> "H",   2 -> "He", 3 -> "Li", 4 -> "Be", 5 -> "B",
       6 -> "C",   7 -> "N",   8 -> "O", 9 -> "F", 10 -> "Ne",
      11 -> "Na", 12 -> "Mi", 13 -> "Al", 14 -> "Si", 15 -> "P",
      16 -> "S",  17 -> "Cl", 18 -> "Ar", 19 -> "K",  20 -> "Ca"
    )

    val ones = Seq(1, 5, 6, 7, 8, 9, 15, 16, 19)  // 1文字

    val result = input.split("""\W+""").zipWithIndex.map {
      case (c, i) =>
        val t = if (ones.contains(i + 1)) 1 else 2
        (i + 1, c.take(t))
    }.toMap
    assert(result == expect)
  }
}

