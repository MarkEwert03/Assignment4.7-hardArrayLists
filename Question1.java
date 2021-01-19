//Mark Ewert
//Jan 12, 2021

import java.util.*;

public class Question1{
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        //prompt
        System.out.println("Pick a number to find all the primes below it");
        int number = sc.nextInt();
        
        //outputs answer
        System.out.println("List of primes below " + number + " is");
        System.out.println("" + primes(number));
    }

    public static ArrayList<Integer> primes(int n){
        //making the list that will be returned
        ArrayList<Integer> primeList = new ArrayList<Integer>();

        //filling the list with all numbers from 2-n
        for (int i = 2; i <= n; i++){
            primeList.add(i);
        }

        int currentIndex = -1; //ends up starting as 0
        //loops through each subsequent number in the shrinking list, that could be divisible by other numbers
        while (currentIndex < primeList.size()-1) {
            //moves to next index of primeList
            currentIndex++;
            int p = primeList.get(currentIndex);
            
            //starting at currentNum, loops through all remaining indecies to see if the current number is divisible by p
            for (int i = currentIndex+1; i < primeList.size(); i++){
                //if current index in divisible by the current number, remove it
                if (primeList.get(i) % p == 0) {
                    primeList.remove(i);
                    i--;
                }
            }
            
        }
        return primeList;
    }

}
