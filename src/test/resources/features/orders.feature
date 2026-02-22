Feature: Manage gifts
  In order to maintain the gift system
  As an API user
  I want to create, retrieve and delete gifts

  Scenario: Create an gift
    Given a gift with product "Book", quantity 2 and description "To do homework"
    When the gift is saved
    Then the gift is persisted successfully

  Scenario Outline: Create an gift
    Given a gift with product <prod>, quantity <qty> and description <dcn>
    When the gift is saved
    Then the gift is persisted successfully

    Examples:
      | prod    | qty | dcn                                   |
      | "Book"  | 1   | "To do Homework"                      |
      | "Pen"   | 5   | "Light and durable"                   |
      | "Photo" | 2   | "When we were happy and not divorced" |


  Scenario: Delete an gift
    Given an existing gift with product "Pen", quantity 5 and description "Light and durable"
    When the gift is deleted
    Then the gift no longer exists

  Scenario: Get non-existing gift
    When I request a gift with id 999
    Then the response status should be 404

  Scenario: Delete non-existing gift
    When I delete a gift with id 999
    Then the response status should be 404

  Scenario: Get all gifts
    Given an existing gift with product "Notebook", quantity 3 and description "To do Homework"
    When I request all gifts
    Then the response status should be 200

  Scenario: Create gift with invalid body
    When I create a gift with invalid payload
    Then the response status should be 500

