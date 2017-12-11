package NrTelefoniczny;

class NrTelefoniczny implements Comparable<NrTelefoniczny>
{
    //Typy ? jakie lepsze do przebudowy ?
    private Integer  nrTelefonu,
                    nrKierunkowy;

    public NrTelefoniczny(){
        nrKierunkowy = 0;
        nrTelefonu = 0;
    }

    public NrTelefoniczny(Integer nrKierunkowy, Integer nrTelefonu)
    {
        this.nrTelefonu   = nrTelefonu;
        this.nrKierunkowy = nrKierunkowy;
    }

    public NrTelefoniczny(Integer nrTelefonu)
    {
        this.nrTelefonu   = nrTelefonu;
        this.nrKierunkowy = 48;
    }

    public NrTelefoniczny(NrTelefoniczny dubel){
        nrKierunkowy = dubel.nrKierunkowy;
        nrTelefonu = dubel.nrTelefonu;
    }


    public String toString()
    {
        return String.format("+(%s)%s ",nrKierunkowy, nrTelefonu);
    }


    public int compareTo(NrTelefoniczny compered) {
        String linkedString = new String(Integer.toString(nrKierunkowy) + Integer.toString(nrTelefonu));
        return linkedString.compareTo(Integer.toString(compered.nrKierunkowy) + Integer.toString(compered.nrTelefonu));
    }

}
