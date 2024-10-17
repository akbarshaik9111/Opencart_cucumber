Feature: User should search the product and added to cart

  @regressiontest
  Scenario Outline: product successfully added to the cart
    Given the user navigates to login page
    And user enters valid email as "akbarshaik911@gmail.com" and password as "Akbar@0326"
    When user search the item <productname>
    And add searched item <productname> to wish list
    Then go to the shopping cart page
    And verify the searched item <productname> added to the cart

    Examples:
    | productname |
    | iphone      |