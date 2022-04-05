//Name: Rashmika Batra, Recitation Section: RI

//Pledge: I pledge my honor that I have abided by the Stevens Honor System. 


import java.lang.Math.random; 
import java.util.random; 
import java.util.Arrays; 


public class CoinPurse {
	//data fields
		private int numGalleons; 
		private int numSickles; 
		private int numKnuts; 
		private static final int CAPACITY=256; 
		
		public CoinPurse(){
			//creates an empty coin purse
			
			this.numGalleons=0; 
			this.numSickles=0; 
			this.numKnuts=0; 
		}
		
		public CoinPurse(int g, int s, int k){
			//creates a Coin Purse containing g Galleons, s Sickles and k Knuts 
			
			//error if coins exceed capacity 
			if (g+s+k>CAPACITY) {
				throw new IllegalArgumentException("Too many coins"); 
			}
			
			if (g<0 ||s<0 || k<0) {
				throw new IllegalArgumentException("Please enter a positive number"); 
			}
			
			this.numGalleons=g; 
			this.numSickles=s;  
			this.numKnuts=k; 
			
			}
		
		public void depositGalleons(int n) {
			//adds n Galleons 
			
			//error if coins exceed capacity 
			
			if (numGalleons+numSickles+numKnuts+n>CAPACITY) {
				throw new IllegalArgumentException("Too many coins deposited"); 
			} 
			
			if (n<0) {
				throw new IllegalArgumentException("Please enter a positive number"); 
			} 
			this.numGalleons=numGalleons+n;  
			}
		
		public void depositSickles(int n) {
			//adds n Sickles
			
			//error if coins exceed capacity 
			if (numGalleons+numSickles+numKnuts+n>CAPACITY) {
				throw new IllegalArgumentException("Too many coins deposited"); 
			} 
			if (n<0) {
				throw new IllegalArgumentException("Please enter a positive number"); 
			} 
			this.numSickles=numSickles+n;  
			
			}
		
		public void depositKnuts(int n) {
			//adds n Knuts 
			
			//error if coins exceed capacity 
			if (numGalleons+numSickles+numKnuts+n>CAPACITY) {
				throw new IllegalArgumentException("Too many coins deposited"); 
			} 
			
			if (n<0) {
				throw new IllegalArgumentException("Please enter a positive number"); 
			} 
			this.numKnuts=numKnuts+n;
			}
		
		public void withdrawGalleons(int n) { 
			//withdraws n Galleons 
			//error if too many coins are taken out
			if (numGalleons+numSickles+numKnuts-n<0) {
				throw new IllegalArgumentException("Too many coins withdrawm"); 
			} 
			if (n<0) {
				throw new IllegalArgumentException("Please enter a positive number"); 
			} 
			this.numGalleons=numGalleons-n; 
			}
		
		public void withdrawSickles(int n) {
			//withdraws n Sickles 
			//error if too many coins are taken out
			if (numGalleons+numSickles+numKnuts-n<0) {
				throw new IllegalArgumentException("Too many coins withdrawn"); 
			} 
			if (n<0) {
				throw new IllegalArgumentException("Please enter a positive number"); 
			} 
			this.numSickles=numSickles-n;
			}
		
		public void withdrawKnuts(int n) {
			//withdraws n Knuts 
			//error if too many coins are taken out
			if (numGalleons+numSickles+numKnuts-n<0) {
				throw new IllegalArgumentException("Too many coins withdrawn"); 
			} 
			if (n<0) {
				throw new IllegalArgumentException("Please enter a positive number"); 
			} 
			this.numKnuts=numKnuts-n;	
			}
		
		public int numCoins() { 
			//returns the number of coins in the CoinPurse
			return numGalleons+numSickles+numKnuts; 
		}
		
		public int totalValue() { 
			//returns the value in Knuts of the CoinPurse 
			return (numGalleons*493)+(numSickles*29)+numKnuts;
		}
		
		public String toString() { 
			//returns a string denoting the current contents of the CoinPurse 
			return "Galleons: " + numGalleons + " Sickles: " + numSickles + " Knuts: "+ numKnuts; 
		}
		
