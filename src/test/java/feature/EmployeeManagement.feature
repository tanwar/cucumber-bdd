#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Employee Management
Documentation line for this feature.

  Scenario: Add an Employee
    Given I have an employee with name "Amar" and salry 30000
    When I add this employee to company systems
    Then New employee with name "Amar" should be added successfully
    
    
  Scenario: Add an Employee - flavour 2
    Given I have an employee with name "Bhawana" 
    And salry 50000
    When I add this employee to company systems
    Then New employee with name "Bhawana" should be added successfully
    
    
 Scenario: Add an Employee - flavour 3
    Given I have an employee with name "Vanshika" 
    And salry of 70000.00
    When I add this employee to company systems
    Then New employee with name "Vanshika" should be added successfully   
