package test

import scala.io.BufferedSource
import scala.io.Source

object Util {

  def partSplit{
    println("\n"+"-"*40+"本小节完，以下为下一小节内容"+"-"*40+"\n")
  }
  
  def barSplit{
    println("\n"+"-"*40+"以下内容为本小节下一知识点"+"-"*40+"\n")
  }
  
  def getTextSource : BufferedSource = {
    Source.fromFile("myfile.txt", "UTF-8")
  }
  
  def getNumSource : BufferedSource = {
    Source.fromFile("number.txt", "UTF-8")
  }
}