import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;

public class program{
    public static void main(String[] args) {
       System.out.println(repeatChar(7, 'j', 'u'));
        Path path = Path.of("file.txt");
        try{
        if (Files.notExists(path)){
            Files.createFile(path);
        }
        FillFile(100, "TEXT", path);
    } catch(IOException e){
        System.out.println("Что-то пошло не так");
    }
    }

    private static String repeatChar(int n, char a, char b){
        StringBuilder rezultStr = new StringBuilder();
        for (int i = 0; i < n/2; i++){
             rezultStr.append(a).append(b);
         }
        if(n%2 != 0) rezultStr.append(a);
       return rezultStr.toString();
    }
    private static void FillFile(int n, String text, Path path){
        StringBuilder textForWrite = new StringBuilder();
        for (int i = 0; i < n; i++){
            if(i % 10 == 0) textForWrite.append("\n");
            textForWrite.append(text);
        }
        try{
            Files.writeString(path, textForWrite.toString());
        } catch(IOException e){
            System.out.println("Что-то пошло не так");
        }
    }
}