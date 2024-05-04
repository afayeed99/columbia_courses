Abdul Fayeed Abdul Kadir
aa5042
March 8th, 2024 (Friday)

Resources: There are some functions/codes that I used in this Homework
that are not directly from the lecture's materials. Both were used
in Simulations.java to format the threshold value to 2 decimal places
ONLY when printed out at the terminal, when the optimal threshold(s)
is found.
https://www2.cs.arizona.edu/classes/cs210/fall17/lectures/decimal_format.pdf
a) import java.text.DecimalFormat
b) DecimalFormat df = new DecimalFormat("0.00")

1. ComputerPlayer.java
This class represents the computer player in the game. 
The class can be instantiated with or without parameters.
When the class is instantiated with no parameter,
it will assume a computer player having a threshold of 0.5,
and initialized the computer's token balance to 0.
When user wants to instantiate the class with parameters, 
the class can take two parameters, which represent 2 separate thresholds,
which represents the threshold for two distinct computer players,
and initialized both computers' token balance to 0.

This class has several methods that can be accessed by user.
a) move() - generates random move based on threshold for the computer 
            and return int 1 or 2 for each round.
b) computersChoice(int opponentChoice) - return int 1 or 2 which represents
        Player 1 (odd) or 2 (even) for the computer, 
        based on opponentChoice parameter as Player 1 or 2.
c) calcCompBal(int opponentNum, int compNum, int compChoice)
    - calculate the cumulative token balance for the computer, by taking
    parameters: opponentNum = number chosen by opponent every round,
                compNum = number randomly chosen by computer each round,
                compChoice = computer as Player 1 or 2.
d) getScore() - return int cumulative token balance for the computer.
e) computerReset() - reset the cumulative token balance for computer to 0.
    
2. Game.java
This class represents the Odd-Even game.
This class can be instantiated with or without parameters.
With no parameters, this will be an interactive game.
It will initialized the token balance for human to 0.
With parameters, this will be a simulated game.
It will take the parameter threshold for the two players, where
this will be for two distinct computers per 1 simulation game. 
Each computer's token balance is initialized the way the computer's 
initialize its token balance.

This class has several methods that can be accessed by user:
a) playSession() - interactive method with user, where it starts by
        welcoming the user and letting the user to decide to be 
        Player 1 or 2 per session. 
        It will then ask the user to choose between 1 or 2 for each round.
        At the end of each round, the current score of both players
        will be displayed, and it will ask user if they want to continue
        playing the game or to quit, by entering anything or "q" respectively.
        If the user wish to quit, the winner will be announced and 
        the cumulative token for each player will be displayed.
        This will end the session, and the computer's and user's token
        will be reset to 0 before starting another session. 

b) getP1Score() - return player 1's int cumulative token
c) getP1Score() - return player 2's int cumulative token 
d) play(int games) - simulation games with two computers, where it will
        play "games" number of rounds. At the end of the session,
        each player's token will reset to 0. 

3. OddEven.java
This program is a test class for the interactive game between the human user
and a computer.

4. Simulation.java
This program is the simulation game between two computer players. This program
determines if the game is fair or not. If the game is unfair, it will determine
which player has the advantage and at which threshold value that will ensure
the player always win the game. The simulation is performed by varying the
threshold for each player from 0 to 1 with an increment of 0.01. For each pair
of thresholds, 100,000 games are played and the minimum token that can be 
obtained by the player in reference is recorded. If the minimum token is
positive, then it suggests that the particular threshold will guarantee the
player in reference to always win.

From the simulation that I ran, I found that the game is unfair. Player 1 will
have the advantage to win all the time against Player 2 if Player 1 sets their
threshold to 0.58 or 0.59. From these thresholds, the minimum token balance
Player 1 can obtain at any threshold value of Player 2 remains positive. 
This suggests that Player 1 will be guaranteed to win the game IF their 
threshold is either 0.58 or 0.59. This does not mean that Player 1 will never
win with other threshold; in fact, they may win with other thresholds, but
they may also lose, which is clearly a gamble for Player 1. Thus, Player 1
has to always choose 0.58 or 0.59 as their threshold in order to always win!

However, Player 2 has no advantage against Player 1. This is because at any
threshold value of Player 1, there is no positive minimum token balance
that can be obtained by Player 2. There is a clear disadvantage for Player 2.
This does not mean that Player 2 will never win, but Player 2 has to gamble
on their choice of threshold, where they may win or lose against Player 1, 
depending on Player 1's threshold too. 

To ensure the variability due to the random number generator used in the code,
the Simulation.java is run multiple times. The actual token balance changes,
but the conclusion made above remains, where Player 1 will have the advantage
to win the game with a threshold of 0.58 or 0.59, which suggests that 100,000
games per threshold pair is large enough that minimizes the simulation error.