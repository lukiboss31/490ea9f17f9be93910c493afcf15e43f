

public class Vokabel
{
    private String dt;
    private String en;
    private char[] dtch;
    private char[] ench;

    public Vokabel(String dt, String en){
    this.dt = dt;
    this.en = en;
    dtch = dt.toCharArray();
    ench = en.toCharArray();
    }

    public String getdt(){
    return dt;
    }

    public String geten(){
    return en;
    }
    
    public char[] getdtch(){
    return dtch;
    }

    public char[] getench(){
    return ench;
    }
}
