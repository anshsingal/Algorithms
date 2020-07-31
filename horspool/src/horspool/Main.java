package horspool;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //System.out.println("enter text:");
        String text = s.nextLine();
        //System.out.println("enter pattern");
        String pattern = s.nextLine();
        horspool h = new horspool(text, pattern);
        h.find();
        System.out.println("pattern found at: "+h.place);
    }
}
