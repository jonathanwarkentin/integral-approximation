import java.math.*;
public class IntApprox
{
    
    public static double currentFunction(double x){
        //example function
        double result = (1/Math.log(x));
        
        result = Math.round(result * 1000000.0) / 1000000.0;
        return result;
    }
    
    public static double trapezoidal(double a, double b, double n){
        double sum = 0;
        for (int i=0;i<=n;i++){
            double current = currentFunction(a+(i*((b-a)/n)));
            if (i!=0 && i!=n)
                current *= 2;
            sum += current;
        }
        return Math.round((sum*((b-a)/(2*n))) * 1000000.0) / 1000000.0;
    }
    
    public static double midpoint(double a, double b, double n){
        double sum = 0;
        double interval = (b-a)/n;
        for (int i=0;i<n;i++){
            double current = currentFunction(a+((i*interval)+((i+1)*interval))/2);
            sum += current;
        }
        return Math.round((sum*interval) * 1000000.0) / 1000000.0;
    }
    
    
    public static double simpsons(double a, double b, double n){
        double sum = 0;
        for (int i=0;i<=n;i++){
            double current = currentFunction(a+(i*((b-a)/n)));
            if (i!=0 && i!=n && (i+1)%2==0)
                current *= 4;
            else if (i!=0 && i!=n && i%2==0)
                current *= 2;
            sum += current;
        }
        return Math.round((sum*((b-a)/(3*n))) * 1000000.0) / 1000000.0;
    }
    
    public static void printResult(double a, double b, double n){
        System.out.println("Integral approximations:");
        System.out.println("Trapezoidal: " + trapezoidal(a,b,n));
        System.out.println("Midpoint: " + midpoint(a,b,n));
        System.out.println("Simpson's: " + simpsons(a,b,n));
    }
    
    public static void main(String[] args){
        printResult(4,5,10);
    }
}
