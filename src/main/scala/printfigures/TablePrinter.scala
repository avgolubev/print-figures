package printfigures

abstract class Figure {
  def td: String
  val newLine = false 
}

private case class TransformedFigure(override val newLine: Boolean, val td: String) extends Figure 

class TablePrinter(val figures: Seq[Figure])  {  
  def |(that: Figure) = new TablePrinter(figures :+ TransformedFigure(false, that.td))
  def ||(that: Figure) = new TablePrinter(figures :+ TransformedFigure(true, that.td))
  
  override def toString(): String = {   
    var res = "<html><body><table><tr>"
    for(figure <- figures) {       
      if(figure.newLine) 
        res += "</tr><tr><td>" + figure.td + "</td>"
      else
        res += "<td>" + figure.td + "</td>"
    }
          
    res + "</tr></table></body></html>"
  }  
}

object TablePrinter {
  def apply() = new TablePrinter(List()) 
}
