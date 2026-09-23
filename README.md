# ☕ JPAe Coffee

**JPAe Coffee**, Java ve JPA teknolojileri kullanılarak geliştirilmiş, kullanıcı ve yönetici taraflarını içeren web tabanlı bir kahve uygulamasıdır.

Proje; kullanıcıların kahve ürünlerini görüntüleyebildiği ve sipariş işlemleri gerçekleştirebildiği bir kullanıcı arayüzünün yanı sıra, ürün ve uygulama yönetiminin gerçekleştirilebildiği bir **Admin Paneli** içermektedir.

## 📌 Proje Hakkında

JPAe Coffee, Java Web teknolojileri kullanılarak geliştirilmiş bir kahve e-ticaret ve yönetim uygulamasıdır.

Uygulamada iki temel bölüm bulunmaktadır:

* 👤 **Kullanıcı Paneli:** Kahve ürünlerinin görüntülenmesi ve sipariş işlemlerinin gerçekleştirilmesi
* 🔐 **Admin Paneli:** Ürünlerin ve uygulama içerisindeki verilerin yönetilmesi

Projenin veri erişim katmanında **JPA (Java Persistence API)** kullanılarak Java nesneleri ile veritabanı arasındaki veri işlemleri gerçekleştirilmiştir.

Uygulama, **GlassFish Server** üzerinde çalışacak şekilde geliştirilmiştir.

## ✨ Özellikler

### 👤 Kullanıcı Paneli

* ☕ Kahve ürünlerini görüntüleme
* 🛒 Ürünler üzerinden sipariş işlemleri
* 📋 Ürün detaylarını görüntüleme
* 🌐 Web tabanlı kullanıcı arayüzü
* 🔄 Veritabanından dinamik ürün verilerinin görüntülenmesi

### 🔐 Admin Paneli

Admin paneli, uygulamanın yönetim işlemlerinin gerçekleştirilmesini sağlar.

* 📦 Ürün yönetimi
* ➕ Yeni ürün ekleme
* ✏️ Mevcut ürün bilgilerini güncelleme
* 🗑️ Ürün silme
* 📋 Uygulama verilerini yönetme
* 🔑 Admin erişimi ve yönetici işlemleri

## 🛠️ Kullanılan Teknolojiler

| Teknoloji            | Kullanım Alanı                 |
| -------------------- | ------------------------------ |
| **Java**             | Backend ve uygulama geliştirme |
| **JPA**              | ORM ve veritabanı işlemleri    |
| **HTML5**            | Web arayüzü                    |
| **CSS3**             | Arayüz tasarımı                |
| **JavaScript**       | Kullanıcı etkileşimleri        |
| **GlassFish Server** | Uygulama sunucusu              |
| **Apache Ant**       | Build ve proje yönetimi        |
| **NetBeans IDE**     | Geliştirme ortamı              |
| **SQL / Veritabanı** | Veri yönetimi                  |

## 🏗️ Proje Yapısı

```text
JPAe_coffee/
│
├── src/
│   └── Java kaynak kodları
│
├── web/
│   └── Web arayüzü ve frontend dosyaları
│
├── nbproject/
│   └── NetBeans proje yapılandırmaları
│
├── build/
│   └── Build çıktıları
│
├── dist/
│   └── Dağıtım dosyaları
│
└── build.xml
    └── Apache Ant build yapılandırması
```

## 🔄 Uygulama Yapısı

```text
                         ☕ JPAe Coffee
                              │
                ┌─────────────┴─────────────┐
                │                           │
           👤 Kullanıcı                 🔐 Admin
                │                           │
                │                           │
        Ürünleri görüntüle          Ürünleri yönet
        Sipariş işlemleri           Ekle / Güncelle / Sil
                │                           │
                └─────────────┬─────────────┘
                              │
                              ▼
                         JPA / ORM
                              │
                              ▼
                        🗄️ Veritabanı
                              │
                              ▲
                              │
                     GlassFish Server
```

## 🎯 Projenin Amacı

Projenin amacı, Java tabanlı web uygulamalarında **kullanıcı işlemleri, admin yönetimi ve veritabanı etkileşimlerinin** bir arada kullanıldığı bir uygulama geliştirmektir.

Proje kapsamında;

* Java Web uygulaması geliştirme
* JPA ile ORM ve veri erişimi
* CRUD işlemleri
* Kullanıcı ve admin panelleri
* Ürün yönetimi
* Veritabanı işlemleri
* Web arayüzü geliştirme
* GlassFish Server üzerinde uygulama çalıştırma

konularında uygulamalı deneyim kazanılmıştır.

## 📚 Kazanılan Deneyimler

* Java Web Development
* JPA / ORM
* CRUD Operations
* Database Management
* Admin Panel Development
* User Interface Development
* Backend–Database Communication
* GlassFish Server
* Apache Ant
* NetBeans IDE

## 👩‍💻 Geliştirici

**Hatice Gazel**

Software Engineering Graduate

[GitHub](https://github.com/gazellhatice)
