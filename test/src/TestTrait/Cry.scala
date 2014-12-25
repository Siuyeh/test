package TestTrait

import java.io.PrintStream

trait Cry {

  val voice:String
  
  lazy val out = new PrintStream(voice)//不使用这个就可以进行重写了，为什么还需要这句话？
  
  def init(v : String) {out.println(v)}
}