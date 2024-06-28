Feature: implementing Salesforce login


Scenario: Check Login Error Msg

Given the url "https://login.salesforce.com/"
When i land in "LoginPage"
When i enter the username as "radhi@company.sandbox"
And i clear the password
And i click on the button
Then i should see the error msg 

Scenario: login using correct Username and password

Given the url "https://login.salesforce.com/"
When i land in "LoginPage"
When i enter the username as "radhi@company.sandbox"
And i enter the password as "Saikrisha@123"
And i click on the button


Scenario: Test the remember me username checkbox

Given the url "https://login.salesforce.com/"
When i land in "LoginPage"
When i enter the username as "radhi@company.sandbox"
And i enter the password as "Saikrisha@123"
And i click on the rememberme checkbox
And i click on the button
When i land in "SalesforceHomePage"
And i click on Usermenudropdown
And i click on Logout


Scenario: Test Forgotpassword
Given the url "https://login.salesforce.com/"
When i land in "LoginPage"
When i enter the username as "radhi@company.sandbox"
When i click forgotPassword
When i land in "ForgotPasswordPage"
And i enter the username in forgotPage as "radhi@company.sandbox"
Then i click Continue

Scenario: login using incorrect username and password

Given the url "https://login.salesforce.com/"
When i land in "LoginPage"
When i enter the username as "212134"
And i enter the password as "1234"
And i click on the button
Then i should see the error msg












