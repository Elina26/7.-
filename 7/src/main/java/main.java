import java.io.File;
import java.io.IOException;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        String path = "C:/Users/Lenovo/IdeaProjects/2 семестр/7";
        String filter = ".txt";
        FileProcessor fileProcessor = new FileProcessor();
        List<File> list =  fileProcessor.method_4(path, filter);
        System.out.println(list.toString());
    }
}

