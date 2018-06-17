package it.eparlato.tictactoe;

import java.util.ArrayList;
import java.util.List;

import it.eparlato.tictactoe.gameovercondition.AllFieldsHaveBeenTaken;
import it.eparlato.tictactoe.gameovercondition.GameOverCondition;
import it.eparlato.tictactoe.gameovercondition.HasAColumnBeenTakenByAPlayer;
import it.eparlato.tictactoe.gameovercondition.HasARowBeenTakenByPlayer;
import it.eparlato.tictactoe.gameovercondition.UpperLeftBottomRightDiagonalIsTakenByAPlayer;
import it.eparlato.tictactoe.gameovercondition.UpperRightBottomLeftDiagonalIsTakenByAPlayer;

public class GameStateController {
	
	List<GameOverCondition> gameOverConditions;
	
	GameStateController (Board board) {
		gameOverConditions = new ArrayList<GameOverCondition>();
		gameOverConditions.add(new AllFieldsHaveBeenTaken(board));
		gameOverConditions.add(new HasARowBeenTakenByPlayer(board));
		gameOverConditions.add(new HasAColumnBeenTakenByAPlayer(board));
		gameOverConditions.add(new UpperLeftBottomRightDiagonalIsTakenByAPlayer(board));
		gameOverConditions.add(new UpperRightBottomLeftDiagonalIsTakenByAPlayer(board));
	}

	public boolean isGameOver() {
		
		for (GameOverCondition condition : gameOverConditions) {
			if (condition.isTrue()) {
				return true;
			}
		}

		return false;
	}

}