		public boolean exactChange(int n) { 
			 //returns true if there is some subset of the coins in CoinPurse whose combined value is exactly n 
			if (n<0) {
				throw new IllegalArgumentException("Please enter a positive number"); 
			} 
			if (n>totalValue()) {
				throw new IllegalArgumentException("You don't have enough money"); 
			} 
			
			 
			 int change = n; 
			 int galleonChange = 0; 
			 int sickleChange= 0; 
			 int knutChange= 0; 
			 int numgChange=this.numGalleons; 
			 int numsChange=this.numSickles; 
			 int numkChange=this.numKnuts; 
			 
			 while ((numgChange+numsChange+numkChange)>0) { 
				 
				 if (change >= 493 && numgChange>0) { 
					 change -=493; 
					 galleonChange+=1; 
					 numgChange-= 1; 
					 
					 if(change==0) { 
						 return true; 
					 }
				 	 }	 
				 
				 else if (change >= 29 && numsChange>0) { 
					 
					 change -= 29; 
					 sickleChange += 1; 
					 numsChange-=1; 
					 
					 if(change==0) { 
						 return true; 
					 }			 
				 	 }
				 
				 else if (change >=1 && numkChange>0) { 
					 change -=1;
					 knutChange+=1; 
					 numkChange-=1; 
					 
					 if(change==0) { 
						 return true; 
					 }
				 } else { 
						
						return false; 
				 	} 
				 	} 
			 
			 
			 if (change==0) { 
				 return true; 
			 }
			 
			 else { 
				 return false; 
			 }
		 }
			  
		public int [] withdraw (int n){  
			//if there is exact change, withdraws that change and returns an array representing how many of each type of coin are taken out. 
			//if there isn't exact change, withdraws and returns an array with the smallest value that is larger than n
			 
			if (n<0) {
				throw new IllegalArgumentException("Please enter a positive number"); 
			} 
			if (n>totalValue()) {
				throw new IllegalArgumentException("You don't have enough money"); 
			} 
			
			
			
			 int change= n; 
			 int sickles=0; 
			 int galleons=0; 
			 int knuts=0; 
			 
			 while  (!exactChange(change)){
				 
					 if (change>totalValue()) {
							throw new IllegalArgumentException("Please enter a positive number"); 
						} 	
				 
				 change+=1;  
				 
			 	} 
			 while (change>0) { 
					 
					 if (change>=493) { 
						 change-= 493;
						 galleons+=1; 
						 numGalleons-=1; 
					 }
					 
					 else if (change>=29) { 
						 change-= 29;
						 sickles+=1; 
						 numSickles-=1; 
					 }
					 
					 else if (change>=1) { 
						 change-=1;
						 knuts+=1; 
						 numKnuts-=1; 
					 }
				 }  
			
			
			 int [] array = {galleons,sickles,knuts}; 
			 
			 return array; 
		 } 
		 
		public int drawRandCoin() { 
			//draws a coin at random from the CoinPurse, returning 0 for Knut, 1 for Sickle and 2 for Galleon.
			 if (numCoins()==0) {
					throw new IllegalArgumentException("No coins avalible"); 
				} 
			 
			 double probnumCoins= numCoins(); 
			 double probg= numGalleons/probnumCoins; 
			 double probs= numSickles/probnumCoins; 
			 double probk= numKnuts/probnumCoins; 
			 double random= Math.random();
			 
			 
			 if (0<=random && random<probg) {
				 return 2;  
				} 
			 else if (probg<=random && random<probg+probs) { 
				 return 1; 
			 }
			
			 else { 
				 return 0; 
			 }
		 } 
			 
		public int[] drawRandSequence(int n) { 
			// Returns an array of length n, representing a random sequence of n coins
			 
			if (numCoins()==0) {
					throw new IllegalArgumentException("No coins avalible"); 
				} 
			
			if (n<0) {
				throw new IllegalArgumentException("Please enter a positive number"); 
			} 
			
			int[] array = new int[n]; 
			
			for (int i=0; i<n; i++) { 
				
				array[i]= drawRandCoin(); 
			} 
			return array; 
				
			}
		
