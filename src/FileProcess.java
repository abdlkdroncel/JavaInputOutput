import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcess {

    static FileOutputStream fos=null;
    static FileInputStream fis=null;
    String fileName;
    static List<Integer> files=new ArrayList<>();

    static FileWriter fw=null;

    static FileReader fr=null;

    static BufferedReader br=null;

    static BufferedWriter bw=null;

    /**
     * Dosya kopyalamak için
     * İlk dosyadan değer okuyup List'e ekle
     * İkinci dosya olustur List'teki degerleri ekle
     * Buffer ile File arasındaki fark file her byte için dosyaya erişim sağlar
     * */

    public static FileWriter readFileFw(String fileName){
        try {
            fw=new FileWriter(fileName);

            fw.write("Java Test");

            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fw;
    }

    public static BufferedWriter wrirteFilebw(String fileName){
        try {
            bw=new BufferedWriter(new FileWriter(fileName,true));
            bw.write("Postgre Sql Test");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bw;
    }

    public static BufferedReader readFileBr(String fileName){
        try {
            br=new BufferedReader(new FileReader(fileName));
            Scanner scanner=new Scanner(br);

            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return br;
    }

    public static FileReader readFileFr(String fileName){
        try {
            fr=new FileReader(fileName);
            Scanner scanner=new Scanner(fr);

            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fr;
    }

    public static FileInputStream readFile(String fileName){
        try {
            fis=new FileInputStream(fileName);
            int deger;

            while((deger=fis.read())!=-1){
                files.add(deger);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fis;
    }


    public static FileOutputStream copyFile(String fileName){
        try {
            fos=new FileOutputStream(fileName);

            for(int f:files){
                fos.write(f);
            }
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fos;
    }
}
