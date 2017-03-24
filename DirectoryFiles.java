import java.io.File;
public class DirectoryFiles{
    
    //Method that prints the contents of a directory
    //added number of files directly under each directory. The variable 'count' counts the number of files directly under the directory
    
    public static void getContents(File dir){
        File[] paths = dir.listFiles();
        for(File path:paths){ 
            if(path.isDirectory()){
                int count=0;
                File[] files = path.listFiles(); 
                for (File file:files){ 
                    if(file.isFile()){ 
                        count++; 
                    }
                }
                System.out.println(count + " d " + path.getAbsolutePath());
                getContents(path); 
            }
            else{
                System.out.println(0 + " f " + path.getAbsolutePath());
            }
        }
    }
    
    
     public static void main(String[] args){
        File currentDirectory = new File (".");
        getContents(currentDirectory);
    }
}
