package horspool;

import java.util.Arrays;

public class horspool {
    int place;
    String text, pattern;
    int[] shiftTable;

    horspool(String text, String pattern){
        this.text = text;
        this.pattern = pattern;
        createShiftTable();
    }

    void createShiftTable(){
        shiftTable = new int[256];
        Arrays.fill(shiftTable, pattern.length());
        for(int i=0;i<pattern.length()-1;i++){
            shiftTable[(int) pattern.charAt(i)] = pattern.length() - i - 1;
        }
    }

    void find(){
        place = -1;
        int l = pattern.length();
        int i = l-1;
        int k;
        while(i<text.length()){
            for(k=0;k<l;k++){
                if(pattern.charAt(l-k-1) != text.charAt(i-k)){
                    i = i + shiftTable[(int)text.charAt(i)];
                    //System.out.println("i = "+i+" text[i] = "+text.charAt(i)+" text[i-k] = "+text.charAt(i-k));
                    k=0;
                }
            }
            if(k==l){ place = i-l+2;
                      break;}
        }
    }
}
 //   computer organization, computer architecture and design
 //   architecture
