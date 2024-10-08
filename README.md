# Nesine Cucumber Web Test Otomasyon Framework'ü 

## 1. Kurulum
   Proje için gerekli temel kurulumları yapmak oldukça basit. Aşağıdaki adımları takip edin:

* Maven ve Java'nın sisteminize yüklü olduğundan emin olun.
* Allure raporlaması için de allure kurulumu gerekmektedir. Bunun için Allure CLI yükleyin.
* Projeyi IntelliJ IDEA ile açın ve tüm Maven bağımlılıklarını indirerek projeyi hazır hale getirin.

## 2. Projeyi Başlatmadan Önce
* Testleri çalıştırmadan önce yapmanız gereken bazı önemli adımlar var:

* ``nesine_cucumber_web\src\test\resources\data\test\user_credentials.json`` dosyasına gidip bu dosyada <span style="color:red">**TCKN**</span> ve <span style="color:red">**PASSWORD**</span> alanlarını doldurmalısınız:

```json {
{
  "user": {
    "tckn": "x",
    "username": "y",
    "password": "z",
    "memberId": "a",
    "phoneNumber": "b",
    "team": "Galatasaray",
    "city": "Muğla",
    "district": "Marmaris"
  }
}
```

* IntelliJ IDEA üzerinde testleri çalıştırmak için Runner sınıfı üzerinden testng.xml dosyasının yolunu seçin. Bunun için IntelliJ'de Edit Configurations kısmından TestNG yapılandırmasını açarak suite yolunu testng.xml dosyasına yönlendirin. Bu dosya, testlerin paralel çalışmasını sağlar.

## 3. Dockerize Proje (Tercihen)
Projeyi dockerize etmek isterseniz aşağıda ki adımları takip ediniz

Aşağıdaki komutla Docker imajını oluşturun:
```bash
docker build -t nesine_cucumber_web .
```

Docker imajını kullanarak bir konteyner çalıştırın:
```bash
docker run -d --name nesine_cucumber_web-container nesine_cucumber_web
```

## 4. Testlerden Sonra Allure Rapor Almak

Testler çalıştıktan sonra sonuçları raporlamak için Allure'yi şu şekilde kullanabilirsiniz:
```bash
allure serve
```
Bu komut ile Allure test sonuçlarını tarayıcıda görüntüleyebilir ve detaylı raporları inceleyebilirsiniz.


## 5. Projenin Genel Yapısı
   Projenin yapısı aşağıdaki gibidir:

* ``config`` dizini altında uygulamanın yapılandırma dosyaları bulunur. Buradan test_config.properties dosyasını düzenleyerek tarayıcı, URL ve paralel test sayısı gibi ayarlamaları yapabilirsiniz.
* ``helpers`` dizini altında projenin ihtiyaç duyduğu gereklilikler vardır. 
* ``common/*json`` altında testler için gerekli olan ve her ortamda var olan static veriler yer alır.
* ``test/*json`` altında test ortamı için gerekli veriler yer alır.
* ``pages`` dizini altında Page Object Model (POM) yapısında sayfa sınıfları bulunur. Bu sınıflar üzerinden uygulamanın çeşitli bölümleriyle etkileşim kurulur. 
* ``runners`` dizini altında ise testlerin başlatılmasını sağlayan Runner sınıfı yer almaktadır. Bu sınıf TestNG kullanarak testlerin paralel çalışmasını sağlar.
* ``MainHooks`` Testler başlamadan önce ve sonra kritik aksiyonları yönetir. WebDriver başlatma, tarayıcı kapatma, test başarısız olduğunda ekran görüntüsü alma ve raporlama gibi işlemler burada yapılır. Başarılı ya da başarısız olan senaryoların loglanması ve gerektiğinde ekran görüntülerinin Allure raporlarına eklenmesi sağlanır.
* ``PreConditionHooks:`` Tekrar eden ihtiyaçlar için oluşturulan hook sınıfları. Bu case'in ihtiyaç duyduğu verileri api ile oluşturmayada yarar veya static tekrar eden işlemleri gerçekleştirmeyede yarar.





