Feature: Delete address feature

  Scenario Outline: Delete an address
    Given I am logged in as "<email>" with password "<password>"
    And I am on the address page
    And The address "<alias>" exists in the address list
    When I delete the address "<alias>"
    Then The address should not be displayed in the address list

    Examples:
      | email            | password   | alias |
      | wojtek@wojtek.pl | Masakra!23 | Home  |