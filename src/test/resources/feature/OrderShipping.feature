Feature: Order Shipping
  Scenario: Get shipping address for an order
    Given I have the order number 115
    And it is present in the system
    When I call shipping address service
    Then the shipping address should be "Dwarka, Delhi"