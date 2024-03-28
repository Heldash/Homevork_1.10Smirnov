import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Смирнов Игорь Евгеньевич, РИБО-01-22, вариант 1");
        Scanner scan = new Scanner(System.in);
        System.out.println("Сколько файлов вы хотите склеить");
        ArrayList<File> mergeFiles = new ArrayList<>();
        int cntFiles = scan.nextInt();
        scan.nextLine();
        int cnt = 0;
        while (cnt<cntFiles){
            System.out.print("Введите путь к файлу который хотите склеить: ");
            String path = scan.nextLine();
            boolean isExits = FileUtils.existFile(path);
            if (isExits) {
                mergeFiles.add(new File(path));
                System.out.println("Файл добавлен");
                cnt++;
            }
        }
        boolean result = true;
        try {
            FileUtils.mergesFiles(mergeFiles);
        } catch (IOException err){
            System.out.println("Ошибка при загрузке файла");
            result = false;
        }
        if (result){
            System.out.println("Файлы соеденены успешно");
            System.out.println("Файл создан по пути "+mergeFiles.get(0).getParent()+"\\otput.txt");
        }else {
            System.out.println("Склейка файлов не произошла");
        }
    }
}
