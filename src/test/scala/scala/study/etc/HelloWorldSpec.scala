package scala.study.etc

import org.scalatest.FunSpec

class HelloWorldSpec extends FunSpec {
  it("HelloWorldと出力する") {
    println("Hello world")
  }

  it("HelloWorld classを扱う") {
    val hello = new HelloWorld()
    assert(hello.say("nnno") == "Hello, nnno!")
  }
}

