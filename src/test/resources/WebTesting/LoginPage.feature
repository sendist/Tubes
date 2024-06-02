Feature: Login to Swag Labs

  Background:
    Given User is on Swag Labs Login page

  @ValidAccount @TC01
  Scenario: Berhasil melakukan login dengan mengisi credential valid
    When User enters username as "standard_user" and password as "secret_sauce"
    Then User should be able to login successfully and navigated to dashboard page

  @PasswordEmpty @TC02
  Scenario: Login gagal diakibatkan password tidak terisi
    When User enters username as "standard_user" and password as ""
    Then User should see an error message "You need Password !"

  @UsernameEmpty @TC03
  Scenario: Login gagal diakibatkan username tidak terisi
    When User enters username as "" and password as "rahasia123"
    Then User should see an error message "You need Username !"

  @UsernamePasswordInvalid @TC04
  Scenario Outline: Login gagal diakibatkan username dan password tidak terdaftar pada sistem
    When User enters username as "<username>" and password as "<password>"
    Then User should see an error message "<errorMessage>"

    Examples:
      | username      | password     | errorMessage                                           | test case        |
      | admin123    | admin321 | Username and password do not match any user in this service! | username password tidak terdaftar |

  @UsernamePasswordEmpty @TC05
  Scenario: Login gagal diakibatkan username dan password tidak terisi
    When User enters username as "" and password as ""
    Then User should see an error message "You need Username & Password!"

  @UsernamePasswordNotMatch @TC06
  Scenario Outline: Login gagal diakibatkan password tidak sesuai dengan username yang terdaftar pada sistem
    When User enters username as "<username>" and password as "<password>"
    Then User should see an error message "<errorMessage>"

    Examples:
      | username      | password     | errorMessage                   | test case        |
      | standar_user  | admin123     | Username and password do not match any user in this service ! | invalid password |
