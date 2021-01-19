//Mark Ewert
//Jan 13, 2021

import java.util.ArrayList;
import java.util.Scanner;

public class Question2{
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        int number = sc.nextInt();
        System.out.println("" + evenPrimePair(number));
    }

    public static String evenPrimePair(int n){
        ArrayList<Integer> primeList = primes(n);
        for (int s = 0; s < primeList.size(); s++){
            int small = primeList.get(s);
            int big = n - small;
            if (primeList.contains(big)) return "" + small + " + " + big;
        }
        
        //bug checker
        return "uh oh, something went wrong";
    }

    public static ArrayList<Integer> primes(int n){
        //making the list that will be returned
        ArrayList<Integer> primeList = new ArrayList<Integer>();

        //filling the list with all numbers from 2-n
        for (int i = 2; i <= n; i++){
            primeList.add(i);
        }

        int currentNum = -1; //ends up starting as 0
        //loops through each subsequent number in the shrinking list, that could be divisible by other numbers
        while (currentNum < primeList.size()-1) {
            //moves to next index of primeList
            currentNum++;
            int p = primeList.get(currentNum);

            //starting at currentNum, loops through all remaining indecies to see if the current number is divisible by p
            for (int i = currentNum+1; i < primeList.size(); i++){
                if (primeList.get(i) % p == 0) {
                    primeList.remove(i);
                    i--;
                }
            }
        }
        return primeList;
    }
}

