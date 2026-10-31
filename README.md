# Hello World Service

Spring Boot ile hazırlanmış servis, PostgreSQL'de saklanan metni `GET /` isteğinde
`text/plain` olarak döndürür. Uygulama başlarken `schema.sql` tabloyu oluşturur ve
`data.sql` ilk `Hello, World!` kaydını ekler.

## Docker Compose ile çalıştırma

Docker ve Docker Compose kurulu olmalıdır:

```sh
docker compose up --build
```

Servis `http://localhost:8080/` adresinde çalışır. İsteğe bağlı kontrol:

```sh
curl http://localhost:8080/
```

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
