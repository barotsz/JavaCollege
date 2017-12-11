import java.util.*;
import java.io.*;

public class Wektory {

    public static void main(String[] args) throws WektoryRoznejDlugosciException {

        Double wynik = 0.0;
        Boolean flaga = false;

        ZapisDoPliku zdp = new ZapisDoPliku();

        ArrayList<Double> mojeWektory = new ArrayList<Double>(2);

        while(!flaga){
            mojeWektory = czytajWektory (mojeWektory);

            CzyMamyTakaSamaDlugosc cmtsd = new CzyMamyTakaSamaDlugosc ();
            flaga = cmtsd.czyMamyTakaSamaDlugosc (mojeWektory);

            wynik = mojeWektory.get(0) + mojeWektory.get(1);

            if(flaga == true)
            {
                zdp.zapisDoPliku (wynik);
            }else{
                mojeWektory.removeAll (mojeWektory);
            }
        }
    }

    public static ArrayList czytajWektory(ArrayList<Double> mojeWektory)
    {
        String doSprawdzenia;
        Scanner czytajLinie = new Scanner (System.in);

        for (int i = 0; i < 2; i++) {
            System.out.println ("Podaj wektor ["+(i+1)+"]:");
            doSprawdzenia = czytajLinie.next ();

            if (!czyJestemLiczba (doSprawdzenia)) {
                i--;
            } else {
                mojeWektory.add(Double.parseDouble (doSprawdzenia));
            }
        }

        return mojeWektory;
    }

    public static boolean czyJestemLiczba(String doSprawdzenia) {
        try {
            Double.parseDouble (doSprawdzenia);
            return true;
        } catch (NumberFormatException e) {
            System.out.println (e);
            return false;
        }
    }

}

class ZapisDoPliku{
    public boolean zapisDoPliku(Double wynik){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("sumaWertorow.txt"))){

            String wynikString = Double.toString(wynik);
            bw.write(wynikString);
            bw.close();

            System.out.println("Zapis przeprowadzono pomyslnie");
            return true;

        }catch (IOException e){
            System.out.println(e);
            return false;
        }
    }
}

class CzyMamyTakaSamaDlugosc{
    public boolean czyMamyTakaSamaDlugosc(ArrayList<Double> mojeWektory) throws WektoryRoznejDlugosciException {

        String text = Double.toString (mojeWektory.get (0));
        int lengthOfFirstElement = text.length ();

        text = Double.toString (mojeWektory.get (1));
        int lengthOfSecoundElement = text.length ();

        try {
            if (!(lengthOfFirstElement == lengthOfSecoundElement)) {
                throw new WektoryRoznejDlugosciException("WektoryRoznejDlugosciException ", lengthOfFirstElement, lengthOfSecoundElement);
            }
        }catch(WektoryRoznejDlugosciException e){
            e.printStackTrace(System.err);
            System.err.println("e.getFirst () = " + e.getFirst ());
            System.err.println("e.getSecond () = " + e.getSecond ());
        }

        if (!(lengthOfFirstElement == lengthOfSecoundElement))
        {
            return false;
        }else {
            return true;
        }
    }
}