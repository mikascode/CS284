package hw3;
//Name:Rashmika Batra 
//I pledge my honor that I have abided by the Stevens Honor System. 
//Recitation RI 

public class MultiplayerGame {
	
	private GameEntity[] index; 
	private GameEntity turnTaker; 
	
	public MultiplayerGame(int n) {
		//creates a new MultiplayerGame with n players.
		if (n<=0) { 
			throw new IllegalArgumentException ("Please enter a positive number greater than 0 ");
		}
		
		index= new GameEntity [n]; 
		 
		 for (int i=0;  i<n;  i++) {
			  
			index[i] = new GamePlayer(null,null, i); 
		
		 }
		 
		 for (int i=0;  i<n;  i++) {
			 
			 if(i==0) { 
				 
				 index[i].next = index[i+1]; 
				 index[i].prev = index[n-1]; 
 
			 }
			 
			 else if(i==n-1) { 
				 
				 index[i].next = index[0]; 
				 index[i].prev = index[i-1]; 
 
			 }
			 	else { 
			 index[i].next = index[i+1]; 
			 index[i].prev = index[i-1]; 
		 }
		 } 
		 }
	
	
	public int size() {
		//returns the size of the MultiplayerGame
		
		GameEntity current = index[0]; 
		int size= 0; 
		
		while (current.next!=index[0]) {
			
			size= current.size() + size; 
			
			current= current.next; 
		}
		
		size+=current.size(); 
		return size; 
		
		}
	
	
	



public void addGamePiece(int playerId, String name, int strength) {
	
	//adds a GamePiece owned by specified player of the given strength to the game. 
	
	 if ( playerId> index.length-1|| playerId<0) { 
		 throw new IllegalArgumentException ("addGamePiece: no such player"); 
		 
	 }
	 
	 if (helpercontains(playerId, name)){ 
		 
		 throw new IllegalArgumentException ("addGamePiece: duplicate entity"); 
	 }
	
	
	
	 GamePiece newPiece = new GamePiece( null, null, name, strength );  
	 
	 GameEntity current= index[playerId]; 
	 
	 
	 current= current.next; 
	 
	 
	 while (!current.isGamePlayer()) {
		 
		 if (((GamePiece)current).getStrength() < strength ) { 
			 
			 break; 
		
		 }
		 
		 current= current.next; 
		 
	 }
	
	 current.prev.next= newPiece; 
	 
	 newPiece.prev= current.prev; 
	 
	 current.prev= newPiece; 
	 
	 newPiece.next= current; 
	 
	 
}
	 

	
	
	
	public void removeGamePiece(int playerId, String name) {
		//removes the GamePiece owned by specified player of the given name.
		 
		 if ( playerId> index.length-1|| playerId<0) { 
			 throw new IllegalArgumentException ("removePlayer: no such player"); 
			 
		 }
		
		 if ( !helpercontains(playerId, name)){ 
			 
			 throw new IllegalArgumentException ("removePlayer: entity does not exist"); 
		 }
			 
		 
		 GameEntity current= index[playerId]; 
		 
		 current= current.next; 
		 
		
		 
		
		 while (!current.isGamePlayer()) {

			 if (((GamePiece)current).getName()==name ) { 
				 
				 break;
			 }
			 
			 current=current.next; 
				
		 	}
			 
			 current.prev.next= current.next; 
			 current.next.prev=current.prev; 
			
			 
			} 
	
	
	private boolean helpercontains (int playerId, String name) { 
		//helper function 
		
		GameEntity current= index[playerId]; 
		current=current.next; 
		
		
		 while (!current.isGamePlayer()) {
				
				if(current.getName() == name) {
					
					return true;
				}
				 
				current = current.next; 
			 	
				} 
			
		return false; 
	}
		 
	 public boolean hasGamePiece (String name) { 
		 // checks if any player has a GamePiece of the given name.
		 
			
		GameEntity current= index[0]; 
		 
		while ((current.next!=index[0]) ) { 
			
			if (!(current.isGamePlayer())){ 
				
				if(current.getName() == name) {
					
					return true;
				}
				}
				 
				current = current.next; 
			 	
				} 
			
		return false; 
		 		}

	 
	 
	 public void removeAllGamePieces(int playerId) { 
		 // removes all the GamePieces owned by specified player.
		 if ( playerId> index.length-1|| playerId<0) { 
			
			 throw new IllegalArgumentException ("removeAllGamePieces: no such player"); 
			 
		 }
		 
		 GameEntity current= index[playerId]; 
		 current=current.next; 
		 
		 while (!current.isGamePlayer()) {		 
			 
			 removeGamePiece(playerId,current.getName()); 
			 
			 current = current.next; 
			 	
				} 
		 
	 }
	 
	 

	
	public void increaseStrength(int playerId, int n) {
		//increases the strength of all GamePieces owned by the specified player by n.
		
		if ( playerId> index.length-1|| playerId<0) { 
			 throw new IllegalArgumentException ("increaseStrength: no such player"); 
			 
		 }
		
		GameEntity current= index[playerId]; 
		current= current.next; 
	

		 while (!current.isGamePlayer()) { 
			((GamePiece) current).updateStrength(n); 
			current=current.next; 
			
	
		 }
		 
		 
			 
	}
	
