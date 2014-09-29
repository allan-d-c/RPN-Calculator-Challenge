RPN Calculator Exercise
=======================

Introduction
------------

This is a pairing programming exercise that we give at my company. The point of this exercise is to assess the
the interaction between the candidate and the interviewer during the coding process. It is not to have anything
in particular running at the end of the exercise, although something running is probably better than nothing.

Having said that, we allot about 90 minutes for the exercise. We will sometimes pass the resulting code to other
engineers for evaluation and were wondering how much time pressure affects the quality of the code. To help answer
this, I decided to actually do the exercise myself.

Problem
-------

You have 90 minutes to design a Java-based RPN (Reverse Polish Notation) calculator that takes a single string
as input and returns a double as output. Example inputs are 

* "1 2 +" should return 3
* "3 4 + 2 *" should return 14

You should support at least addition and multiplication. As a stretch goal, implement variables with assignment
so that the input "3 abc = abc 2 *" should yield 6.

Results
-------

The code in this repo already is unfair to compare to a candidate's submission because I already know the scope of 
the problem (but have not coded any particular solution to it). Also I am not being interviewed, so I'm not under
any real pressure here. 

As a result, I got most of the code running in about 90 minutes. It took an additional 30 minutes beyond that to 
get variables requirement into the mix. Note that the Preconditions.java class was already written by me prior to 
the start of the exercise (it came from another repository of mine). If I had not started with that, I would likely
have used more verbose asserts in its place.

When you look at the code, remember that all design and coding decisions were done in the 90 minutes. I have not
gone back and refactored or made anything better (beyond the additional 30 minutes). I did take some time 
afterwards to walk through the code and put down some self critiques. If I critiqued something, I only did it
the first time I saw the problem, not at each instance of the problem. Note that there was very little time
for testing of the error flow.

Things you'll see that are good:

* Effective use of classes
* Clear separation of concerns
* Some attempt at unit testing
* Almost all methods are short and are quite readable
* Adherence to Clean Coding principles
* Use of open-closed principle (with the exception of the StackableFactory)
* Minimized procedural run-on logic