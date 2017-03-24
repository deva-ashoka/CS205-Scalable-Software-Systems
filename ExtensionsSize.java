import java.io.File;
import java.lang.String;
public class ExtensionsSize{
    
    static String[] TYPES = new String[]{"jpg", "png", "gif", "mp4", "mp3", "exe", "psd", "html", "xml", "pdf", "xlsx", "xls", "docx"};
    static int[] typeCount = new int[TYPES.length];
    static long[] typeSize = new long[TYPES.length];
    
    //method to keep adding the size of each file to its specific extension type
    
    public static void addToExtensionSize(String type, long fileSize){
        for(int i=0; i<TYPES.length; i++){
            if(type.equals(TYPES[i])){
                typeSize[i] += fileSize;
            }
        }
    }
    
    //method to get the size of each file
    
    public static long getFileSize(File dirSize){
       long fileSize = dirSize.length();
       return fileSize;
    }
    
    //method to get the number of files of each extension type
    
    public static void getExtensionCount(String type){
        for(int i=0; i<TYPES.length; i++){
            if(type.equals(TYPES[i])){
                typeCount[i]++;
            }
        }
    }
               
    //method to get the extension of each file
    
    public static String getExtension(File dirExtension){
        String name = dirExtension.getName();
        String extension = "";
        extension = name.substring((name.lastIndexOf('.'))+1,name.length());
        extension = extension.toLowerCase();
        return extension;
    }
    
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
                countFiles=getTotalFiles(path);
                System.out.println(countFiles + " " + count + " d " + path.getAbsolutePath());
                getContents(path); 
            }
            else{                
                System.out.println(0 + " " + 0 + " f " + path.getAbsolutePath());
                String ext = getExtension(path);
                getExtensionCount(ext);
                long size = getFileSize(path);
                addToExtensionSize(ext, size);
            }
        }
    }
    
     public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        File currentDirectory = new File (".");
        getContents(currentDirectory);
        System.out.println("");
        System.out.println("Number of files by type:");
        for(int i=0; i<TYPES.length; i++){
            System.out.println(TYPES[i] + " - " + typeCount[i]);
        }
        System.out.println("");
        System.out.println("Size of each type:");
        for(int i=0; i<TYPES.length; i++){
            System.out.println(TYPES[i] + " - " + String.format("%,d", typeSize[i]));
        }
        System.out.println("");
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Program executed in " + timeTaken + " milliseconds");
    }
}
