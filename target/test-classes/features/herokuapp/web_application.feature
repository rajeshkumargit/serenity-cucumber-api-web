@all-web
Feature: web application navigation

As a user I want to navigate through Herokuapp web application

@auth
Scenario Outline: Successful authorization with valid credentials

Given application is launched with basic auth "<username>","<password>"
Then validate the authentication message "<message>"

Examples:
|username|password|message          |
|admin	 |admin	  |Congratulations	|
|admin	 |test	  |Not authorized		|

@redirect
Scenario: Successful redirection to home page

Given application is launched with path "disappearing_elements"
When user clicks on the Home link
Then user gets redirected to Home page "Welcome to the-internet"

@drop-down
Scenario Outline: Selecting options from a dropdown list

Given application is launched with path "dropdown"
When user selects the dropdown option "<option>"
Then selected item appears with the option "<option>"

Examples:
|option|
|Option 1|
|Option 2|

@iframe
Scenario: Using iframe window
Given application is launched with path "iframe"
When user selects the File menu
And clicks on the New Document sub-menu
Then user could type "IFrames still used in legacy websites" on the text area





