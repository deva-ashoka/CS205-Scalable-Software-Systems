import java.io.File;
public class DirectoryContents{
    
    //Method that prints the contents of a directory
    
    public static void getContents(File dir){
        File[] paths = dir.listFiles();
        for(File path:paths){ 
            if(path.isDirectory()){ 
                System.out.println("d " + path.getAbsolutePath());
                getContents(path); 
            }
            else{
                System.out.println("f " + path.getAbsolutePath());
            }
        }
    }
    
     public static void main(String[] args){
        File currentDirectory = new File (".");
        getContents(currentDirectory);
    }
}
