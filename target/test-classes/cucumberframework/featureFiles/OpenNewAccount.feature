Feature: Create new Account in the ParaBank website
  Description: I want to use this template to create a new account

  Background: User is Logged In
    Given User navigates to the  website
    And User enters valid username 
    And User enters valid password 
    When User clicks on the Login button
    Then User is taken to home page successfully
    
  Scenario Outline: Login to the ParaBank website with valid credentials  
    Given User clicks on Open New Account button
    And User selects from the account type drop down "<accounttype>"
    And User selects from the account number drop down "<accountnumber>"
    When User clicks on the Open New Account button
    Then User is taken to congratulations account opened page successfully "<success>"
    
  Examples: 
      | accounttype  | accountnumber | success         |
      | CHECKING     | 18006         | Account Opened! |
      
