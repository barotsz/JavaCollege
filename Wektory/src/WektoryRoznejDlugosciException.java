
class WektoryRoznejDlugosciException extends Exception{

    private Integer first,second;

    public WektoryRoznejDlugosciException(String msg, Integer first, Integer second)
    {
        super(msg);
        this.first = first;
        this.second = second;
    }

    public int getFirst()
    {
        return first;
    }

    public int getSecond()
    {
        return second;
    }
}