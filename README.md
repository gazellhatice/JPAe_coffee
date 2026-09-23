# ☕ JPAe Coffee

**JPAe Coffee**, Java ve JPA teknolojileri kullanılarak geliştirilmiş, kullanıcı ve yönetici taraflarını içeren web tabanlı bir kahve uygulamasıdır.

Proje; kullanıcıların kahve ürünlerini görüntüleyebildiği ve uygulama üzerinden işlemler gerçekleştirebildiği bir kullanıcı arayüzünün yanı sıra, ürün ve uygulama yönetiminin gerçekleştirilebildiği bir **Admin Paneli** içermektedir.

## 📌 Proje Hakkında

JPAe Coffee, Java Web teknolojileri kullanılarak geliştirilmiş bir kahve e-ticaret/yönetim uygulamasıdır.

Uygulamada iki temel kullanıcı deneyimi bulunmaktadır:

* 👤 **Kullanıcı Paneli:** Kahve ürünlerinin görüntülenmesi ve kullanıcı işlemlerinin gerçekleştirilmesi
* 🔐 **Admin Paneli:** Uygulama ve ürün bilgilerinin yönetilmesi

Projenin veri erişim katmanında **JPA (Java Persistence API)** kullanılarak Java nesneleri ile veritabanı arasındaki ilişkilerin yönetilmesi sağlanmıştır.

## ✨ Özellikler

### 👤 Kullanıcı Tarafı

* ☕ Kahve ürünlerini görüntüleme
* 🛒 Ürünler üzerinden sipariş işlemleri
* 🌐 Web tabanlı kullanıcı arayüzü
* 📋 Ürün bilgilerini görüntüleme
* 🔄 Veritabanındaki bilgilerle dinamik veri alışverişi

### 🔐 Admin Paneli

Admin paneli, uygulamanın yönetim işlemlerinin gerçekleştirilebilmesi için geliştirilmiştir.

Admin tarafında;

* 📦 Ürünlerin yönetilmesi
* ➕ Yeni ürün ekleme
* ✏️ Mevcut ürün bilgilerini güncelleme
* 🗑️ Ürün silme
* 📋 Ürün ve uygulama verilerini yönetme
* 🔑 Yönetici erişiminin kontrol edilmesi

gibi yönetim işlemleri gerçekleştirilebilir.

## 🛠️ Kullanılan Teknolojiler

* **Java**
* **JPA (Java Persistence API)**
* **HTML5**
* **CSS3**
* **JavaScript**
* **Java Web Technologies**
* **Apache Ant**
* **NetBeans IDE**
* **Veritabanı**

## 🏗️ Proje Mimarisi

Proje, Java tabanlı web uygulaması yapısında geliştirilmiştir.

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

## 🔄 Uygulama Akışı

```text
                    JPAe Coffee
                         │
             ┌───────────┴───────────┐
             │                       │
        👤 Kullanıcı              🔐 Admin
             │                       │
             │                       │
      Ürünleri görüntüle      Ürünleri yönet
             │                       │
      Sipariş işlemleri       Ekle / Güncelle / Sil
             │                       │
             └───────────┬───────────┘
                         │
                         ▼
                    🗄️ Veritabanı
                         │
                         ▼
                       JPA
```

## 🎯 Projenin Amacı

Projenin amacı, Java tabanlı web uygulamalarında kullanıcı işlemleri, yönetici işlemleri ve veritabanı etkileşimlerinin birlikte nasıl gerçekleştirilebileceğini uygulamalı olarak geliştirmektir.

Proje kapsamında özellikle:

* Java Web uygulaması geliştirme
* JPA ile veri erişimi
* CRUD işlemleri
* Kullanıcı ve admin taraflarının oluşturulması
* Web arayüzü geliştirme
* Veritabanı ile uygulama arasındaki veri iletişimi

konularında uygulamalı çalışma yapılmıştır.

## ⚙️ Kurulum

Repository'yi klonlayın:

```bash
git clone https://github.com/gazellhatice/JPAe_coffee.git
```

Proje klasörüne gidin:

```bash
cd JPAe_coffee
```

Projeyi **NetBeans IDE** üzerinden açın.

Gerekli Java Web Server ve veritabanı bağlantılarını yapılandırdıktan sonra projeyi çalıştırabilirsiniz.

## 📚 Kazanılan Deneyimler

Bu proje sayesinde aşağıdaki alanlarda deneyim kazanılmıştır:

* Java Web Development
* JPA / ORM
* CRUD işlemleri
* Veritabanı yönetimi
* Admin Panel geliştirme
* Kullanıcı arayüzü geliştirme
* Backend–database iletişimi
* Java Web uygulamalarında proje yapısı
* Apache Ant build sistemi
* NetBeans ile proje geliştirme

## 👩‍💻 Geliştirici

**Hatice Gazel**

Software Engineering

GitHub: https://github.com/gazellhatice

---

⭐ Projeyi faydalı bulduysanız repository'ye yıldız bırakabilirsiniz.
