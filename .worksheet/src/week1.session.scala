package week1

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(347); 

	def sqrt(x: Double) : Double = {

	def sqrtIter(guess: Double) : Double =
		if(isGoodEnough(guess)) guess
		else sqrtIter(improve(guess))

 	def isGoodEnough(guess: Double) : Boolean =
 		abs(guess * guess - x) / x < 0.001
 		
 	def improve(guess: Double) : Double =
 		(guess + x / guess) / 2


	sqrtIter(1.0)
 };System.out.println("""sqrt: (x: Double)Double""");$skip(58); 
 
 	def abs(x: Double) : Double =
 		if(x<0) -x
 		else x;System.out.println("""abs: (x: Double)Double""");$skip(57); val res$0 = 
 		
 		
 		//////////////////////////
 		
 		
 		sqrt(2);System.out.println("""res0: Double = """ + $show(res$0));$skip(11); val res$1 = 
 		sqrt(4);System.out.println("""res1: Double = """ + $show(res$1));$skip(14); val res$2 = 
 		sqrt(1e-6);System.out.println("""res2: Double = """ + $show(res$2));$skip(14); val res$3 = 
 		sqrt(1e60);System.out.println("""res3: Double = """ + $show(res$3));$skip(34); val res$4 = 
 		
 		
 		//tests
 		sqrt(0.001);System.out.println("""res4: Double = """ + $show(res$4));$skip(15); val res$5 = 
 		sqrt(1e-20);System.out.println("""res5: Double = """ + $show(res$5));$skip(16); val res$6 = 
 		sqrt(1.0e20);System.out.println("""res6: Double = """ + $show(res$6));$skip(16); val res$7 = 
 		sqrt(1.0e50);System.out.println("""res7: Double = """ + $show(res$7))}
}