	public void removePlayer(int playerId) {
		//removes the GamePlayer and all their GamePieces from the game. 
		if ( playerId> index.length-1|| playerId<0) { 
			 throw new IllegalArgumentException ("removePlayer: no such player"); 
			 
		 }
		removeAllGamePieces(playerId); 
		GameEntity current= index[playerId]; 

			 current.prev.next= current.next; 
			 current.next.prev=current.prev; 
			
			 
			} 
	

	
	
	public void swapPieces(int playerId1, int playerid2) { 
		//swaps the GamePieces of the two specified players.
		
		if ( playerId1> index.length-1|| playerId1<0) { 
			 throw new IllegalArgumentException ("swap: no such player"); 
			 
		 }
		 if ( playerid2> index.length-1|| playerid2<0) { 
			 throw new IllegalArgumentException ("swap: no such player"); 
		 }
		 
		 if ( index[playerId1].next.isGamePlayer() && index[playerid2].next.isGamePlayer()) { 
				
				return; 
			}
		 if ( index[playerId1].next.isGamePlayer() ) { 
				
				return; 
			}
		 GameEntity tail1; 
		 if (playerId1==index.length-1) { 
			  tail1=index[0].prev; 
			 
		 }
		 
		 else { 
			  tail1= index[playerId1+1].prev; 
			 
		 }
		 
		 GameEntity tail2; 
		 
		 if (playerid2==index.length-1) { 
			 tail2=index[0].prev; 
			 
		 }
		 
		 else { 
			  tail2= index[playerid2+1].prev; 
		 }
		 
		GameEntity a =  index[playerId1].next; 
		GameEntity b =  index[playerid2].next; 
		
		index[playerId1].next= b; 
		index[playerid2].next= a; 
		a.prev= index[playerid2]; 
		b.prev= index[playerId1]; 
		
		
		 if (playerId1==index.length-1) { 
			 index[0].prev= tail2; 
			 tail2.next=index[0]; 
			 
		 }
		 
		 else { 
			 index[playerId1+1].prev= tail2; 	
			 tail2.next=index[playerId1+1]; 
		 }
		 
		 if (playerid2==index.length-1) { 
			 index[0].prev= tail1; 
			 tail1.next=index[0]; 
			 
			
			 
		 }
		 
		 else { 
				index[playerid2+1].prev= tail1; 
				tail1.next=index[playerid2+1]; 
		 }
		
	}
	
	public String toString() { 
		//produces a String representation of the MultiplayerGame. 
		 
		GameEntity current= index[0]; 
		
		String string = "["; 
		
		while (current.next!=index[0]) { 
			
			string+=current.toString() + "; " ; 
			
			current= current.next;
			
		}
		string+=current.toString() + "]" ; 
		
		return string; 
		
	}
	
	
	public void initializeTurnTracker () {
		//sets the turnTracker to the first GamePlayer
		
		turnTaker= index[0]; 
		
	}
	
	public void nextPlayer () {
		// moves the turnTracker to the next GamePlayer.
		
		while (!turnTaker.isGamePlayer());  {
			
			turnTaker=turnTaker.next; 
		}
				
			
		turnTaker= turnTaker.next; 
		
	}
	
	public void prevPlayer () {
		//backtracks the turnTracker to the previous GamePlayer.

	while (!turnTaker.isGamePlayer());  {
			
			turnTaker=turnTaker.prev; 
		}
				
			
		turnTaker= turnTaker.prev; 
		
	}
	
	public void nextEntity () {
		//moves to next entity 

		turnTaker= turnTaker.next; 
		
	}

	public String currentEntityToString () { 
		//returns the string representation of the current entity pointed to by the turnTracker.
		
		String  s = turnTaker.toString(); 
		return s;
}


	
	public static void main(String[] args) {
		MultiplayerGame g1 = new MultiplayerGame(3);
		g1.addGamePiece(2, "BluePiece", 5);
		g1.addGamePiece(1, "PurplePiece", 2);
		g1.addGamePiece(1, "OrangePiece", 17);
		System.out.println(g1.toString());
		g1.swapPieces(2, 1);
		System.out.println(g1.toString());
		System.out.println(g1.size());
		
		
		//Expected output: 
		//[Player0; Player1; GamePiece: OrangePiece strength: 17; GamePiece: PurplePiece strength: 2; Player2; GamePiece: BluePiece strength: 5]
		
		MultiplayerGame g2 = new MultiplayerGame(3);
		g2.addGamePiece(2, "BluePiece", 5);
		g2.addGamePiece(1, "PurplePiece", 2);
		g2.addGamePiece(1, "OrangePiece", 17);
		g2.removePlayer(1);
		
		
		System.out.println(g2.toString());
		g2.removeAllGamePieces(1);
		System.out.println(g2.toString());
	
		//Expected output:
		//[Player0; Player2; GamePiece: BluePiece strength: 8]
		
		MultiplayerGame g3 = new MultiplayerGame(3);
		g3.addGamePiece(2, "BluePiece", 5);
		g3.addGamePiece(1, "PurplePiece", 2);
		g3.addGamePiece(1, "OrangePiece", 17);
		g3.removeGamePiece(1, "PurplePiece");
		System.out.println(g3.hasGamePiece("OrangePiece")); 
		System.out.println(g3.hasGamePiece("yea")); 
		System.out.println(g3.toString());
		
		//Expected output:
		//[Player0; Player1; GamePiece: OrangePiece strength: 17; Player2; GamePiece: BluePiece strength: 5]
	}

}

