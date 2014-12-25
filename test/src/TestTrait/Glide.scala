package TestTrait

/**
 * 10.5-叠在一起的特质
 */
trait Glide extends TestTrait03{
  //此处的super其实指的是这个特质的上一个叠加特质
  override def fly(broom : String) {super.fly(if("Jack".equals(broom)) "Jackfrued" else broom)}
}