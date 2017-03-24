import java.io.File;
public class TotalDirectoryFiles{
    
   //method that returns the total number of files under a directory including it's sub-directories recursively.
   //the varialble 'totalFiles' counts the number of files
    
    public static int getTotalFiles(File dirRecursive){
        int totalFiles=0;
        File[] fileRecurs = dirRecursive.listFiles();
        for(File fileRecur:fileRecurs){
            if (fileRecur.isFile()){
                totalFiles++;
                }
            if(fileRecur.isDirectory()){
                totalFiles += getTotalFiles(fileRecur);
            }
        }
        return totalFiles;
   }
 
   //Method that prints the contents of a directory
   //added number of files directly under each directory. The variable 'count' counts the number of files directly under the directory
   
     public static void getContents(File dir){
        File[] paths = dir.listFiles();
        for(File path:paths){ 
            if(path.isDirectory()){
                int count=0;  
                int countFiles=0;
                File[] files = path.listFiles(); 
                for (File file:files){ 
                    if(file.isFile()){ 
                        count++; 
                    }
                }
                countFiles=getTotalFiles(path);//getting the total number of files in the directory including sub directories
                System.out.println(countFiles + " " + count + " d " + path.getAbsolutePath());
                getContents(path); 
            }
            else{
                System.out.println(0 + " " + 0 + " f " + path.getAbsolutePath());
            }
        }
    }
    
     public static void main(String[] args){
        File currentDirectory = new File (".");
        getContents(currentDirectory);
    }
}
