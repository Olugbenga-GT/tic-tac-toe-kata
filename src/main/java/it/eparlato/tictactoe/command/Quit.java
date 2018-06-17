package it.eparlato.tictactoe.command;

import it.eparlato.tictactoe.GameStateController;

public class Quit implements Command {

	private GameStateController gameStateController;

	public Quit(GameStateController gameStateController) {
		this.gameStateController = gameStateController;
	}

	@Override
	public void execute() {
		gameStateController.quit();
	}

}
