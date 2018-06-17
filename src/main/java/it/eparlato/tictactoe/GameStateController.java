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
	private GameState gameState = GameState.RUNNING;
	
	public GameStateController (Board board) {
		gameOverConditions = new ArrayList<GameOverCondition>();
		gameOverConditions.add(new AllFieldsHaveBeenTaken(board, this));
		gameOverConditions.add(new HasARowBeenTakenByPlayer(board, this));
		gameOverConditions.add(new HasAColumnBeenTakenByAPlayer(board, this));
		gameOverConditions.add(new UpperLeftBottomRightDiagonalIsTakenByAPlayer(board, this));
		gameOverConditions.add(new UpperRightBottomLeftDiagonalIsTakenByAPlayer(board, this));
	}

	public void checkForGameOver() {
		for (GameOverCondition condition : gameOverConditions) {
			condition.check();
		}
	}

	public void quit() {
		gameState = GameState.QUIT;
	}

	public boolean isGameOverAllFieldsHaveBeenTaken() {
		return gameState.equals(GameState.GAME_OVER_ALL_FIELDS_TAKEN);
	}

	public void gameOverAllFieldsTaken() {
		gameState = GameState.GAME_OVER_ALL_FIELDS_TAKEN;
	}

	public void gameOverAColumnHasBeenTaken() {
		gameState = GameState.GAME_OVER_A_COLUMN_HAS_BEEN_TAKEN;
	}

	public void gameOverARowHasBeenTaken() {
		gameState = GameState.GAME_OVER_A_ROW_HAS_BEEN_TAKEN;
	}

	public boolean isGameOverAllFieldsInDiagonalUpperRightBottomLeftHaveBeenTaken() {
		return gameState.equals(GameState.GAME_OVER_UPPER_RIGHT_BOTTOM_LEFT_DIAGONAL);
	}

	public void gameOverUpperRightBottomLeftDiagonal() {
		gameState = GameState.GAME_OVER_UPPER_RIGHT_BOTTOM_LEFT_DIAGONAL;
	}

	public boolean isGameOverAllFieldsInDiagonalUpperLeftBottomRightHaveBeenTaken() {
		return gameState.equals(GameState.GAME_OVER_UPPER_LEFT_BOTTOM_RIGHT);
	}

	public void gameOverUpperLeftBottomRightDiagonal() {
		gameState = GameState.GAME_OVER_UPPER_LEFT_BOTTOM_RIGHT;
	}

	public boolean isGameOverAllFieldsInAColumnHaveBeenTaken() {
		return gameState.equals(GameState.GAME_OVER_A_COLUMN_HAS_BEEN_TAKEN);
	}

	public boolean isGameOverAllFieldsInARowHaveBeenTaken() {
		return gameState.equals(GameState.GAME_OVER_A_ROW_HAS_BEEN_TAKEN);
	}

	public boolean isGameRunning() {
		return gameState.equals(GameState.RUNNING);
	}

}
