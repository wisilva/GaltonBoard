# GaltonBoard
This project is designed to simulate a Galton Board, a device that displays a normal distribution by probability.

Running the Main method will bring up a two-tabbed window. This will bring up six rows of numbers, each containing 
one more digit than the previous row (similar to a Pascal's Triangle). The number is either 0 or 1.

Pressing the "Next" button will move the 1 on the board one row down and one across, either to the left or right.
The horizontal direction the 1 moves is decided randomly.

When the 1 reaches the bottom row, it will be added permanently to the row, and the 1 will move back to the top.
The corresponding space in the Graph will increase in height.

To speed up the process, enter any number of 1s into the text box and press the "Full" button to run it that many 
times. This can only be done when an individual run is not in progress (the 1 must be at the top of the board). 
There is no maximum number of runs, but in order to keep the top of the graph in the window, it would be best to keep
the number at around 400 maximum.

You can click on the graph at any time to see the distribution of places where the numbers ended up. It will usually 
be similar to normal distribution (increasing as the graph approaches the center).
