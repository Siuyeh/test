package test

import scala.io.Source

object Test01 {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("myfile.txt", "UTF-8")
    
    //这里有一个有趣的现象，source只能使用一次，这是为何，难道是我打开的方式不对？
    //使用迭代器进行逐个处理
    println("从文件中按行读取：")
    val lineIterator = source.getLines()
    for(l <- lineIterator) println(l)
    println("---------")
    
//    val source1 = Source.fromFile("myfile.txt", "UTF-8")
    //将迭代器转化为数组然后便利处理
    val lines = source.getLines().toArray
    lines.foreach(println)
    println("----------------")
    
    println("将文件读取成一个字符串：")
    //将整个文件读取成一个字符串
    val contents = source.mkString
    println(contents)
    println("------------")
    
    println("从文件中读取单个字符：")
    val source2 = Source.fromFile("myfile.txt", "UTF-8")
    for(c <- source2) println(c)
    
    println("----------------")
    
    println("最后一个")
    val source3 = Source.fromFile("myfile.txt", "UTF-8")
    val iter = source3.buffered
    while(iter.hasNext){
      if(!iter.head.equals('a'))
        println(iter.head)
      iter.next()
    }
    source3.close
  }
}