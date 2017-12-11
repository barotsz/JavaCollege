package NrTelefoniczny;

public class Osoba extends Wpis{

    private String  name,
            surname,
            address;
    private NrTelefoniczny phoneNumber;
    //NrTelefonu co z kierunkiem, jak wprowadzi się stringa ? separować po 3 znakach ?

    Osoba(String name, String surname, String address, Integer phoneNumber){
        this.name      = name;
        this.surname   = surname;
        this.address   = address;
        this.phoneNumber = new NrTelefoniczny(phoneNumber);
    }

    Osoba(String name, String surname, String address, Integer prefix, Integer phoneNumber){
        this.name       = name;
        this.surname    = surname;
        this.address    = address;
        this.phoneNumber = new NrTelefoniczny(prefix, phoneNumber);

    }

    public NrTelefoniczny getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s", name, surname, address);
    }

    @Override
    void opis() {
        System.out.println("- - - - - - "
                + "\nName: " + name
                + "\nSurname: " + surname
                + "\nAddress: " + address
                + "\nPhone num: " + getPhoneNumber());
    }
}