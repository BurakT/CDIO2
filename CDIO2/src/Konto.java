// Klassen Konto er ansvarlig for at holde styr på indholdet af balancen
public class Konto
{
	/*
	 * Variabler
	 */
   private int balance=0;
   /*
    * Metoder
    */
   // metode til at retunere balancen på kontoen.
   public int getBalance()
   {
	   return balance;
   }
   // metode til at ændre balancen til en specifik værdi. ( ikke under nul, KRAV FRA OPGAVEN )
   public String setBalance(int balance)
   {
	   String resultat="fejl";
	   if(balance<0)
	   {
		   this.balance= 0;
		   resultat="intastet var mindre end nul. Balance sat til nul.";
	   }
	   else
	   {
		   this.balance= balance;
		   resultat="Balance korrekt ændret";
	   }
	   return resultat;
   }
   // metode til at øge balancen med et givent tal.
   public String incrementBalance(int balance)
   {
	   String resultat="fejl";
	   if( (this.balance+balance)<0 )
	   {
		   this.balance= 0;
		   resultat="Balance blev negativ. Balance er nu sat til nul.";
	   }
	   else
	   {
		   this.balance+= balance;
		   resultat="Balance korrekt ændret";
	   }
	   return resultat;
   }
   // metode til at trække et givent tal fra balancen.
   public String decrementBalance(int balance)
   {
	   String resultat="fejl";
	   if( (this.balance-balance)<0 )
	   {
		   this.balance= 0;
		   resultat="Balance blev negativ. Balance er nu sat til nul.";
	   }
	   else
	   {
		   this.balance-= balance;
		   resultat="Balance korrekt ændret";
	   }
	   return resultat;
   }
   // Metode til at ændre balancen med et givent tal. ( både negativ og positiv )
   public String transaktionTilBalance(int balance)
   {
	   String resultat="fejl";
	   if( (this.balance+balance)<0 )
	   {
		   this.balance= 0;
		   resultat="Balance blev negativ. Balance er nu sat til nul.";
	   }
	   else
	   {
		   this.balance+= balance;
		   resultat="Balance korrekt ændret";
	   }
	   return resultat;
   }
}