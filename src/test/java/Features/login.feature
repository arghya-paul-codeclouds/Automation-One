@Login
Feature: Login functionality

#Background:
#Given user is on login page

@Smoke @Regression
Scenario Outline: Successful login with valid credentials

When user enters "<username>" and "<password>"
And user clicks the login submit button
Then user sees the Dashboard
Examples:
|	username	|	password	|
|	arghya		|	Test@123	|
|	arghya.paul	|	Test@123	|

@Regression
Scenario Outline: Unsuccessful login with invalid credentials

When user enters "<username>" and "<password>"
And user clicks the login submit button
Then user remains on the login page

@Staging
Examples:
|	username	|	password	|
|	arghy		|	Test@1234	|
|	arghya.pau	|	Test@1234	|

@Production
Examples:
|	username	|	password	|
|	arghy_P		|	Test@1234	|
|	arghya.pau_P|	Test@1234	|