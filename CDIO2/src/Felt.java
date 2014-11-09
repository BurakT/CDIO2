public class Felt {
	int feltVaerdi=0;
	String feltNavn="";
	String feltBesked="";
	public Felt(int feltVaerdi, String feltNavn, String feltBesked)
	{
		this.feltVaerdi=feltVaerdi;
		this.feltNavn=feltNavn;
		this.feltBesked=feltBesked;
	}
	public int getFeltVaerdi()
	{
		return feltVaerdi;
	}
	public String getFeltbesked()
	{
		return feltBesked;
	}
	public String getFeltNavn()
	{
		return feltNavn;
	}
}