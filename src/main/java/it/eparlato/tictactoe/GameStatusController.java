package it.eparlato.tictactoe;

import java.util.ArrayList;
import java.util.List;

import gameovercondition.AllFieldsHaveBeenTaken;
import gameovercondition.GameOverCondition;
import gameovercondition.HasAColumnBeenTakenByAPlayer;
import gameovercondition.HasARowBeenTakenByPlayer;
import gameovercondition.UpperLeftBottomRightDiagonalIsTakenByAPlayer;
import gameovercondition.UpperRightBottomLeftDiagonalIsTakenByAPlayer;

public class GameStatusController {
	
	List<GameOverCondition> gameOverConditions;
	
	GameStatusController (Board board) {
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
