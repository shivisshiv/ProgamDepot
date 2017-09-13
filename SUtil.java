import java.util.*;
import java.io.*;

public class SUtil {
    
    
    public static String[] fileToArray(String fileLocationStr){
        
        try(Scanner txtFile = new Scanner(new File(fileLocationStr))){
            String fileStr = "";
            while(txtFile.hasNext()){
                fileStr = fileStr + txtFile.nextLine() + "\n";
            }
            String linesAry[] = fileStr.split("\n");
            
            txtFile.close();
            return linesAry;
            
        }catch(IOException badFileException){
            System.out.println("ERROR -> Bad file name or file does not exist");
            return null;
        }
    }
}
