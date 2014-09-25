package src.week2

object rationals {

	val r = new Rational(1,2)                 //> r  : src.week2.Rational = 1/2
	r.denom                                   //> res0: Int = 2
	r.numer                                   //> res1: Int = 1
	
	val s = new Rational(2,3)                 //> s  : src.week2.Rational = 2/3
	r.+(s)                                    //> res2: src.week2.Rational = 7/6
	r.-(s)                                    //> res3: src.week2.Rational = 1/-6
	
	val rNeg = r.neg                          //> rNeg  : src.week2.Rational = 1/-2
	
	val x = new Rational(1,3)                 //> x  : src.week2.Rational = 1/3
	val y = new Rational(5,7)                 //> y  : src.week2.Rational = 5/7
	val z = new Rational(3, 2)                //> z  : src.week2.Rational = 3/2
	
	x.-(y).-(z)                               //> res4: src.week2.Rational = -79/42
	
	y.+(y)                                    //> res5: src.week2.Rational = 10/7
	
	x.<(y)                                    //> res6: Boolean = true
	x.max(y)                                  //> res7: src.week2.Rational = 5/7
	
	//val strange = new Rational(1, 0)
	//strange.add(new Rational(1,1))
	
	val two = new Rational(2)                 //> two  : src.week2.Rational = 2/1
	
	//infix operations
	s + r                                     //> res8: src.week2.Rational = 7/6
}

class Rational(x: Int, y: Int){
	//precondition check, similar to assert
	require(y != 0, "denominator must not be zero")

	//alternative constructor
	def this(x: Int) = this(x,1)


	def numer = x
	def denom = y
	
	private val g = gcd(x,y)
	
	private def gcd(a: Int, b: Int): Int=
		if(b==0) a else gcd(b, a % b)
	
	def max(that: Rational)  = if(this.<(that)) that else this
	
	def <(that: Rational) = this.numer * that.denom < that.numer * this.denom
	
	def +(that: Rational)=
		new Rational(
			numer * that.denom + that.numer * denom,
			denom * that.denom
		)
		
	def unary_- : Rational = new Rational(-numer, denom)
		
	def -(that: Rational) = this + that.neg
	
	def neg() = new Rational(-numer, denom)
	
	override def toString = numer/g + "/" + denom/g
}