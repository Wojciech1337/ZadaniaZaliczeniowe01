Feature: New address

  Scenario Outline: Add a new address
    Given I am logged in as "<email>" with password "<password>"
    When I go to the Addresses section
    And I click Create new address
    And I fill in new address form with:
      | alias      | <alias>      |
      | address    | <address>    |
      | city       | <city>       |
      | postalCode | <postalCode> |
      | country    | <country>    |
      | phone      | <phone>      |
    Then The new address "<alias>" is displayed in the address list

    Examples:
      | email            | password   | alias | address       | city      | postalCode | country       | phone     |
      | wojtek@wojtek.pl | Masakra!23 | Home  | Kolejowa 38/5 | Kielce | 12345      | United States | 722223344 |