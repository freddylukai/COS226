/******************************************************************************
 *  Name: Kai Lu    
 *  NetID: kail  
 *  Precept: P02A
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 * 
 *  Operating system: Windows 10
 *  Compiler: Javac
 *  Text editor / IDE: Intellij
 *
 *  Have you taken (part of) this course before: No
 *  Have you taken (part of) the Coursera course Algorithm, Part I: No
 *
 *  Hours to complete assignment (optional): 1-2
 *
 ******************************************************************************/


/******************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates?
 *****************************************************************************/

There's two arrays of size N^2 which initializes at the beginning;
these arrays contain data on whether the node is connected at the top
and whether its connected at the bottom.

Every time a gate is opened, a single connection in the array is potentially
updated; it only changes if whether there's a connection to the top and to the
bottom is created (when it checks to see if any of the four gates around it are
open and connects to them). If any of these new connections result in a pathway
from the top to the bottom, the boolean value "percolates" is updated. Checking
percolation simply checks the boolean.


/******************************************************************************
 *  Using Percolation with QuickFindUF.java, give a formula (using tilde
 *  notation) for the running time (in seconds) of PercolationStats.java
 *  as a function of both N and T.
 *
 *  Model the running time as a power law and be sure to give both the
 *  coefficient and exponent of the leading term. Your coefficients
 *  should be based on empirical data and rounded to two significant
 *  digits, such as 5.3*10^-8 * N^5.0 T^1.5.
 *****************************************************************************/

(keep T constant)

 N          time (seconds)
------------------------------
50          0.092
100         1.055
200         14.06
300         66.164
400         208.492


(keep N constant)

 T          time (seconds)
------------------------------
25          3.678
50          7.17
100         14.06
200         27.626
400         56.028


running time as a function of N and T:  ~8.2e-11 * N^4.0 * T^1.0


/******************************************************************************
 *  Repeat the previous question, but use WeightedQuickUnionUF.java.
 *****************************************************************************/

(keep T constant)

 N          time (seconds)
------------------------------
100         0.1
200         0.324
400         1.214
800         7.285
1600        37.419


(keep N constant)

 T          time (seconds)
------------------------------
50          3.506
100         7.285
200         13.447
400         28.338
800         52.487


running time as a function of N and T: 1.2e-7 ~  N^2.0 * T^1.0




/******************************************************************************
 *  After reading the course collaboration policy, answer the
 *  following short quiz. This counts for a portion of your grade.
 *  Write down the answers in the space below.
 *****************************************************************************/
1. b
2. c

1. How much help can you give a fellow student taking COS 226?
(a) None. Only the preceptors and lab TAs can help.
(b) You can discuss ideas and concepts but students can get help
    debugging their code only from a preceptor, lab TA, or
    student who has already passed COS 226.
(c) You can help a student by discussing ideas, selecting data
    structures, and debugging their code.
(d) You can help a student by emailing him/her your code.

2. What are the rules when partnering?
 (a) You and your partner must both be present while writing code.
     But after that only one person needs to do the analysis.
 (b) You and your partner must both be present while writing code
     and during the analysis, but, after that, only one person
     needs to be present while submitting the code and the
     readme.
 (c) You and your partner must both be present while writing code,
     during the analysis, and while submitting the code and the
     readme. Failure to do so is a violation of the course
     collaboration policy.
 
/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
N/A



/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
N/A


/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
N/A



/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/