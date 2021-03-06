
/*
 * @author Preston Porter
 * date 10/2/2018
 * Implement a Polynomial class
 * */
public class Polynomial implements Cloneable{
  
  double[]  x; //name of the array is x
  private int degree;

public Polynomial () 
{
  //private int[] data;
 degree=0;
  x = new double[10];
  x[degree]=0;
}
public Polynomial (double a0) 
{
  x = new double[10];
  x[0]=a0;
}

/*public Polynomial (double a2,double a1, double a0) 
{
  x = new double[10];
  x[0]=a0;

  x[1]=a1;

  x[2]=a2;
}*/
public Polynomial clone( ){  // Clone a Polynomial object.
     Polynomial answer;

      try
      {
         answer = (Polynomial) super.clone( );
                 
      }
      catch (CloneNotSupportedException e)
      {  // This exception should not occur. But if it does, it would probably
         // indicate a programming error that made super.clone unavailable.
         // The most common error would be forgetting the "Implements Cloneable"
         // clause at the start of this class.
         throw new RuntimeException
            ("This class does not implement Cloneable.");
      }

      return answer;
   }
public Polynomial (Polynomial P) 
{
  
    //Polynomial newP = new Polynomial();// = (Polynomial) P.clone();
    x =P.x.clone();
}

   public void add_to_coef(double amount, int exponent)
   {
     
     if(exponent > this.x.length-1)
     {
      double[] newX = new double[exponent+1];
      
       System.arraycopy(this.x,0,newX,0,this.x.length);
       x= newX;
        x[exponent] = x[exponent]+amount;
       //degree =exponent;
     }
     else 
     x[exponent] = x[exponent]+amount;
     
   } 
   
   
   public void assign_coef(double coefficent, int exponent)
   {
     if(exponent > this.x.length-1)
     {
      double[] newX = new double[exponent+1];
      
       System.arraycopy(this.x,0,newX,0,this.x.length);
       x= newX;
        x[exponent] = coefficent;
       //degree =exponent;
     }
     else 
     x[exponent] = coefficent;
     
   } 
  /**
     * POSTCONDITION: Returns coefficient at specified exponent of this polynomial.
     Note: the exponent is allowed to be greater than the degree of the polynomial
     e.g. if p = x + 1; p.coeffcient(3) should return 0
     * @param exponent
     */
   public double coefficient(int exponent)
   {
     if (exponent>this.x.length+1)
     {return 0;}
    else return x[exponent];
   }
   
    /**
     * Returns the result of evaluating this polynomial at the point x.
     *
     * POSTCONDITION: The return value is the value of this polynomial with the given value for the variable x.
     * @param  x the point at which to evaluate the polynomial
     */
   public double evaluate(int x) {
        double p = 0;
        for (int i = this.x.length -1; i>=0;i--) {
          p = this.x[i] + (x * p);
        
        } 
        
        return p;
    }
   
  /*POSTCONDITION:
                this object and p are not changed   
                return a polynomial that is the sum of   p and this polynomial */
   public Polynomial add(Polynomial p)
   {
     
   
    Polynomial newP = new Polynomial(this);
    newP.x = new double[this.x.length+newP.x.length+1];
    
   if(p.x.length >this.x.length)
    {
      for(int i=0;i<p.x.length;i++)
      {
        newP.x[i]=this.x[i]+p.x[i];
      }
    }
    if(this.x.length >p.x.length)
    {
      for(int i=0;i<this.x.length;i++)
      {
        newP.x[i]=this.x[i]+p.x[i];
      }
    }
    else {
        for(int i=0;i<this.x.length;i++)
      {
        newP.x[i]=this.x[i]+p.x[i];
        }}
    return newP;
   }
   /**
     * POSTCONDITION:
     this object and p should not be changed
     returns a new polynomial obtained by multiplying this term and p. For example, if this polynomial is
     2x^2 + 3x + 4 and p is 5x^2 - 1x + 7, then at the end of this function, it will return the polynomial 10x^4 + 13x^3 + 31x^2 + 17x + 28.
     * @param p
     * @return
     */
public Polynomial multiply(Polynomial p)
{
  Polynomial newP =new Polynomial();

  for(int i =0; i< p.x.length; i++)
  {
    for( int j=0; j< this.x.length; j++)
    {
      newP.add_to_coef(p.x[i] * this.x[j], i + j);

    }
  }
  return newP;
}

public String toString()
     {
        String s1 ="";
       
        for(int i=this.x.length-1; i>=0; i--)
        {
          if(this.x[i]!=0 &&this.x.length>1) //if coefficient is 0 it will not be added to string unless the polynomial is 0
          {
          if(i==1)
          {s1+=this.x[i]+"x"+" + ";}
          
          if(i==0)
          {s1+= +this.x[i];}
          
          if(i>1)
          {s1 += this.x[i]+"x^"+i+" + ";}
          }
          else if(i==0){ s1+= this.x[i];} //if polynomial is 0
        }
             return s1;
     }
public static void main(String[] args){
   

    Polynomial p1= new Polynomial();
    System.out.println("Default Constructor "+ p1.toString());
    Polynomial p2= new Polynomial(2);
    System.out.println(p2.toString());
 
    
    Polynomial p3= new Polynomial(p2);
   System.out.println( p3.toString());
   p3.add_to_coef(1,2);
   System.out.println( p3.toString());
   p3.assign_coef(2,3);
   System.out.println( p3.toString());
   System.out.println( p3.coefficient(3));
   System.out.println(p3.evaluate(2));
   Polynomial p4 = p3.add(p3);
   
   System.out.println( p4.toString());
    System.out.println( p3.multiply(p3));
  
 }

  
}