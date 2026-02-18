Feature: Manage orders
  In order to maintain the gift system
  As an API user
  I want to create, retrieve and delete gifts

  Scenario: Create an gift
    Given a gift with product "Book" and quantity 2
    When the gift is saved
    Then the gift is persisted successfully

  Scenario outline: Create an gift
     Given a gift with product <prod> and quantity <qty>
     When the gift is saved
     Then the gift is persisted successfully

  Example:
  |prod|qty|
  |"Book"|1|
  |"Pen"|5|
  |"Photo"|2|


  Scenario: Delete an gift
    Given an existing gift with product "Pen" and quantity 5
    When the gift is deleted
    Then the gift no longer exists

  Scenario: Get non-existing gift
    When I request a gift with id 999
    Then the response status should be 404

  Scenario: Delete non-existing gift
    When I delete a gift with id 999
    Then the response status should be 404

  Scenario: Get all gifts
    Given an existing gift with product "Notebook" and quantity 3
    When I request all gifts
    Then the response status should be 200

  Scenario: Create gift with invalid body
    When I create a gift with invalid payload
    Then the response status should be 500
