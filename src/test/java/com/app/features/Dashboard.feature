Feature: Verify the URL and Title of the page

  Scenario: Verify the page URL and title
    Given the user navigates to the dashboard page
    When verify the page URL
    Then verify the page title