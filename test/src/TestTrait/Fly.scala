package TestTrait

/**
 * 10.5-叠在一起的特质
 */
trait Fly extends TestTrait03 {
  override def fly(broom : String) {println("I am fly with " + broom)}
}