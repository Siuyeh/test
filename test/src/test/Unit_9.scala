package test

import scala.io.Source
import java.io.FileInputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.FileWriter
import java.io.ObjectOutputStream
import java.io.FileOutputStream
import scala.sys.process._

object Unit_9 {
  def main(args: Array[String]): Unit = {
//    nine_1
//    nine_2
//    nine_3
//    nine_4
//    nine_5
//    nine_6
//    nine_7
//    nine_8
//    nine_9
//    nine_10
    nine_11
  }
  
  /**
   * 9.1-从文件中按行读取
   */
  def nine_1{
    val source = Util.getTextSource
    val lineIterator = source.getLines()//得到一个迭代器
    for(l <- lineIterator) println(l)
    source.close()
    
    Util.partSplit
  }
  
  /**
   * 9.2-从文件中读取单个字符
   */
  def nine_2{
    //将source直接当作迭代器
    var source = Util.getTextSource
    for(w <- source) println(w)
    source.close()
    Util.barSplit
    
    //使用buffered查看而不改变原本迭代器中内容
    source = Util.getTextSource
    val iter = source.buffered
    while(iter.hasNext){
      if(iter.head.equals('a'))
        print(iter.head)
      iter.next()
    }
    source.close()
    Util.barSplit
    
    //将整个文件读取成字符串
    source = Util.getTextSource
    val contents = source.mkString
    println(contents)
    source.close()
    
    Util.partSplit
  }
  
  /**
   * 9.3-读取词法单元和数字
   */
  def nine_3{
    //以空格分开的词法单元
    var source = Util.getNumSource
    val contents = source.mkString.split("\\s+")
    contents.foreach(println)
    val numbers = for(num <- contents) yield num.toDouble
    numbers.foreach(println)
    source.close()
    Util.barSplit
    
    //从控制台读取内容
    println("How old are you?")
    val age = Console.readInt
    println("age is "+age)
    
    Util.partSplit
  }
  
  /**
   * 9.4-从URL或其它源读取
   */
  def nine_4{
    //从字符串中读取
    var source = Source.fromString("Hello world!")
    val str = source.mkString
    println(str)
    source.close()
    Util.barSplit
    
    //从标准输入读取
    println("请输入内容")
    source = Source.stdin
    source.getLines().foreach(println)
    source.close()
    
    Util.partSplit
  }
  
  /**
   * 9.5-读取二进制文件
   */
  def nine_5{
    //读取二进制文件需要使用Java类库
    val file = new File("myfile.txt")
    var in : FileInputStream = null
    try {
      in = new FileInputStream(file)
//      var source = Source.fromInputStream(in, "UTF-8")//Scala从Java的流中读取完毕后会自动将流关闭
//      println(source.mkString)
//      source.close()
//      Util.barSplit
      
      val bytes = new Array[Byte](file.length().toInt)
      in.read(bytes)//将读取到的内容装到字节数组中
      println(new String(bytes))
    } catch {
      case ex: FileNotFoundException => ex.printStackTrace()
    } finally {
      in.close()
    }
    
    Util.partSplit
  }
  
  /**
   * 9.6-写入文本文件
   */
  def nine_6{
    var out : FileWriter = null
    try{
      out = new FileWriter("write.txt", true)
      for (num <- 0 to 3) {
        out.write(num.toString())//此处直接给数字会写入的是乱码，不知如何解决
      }
    }catch{
      case ex:FileNotFoundException => ex.printStackTrace()
    }finally{
      out.close()
    }
    
    Util.partSplit
  }
  
  /**
   * 9.7-访问目录
   */
  def nine_7{
    //访问某个目录下所有子目录的方法
    def subdirs(dir : File) : Iterator[File] = {
      val children = dir.listFiles().filter(_.isDirectory())
      children.toIterator ++ children.toIterator.flatMap(subdirs _)
    }
    
    val file = new File("D:\\eclipse")
    subdirs(file).foreach(println)
    
    Util.partSplit
  }
  
  /**
   * 9.8-序列化
   */
  def nine_8{
    val person = new Person("Mary", 18, List("mm", "xx"))//集合类都是可以序列化
    val out = new ObjectOutputStream(new FileOutputStream("person.obj"))
    out.writeObject(person)
    out.close
    
    Util.partSplit
  }
  
  /**
   * 9.9-进程控制
   */
  def nine_9{
    "ls -al"!
  }
  
  /**
   * 9.10-正则表达式
   */
  def nine_10{
    //使用String的r方法即可创建一个正则表达式
    val numPattern = "[0-9]+".r//得到的是一个Regex对象
    //获取所有匹配项
    for(str <- numPattern.findAllIn("99 bottles, 98 bottles")) println(str)//可以用for直接迭代处理
    val matchs = numPattern.findAllIn("99 bottles, 98 bottles").toArray//也可以获取迭代器后处理成数组等
    matchs.foreach(println)
    Util.barSplit
    
    //获取首个匹配项
    val first = numPattern.findFirstIn("99 bottles, 98 bottles")//获取到一个Option[String]
    println(first.getOrElse("nothing"))
    Util.barSplit
    
    //检查某个字符串的开始部分是否能匹配
    val initial = numPattern.findPrefixOf("99 bottles, 98 bottles")//得到一个Option[String]
    println(initial.getOrElse("nothing"))
    Util.barSplit
    
    //替换首个匹配项
    val replaceFirst = numPattern.replaceFirstIn("99 bottles, 98 bottles", "HERE")//得到一个String
    println(replaceFirst)
    val replaceAll = numPattern.replaceAllIn("99 bottles, 98 bottles", "HERE")
    println(replaceAll)
//    val replaceSome = numPattern.replaceSomeIn("99 bottles, 98 bottles", )不会用
    
    Util.partSplit
  }
  
  /**
   * 9.11-正则表达式组
   */
  def nine_11{
    //一个匹配项
    val matcher = "([0-9]+) ([a-z]+)".r
    val matcher(num, word) = "99 bottles"
    println("num is :"+num)
    println("word is :"+word)
    Util.barSplit

    //多个匹配项，这个用起来感觉还是很爽
    for (matcher(nums, words) <- matcher.findAllIn("它可以从99 bottles98 forword中提取，100 power")) {
      println("nums is :" + nums)
      println("words is :" + words)
    }
  }
}