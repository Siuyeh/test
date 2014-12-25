package test

import TestTrait.Monk

/**
 * 10.7-当作富接口使用的特质
 */
class OldMonk extends Monk {
//  val id = 11
  
  def shameless(str : String) {
    chanting01(str)
  }

  override def chanting(essay: String){println(essay)}//这里 对chanting进行了初始化
}