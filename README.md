# rangecalculator

## BACKGROUND

Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5-digit codes. For example, if the ranges are:

 

[94133,94133] [94200,94299] [94600,94699]

 

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

 Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

###### PROBLEM

Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

 

###### NOTES

- The ranges above are just examples, your implementation should work for any set of arbitrary ranges

- Ranges may be provided in arbitrary order

- Ranges may or may not overlap

- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

 

###### EXAMPLES:

If the input = [94133,94133] [94200,94299] [94600,94699]

Then the output should be = [94133,94133] [94200,94299] [94600,94699]

 

If the input = [94133,94133] [94200,94299] [94226,94399]

Then the output should be = [94133,94133] [94200,94399]


## =============== Project Highlights ==================

To test run this project , Command line arguments can be provided or can add inputs in Junit tests to execute .

#### IMP NOTE : Jar has already been created and pushed into github. If latest jar can not be created, then jar can be downloaded from rangecalculator/build/libs folder.

prerequisite for environement setup : 

###### Java 8 or above 
###### git version 2.32.0.windows.1
###### gradle 7.1


#### STEPS to execute rangecalce-1.0-SNAPSHOT.jar

1. Clone rangecalculator project from github into local system.
2. Go to rangecalculator folder from command line and run 

~/eclipse-workspace/github/rangecalculator/
$ gradle build

###### Note : gradle build also executes Junit testcases available at /src/test/java

~/eclipse-workspace/github/rangecalculator/build/libs (main)
$ java -jar rangecalce-1.0-SNAPSHOT.jar [10000,20000] [20000,25000] [20000,30000] [10000,15000] [70000,70001]


******************************
********RANGE CALCULATOR******
******************************

---- TESTCASE ----
INPUT ZIPCODE RANGE :
[[10000,20000], [20000,25000], [20000,30000], [10000,15000], [70000,70001]]

OUTPUT ZIPCODE RANGE :
[[10000,30000], [70000,70001]]

#### ===============================Support of Zipcodes starting with ZEROS===============================

$ java -jar rangecalce-1.0-SNAPSHOT.jar [00000,00001] [00001,060000] [10000,20000] [20000,25000] [20000,30000] [10000,15000] [70000,70001]
******************************
********RANGE CALCULATOR******
******************************

Range string [00001,060000] is in an invalid format.  Use [nnnnn,nnnnn]

---- TESTCASE ----
INPUT ZIPCODE RANGE :
[[00000,00001], [10000,20000], [20000,25000], [20000,30000], [10000,15000], [70000,70001]]

ZipCode must be non ZERO digit :[00000,00001]

OUTPUT ZIPCODE RANGE :
[[10000,30000], [70000,70001]]


### Note : "00000" treated as invalid Zipcode and invalid pairs are removed and results are based on valid ZipCodes.

###### NOTE : something like above can be seen at commandline after executing java -jar commmad. Here, INPUT ZIPCODE RANGE shows what input has been provided from commandline and then , OUTPUT ZIPCDOE RANGE : provides final output for minumum zipcode list derived.

#### ===============Code Coverage is 87.3 %========================



<img width="788" alt="Code_Coverage" src="https://user-images.githubusercontent.com/43265292/124636464-90091480-de56-11eb-9809-7071cec939a8.PNG">

