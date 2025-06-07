Feature: Registrasi

  @Register
  Scenario: Registrasi
    Given User berada di registrasi page
    When user input nama toko
    And User input email
    And User input password
    And User klik button daftar
    Then User berhasil registrasi