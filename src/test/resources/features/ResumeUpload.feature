Feature: Upload


  @wip
  Scenario: Sample CV yükleme

  Given Kullanıcı url sayfasına gider
  And   "Roof Stack Yazılım" yazarak arama yapar
  Then  Arama sonuçlarında roofstacks.com sayfasına tıklar
  And   Anasayfada career butonuna tıklar
  Then  Product pozision seçilir
  And   Lead Product Tester seçilir
  Then  Sayfanın Product Tester sayfasında olup olmadığı doğrulanır
  And   SendCV buttonu tıklanır
  And   Kullanıcı email adresini girer
  Then  Sample bir CV dosya upload butonuna basılarak paylaşılır


