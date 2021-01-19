//Mark Ewert
//Jan 13, 2021

import java.util.*;

public class Question3{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        //making empty ArrayLists
        ArrayList<Integer> bigInt1 = new ArrayList<Integer>();
        ArrayList<Integer> bigInt2 = new ArrayList<Integer>();

        //prompt 1
        System.out.println("Please add digits to your first bigInt:");
        System.out.println("[type \"next\" to move on to the next number]");

        //adding digits to first number
        String input = "";
        while (!input.equals("next")) {
            input = sc.next();
            if (input.matches("[0-9]")) bigInt1.add(Integer.parseInt(input));
            else if (!input.equals("next")) System.out.println("only single numbers please!");
        }

        //prompt 2
        System.out.println("Please add digits to your second bigInt");
        System.out.println("[type \"done\" to finish and add them]");

        //adding digits to second number
        while (!input.equals("done")) {
            input = sc.next();
            if (input.matches("[0-9]")) bigInt2.add(Integer.parseInt(input));
            else if (!input.equals("done")) System.out.println("only single numbers please!");
        }

        //result
        System.out.println("\n" + String.valueOf(bigInt1) + "\n+\n" + String.valueOf(bigInt2));
        System.out.println("=\n" + addBigInts(bigInt1, bigInt2));
    }

    public static ArrayList<Integer> addBigInts(ArrayList<Integer> bigInt1, ArrayList<Integer> bigInt2){
        //creating ArrayList that will be returned
        ArrayList<Integer> bigSum = new ArrayList<Integer>();
        
        //making the arrays the same size
        while (bigInt1.size() < bigInt2.size()) bigInt1.add(0, 0);
        while (bigInt2.size() < bigInt1.size()) bigInt2.add(0, 0);

        //adding each digit
        for (int i = 0; i < bigInt1.size(); i++) {
            int b1 = bigInt1.get(i);
            int b2 = bigInt2.get(i);
            bigSum.add(b1 + b2);
        }
        
        //carrying
        int size = bigSum.size();
        for (int i = size-1; i >= 0; i--){
            int num = bigSum.get(i);
            if (num >= 10) {
                bigSum.set(i, num-10);
                if (i != 0) bigSum.set(i-1, bigSum.get(i-1) + 1);
                else bigSum.add(0, 1);
            }
        }
        
        return bigSum;
    }

}
