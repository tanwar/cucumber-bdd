Feature: Order management

Scenario: Get the list of orders
Given I have a start date "2020-06-06" and end date "2020-06-09"
When I search for the orders in our system
Then Search should result in success with code 200
And Response should return a list of order numbers
|115|116|

Scenario: Get order number for price > 8000

Given I have a start date "2020-06-06" and end date "2020-06-09"
When I search for the orders in our system
Then Search should result in success with code 200
And ordernumber should be 115
And response should be under 1000 milis