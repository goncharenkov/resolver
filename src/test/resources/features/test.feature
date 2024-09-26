Feature: Home Page Tests

  Scenario: Test 1 - Login Form
    Given I navigate to the home page
    Then I should see the email and password fields and the login button
    When I enter "test@example.com" and "password123" in the login form
    And I click on the login button

  Scenario: Test 2 - List Group
    Given I navigate to the home page
    Then I should see 3 items in the list group
    And the second item's value should be "List Item 2"
    And the badge value should be 6

  Scenario: Test 3 - Dropdown Menu
    Given I navigate to the home page
    Then the default selected value should be "Option 1"
    When I select "Option 3" from the dropdown menu
    Then the selected value should be "Option 3"

  Scenario: Test 4 - Button States
    Given I navigate to the home page
    Then the first button should be enabled
    And the second button should be disabled

  Scenario: Test 5 - Delayed Button Click
    Given I navigate to the home page
    When I wait for the button to appear and click it
    Then a success message should be displayed
    And the button should be disabled

  Scenario: Test 6 - Grid Cell Value
    Given I navigate to the home page
    Then the value of the cell at coordinates 2, 2 should be "Ventosanzap"
