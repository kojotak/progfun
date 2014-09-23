package week2

object sum {
  
  
  def sumHighOrderFunction (f: Int => Int, a: Int, b: Int) : Int = {
  	def loop(a: Int, acc: Int) : Int = {
  		if(a > b) acc
  		else loop(a +1 , f(a) + acc )
  	}
  	loop(a, 0);
  }                                               //> sumHighOrderFunction: (f: Int => Int, a: Int, b: Int)Int
  
  def sumCurrying (f: Int => Int)  : (Int, Int) => Int = {
  	def sumF(a: Int, b: Int): Int =
  		if(a > b) 0
  		else f(a) + sumF(a+1, b)
  		
  	sumF
  }                                               //> sumCurrying: (f: Int => Int)(Int, Int) => Int
  
  def sumNested (f: Int => Int)(a: Int, b: Int): Int =
  	if( a > b ) 0 else f(a) + sumNested(f)(a +1, b)
                                                  //> sumNested: (f: Int => Int)(a: Int, b: Int)Int
  
	sumHighOrderFunction( x => x * x , 3, 5)  //> res0: Int = 50
	
	sumCurrying(x => x * x) (3, 5)            //> res1: Int = 50
	
	sumNested( x=> x * x) (3, 5)              //> res2: Int = 50
	
}