		public static int compareSequences(int [] CoinSeq1, int [] CoinSeq2 ) { 
			//compares two coin sequences, element by element
			
			if (CoinSeq1.length==0) {
				throw new IllegalArgumentException("Do not enter an emty array"); 
			} 
			
			if (CoinSeq2.length==0) {
				throw new IllegalArgumentException("Do not enter an empty array"); 
			} 
			
			if (CoinSeq1.length!=CoinSeq2.length) { 
				throw new IllegalArgumentException("Please enter arrays of the same length"); 
			} 
			
			
			int size = CoinSeq1.length; 
			
			int [] scoreTotal= new int [size]; 
			
			
			for (int i= 0; i < size; i++) { 
				
				scoreTotal[i]= CoinSeq1[i] - CoinSeq2[i]; 
			} 
			
			int sum= 0; 
			
			for (int i=0; i<size; i++ ) { 
				
				sum+=scoreTotal[i]; 	
			}
			if (sum>0) { 
				
				return 1; 
			}
			
			else if (sum ==0) { 
				return 0; 
			}
			
			else { 
				
				return -1; 
			}
		}
		
		public int helperdrawRandCoin(int ng, int ns, int nk) { 
			//helper function for bonus question, updating probabilities
			 if (ng+ns+nk==0) {
					throw new IllegalArgumentException("No coins avalible"); 
				} 
			 
			 double probnumCoins= ng+ns+nk; 
			 double probg= ng/probnumCoins; 
			 double probs= ns/probnumCoins; 
			 double probk= nk/probnumCoins; 
			 double random= Math.random();
			 
			 if (0<=random && random<probg) {
				 return 2;  
				} 
			 else if (probg<=random && random<probg+probs) { 
				 return 1; 
			 	}
			
			 else { 
				 return 0; 
			 	}
		 	} 
		
		public int[] drawRandSequenceNoRepl(int n) { 
			//returns a random array of coins, assuming each is taken out after each draw 
		
		
			if (numCoins()==0) {
				throw new IllegalArgumentException("No coins avalible"); 
			} 
			
			if (n>numCoins()) {
				throw new IllegalArgumentException("Not enough coins"); 
			} 
			
			
			if (n<0) {
				throw new IllegalArgumentException("Please enter a positive number"); 
			} 
			int numg=numGalleons; 
			int nums=numSickles; 
			int numk=numKnuts; 
			
			int[] array = new int[n]; 
			
			
			for (int i=0; i<n; i++) { 
				
				array[i]= helperdrawRandCoin(numg, nums, numk); 
				
				if (array[i]==0) { 
					
					numk-=1; 
				}  
				
				else if (array[i]==1) { 
						
						nums-=1; 
				}  
				
				else if (array[i]==2) { 
					
					numg-=1; 
				}  
				} 
			
			return array; 
				} 
		
		public static void main (String[]args) {
			//testing
			CoinPurse cp1 = new CoinPurse();
			CoinPurse cp2 = new CoinPurse(100,100,54); 
			int[] array1 = {0,1,2,2,0}; 
			int[] array2 = {1,1,1,2,2}; 
			System.out.println(compareSequences(array1,array2)); 
			CoinPurse cp3 = new CoinPurse(2,5,10);  
			System.out.println("knuts " + cp2.numKnuts);
			cp2.withdrawKnuts(1); 
			System.out.println("withdrawn knuts " +cp2.numKnuts);
			System.out.println(cp2.numCoins());
			System.out.println(cp2.totalValue());
			System.out.println(cp2.toString());
			//System.out.println(Math.random()); 
			System.out.println(cp2.drawRandCoin()); 
			System.out.println(cp3.exactChange(564)); 
			System.out.println(Arrays.toString(cp3.withdraw(564)));
			System.out.println(cp3); 
			System.out.println(Arrays.toString(cp3.drawRandSequenceNoRepl(5))); 
			
		}
}
