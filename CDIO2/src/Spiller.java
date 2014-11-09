
public class Spiller 
{
   private Konto balanceKonto= new Konto();
   private String navn="";
   private int boardPlads=0;
   
   public Spiller(String navn,int balance)
   {
	   this.navn=navn;
	   balanceKonto.setBalance(balance);
	   //test
   }
   public int getPlads()
   {
	   return boardPlads;
   }
   public void setPlads(int boardPlads)
   {
	   this.boardPlads=boardPlads;
   }   
   public void incrementerPlads()
   {
	   if(boardPlads>=11)
	   {
		   this.boardPlads=1;
	   }else
		   boardPlads++;
	   
   }
   public String getNavn()
   {
	   return navn;
   }
   public int getBalance()
   {
	   return balanceKonto.getBalance();
   }
   public String setBalance(int balance)
   {
	   return balanceKonto.setBalance(balance);
   }
   public String transaktionTilBalance(int balance)
   {
	   return balanceKonto.transaktionTilBalance(balance);
   }
   public String incrementBalance(int balance)
   {
	   return balanceKonto.incrementBalance(balance);
   }
   public String decrementBalance(int balance)
   {
	   return balanceKonto.decrementBalance(balance);
   }
}