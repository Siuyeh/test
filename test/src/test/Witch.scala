package test

import TestTrait.TestTrait01
import TestTrait.TestTrait02
import TestTrait.TestTrait03

/**
 * 10.1-为什么没有多重继承
 */
//此处写为抽象类是因为我不想在这里实现特质中的抽象方法
abstract class Witch01 extends TestTrait01 {

}

/**
 * 10.2-当作接口使用的特质
 */
//可以实现多个特质
class Witch02 extends TestTrait01 with TestTrait02{

  override def curse(animal: String) {println("you will become a " + animal)}
  
  def conjure(incantation : String) {println("incantation")}//不需要override关键字
}

/**
 * 10.3-带有具体实现的特质
 */
class Witch03 extends TestTrait01 with TestTrait02{

  def curse(animal: String) {println("you will become a " + animal)}
  
  def conjure(incantation : String) {println("incantation")}
}

/**
 * 10.4-带有特质的对象
 */
//即使这里不实现TestTrait03，也依然可以构造带有Fly特质的对象
class Witch04 extends TestTrait03 {
  
}