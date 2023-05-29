@dtb
Feature: US0016 DATA BASE TEST

  Scenario: Database üzerinden death_report tablosundaki ölüm tarihlerine göre en son ölen hastanin guardian_name bilgisinin Kane Stark oldugunu dogrulayiniz.
    * Kullanici data base baglantinisi kurmak icin "select death_date,guardian_name from heallife_hospitaltraining.death_report where death_date order by death_date desc limit 1" gerekli ayarlamalari yapar
    * Kullanici data base den gelen "guardian_name" in "Kane Stark" a ait oldugunu dogrular


