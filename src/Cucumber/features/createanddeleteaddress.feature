Feature: Create and delete address

  Scenario Outline: User adds and deletes a new address

    Given the user is on the login page
    And the user logs in with email "<email>" and password "<password>"
    When the user navigates to the Addresses section
    And the user clicks on "Create new address"
    And the user fills in the new address form with alias "<alias>", address "<address>", city "<city>", postalCode "<postalCode>", country "<country>", phone "<phone>"
    And the user clicks the Save button
    Then the new address with alias "<alias>", should have correct data  address "<address>", city "<city>", postalCode "<postalCode>", country "<country>", phone "<phone>"

    When the user deletes the address "<alias>"
    Then the address "<alias>" should no longer be displayed in the address list

    Examples:
      | email            | password   | alias | address       | city   | postalCode | country        | phone     |
      | wojtek@wojtek.pl | Masakra!23 | Home  | Kolejowa 38/5 | Kielce | 12345      | United Kingdom | 722223344 |