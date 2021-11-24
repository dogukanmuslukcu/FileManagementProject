import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FileManager {


    public void delete(String fileName) {

        File file = new File("C:\\Users\\doğukan\\Desktop\\" + fileName + ".txt");
        if (file.delete()) {
            System.out.println("Dosya silindi :" + file.getName());
        } else {
            System.out.println("Dosya silinemedi.");
        }
    }

    public void read(String fileName) {
        File file = new File("C:\\Users\\doğukan\\Desktop\\" + fileName + ".txt");
        try {

            Scanner scanner = new Scanner(file);
            if (scanner.hasNextLine() == false) {
                System.out.println("Dosyada metin bulunamadı");
            } else {
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    System.out.println(data);
                }
                scanner.close();

            }
        } catch (FileNotFoundException exception) {
            System.out.println("Dosya okunurken hata alındı");

        }
    }

    public void write(String fileName, String text) {

        try {
            FileWriter writer = new FileWriter("C:\\Users\\doğukan\\Desktop\\" + fileName + ".txt");
            writer.write(text);
            writer.close();
            System.out.println("Metin başarıyla dosyaya yazıldı.");
        } catch (IOException exception) {
            System.out.println("Metin yazılırken hata alındı.");

        }
    }

    public void create(String fileName) {
        File file = new File("C:\\Users\\doğukan\\Desktop\\" + fileName + ".txt");
        try {

            if (file.createNewFile()) {
                System.out.println("Dosya oluşturuldu : " + fileName);

            } else {
                System.out.println("Dosya zaten bulunmaktadır.");
            }
        } catch (IOException exception) {
            System.out.println("Dosya oluşturulurken hata alındı.");

        }
    }

    public void copyFile(String fileName, String toBeCopiedFileName) {

        try {

            File toBeCopiedFile = new File("C:\\Users\\doğukan\\Desktop\\" + toBeCopiedFileName + ".txt");
            Scanner scanner = new Scanner(toBeCopiedFile);
            if (scanner.hasNext() == false) {

                System.err.println("Kopyalanacak olan dosyada metin bulunamadı.");
            } else {
                FileWriter writer = new FileWriter("C:\\Users\\doğukan\\Desktop\\" + fileName + ".txt");// Eğer en başta tanımlarsak hedef
                // dosyanın boş olması durumunda hata vermesine rağmen kaynak dosyanın içinde şayet metin varsa silinir.
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    writer.write(data);
                }
                System.out.println("Metin başarıyla dosyaya kopyalandı.");
                scanner.close();
                writer.close();
            }

        } catch (IOException exception) {
            System.out.println("Dosya oluşturulurken hata alındı.");

        }

    }

    public void updateFile(String fileName, String resarchWord, String updateWord) {

        FileManager manager = new FileManager();
        File file = new File("C:\\Users\\doğukan\\Desktop\\" + fileName + ".txt");
        String data = null;
        try {
            manager.create("tempFile");
            manager.copyFile("tempFile", fileName);

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data = scanner.nextLine();
            }
            String data2 = data.replace(resarchWord, updateWord);
            scanner.close();
            manager.write("tempFile", data2);
            manager.copyFile(fileName, "tempFile");

        } catch (FileNotFoundException exception) {
            System.out.println("Dosya güncellenirken hata alındı.");
        }

    }
}
