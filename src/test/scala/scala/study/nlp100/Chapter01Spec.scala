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

  // 単語単位のn-gram関数
  def ngram(target:  List[String], n: Int): List[List[String]] = target.sliding(n).toList
  // 文字単位のn-gram関数
  def ngram(target: => List[Char], n: Int): List[String]       = target.sliding(n).map(p => p.mkString).toList

  it("05. n-gram") {
    val target = "I am an NLPer"
    val chars = target.toList
    val words = target.split(" ").toList

    // 文字単位のuni-gram, bi-gram, tri-gram
    assert(ngram(chars, 1) == List("I", " ", "a", "m", " ", "a", "n", " ", "N", "L", "P", "e", "r"))
    assert(ngram(chars, 2) == List("I ", " a", "am", "m ", " a", "an", "n ", " N", "NL", "LP", "Pe", "er"))
    assert(ngram(chars, 3) == List("I a", " am", "am ", "m a", " an", "an ", "n N", " NL", "NLP", "LPe", "Per"))

    // 単語単位のuni-gram, bi-gram, tri-gram
    assert(ngram(words, 1) == List(List("I"), List("am"), List("an"), List("NLPer")))
    assert(ngram(words, 2) == List(List("I", "am"), List("am", "an"), List("an", "NLPer")))
    assert(ngram(words, 3) == List(List("I", "am", "an"), List("am", "an", "NLPer")))
  }

  it("06. 集合") {
    val x = ngram("paraparaparadise".toList, 2).toSet
    val y = ngram("paragraph".toList, 2).toSet
    // x, y
    assert(x               == Set("ar", "se", "di", "is", "pa", "ap", "ad", "ra"))
    assert(y               == Set("ar", "gr", "ph", "ra", "pa", "ap", "ag"))
    // 和集合
    assert((x union y)     == Set("ar", "gr", "se", "ph", "di", "is", "pa", "ap", "ad", "ra", "ag"))
    // 積集合
    assert((x intersect y) == Set("ar", "ap", "pa", "ra"))
    // 差集合
    assert((x diff y)      == Set("di", "is", "se", "ad"))
    // xに"se"が含まれるか (含まれる)
    assert(x contains "se")
    // yに"se"が含まれるか (含まれない)
    assert(!(y contains "se"))
  }

  it("07. テンプレートによる文生成") {
    def func(x: Int, y: String, z: Double) = s"${x}時の${y}は$z"
    assert(func(12, "気温", 22.4) == "12時の気温は22.4")
  }

}

