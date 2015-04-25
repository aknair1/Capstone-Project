------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Chess

1. I created a chess board program that can be used to play 1 player vs. computer chess or 2 player chess. This gamemode allows you to drop your king (you are allowed to move into check) and en passant and winner detection 
is not available.

2. First my capstone uses the gridworld package which we learned in unit 3 for the game of life lab. However in that lab we only did a little with gridworld(it was just our method of displaying cells). I had to research how to create 
custom actors(by extending critter), I learned how to use custom sprites and rotate images, I also learned how to call methods on actors directly from the grid screen.

   Second my capstone uses array lists to keep track of legal moves and keep track of each color's pieces. I was planning on using a 2D Array for the board but gridworld proved to be much better
   
   Third my capstone uses many loops and conditional statements. Calcuating the legal moves took a lot of planning and testing
   
   Fourth my capstone uses (slightly) good class design from unit 7. More importantly a huge component of my capstone was based on inheritance, abstract classes, polymorphism, and (in previous versions) interfaces. I was able to remove 
   my interface by taking full advantage of polymorphism and learning that you could have an abstract class extend from a non abstract class.
   
   Sadly I was not able to use recursion in my program, if I had more time I could implement some methods that use recursion to improve my computer's moves(Currently it does random legal moves).
   
4. How to run:  I am not sure if the gridworld.jar soure file is already added to the library. It is located in the capstone BlueJ project folder if needed.
                If do not want the black(upside down) pieces to automatically move set the computer constant in the piece class to false.
                You should run the main method of my board class(or just create a new board). 
                Next right click on the piece you want to move and select the makeMove method. Enter the coordinates (x,y). You can hold the cursor over the square you would like to move to, to see what its coordinates are. 
                    It isn't a standard coordinate plane(it is like a 2D array).
                Enjoy(the computer is extremely easy to beat; it does only random moves.