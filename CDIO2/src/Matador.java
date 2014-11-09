import java.util.Scanner;
// klasse til ansvar for at styre spillet MATADOR
public class Matador {
	/*
	 * Variabler
	 */
	// instanziere de 12 felter fra MATADOR i et array
	private static Felt[] felter = new Felt[11];
	// opretter Spiller 1
	private static Spiller spiller1;
	// opretter Spiller 2
	private static Spiller spiller2;
	// variable til at holde styr p� hvilken spillers tur det er.
	private int aktiveSpiller = 1;
	// selve spillet bliver oprettet som en vaiabel. (rykket til MAIN METODE)
	//Matador spil;
	// et flag som kontrollerer at f�rste spiller er spiller 1, og kun sl�r en gang.
	static boolean firstRun = true;
	//flag til at kontrollere hvis spilleren har f�et ekstra tur !
	boolean specialFlag = false;
	static boolean spillerVundetFlag = false;
	
	/*
	 * Main Metode. bliver k�rt n�r der trykkes RUN
	 */
	public static void main( String[] args ) 
	{
		//opretter opjektet spil Af typen Matador. ( selve objektet vi bruger til at spille med )
		Matador spil = new Matador();
		//intializere spiller v�rdier
		spiller1= new Spiller("Spiller1",1000);
		spiller2= new Spiller("Spiller2",1000);
		//intializere felt v�rdier
		felter[0]=new Felt(250,"Tower","FEDT! Du har lige opnået 250 point");
		felter[1]=new Felt(-200,"Crater","ØV! Du har lige tabt 200 point");
		felter[2]=new Felt(-100,"Palace Gates","Kom igen. Du har mistet 100 point");
		felter[3]=new Felt(-20,"Cold Desert","Kom igen");
		felter[4]=new Felt(180,"Walled City","Du har vidst heldet med dig nu! :)");
		felter[5]=new Felt(0,"Monastery","Hellere 0 ponit end minus");
		felter[6]=new Felt(-70,"Black Cave","Det g�r vidste ikke s�rlig godt for dig lige nu");
		felter[7]=new Felt(-60,"Huts in the Mountain","Bedre held n�ste gang");
		felter[8]=new Felt(-80,"The werewall","werewolfwall? EKSTRA TUR !Op med humøret du får et forsøg til");
		felter[9]=new Felt(-90,"The Pit","Hmmmm....");
		felter[10]=new Felt(650,"Goldmine","HOLD DA OP! Det k�re for dig du er blevet rig. 650 point");
		Rafleb�ger raf = new Rafleb�ger();	
		// print i ved starten af spillet.
		System.out.println("Velkommen, tryk på Enter for at starte med at kaste");
    	System.out.println("spiller1 s tur");
    	// opretter en scanner der tjekker efter et tryk på BACKSPACE.
		Scanner tryk = new Scanner (System.in); //Man starter spillet ved at trykke på "enter" og forts�tter med samme tast 
		// k�rer dette i tilf�lde af der trykkes BACKSPACE
		while(!spillerVundetFlag){
			
			raf.roll();
			int value1 = raf.getvalue1(); //Dette er v�rdien af f�rste terning
			int value2 = raf.getvalue2(); //Dette er v�rdien er anden terning
			int Sum = raf.getSum();	//Dette er summen af begge terninger
			if(firstRun==false)
			{	
				spil.rykAntalPladser(Sum);
			}
			tryk.nextLine();
			firstRun=false;
		}
	}
	/*
	 * METODER
	 */
	//metode til at rykke spilleren et antal pladser
	public void rykAntalPladser( int terningResultat )
	{
		// lokal variable bruges kun til at t�lle pladser.
		int count = 1;
		// kontroller antal pladser der rykkes.
        while (count <= terningResultat) {
        	if(aktiveSpiller==1)
        	{
        		spiller1.incrementerPlads();
        	}
        	if(aktiveSpiller==2)
            {
        		spiller2.incrementerPlads();
        	}
        	count++;
        }
        // HERUNDER, sættes op til at printe afhængig af hvilken spillers tur det er.
        int tempPlads=0;
        String tempNavn="";
        String tempBesked="";
        if(aktiveSpiller==1)
    	{
        	tempPlads=spiller1.getPlads();
        	System.out.println("Spiller1 er nu på felt "+tempPlads);
        	tempNavn=felter[(tempPlads-1)].getFeltNavn();
        	System.out.println("Du landte på plads "+tempNavn);
        	tempBesked=felter[(tempPlads-1)].getFeltbesked();
        	System.out.println("BESKED: "+tempBesked);
            int tempFeltvaerdi=felter[(tempPlads-1)].getFeltVaerdi();
            spiller1.transaktionTilBalance(tempFeltvaerdi);
            System.out.println("Balance: "+spiller1.getBalance());
            
            if(spiller1.getBalance()>=3000)
            {
            	spillerVundetFlag=true;
            }
    	}
    	else
    	{
    		tempPlads=spiller2.getPlads();
        	System.out.println("Spiller2 er nu p� felt "+tempPlads);
        	tempNavn=felter[(tempPlads-1)].getFeltNavn();
        	System.out.println("Du landte på plads "+tempNavn);
        	tempBesked=felter[(tempPlads-1)].getFeltbesked();
        	System.out.println("BESKED: "+tempBesked);
            int tempFeltvaerdi=felter[(tempPlads-1)].getFeltVaerdi();
            spiller2.transaktionTilBalance(tempFeltvaerdi);
            System.out.println("Balance: "+spiller2.getBalance());
            if(spiller2.getBalance()>=3000)
            {
            	spillerVundetFlag=true;
            }
    	}
        if(tempPlads==9){
        	specialFlag=true;
        }
        if(!spillerVundetFlag)
        {
	        if(!specialFlag)
	        {
		        if(aktiveSpiller==1){
		        	aktiveSpiller=2;
		        	System.out.println("spiller2 s tur");
		        	
		        }else{
		        	aktiveSpiller=1;
		        	System.out.println("spiller1 s tur");
		        }
	        }else{
	        	specialFlag=false;
	        }   
        }else{
        	System.out.println("SPILLER "+aktiveSpiller+" HAR VUNDET!!!");
                }
	}	
}
