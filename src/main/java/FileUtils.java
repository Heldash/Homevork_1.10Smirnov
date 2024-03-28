import java.io.*;
import java.util.ArrayList;

public class FileUtils {
    public static boolean existFile(String path){
        File file = new File(path);
//        System.out.println(file.getPath());
//        System.out.println(file.getParent());
        if (file.exists()){
            return true;
        }else{
            System.out.println("Данного файла не существует");
            return false;
        }
    }
    public static boolean mergesFiles(ArrayList<File> files) throws IOException{
//        ArrayList<byte[]> arr = new ArrayList<>();
        File firstFile = files.getFirst();
        FileOutputStream fos = new FileOutputStream(firstFile.getParent()+"/"+"output.txt");
        for (File file: files){
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[fis.available()];
            int size;
            while ((size = fis.read(data))!=-1){
                fos.write(data,0,size);
            }
            fis.close();
        }
        fos.flush();
        fos.close();
        return true;
    }
    public static void saveFile(String path,byte[] array) throws IOException,
            FileNotFoundException{
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(array);
        fos.flush();
        fos.close();
    }
//    public static
}
