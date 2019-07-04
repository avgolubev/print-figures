package printfigures

import org.scalatest._
import Figures._

class TablePrinterSpec extends FlatSpec with Matchers {
  
  "Created html of two equal objects" should "equal" in {
    (TablePrinter() | Car).toString() should equal ((TablePrinter() | Car).toString())
  }
  
  "The number of printing figures" should "equal" in {
    (TablePrinter() | Car || Car | Pizza).figures.size should equal (3)
  }  
  
}
