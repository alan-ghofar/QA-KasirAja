Feature: Login


@BDD
Scenario: Positif
  Given User berada di login page
  When User memasukkan email dan password
  And User klik button login
  Then User berhasil login

@BDD
  Scenario: Negatif
  Given User berada di login page
  When User memasukkan email dan password salah
  And User klik button login
  Then User gagal login

@TDD
Scenario Outline:
  Given User berada di login page
  When User input <email> and <password>
  And User klik button login
  Then User verify login <result>

Examples:
|email| |password| |result|
|alan@gmail.com| |alan| |true|
|email error|    |alan| |false|
|alan@gmail.com| |password error| |false|
