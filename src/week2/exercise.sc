package week2

object exercise {

  def product(f: Int => Int)(a:Int, b:Int): Int=
  		if( a > b ) 1
  		else f(a) * product(f)(a +1, b)   //> product: (f: Int => Int)(a: Int, b: Int)Int

	product(x => x*x)(3, 4)                   //> res0: Int = 144
  		
  //implementation of factorial in terms of product
  def factorial(x: Int): Int=
  	product(x => x)(1, x)                     //> factorial: (x: Int)Int
  
  factorial(1)                                    //> res1: Int = 1
  factorial(2)                                    //> res2: Int = 2
  factorial(3)                                    //> res3: Int = 6
  factorial(4)                                    //> res4: Int = 24
  factorial(5)                                    //> res5: Int = 120
  
  //generalalization of sum and product
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, unit: Int)(a: Int, b: Int) : Int =
  	if( a > b) unit
  	else combine( f(a), mapReduce(f, combine, unit)(a+1, b) )
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, unit: Int)(a: Int, b:
                                                  //|  Int)Int
  def productReduce(f: Int => Int)(a:Int, b:Int): Int=
  	mapReduce(f, (x, y) => x*y, 1)(a, b)      //> productReduce: (f: Int => Int)(a: Int, b: Int)Int
  	
  def sumReduce(f: Int => Int)(a:Int, b:Int): Int=
  	mapReduce(f, (x, y) => x+y, 0)(a, b)      //> sumReduce: (f: Int => Int)(a: Int, b: Int)Int
  	
  productReduce( x=> x*x)(3, 4)                   //> res6: Int = 144
  sumReduce( x=> x*x)(3,5)                        //> res7: Int = 50
}