# Tic Tac Toe kata

From [kata-logs](http://kata-log.rocks/tic-tac-toe-kata).

The classic Tic Tac Toe game, implemented in Test Driven Development as a Java console application. 

I used the [Inside-out](https://8thlight.com/blog/georgina-mcfadyen/2016/06/27/inside-out-tdd-vs-outside-in.html ) approach.

**NOTE**: this is still a work in progress version, many stories need to be implemented. 

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

## Instructions

### How to run the tests

From the main root you can use gradle to execute the tests, running

    gradle clean test

### How to build an executable jar file

From the main root run

    gradle clean
    gradle buildJarWithDependencies


### Launch the jar application

Go to the folder

/build/libs

and run

    java -jar tic-tac-toe-kata-all.jar


### How to play the game

Two human players can play the game.

Each player writes the coordinates of the field he wants to take, for example A1.

Player X starts.

The game ends when either three consecutive fields have been taken by a player, or when all the fields have been taken.

## TODO list

* When a field is occupied by a user, skip the move, and let the current player retry

* the app should accept lower case letters: a1 should be valid.

* deal with not valid commands: start ignoring them, then print a message on a prompt

* prompt: print when the game begins, when the game is over, who is the current player, when the command is invalid...

* write good application end-to-end tests

* use Command pattern?

* apply state design pattern in main loop?

* apply object calisthenics rules?

* [OK] simplest case: 1x1 board, only player X. Player X moves, the game ends.

* [OK] only a command in form "A1" is valid

* [OK] no controls on valid command basing on board dimensions. This is a just a kata.

* [OK] I/O with stdin and stdout

* [OK] board 3x3

* [OK] when a player has taken a field, it's the other player's turn 

* [OK] a game is over when all fields in a column are taken by a player

* [OK] a game is over when all fields in a row are taken by a player

* [OK] a game is over when all fields in a diagonal are taken by a player

* [OK] on a 3x3 grid a game is over if all the fields are taken