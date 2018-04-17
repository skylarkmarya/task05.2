import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    private static final String sFileEx = ".properties";
    private static String sDirSeparator = System.getProperty("file.separator");
    private static Properties props = new Properties();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// определяем текущий каталог
        File currentDir = new File(".");
        try {
            System.out.println("Enter properties file name:");
            String nameFile = scanner.nextLine();
            String sFileName = nameFile+sFileEx;
// определяем полный путь к файлу
            String sFilePath = currentDir.getCanonicalPath() + sDirSeparator + sFileName;
// создаем поток для чтения из файла
            FileInputStream ins = new FileInputStream(sFilePath);
// загружаем свойства
            props.load(ins);
// выводим значение для свойства mykey
            System.out.println("Enter key:");
            String key = scanner.nextLine();
//проверка существования ключа
            if (props.getProperty(key) != null) {
                System.out.println(props.getProperty(key));
            }else{
                System.out.println("Key not found!");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File properties not found!");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("IO Error!");
            e.printStackTrace();
        }
    }
}
