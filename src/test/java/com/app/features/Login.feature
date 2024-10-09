Feature: Login with valid credentials

  @sanity @regression
  Scenario: Successful login with valid credentials
    Given the user navigates to login page
    When user enters email as "akbarshaik911@gmail.com" and password as "Akbar@0326"
    And the user clicks on the login button
    Then the user should be redirected to the MyAccount page

  #Scenario Outline: Login Data Driven
  #  Given the user navigates to login page
  #  When user enters email as "<email>" and password as "<password>"
  #  And the user clicks on the login button
   # Then the user should be redirected to the MyAccount page

   # Examples: 
   #   | email                     | password |
    #  | pavanol@gmail.com         | test123  |
    #  | pavanlotraining@gmail.com | test@123 |
