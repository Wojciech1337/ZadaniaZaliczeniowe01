Feature: Login User

Scenario Outline: Successful login
Given I'm on the login page
When I log in with email "<email>" and password "<password>"
Then I should be on the account page

Examples:
| email            | password   |
| wojtek@wojtek.pl | Masakra!23 |

