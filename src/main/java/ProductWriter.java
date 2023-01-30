import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.*;
public class ProductWriter {
    public static void main (String[] args){
        SafeInput inPt= new SafeInput();
        int mode=0;
        String iD;
        String name;
        String desCrip ;

        Double cost;
        Boolean done = false;
        Scanner pipe = new Scanner(System.in);
        File pFile;
        ArrayList<Product> products = new ArrayList<Product>();
        while(done == false) {
            iD=inPt.getNonZeroLenString(pipe, "ID of Product");
            name=inPt.getNonZeroLenString(pipe, "Name of Product");
            desCrip=inPt.getNonZeroLenString(pipe, "Description of Product");



            cost=inPt.getDouble(pipe, "Cost of Product");
            products.add(new Product(iD,name,desCrip,cost));
            done = inPt.getYNConfirm(pipe, "Are you done with input");
        }
        if (inPt.getYNConfirm(pipe,"Do you want to save your list?")==true) {
            try {
                pFile = new File("ProductTestData.txt");
                if (pFile.createNewFile()) {
                    System.out.println("File created: " + pFile.getName());
                } else {
                    System.out.println("File already exists.");
                }
                PrintStream pWriter = new PrintStream(pFile);
                int listLength = products.size();
                for(int x=0; x < listLength; x++){

                    pWriter.println(products.get(x).toCSVDataRecord());




                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }


    }
}
