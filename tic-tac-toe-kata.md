# Tic Tac Toe kata

## Rules

In random order

* a game is over when all fields are taken
* a game has nine fields in a 3x3 grid
* a player can take a field if not already taken
* there are two players in the game (X and O)
* players take turns taking fields until the game is over
* a game is over when all fields in a column are taken by a player
* a game is over when all fields in a row are taken by a player
* a game is over when all fields in a diagonal are taken by a player

## TODO list

* [OK] simplest case: 1x1 board, only player X. Player X moves, the game ends.

* [OK] only a command in form "A1" is valid

* [OK] no controls on valid command basing on board dimensions. This is a just a kata.

* [OK] I/O with stdin and stdout

* [OK] board 3x3

* [OK] when a player has taken a field, it's the other player's turn 

* on a 3x3 grid a game is over if all the fields are taken

* prompt status: when the game begins, when the game is over...

* application end-to-end tests