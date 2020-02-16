@rest-all
Feature: Employee Details

Scenario: Get All Employee Details
	Given users requests employee details with path "employees"
	Then receives a response code "200"
	
Scenario Outline: Get particular employee details
	Given users requests employee details with path "employee/<id>"
	When receives a response code "200"
	Then compares the output with the expected data "<id>","<emp_name>","<age>","<salary","<image">

Examples:
|id|emp_name|age|salary|image|
|17|Paul Byrd|64|725000|64|

Scenario: page not found error
	When users posts employee details with path "update/21"
	Then receives a response code "404"

