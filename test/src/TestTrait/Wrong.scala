package TestTrait

trait Wrong extends Exception{

  //注释掉以下两行，依然不能被其它类扩展
//  this : Exception => 
//    println("123")
}