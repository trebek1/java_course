package com.example.mypackage;

/**
 * Created by Alex on 12/21/16.
 */
public class Series {
    public static int nSum(int n){
        int sum = 0;
            //(0+1) + (0+2) + (0+3) + ... (n -1) + n = (n+1)(n/2);
        for( int i = 1; i<=n; i++){
            sum += i;
        }
        return sum;
    }

    public static int factorial(int n){
        int prod = 1;

        for(int i = 2; i<=n; i++){
            prod *= i;
        }
        return prod;
    }

    public static int fibonacci(int n){
        if((n - 1) == 0){
            return 0;
        }else if((n - 1) == 1){
            return 1;
        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }


}


