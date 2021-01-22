# junitHelper

AbstractTest
------------

If you extend your Test Class with AbstractTest.class this enables the additional Features.
If you have a lot of Tests with a lot of debug messages it is a good idea to have a seperator between each test, so you easily can see which test is currently running.
So at startup the AbstractTest class logs out which Test is started. It then initializes internal veriables to later know which test is currently running.
When the test finishes we then can log a message with the testname and how long it took.

For now the AbstractTest.class directly provides the method assertExpectedResult. 

assertExpectedResult
--------------------


Simplified Assertion to see if the result of an object-value in string
representation is as expected. This gives you a nice view in eclipse for each
sub-value which differs in the JUnit-test-result<br>

in you test you simply call 
	
	assertExpectedResult(seenResultValueObject);

The seenResultValueObject is recursively converted into a string. So we have all
values of the object and its sub-objects in a human readable string. Then
this string-representation of the Object is compared against a file located
in the expectedResults directory
	
	src/test/resources/expectedResult/<package-name>/<testName>-<filenameAddition>.txt
	 
Before comparing a seenResult File is written to always be able to see the
resulting string-representation of the object-value. <br/>
	 
In case of the results not being the same this method writes a file in
src/test/errorResults/. In case of a correct but changed result the
developer/tester can simply copy this file into the same location in
seenResults.<br/>
	 
If no seen Result File is found we use a String which tells us which
seenResult-file we would expect.<br>
e.g.: 
	
	!!!!! ERROR: Missing expected Result File
	src/test/resources/expectedResults/name/ostertag/test/objects/TestObjectsTest/testList.txt
	 
	 

An example how to use it can be seen at:
	
	junitHelper/src/test/java/name/ostertag/test/objects/TestObjectsTest.java

The result templates for this test can be see at:
	
	junitHelper/src/test/resources/expectedResults/name/ostertag/test/objects/TestObjectsTest/*.txt
		

Hint:
since the temporary files should not be commited to the repository you should add the directories to your .gitignore
	
	junitHelper/src/test/resources/seenResults/
	junitHelper/src/test/resources/errorResults/
