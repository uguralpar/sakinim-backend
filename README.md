# Hello World Service

Spring Boot ile hazırlanmış servis, PostgreSQL'de saklanan metni `GET /` isteğinde
`text/plain` olarak döndürür. Uygulama başlarken `schema.sql` tabloyu oluşturur ve
`data.sql` ilk `Hello, World!` kaydını ekler.

## Docker Compose ile çalıştırma

Docker ve Docker Compose kurulu olmalıdır:

```sh
docker compose up --build
```

Servis varsayılan olarak `http://localhost:8080/` adresinde çalışır.
Host portunu değiştirmek için Compose'u başlatmadan önce `APP_PORT` ortam
değişkenini ayarlayın. İsteğe bağlı kontrol:

```sh
curl http://localhost:8080/
```

Docker Compose, PostgreSQL'i ve API'yi birlikte başlatır. API yerel makinede
`http://localhost:8080/` üzerinden erişilebilir; veritabanı yalnızca Compose
ağı içinde kalır. İstemci uygulama, dağıtım sonrasında API'nin herkese açık
adresine `GET /` isteği göndermelidir. İstemci ve API farklı origin'lerde
sunulacaksa tarayıcı istekleri için API'de istemci origin'ine uygun CORS
ayarları ayrıca yapılmalıdır.

## Yerel çalıştırma

Java 17+ (kurulu Java 17.0.14 uygundur), Maven ve erişilebilir bir PostgreSQL veritabanı gerekir. Varsayılan bağlantı
`jdbc:postgresql://localhost:5432/hello` adresini ve `hello` kullanıcı/parolasını kullanır.
Bağlantıyı `DATABASE_URL`, `DATABASE_USERNAME` ve `DATABASE_PASSWORD` ortam değişkenleriyle
özelleştirebilirsiniz.

```sh
mvn spring-boot:run
```

## Testler

```sh
mvn test
```

## CI

GitHub Actions, her push ve pull request'te Java 17 ile `mvn verify` çalıştırır
ve Dockerfile'dan `hello-world-service` imajının oluşturulabildiğini doğrular.
Bu iş akışı imajı bir registry'ye yayımlamaz veya canlı ortama dağıtmaz.
