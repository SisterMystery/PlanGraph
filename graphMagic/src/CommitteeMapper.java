import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by torrentglenn on 5/27/15.
 */
public class CommitteeMapper {
    public File textFile;
    public Scanner textScanner;
    public HashMap<String, ArrayList<String>> committeeMap = new HashMap<String, ArrayList<String>>();

    public CommitteeMapper(String filePath, String delimiter) throws FileNotFoundException {
        textFile = new File(filePath);
        textScanner = new Scanner(textFile).useDelimiter(delimiter);
    }

    public void map(){
        String currentKey = "";
        String s;
        while(textScanner.hasNext()){
            s = textScanner.next();

            s = s.replace("*","");

            if(s.contains(",")){
                currentKey = s;
                committeeMap.put(s, new ArrayList<String>());
            } else {
                committeeMap.get(currentKey).add(s);
            }
        }

        for(Map.Entry<String,ArrayList<String>> e: committeeMap.entrySet()){
            e.getValue().remove(e.getValue().size()-1);
        }
    }
}
