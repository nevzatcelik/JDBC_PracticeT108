
Feature: US0011

  Scenario: Database üzerinden blood_donor tablosundaki id= 7 olan donorun donor_name'i Maria, date_of_birth=2001-03-02, gender=Female, father_name=Jhonson, address=England oldugunu dogrulayiniz.

  * Kullanici data base baglantinisi kurmak icin "select * from heallife_hospitaltraining.blood_donor where id=7;" gerekli ayarlamalari yapar
  * Kullanici verilen sutunlardan "donor_name" "date_of_birth" "gender" "father_name" "address" "Maria" "2001-03-02" "Female" "Jhonson" "England"

  Scenario: diger
    * Kullanici data base baglantinisi kurmak icin "select * from heallife_hospitaltraining.blood_donor where id=5" gerekli ayarlamalari yapar
