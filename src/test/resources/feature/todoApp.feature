Feature: Todo App

@Web
Scenario: Add a task to the todo list
Given I have a task "Buy_EV"
When I hit enter on the task field
Then The task should be added successfully