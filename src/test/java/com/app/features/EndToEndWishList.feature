Feature: User should search the product and added to wishlist

@regressiontest
Scenario: Successfully product added to wish list
	Given the user navigates to login page
	And user enters valid email as "akbarshaik911@gmail.com" and password as "Akbar@0326"
	When user search the item "MacBook"
	And add searched item "MacBook" to wish list
	Then go to the wishlist page
	And verify the item "MacBook" added to the cart