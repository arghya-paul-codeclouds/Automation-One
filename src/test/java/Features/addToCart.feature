Feature: Add to cart functionality

Scenario Outline: Navigate to desired category successfully
#Given user is on login page
And user enters "<username>" and "<password>"
And user clicks the login submit button
And user sees the Dashboard
When user clicks the "<category>"
Then the "<category>" should reflect in the url
Examples:
|	username	|	password	|	category	|
|	arghya		|	Test@123	|	Biography	|
|	arghya.paul	|	Test@123	|	Fiction		|
|	arghya		|	Test@123	|	Fantasy		|
|	arghya.paul	|	Test@123	|	Romance		|

@before @after
Scenario: Just for testing
Then user does nothing