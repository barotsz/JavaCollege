package NrTelefoniczny;

public class Firma extends Wpis{

    private String  name,
            address,
            NIP; //NIP stringiegms
    private NrTelefoniczny phoneNumber;

    IsNIPCorrect iNIPc = new IsNIPCorrect();


    public Firma(String name, String address, String NIP, int phoneNumber) throws NIPNumberWrongException{
        this.name = name;
        this.address = address;

        if(iNIPc.isNIPCorrect(NIP))
            this.NIP = NIP;

        this.phoneNumber = new NrTelefoniczny(phoneNumber);
    }

    public Firma(String name, String address, String NIP,int prefix, int phoneNumber) throws NIPNumberWrongException{
        this.name = name;
        this.address = address;

        if(iNIPc.isNIPCorrect(NIP))
            this.NIP = NIP;

        this.phoneNumber = new NrTelefoniczny(prefix, phoneNumber);
    }

    public NrTelefoniczny getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", name, address, NIP);
    }

    @Override
    void opis() {
        System.out.println("- - - - - - "
                + "\nName: " + name
                + "\nAddress: " + address
                + "\nNIP: " + NIP
                + "\nPhone num: " + getPhoneNumber());
    }

}

class IsNIPCorrect{
    public boolean isNIPCorrect(String nipToCheck) throws NIPNumberWrongException{

        try{
            if(nipToCheck == "000000000")
                throw new NIPNumberWrongException("NIPNumberWrongException NULLS", nipToCheck);
        }catch(NIPNumberWrongException e){
            e.printStackTrace(System.err);
            System.err.println("e.getNIPtoVerify() = " + e.getNIPtoVerify());
        }

        //int digits[] = new int[9];

        int[] digits = nipToCheck.chars().map(c -> c-='0').toArray();
        for(int d : digits)
            System.out.print(d);

//        try{
//            if(digits.length > 9 && digits.length < 9)
//                throw new NIPNumberWrongException("NIPNumberWrongException LENGHT", nipToCheck);
//        }catch(NIPNumberWrongException e){
//            e.printStackTrace(System.err);
//            System.err.println("e.getNIPtoVerify() = " + e.getNIPtoVerify());
//        }

        int[] weights = {6,5,7,2,3,4,5,6,7};

        int sum = 0;

        for(int i=0; i<9; i++)
            sum+=digits[i]*weights[i];

        sum = sum%11;

        try{
            if(sum < 0 || sum >= 10)
                throw new NIPNumberWrongException("NIPNumberWrongException MODULO", nipToCheck);
        }catch(NIPNumberWrongException e){
            e.printStackTrace(System.err);
            System.err.println("e.getNIPtoVerify() = " + e.getNIPtoVerify());
        }

        if(sum > 0 && sum < 10)
            return true;
        else
            return false;

    }
}