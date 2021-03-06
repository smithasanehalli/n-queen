# N-Queen
The N Queen problem is problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
There are different approaches to solve this, I am choosing Back track and Genetic algorithm and highlighting the pros and cons of both approaches.

## Little introduction to understand the solutions:

- There are total 64!/(56!*8! ) different possible combinations to place 8 queens on 8*8 chess board.
- Out of which there are only 92 possible combinations to place 8 queens on 8*8 chess board without attacking each other.

## 1. Backtracking Algorithm
- Backtracking is an approach for exploring problems that involve making choices from a set of possible choices 
- The worst case “brute force” solution for the N-queens puzzle has an O(n^n) time complexity.
- After all optimisation avoiding same column and diagonal(using depth first search), time complexity can be reduced to O(n!) I.e for 8 queens 8! = 40320.
- This approach is faster if we only need any one solution out of 92 solutions.
- Number of iterations grows exponentially to find out all 92 solution 
- Best approach in terms of space required because as soon as we hit a blocking state we back track and remove the state we don’t need to save all states.
- More efficient for smaller N
- As the N increases it becomes slower, when N=26 it would take forever!. Number of iteration increases exponentially as N increases.

## 2. Genetic Algorithm 
- Genetic algorithm works by creating a few random solution(within the range) and then start eliminating the faulty ones to get the right fit or result with crossover and mutations.
- This techniq is little complex than back track approach for smaller N value. Works best for Larger N.
- While Randomisation technique is good for AI and Machine learning programms, but it comes with a cost of space because we have to create more random  possible combinations and store all these states and work on them to get attest one valid solution.
- For N queen problem, number of possible choices are more 64!/56!*8! and valid solutions are only 92, this technique will take more time to get the result because possible choices are huge compared to valid solutions, this technique works good for larger values of N(something like 26 and above) 
- where the possible solutions are more and time required to eliminate faulty ones will be less hense chances of finding the solution is more.
- Analogy is similar to picking a random fruit from a basket of fruits to identify whether it is good or bad.If the basket contains 50 fruits, 45 good and 5 rotten, it takes less picks to get a good fruit but If the basket has 45 rotten fruit and only 5 good fruits, it takes more picks to get a good fruit.
- Along with the space factor, time taken to find solution increases when there are more possible combinations and very few valid combinations
- When the num of  valid solutions are more compared to possible combinations of states, then we can create less population(possible random combinations) and find the good children(valid solution state ) with few crossover and mutation(less number of calculations).


