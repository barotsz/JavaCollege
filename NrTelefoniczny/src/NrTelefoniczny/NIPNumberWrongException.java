package NrTelefoniczny;

public class NIPNumberWrongException extends Exception {
    private String NIPtoVerify;

    public NIPNumberWrongException(String msg, String NIPtoVerify){
        super(msg);
        this.NIPtoVerify = NIPtoVerify;
    }

    public String getNIPtoVerify(){
        return NIPtoVerify;
    }
}
