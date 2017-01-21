# Greenfield-Tech2

Running instructions:

Enter a search-words in Line 19 in "Program.java"

Make sure that there is a valid "words.txt" file (its possible to change the path in Line 10 in "Program.java")

=================================================================================================================

Problems with the current state:

***Doesn't work with negative weight edges

Possible Solution:
1. Not allow negative weight edges

2. Build a function F: W --> W' {W: E --> Z, W': E --> N} that meet our requirements for each specific case. 
(E = edges, Z = set of all integers, N = set of all Natural Numbers)

For Example:

A:-2:B
A:3:C

W = { w(A,B) = -2, w(A,C) = 3 }

F(W) = W' = { w(A,B) = 1, w(A,C) = 6 } 

***For each search-word the algorithm will re-run from the beginning i.e for k search-words the time-complexity
will be K * O(our-algorithm-time-complexity) = K * O(V) (V=Vertexs). 
For big k its can cause a problem time-complexity wise.
In additional, if we run 2 search-words or more with father-child relation, 
we don't use the information we get from the first run into the run after

Possible Solution: Memoization via extra fields / data-structure
