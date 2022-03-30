# ProbAndStats

**PROJECT 1**
In the Project 1 branch, you will find a few different simulations that utilize the Monte-Carlo method as well as programs that are capable
of performing various operations seen in Set Theory and Combinatorics. This group of programs serves as a portfolio of material needed for
introductory Probability and Statistics. Each program includes two java files (one of which is a tester class), and an output screenshot
to display the result of calling the main method. There is one additional program in this folder that pertains closer to a supplemental coding
skill but valuable for the scope of this topic: writing data to a csv file to be opened with Excel or similar spreadsheet tool.


**PROJECT 2**
In the project 2 branch, you will find four folders that group the work by Distribution programs, a Plotter program, a Poker hand Simulation,
and output screenshots. In the Distributions folder, you will find four programs of similar style that are Binomial, Geometric, Hyper-Geometric, 
and Poisson Distributions. Each program uses the probability mass function of the distribution type to calculate probability given a parameter.
Each program also has methods to calculate variance and expected values of the distributions. The comments in these programs provide plenty of 
explanation as to when to use each distribution. In addition, there is a PDF file in this branch labeled documentation that will go into further 
detail as far as the scope of this work. Inside the PokerHands simulation folder, you will find four java files that represent objects along with 
a tester class. This program effectively creates a deck of cards, shuffles it randomly, draws five cards from the top, and determines which poker
hand is the highest valued hand present (i.e. straight, flush, four of a kind). The ProbabilitySimulation class uses the Monte-Carlo method as 
in Project 1 to calculate the experimental probability for drawing each poker hand. This simulation can be run up to 1,000,000 times before seeing
any noticeable delay in results (seconds at most). Handevaluator is the most important file in this program as it is heavily documented with javadoc
comments to explain both the logic behind each method, and the overall purpose of the class. This will be followed up with a HandRanker class in the 
future as it will serve as the backbone for a virtual poker game. Finally, the plot program includes three classes with some inheritence between them.
Plotter serves as an object that will create and write an array of OrderedPair objects to a csv file that can be displayed as a graph using excel.
The salter program essentially accepts a dataset (typically from plotter) and 'salts' the data. This new dataset can be written to a csv file and 
displayed as a graph as before. Similarly, the Smoother program will accept a (typically salted) dataset and 'smooth' it. Detailed explanation of
these programs can be found in the documentation PDF in this branch.
