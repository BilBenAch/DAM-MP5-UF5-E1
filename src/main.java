import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) throws IOException {
        Activitat2AmbExpresionsRegulars();
        Activitat2SenseExpresionsRegulars();

    }


    public static void Activitat2AmbExpresionsRegulars() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Belal\\Desktop\\santako.txt"));
        try {
            System.out.println("Amb expresions regulars");
            System.out.println();
            String line;
            int contadorPareNoel = 0;
            int contadorRen = 0;
            int contadorFollet = 0;
            Pattern pareNoel = Pattern.compile(".*?\\<]:-DOo");
            Pattern ren = Pattern.compile("\\>:o\\)");
            Pattern follet = Pattern.compile("\\<]:-D*$");
            while ((line = br.readLine()) != null) {
                Matcher papaNoel = pareNoel.matcher(line);
                Matcher matcherRen = ren.matcher(line);
                Matcher matcherFollet = follet.matcher(line);

                while (papaNoel.find()) {
                    contadorPareNoel++;
                }
                while (matcherRen.find()) {
                    contadorRen++;
                }
                while (matcherFollet.find()) {
                    contadorFollet++;
                }

                if (contadorPareNoel > 0) {
                    System.out.print("Pare noel (" + contadorPareNoel + ") ");
                }

                if (contadorRen > 0) {
                    System.out.print("Ren (" + contadorRen + ") ");
                }

                if (contadorFollet > 0) {
                    System.out.print("Follet (" + contadorFollet + ") ");
                }
                contadorPareNoel = 0;
                contadorRen = 0;
                contadorFollet = 0;

                System.out.println();
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }

    }


    public static void Activitat2SenseExpresionsRegulars() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Belal\\Desktop\\santako.txt"));
        try {
            System.out.println("*******************");
            System.out.println("Sense expresions regulars");
            System.out.println();
            String line;
            int contadorPareNoel = 0;
            int contadorRen = 0;
            int contadorFollet = 0;
            boolean pareNoel;
            boolean ren;
            boolean follet;
            while ((line = br.readLine()) != null) {

                pareNoel = line.contains("<]:-DOo");
                ren = line.contains(">:o)");
                follet = line.contains("<]:-D");

                if (pareNoel) {
                    contadorPareNoel++;
                } else contadorPareNoel = 0;

                if (ren) {
                    contadorRen++;
                } else contadorRen = 0;

                if (follet && line.endsWith("D")) {
                    contadorFollet++;
                } else contadorFollet = 0;

                if (contadorPareNoel > 0) {
                    System.out.print("Pare noel (" + contadorPareNoel + ") ");
                }

                if (contadorRen > 0) {
                    System.out.print("Ren (" + contadorRen + ") ");
                }

                if (contadorFollet > 0) {
                    System.out.print("Follet (" + contadorFollet + ") ");
                }

                System.out.println();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }


    }
}
