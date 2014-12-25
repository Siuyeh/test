package TestTrait

/**
 * 10.6-在特质中重写抽象方法
 */
trait Monk {
  val age = 60
  
  println("无耻的老和尚！")//这是特质构造器的一部分，上面的age同样是特质构造器的一部分
  
  /**
   * 10.8
   */
//  val id:Int//这里如果给的只是抽象字段则需要在实现该特质的类中初始化该字段

  def chanting(essay : String)
  
  def chanting01(essay : String) {chanting("this is a shamelsee monk : " + essay)}//这里调用了未初始化的chanting
}