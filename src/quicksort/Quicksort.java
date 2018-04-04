/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;
import java.util.ArrayList;
import java.util.Random;


public class Quicksort {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        long time1 = 0, time2 = 0;

        for (int i = 0; i < 100; i++) {
            integers.add((int) (Math.random() * 100));
            
        }
            
            time1 = System.currentTimeMillis();
            System.out.println("Solved: " + quicksort(integers));
            time2 = System.currentTimeMillis();
            long time_tot = time2 - time1;
            System.out.println("Trial Took " + time_tot + "miliseconds");
    }
    
    
    public static ArrayList<Integer> quicksort(ArrayList<Integer> integers) {

        if(solved(integers) == -2){
            return integers;
        }
        
        //System.out.println("New QuickSort");
        //System.out.println(integers);

        int pivot = integers.get(0);
        int pivotCount = 0;

        int countEnd = integers.size();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<Integer> biggerTemp = new ArrayList<Integer>();

        for(int i = 1; i < integers.size(); i++){
            if(integers.get(i) < pivot){
                temp.add(integers.get(i));
                pivotCount++;
            }
            else{
                biggerTemp.add(integers.get(i));
            }
        }

        temp.add(pivot);
        for(int elem: biggerTemp){
            temp.add(elem);
        }

        integers = temp;

        //System.out.println("Sorted " + integers);

        if(solved(integers) != -2){
            //System.out.println("Solved: " + solved(integers));

            ArrayList<Integer> a = new ArrayList<Integer>();
            
            for(int i = 0; i < pivotCount; i++){
                a.add(integers.get(i));
            }

            //System.out.println(a + " 2");
            a = quicksort(a);
            //System.out.println("Came back out!" + a);
            //System.out.println("Current ints " + integers);

            for(int i = 0; i < a.size(); i++){
                //System.out.println("Checkpoint " + i);
                integers.set(i, a.get(i));
                //System.out.println("Sorted 2.0 " + integers);

            }
        }

        ArrayList<Integer> a = new ArrayList<Integer>();

        if(solved(integers) != -2){
            for(int i = pivotCount + 1; i < integers.size(); i++){
                a.add(integers.get(i));
            }
            a = quicksort(a);

            //System.out.println("Came out 2.0!");
            int count = 0;
            
            for(int i = pivotCount + 1; i < integers.size(); i++){ 
                //System.out.println("ints " + integers);
                //System.out.println("a " + a);
                
                //System.out.println(count + "c " + i + "i "  + a.get(count));
                integers.set(i, a.get(count));
                count++;
                 
            }
        }

        return integers;
    }
    
    public static int solved(ArrayList<Integer> integers) {
        if(integers.size() <= 1){
            return -2;
        }
        
        for(int i = 1; i < integers.size(); i++){
            if(integers.get(i-1) > integers.get(i)){
                return i;
            }
        }
        return -2;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
    }
}
