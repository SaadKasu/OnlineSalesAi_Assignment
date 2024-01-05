-> Codes for task 1 and task 2 are written in Java.
-> Springboot is used in task 1 for JUnit(Test Classes) only.
-> Created a spring application in task 2 and to evaluate expression we will need to use the localhost to use the post restApi.

Task 1 :
	
	Assumptions : 
		-> Taken the map with key as String and value as a Double.
		-. If you are going to give map as as string input use this format
		"[ {Key1: value1}, {Key2: value2}, {Key3: value3} ..and so on ]"
		-> All values in maps add up to 100 or 1. example - [ {Head: 0.35}, {Tail: 0.65} ].
		
	To run the code - 
		-> Run the BiasGeneratorClient.java file 
		-> If you are using map as input you need to hardcode values in the BiasGeneratorClient.java file .
		
		
Task 2 :
	Assumptions : 
		-> Use Console for String input or provide requestBody in localhost in the format given below :
			{
				"expressions" : ["2 * 4 * 4", "sqrt(-3^2 - 4^2)"]
			}
		
	To Run the code :
		-> Run the EvaluateExpressionApplication.java file.
		
	To handle more requests than API can support :
		-> If the API supports only 50 request per second and we need to support 500 equations per second. 
			Three options here :
				-> Option 1 : Because the API supports bulk equations. We can club those 500 equations in batches and send it to the API. In this way we are not overusing the allocated requests. This is the best way if API supports Bulk equations. Only extra overhead is how do we batch the requests and output correct results for correct users.
				
				-> Option 2 : Use a messaging queue for the request and every 1 second send a new batch of 50 requests to be processed. Messaging queues are extra implementations and cost but if API does not support bulk equations and we need to not waste cpu resources then this is a good option. 
				
				-> Option 3 : Can use Thread.sleep() and wait for 1 second and then send a request. If it is a medium sized application then Thread.sleep() is not a bad approach if care is taken that no common resources are held while sleeping.
				
				
Task 3 :
	Changes Made : 
		1.) Added <= in elif instead of < 
		2.) Changed range from (1,n-10) to (1,n-9)
		3.) Changed lim in else from n-20 to n-19
		
	Edge Cases :
		1.) Testing for 10, 20 and negative numbers
		2.) Tested for some numbers in each range 0-9, 10-20 and 20+
	
