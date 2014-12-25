package TestTrait

/**
 * 10.6-在特质中重写抽象方法
 */
trait Abbot extends Monk{

  //重写Monk中的chanting抽象方法
  abstract override def chanting(essay : String) {
    super.chanting("the shameless monk is reciting " + essay)//此处的chanting没有定义
  }
}