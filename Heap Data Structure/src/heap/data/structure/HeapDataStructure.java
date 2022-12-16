package heap.data.structure;

import java.util.ArrayList;
import java.util.Scanner;

public class HeapDataStructure {
    
    
    public static boolean heapKontrol(ArrayList<Integer> arr){ //Liste, pointer ile işlem yaptığından void olmasında sorun yok
        boolean minHeaptır = true;
        
        for (int i = 0; i < arr.size() ; i++){
            if (3*i+1 < arr.size() && arr.get(i) > arr.get(3*i+1)){
                minHeaptır = false;
                break;
            }
            if (3*i+2 < arr.size() && arr.get(i) > arr.get(3*i+2)){
                minHeaptır = false;
                break;
            }
            if (3*i+3 < arr.size() && arr.get(i) > arr.get(3*i+3)){
                minHeaptır = false;
                break;
            }
        }
        
        return minHeaptır;   
    }
    
    public static void heapEkleme (ArrayList<Integer> arr, int element){
        int index = arr.size();
        arr.add(element);
        
        while (true){
            if (arr.get((index-1)/3) > arr.get(index)){
                //replace
                int box = arr.get(index);
                arr.set(index, arr.get((index-1)/3));
                arr.set((index-1)/3, box);
                index = (index-1)/3;
            }
            else{
                break;
            }
        }
        
    }

    public static void main(String[] args) {
        
        ArrayList<Integer> girdiListe = new ArrayList<Integer>();
        
        System.out.println("Sayıları virgül ile giriniz.");
        Scanner scanner = new Scanner(System.in);
        String girdi = scanner.nextLine();
        
        
        String basamak = "";
        for (int i = 0; i < girdi.length() ; i++ ){
            String harf = Character.toString(girdi.charAt(i));
            
            //harf, sayıya eşit ise
            if (harf.equals("0") || harf.equals("1") || harf.equals("2") || harf.equals("3") || harf.equals("4") || harf.equals("5") || harf.equals("6") || harf.equals("7") || harf.equals("8") || harf.equals("9")){
                basamak += harf;
            }//Sayı harici bir element ise
            else{
                girdiListe.add(Integer.valueOf(basamak));
                basamak = "";
            }
        }
        girdiListe.add(Integer.valueOf(basamak)); //Son eleman listeye giremedi
        
        //girdiListe hazır.
        boolean kontrol = heapKontrol(girdiListe);
        
        if (kontrol){
            System.out.println("3'lük min heap'tır!");
        }
        else{
            System.out.println("3'lük min heap değildir!");
            
            ArrayList<Integer> heap = new ArrayList<Integer>();
            
            for (int i : girdiListe){
                heapEkleme(heap,i);
            }
            System.out.println("Heap hali : " + heap);
            
        }

    }
    
}
