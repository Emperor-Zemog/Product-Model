import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.*;
public class ProductReader {
    public static void main (String[] args)  throws IOException{
        int fileIndex = 0;
        int mode=0;
        SafeInput inPt= new SafeInput();
        Boolean done = false;
        Scanner pipe = new Scanner(System.in);
        ArrayList<String> sList = new ArrayList<String>();
        ArrayList<Product> products = new ArrayList<Product>();

        JFileChooser jChoose= new JFileChooser(new File("Product Model.iml"));
        FileFilter txtFilefilter = new FileFilter() {
            public boolean accept(File file) {
                if (file.getName().endsWith(".txt")) {
                    return true;
                }
                return false;
            }
        };
        File [] files = jChoose.getCurrentDirectory().listFiles(txtFilefilter);
        while(done ==false){

            for (int i = 0; i < files.length; i++) {
                System.out.println(i+": "+ files[i].getName());
            }
            fileIndex= inPt.getRangedInt(pipe,"Please select the number corresponding to the file you want ",0,files.length-1);
            done = inPt.getYNConfirm(pipe, "You selected "+files[fileIndex].getName()+ "Is this correct?");
        }
        Path fPath= Path.of(files[fileIndex].getPath());
        String contents= Files.readString(fPath);
        sList=splitSubstrings(contents);
        for(int x=0;x < sList.size();x=x+4){
            products.add(new Product(sList.get(x),sList.get(x+1),sList.get(x+2),Double.parseDouble(sList.get(x+3))));

        }




        System.out.printf("%-15s %-15s %-25s %-20s\n","ID#","Name","Description","Cost");
        System.out.println("____________________________________________________________________________");
        for(int y=0;y < products.size();y=y+1){

            System.out.printf("%-15s %-15s %-25s %-20s\n",products.get(y).getID(),products.get(y).getName(),products.get(y).getDescription(),products.get(y).getCost());
        }




    }
    public static ArrayList<String> splitSubstrings(String s)
    {


        int i, j;


        int stringLength = s.length();


        ArrayList<String> subStringList = new ArrayList<String>();

        i=0;
        j=0;
        while(i<stringLength){
            if(s.charAt(i)==','){
                subStringList.add(s.substring(j,i));
                j=i+1;
            } else if(s.charAt(i)=='\n'){
                subStringList.add(s.substring(j,i-1));
                j=i+1;

            }else if (i==stringLength-1) {
                subStringList.add(s.substring(j,i));
            }
            i++;
        }


        return subStringList;
    }
}
