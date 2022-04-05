package hw3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultiplayerGameTest {

	@Test
	void MultiplayerGameCheck() {
		assertThrows(IllegalArgumentException.class,() ->{ 
			MultiplayerGame failNegative= new MultiplayerGame(-1);
		});
		assertThrows(IllegalArgumentException.class,() ->{ 
			MultiplayerGame failZero= new MultiplayerGame(0);
		}); 
		
		
	}
	@Test
	void addGamePieceCheck() {
		
		MultiplayerGame g7 = new MultiplayerGame(3);
		g7.addGamePiece(2, "Spongebob", 5);
		g7.addGamePiece(1, "Patrick", 2);
		g7.addGamePiece(1, "Squidward", 17);
		assertEquals(g7.size(),3); 
		
		MultiplayerGame g1 = new MultiplayerGame(3);
		g1.addGamePiece(2, "BluePiece", 5);
		g1.addGamePiece(1, "PurplePiece", 2);
		g1.addGamePiece(1, "OrangePiece", 17);
	
	}
	
	@Test
	void removeGamePieceCheck() {
		MultiplayerGame g6 = new MultiplayerGame(3);
		g6.addGamePiece(2, "Spongebob", 5);
		g6.addGamePiece(1, "Patrick", 2);
		g6.addGamePiece(1, "Squidward", 17);
		g6.removeGamePiece(2, "Spongebob");
		assertEquals(g6.size(),2); 
		
	}
	
	@Test
	void hasGamePieceCheck() {
		MultiplayerGame g3 = new MultiplayerGame(3);
		g3.addGamePiece(2, "BluePiece", 5);
		g3.addGamePiece(1, "PurplePiece", 2);
		g3.addGamePiece(1, "OrangePiece", 17);
		g3.removeGamePiece(1, "PurplePiece");
	    assertTrue(g3.hasGamePiece("OrangePiece")); 
	    assertFalse(g3.hasGamePiece("Patrick")); 
	}
	@Test
	void increaseStrengthCheck() {
		MultiplayerGame g3 = new MultiplayerGame(3);
		assertThrows(IllegalArgumentException.class,() ->{ 
			g3.increaseStrength(-5, 7);
		}); 	
	}
	@Test
	void SwapPiecesCheck() {
		MultiplayerGame g1 = new MultiplayerGame(3);
		g1.addGamePiece(2, "BluePiece", 5);
		g1.addGamePiece(1, "PurplePiece", 2);
		g1.addGamePiece(1, "OrangePiece", 17);
		g1.swapPieces(2, 1); 
		assertEquals(g1.toString(), "[Player0; Player1; GamePiece: BluePiece strength: 5; Player2; GamePiece: OrangePiece strength: 17; GamePiece: PurplePiece strength: 2]"); 
	
	}
	
	@Test
	void removeAllGamePiecesCheck() {
		MultiplayerGame g1 = new MultiplayerGame(3);
		g1.addGamePiece(2, "BluePiece", 5);
		g1.addGamePiece(1, "PurplePiece", 2);
		g1.addGamePiece(1, "OrangePiece", 17);
		g1.removeAllGamePieces(1);
		assertEquals(g1.size(),1); 
	
	}
	
	
	@Test
	void removePlayerCheck() {
		MultiplayerGame g1 = new MultiplayerGame(3);
		g1.addGamePiece(2, "BluePiece", 5);
		g1.addGamePiece(1, "PurplePiece", 2);
		g1.addGamePiece(1, "OrangePiece", 17);
		g1.removePlayer(1);
		assertEquals(g1.size(),1); 
	
	}
	


}
