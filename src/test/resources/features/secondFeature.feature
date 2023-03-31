Feature: Second Feature

  Scenario: Easy Access Scenario
    Given I Login into the application
    When I navigate to "EASY_ACCESS" Module
    Then I select the Administration Option "Companies" in EASY_ACCESS
    And I check row for the following criteria
      | Name      |
      | Ecopetrol |

