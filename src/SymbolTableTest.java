import java.util.Scanner;
import java.util.regex.Pattern;

public class SymbolTableTest {
    public static void main(String[] args) {
        sortedTest();
//        elementaryTest();
    }

    public static void sortedTest() {
        SortedSymbolTable<String, Integer> sst = new SortedSymbolTable<>();
        String line = "F A C B D E";
        //line = "S O R T E D S Y M B O L T A B L E E X A M P L E";
        String arr[] = line.split("\\s");

        for(int i = 0; i < arr.length; i++) {
            try {
                sst.put(arr[i], i);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(sst + "\n");
        }

        /*
        try {
            sst.remove("A");
            sst.remove("M");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(sst + "\n");
        */

        try {
            sst.doSelfOrgSearch("D");
            System.out.println(sst + "\n");
            sst.doSelfOrgSearch("C");
            System.out.println(sst + "\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(sst + "\n");
    }

    public static void elementaryTest() {
        ElementarySymbolTable<String, Object> est = new ElementarySymbolTable<String, Object>();
        String line = "E L E M S Y M B O L T A B L E E X A M P L E",
                stuff[] = line.split("\\s");

        for(int i = 0; i < stuff.length; i++) {
            est.add(stuff[i], i);
            System.out.println(est);
        }

        System.out.println("\n\n");
        est.remove("O");
        System.out.println(est);
        est.remove("X");
        System.out.println(est);
        est.remove("P");
        System.out.println(est);
        est.remove("E");
        System.out.println(est);

        System.out.println("\n\n");
        try {
            System.out.println("M -> " + est.get("M"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
