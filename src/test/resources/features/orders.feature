Feature: Manage orders
  In order to maintain the order system
  As an API user
  I want to create, retrieve and delete orders

  Scenario: Create an order
    Given an order with product "Book" and quantity 2
    When the order is saved
    Then the order is persisted successfully

  Scenario: Delete an order
    Given an existing order with product "Pen" and quantity 5
    When the order is deleted
    Then the order no longer exists

  Scenario: Get non-existing order
    When I request an order with id 999
    Then the response status should be 404

  Scenario: Delete non-existing order
    When I delete an order with id 999
    Then the response status should be 404

  Scenario: Get all orders
    Given an existing order with product "Notebook" and quantity 3
    When I request all orders
    Then the response status should be 200

  Scenario: Create order with invalid body
    When I create an order with invalid payload
    Then the response status should be 500
