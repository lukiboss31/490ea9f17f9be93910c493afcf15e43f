package data;


public class Vokabel
{
	
	private int box;
    private String dt;
    private String en;
    private char[] dtch;
    private char[] ench;

    public Vokabel(String dt, String en, int box){
    this.dt = dt;
    this.en = en;
    this.setBox(box);
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

	public int getBox() {
		return box;
	}

	public void setBox(int box) {
		this.box = box;
	}
}
