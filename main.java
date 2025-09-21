import java.util.ArrayList;
import java.util.List;

public class main{
    public static void main(String[] args){
      List<CustomInteger> L1 = new ArrayList<>();
      L1.add(new customInteger(value:12));
      L1.add(new customInteger(value:23));  
      L1.add(new customInteger(value:34));
      
      List<Integer> L2 = new ArrayList<>();
      L2.add(e:10);
      L2.add(e:20);
      L2.add(e:30);

      for(int i = 0; i < L1.size(); i++){
        System.out.print(L1.get(i) + " ");
      }
      System.out.println();

      for(Integer i : L2){
        System.out.print(i+ " ");
      }
      System.out.println();

      System.out.println(x:"Using printNumberListUpperBound on L1:");
      printNumberListUpperBound(L1);
      System.out.println(x:"Using printNumberListUpperBound on L2:");
      printNumberListUpperBound(L2);

      System.out.println(x:"Using printNumberListLowerBound on L1:");
      printNumberListLowerBound(L1);
    }

    public static void printNumberListUpperBound(List<? extends Number> t){
        for(Number i: t){
            System.out.print(i +" ");
        }
        System.out.println();
    }
    public static void printNumberListLowerBound(List<? super CustomInteger> t){
        for(Object i: data){
            System.out.print(i+ " ");
        }
        System.out.println();
    }

    
}