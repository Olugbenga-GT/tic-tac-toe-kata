# TODO list

* [OK] When a field is occupied by a user, skip the move, and let the current player retry

* [OK] the app should accept lower case letters: a1 should be valid.

* build a prompt object to show messages: print when the game begins, when the game is over, who is the current player, when the command is invalid...

* deal with not valid commands: start ignoring them, then print a message on a prompt

* write good application end-to-end tests

* apply object calisthenics rules?

* [OK] use Command pattern?

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