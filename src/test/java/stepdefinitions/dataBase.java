package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;


import java.sql.*;

public class dataBase {
    String url="jdbc:mysql://194.140.198.209/heallife_hospitaltraining";
    String username="heallife_hospitaltraininguser";
    String password="PI2ZJx@9m^)3";

    Connection connection; // database'e baglantimizi saglayacak
    Statement statement; // database'de istedigimiz query'leri calistirmamizi saglar
    ResultSet resultSet; // statement ile yapilan sorgu sonucunu store etmek icin kullanilir
    @Given("Kullanici data base baglantinisi kurmak icin {string} gerekli ayarlamalari yapar")
    public void kullanici_data_base_baglantinisi_kurmak_icin_gerekli_ayarlamalari_yapar(String Requestquery) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        /*TYPE_SCROLL_INSENSITIVE parametresi, sonuç kümesinin ileri veya geri kaydırılabilir bir sonuç kümesi olduğunu belirtir.
        Bu, sonuç kümesindeki satırları ileri veya geri doğru hareket ettirmenizi sağlar.

         */
        /*
        CONCUR_READ_ONLY parametresi, sonuç kümesinin salt okunur olduğunu belirtir,
         yani sonuç kümesinde yapılan değişikliklerin gerçek veritabanı üzerinde etkisi olmayacaktır.
         */

        String query =Requestquery;
        resultSet = statement.executeQuery(query);

    }

    @Given("Kullanici verilen sutunlardan {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void kullanici_verilen_sutunlardan(String actualName, String actualbirth, String acgender, String acfather, String acadress, String expName, String expBirth, String expGender, String expfather, String expAdress) throws SQLException {
        resultSet.absolute(0);
        resultSet.next();
        Assert.assertEquals("",expName,resultSet.getString(actualName));
        Assert.assertEquals("",expBirth,resultSet.getString(actualbirth));
        Assert.assertEquals("",expGender,resultSet.getString(acgender));
        Assert.assertEquals("",expfather,resultSet.getString(acfather));
        Assert.assertEquals("",expAdress,resultSet.getString(acadress));
    }

    @Given("Kullanici data base den gelen {string} in {string} a ait oldugunu dogrular")
    public void kullanici_data_base_den_gelen_guardian_name_in_kane_stark_a_ait_oldugunu_dogrular(String actualName,String expName) throws SQLException {
      resultSet.absolute(1);
       Assert.assertEquals("",expName,resultSet.getString(actualName));
    }
}
