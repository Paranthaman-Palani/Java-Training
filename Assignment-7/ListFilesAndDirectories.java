package assignment7;

import java.io.File;
public class ListFilesAndDirectories {
    public static void main(String[] args) {
        File myPath = new File("/Users/paranthaman");
        String[] filesAndDirectories = myPath.list();
      
        for(String path:filesAndDirectories)
        {
            System.out.println(path);
        }
    }
}
