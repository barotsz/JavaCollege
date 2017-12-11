package NrTelefoniczny;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Main{

    public static void main(String[] args) throws NIPNumberWrongException
    {

        System.out.println ("\n\nWorking");

        Osoba person1 = new Osoba("Jan", "Nowak", "Warszawa", 510680202);
        person1.opis();

//---------------------------------------------wrong nip cancel company
        Firma company1 = new Firma("Qwerty", "Minessota", "17271005241", 615215845);
        company1.opis();

        TreeMap<NrTelefoniczny, Wpis> phoneBook = new TreeMap<NrTelefoniczny, Wpis>();
        phoneBook.put(person1.getPhoneNumber(), person1);
        phoneBook.put(company1.getPhoneNumber(), company1);

        printWithIterator(phoneBook);


    }
    //cleaing buffer ?
    public static void printWithIterator(TreeMap<NrTelefoniczny, Wpis> table){
        Set set = table.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            Map.Entry buff = (Map.Entry)it.next();
            System.out.println("- - - - - - ");
            System.out.print(buff.getKey() + ": ");
            System.out.println(buff.getValue());
        }
    }


}
