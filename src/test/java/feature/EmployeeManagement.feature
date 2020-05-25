
Feature: Employee Management
Documentation line for this feature.


#Background: Add an Employee
#    Given I have an employee with name "Amar" and salry 30000
#    When I add this employee to company systems
#    Then New employee with name "Amar" should be added successfully

@NightlyBuild
  Scenario: Add an Employee
    Given I have an employee with name "Amar" and salry 30000
    When I add this employee to company systems
    Then New employee with name "Amar" should be added successfully
    
@SmokeTest    
  Scenario: Add an Employee - flavour 2
    Given I have an employee with name "Bhawana" 
    And salry 50000
    When I add this employee to company systems
    Then New employee with name "Bhawana" should be added successfully
    
    
 @NightlyBuild @CoverageTest
 Scenario: Add an Employee - flavour 3
    Given I have an employee with name "Vanshika" 
    And salry of 70000.00
    When I add this employee to company systems
    Then New employee with name "Vanshika" should be added successfully   

    @Datatable
 Scenario: Add an Employee - flavour 4
    Given I have an employee
    |Amar|30000| 
    When I add this employee to company systems
    Then New employee with name "Amar" should be added successfully
    
    
      @ListOfListOfString
 Scenario: Add an Employee - flavour 5
    Given I have a list of employees
    |Amar|30000|
    |Amar|30000|
    |Amar|30000|
    When I add this employee to company systems
    Then New employee with name "Amar" should be added successfully
    
    
    @ListOfMap
 Scenario: Add an Employee - flavour 6
    Given I have a list of employees in a key value pair
    |Name|Salary|
    |Amar|30000 |
    |Amar|30000 |
    |Amar|30000 |
    When I add this employee to company systems
    Then New employee with name "Amar" should be added successfully
    
    
  
  @Outline
 Scenario Outline: Calculate employee Salary
   Given I have salary <Salary> of an employee
   And I have the tax percent <Tax> %
   When I calculate the salary after tax
   Then It should return <FinalSalary>
   
   Examples: 
   |Salary|Tax |FinalSalary|
   |1000  |2.5 |975.0      |
   |5000  |12.5|4375.0     |
    
    
    
    
    
    
    
    
    
    