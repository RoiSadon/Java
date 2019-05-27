package ls8ConstructorAndThis;

// This code converts number to its same text value in English words.

public class NumberAsString {

	public static void main(String[] args) {
		int num=1234567;
		int achadot, asarot, meot, alafim, asrotAlafim, meotAlafim, million;
		String achadotS="", asarotS="", meotS="", alafimS="", asrotAlafimS="", meotAlafimS="", millionS="";
		for(int i=0; i<9; i++) {
			
			achadot=num%10;
			switch(achadot) {
			case 1:achadotS = "one"; break;
			case 2:achadotS = "two"; break;
			case 3:achadotS = "three"; break;
			case 4:achadotS = "four"; break;
			case 5:achadotS = "five"; break;
			case 6:achadotS = "six"; break;
			case 7:achadotS = "seven"; break;
			case 8:achadotS = "eight"; break;
			case 9:achadotS = "nine"; break;
			case 0: break;
			}
			
			asarot = num/10%10;
			if(asarot==1) {
				if(achadot==1)achadotS = "eleven";
				if(achadot==2)achadotS = "twelve";
				if(achadot==3)achadotS = "thirteen";
				if(achadot==4)achadotS = "fourteen";
				if(achadot==5)achadotS = "fifeteen";					
				if(achadot==6)achadotS = "sixteen";
				if(achadot==7)achadotS = "seventeen";
				if(achadot==8)achadotS = "eighteen";
				if(achadot==9)achadotS = "nineteen";										
			}
			else if (asarot!=1)
			{switch(asarot) {
			case 2:asarotS = "twenty "; break;
			case 3:asarotS = "thirty "; break;
			case 4:asarotS = "fourty "; break;
			case 5:asarotS = "fifty "; break;
			case 6:asarotS = "sixty "; break;
			case 7:asarotS = "seventy "; break;
			case 8:asarotS = "eighty "; break;
			case 9:asarotS = "ninety "; break;
			case 0: break;
				}	
			}	
			
			meot = num/100%10;
			switch(meot) {
			case 1:meotS = "one hundred "; break;
			case 2:meotS = "two hundred "; break;
			case 3:meotS = "three hundred "; break;
			case 4:meotS = "four hundred "; break;
			case 5:meotS = "five hundred "; break;
			case 6:meotS = "six hundred "; break;
			case 7:meotS = "seven hundred "; break;
			case 8:meotS = "eight hundred "; break;
			case 9:meotS = "nine hundred "; break;
			case 0: break;
			}	
			
			alafim = num/1000%10;
			switch(alafim) {
			case 1:alafimS = "one thousand "; break;
			case 2:alafimS = "two thousand "; break;
			case 3:alafimS = "three thousand "; break;
			case 4:alafimS = "four thousand "; break;
			case 5:alafimS = "five thousand "; break;
			case 6:alafimS = "six thousand "; break;
			case 7:alafimS = "seven thousand "; break;
			case 8:alafimS = "eight thousand "; break;
			case 9:alafimS = "nine thousand "; break;
			case 0: break;
			}	
			
			asrotAlafim = num/10000%10;
			if(asrotAlafim==1) {
				if(alafim==1)alafimS = "eleven thousand ";
				if(alafim==2)alafimS = "twelve thousand ";
				if(alafim==3)alafimS = "thirteen thousand ";
				if(alafim==4)alafimS = "fourteen thousand ";
				if(alafim==5)alafimS = "fifeteen thousand ";					
				if(alafim==6)alafimS = "sixteen thousand ";
				if(alafim==7)alafimS = "seventeen thousand ";
				if(alafim==8)alafimS = "eighteen thousand ";
				if(alafim==9)alafimS = "nineteen thousand ";										
			}
			else if (asrotAlafim!=1)
			{switch(asrotAlafim) {
			case 2:asrotAlafimS = "twenty "; break;
			case 3:asrotAlafimS = "thirty "; break;
			case 4:asrotAlafimS = "fourty "; break;
			case 5:asrotAlafimS = "fifty "; break;
			case 6:asrotAlafimS = "sixty "; break;
			case 7:asrotAlafimS = "seventy "; break;
			case 8:asrotAlafimS = "eighty "; break;
			case 9:asrotAlafimS = "ninety "; break;
			case 0: break;
				}	
			}		
			
			meotAlafim = num/100000%10;
			switch(meotAlafim) {
			case 1:meotAlafimS = "one hundred "; break;
			case 2:meotAlafimS = "two hundred "; break;
			case 3:meotAlafimS = "three hundred "; break;
			case 4:meotAlafimS = "four hundred "; break;
			case 5:meotAlafimS = "five hundred "; break;
			case 6:meotAlafimS = "six hundred "; break;
			case 7:meotAlafimS = "seven hundred "; break;
			case 8:meotAlafimS = "eight hundred "; break;
			case 9:meotAlafimS = "nine hundred "; break;
			case 0: break;
			}	
			
			
			million=num%10;
			switch(million) {
			case 1:millionS = "one million "; break;
			case 2:millionS = "two million "; break;
			case 3:millionS = "three million "; break;
			case 4:millionS = "four million "; break;
			case 5:millionS = "five million "; break;
			case 6:millionS = "six million "; break;
			case 7:millionS = "seven million "; break;
			case 8:millionS = "eight million "; break;
			case 9:millionS = "nine million "; break;
			case 0: break;
			}		
		}
		
		String a="";
		if(num<10) 
			a = achadotS;
		else if(num>10 && num<100)
			a=asarotS+achadotS;
		else if(num>100 && num<1000)
			a=meotS+asarotS+achadotS;
		else if(num>1000 && num<10000)
			a=alafimS+", "+meotS+asarotS+achadotS;
		else if(num>10000 && num<100000)
			a=asrotAlafimS+alafimS+", "+meotS+asarotS+achadotS;
		else if(num>100000 && num<1000000)
			a=meotAlafimS+asrotAlafimS+alafimS+", "+meotS+asarotS+achadotS;
		else if(num>1000000 && num<10000000)
			a=millionS+", "+meotAlafimS+asrotAlafimS+alafimS+", "+meotS+asarotS+achadotS;
		
		
		System.out.println("-----"+num+"-----");
//		String a=alafimC+meotC+asarotC+achadotC;
		System.out.println(a);
		
	}
}
