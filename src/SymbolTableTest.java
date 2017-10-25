import java.util.Scanner;
import java.util.regex.Pattern;

public class SymbolTableTest {
    public static void main(String[] args) {

        ElementarySymbolTable<String, Object> est = new ElementarySymbolTable<String, Object>();
        String line, stuff[];

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            //System.out.println("line: " + line);
            if(line.equals("-"))
                break;
            stuff = line.split("\\s");

            if(stuff[1].matches("\\d+"))
                est.add(stuff[0], Integer.parseInt(stuff[1]));
            else
                est.add(stuff[0], (String)stuff[1]);

            //System.out.println("Reading next line");
        }
        //System.out.println("Loop done");
        System.out.println(est);

        sc.close();
    }
}
