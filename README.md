# Mini-Java-Casino
CS 3330 Final Project
The program contained in this folder is a mini casino. Luke’s casino hosts three games –
Blackjack, Baccarat, and Casino War. All three games are betting games with the player pitted against
the house. There are no casino betting odds here; all bets have 1:1 odds.
This casino is intended to be played through the command line. There are no Java FX components, so it
can be simply compiled and ran from a command line.

Game Rules
Blackjack – The game of Blackjack is very simple. The goal of the game is to get the closest to a score of
21 without going over. The dealer and the player are both dealt two cards, the dealer shows one while
the player can see either of their cards. The player then decides to hit or stand, hitting deals the player
another card, and stand allows the player to leave their hand as is. The player can continue to hit up
until 21 or higher. Once the player stands, the dealer must hit for a card until a score of at least 16.
Whoever has the score closest to 21 without going over wins. If the player wins, they receive their bet in
full, if they lose, the player loses the bet in full. In the case of a tie, the player gets their bet back.
Card values:
2-9 = Face Value 10-King = 10 Ace = 1 or 11, whichever is preferable

Baccarat – The game of Baccarat is very popular in casinos and has some of the best odds of any game.
The goal of Baccarat is to get the closest score to 9. Any score over 9 has the tens place dropped. The
game starts by two hands being dealt, both face down on the table. The player then chooses which hand
to play, banker or robber, without knowing the value of the cards. Then the cards are shown, and if the
player chose the better hand, they receive their bet in full, if the opposing hand wins, then the player
loses their bet, and in case of a tie the player gets their bet back.
Card values:
2-9 = Face Value 10-King = 0 Ace = 1

Casino War – The game of Casino War is probably the simplest of them all. The dealer and the player
both get dealt one card. Whosever card is higher wins. The card scores are the numerical value of the
card. In the case of a tie, the player can decide to double down on their bet and “go to war,” or get half
of their bet back and forfeit the rest. In war time, four cards are dealt to both the dealer and the player,
and the last card of the four determines the new battle card. Again, whosever card is higher wins. If the
player wins, the player receives their bet in full and if the player loses, they lose their bet.

These games are intended to be played until the player wants to stop. All errors are handled, and the
player should be able to play as many rounds of whatever game they would like. Further, the player
should be able to navigate between games after finishing one game or another.

I hope you enjoy!
