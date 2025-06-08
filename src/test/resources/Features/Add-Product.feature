Feature: Add-Product

  @AddProduct
  Scenario: Add successful
    Given user berada di dasboard page
    When user klik button produk
    And User klik button tambah
    And user input nama produk
    And user input deskripsi produk
    And user input harga beli produk
    And user input harga jual produk
    And user input jumlah stok
    And user memilih jenis kategori produk
    And user klik button simpan
    Then user berhasil menambahkan produk

  @AddProduct
  Scenario: Add failed
    Given user berada di dasboard page
    When user klik button produk
    And User klik button tambah
    And user input nama produk
    And user input deskripsi produk
    And user input harga beli produk
    And user empty harga jual produk
    And user empty jumlah stok
    And user memilih jenis kategori produk
    And user klik button simpan
    Then user gagal menambahkan produk dan mendapatkan notifikasi error