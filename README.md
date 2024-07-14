

# 1. Soru
### Spring Framework
Java’nın en popüler framework’üdür. Spring, 
dependency injection, aspect-oriented programming (AOP) ve MVC web 
geliştirmesi için kapsamlı altyapı desteği sunar. Enterprise sınıfı uygulamaların geliştirilmesini kolaylaştırır. Örneğin, bir Spring Boot uygulamasında bir Controller sınıfı oluşturarak web isteklerini işleyebilir.


````
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Merhaba, Dünya!";
    }
}
````


### Hibernate
Hibernate, nesneleri ilişkisel veritabanı tablolarına eşleme (ORM) sağlayan bir framework’tür. Manuel SQL sorgularına gerek kalmadan Java nesnelerini veritabanı tablolarına bağlar. Veri tabanlı uygulamaların geliştirilmesini hızlandırır.

````
SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
Session session = sessionFactory.openSession();
Transaction transaction = session.beginTransaction();

Student student = new Student();
student.setId(1);
student.setName("John Doe");

session.save(student);
transaction.commit();
session.close();
````

### Apache Struts 
Struts, ölçeklenebilir ve bakımı kolay Java web uygulamalarının geliştirilmesini kolaylaştıran bir web uygulama framework’üdür. MVC tasarım desenini destekler ve zengin özellikli web uygulamaları oluşturmayı sağlar.


````
package com.example;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {
    public String execute() {
        return SUCCESS;
    }
}
````

# 2. Soru

### SOA (Service-Oriented Architecture)

Hizmet Odaklı Mimari (SOA), yazılım bileşenlerinin birbirinden bağımsız servisler olarak yapılandırıldığı bir mimari yaklaşımdır. Her servis, belirli bir işlevi yerine getirir ve diğer servislerle etkileşime girerek büyük bir sistemi oluşturur. SOA, esneklik ve yeniden kullanılabilirlik sağlamak için kullanılır.

Örnek:
Bir otel rezervasyon sisteminde, rezervasyon, ödeme ve müşteri yönetimi gibi işlevler farklı servisler olarak yapılandırılabilir. Bu servisler bağımsız olarak çalışır ve birbirleriyle iletişim kurar.

Bu yapı, her bir servisin bağımsız olarak geliştirilebilmesini, dağıtılabilmesini ve ölçeklenebilmesini sağlar.

### Web Service

Web servisleri, internet üzerinden diğer uygulamalarla veri ve işlev paylaşımını sağlayan hizmetlerdir. Web servisleri, genellikle XML veya JSON formatlarında veri gönderir ve alır. İki ana türü vardır:

### SOAP (Simple Object Access Protocol)
XML tabanlı bir protokoldür ve genellikle güvenlik ve karmaşıklığın önemli olduğu kurumsal uygulamalarda kullanılır.
### REST (Representational State Transfer)
HTTP protokolü üzerinde çalışan, daha hafif ve daha kolay anlaşılan bir yaklaşımdır.

SOAP Örneği:
Bir uçuş rezervasyonu yapmak için SOAP kullanabiliriz.

````
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:air="http://airline.example.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <air:BookFlightRequest>
         <air:flightNumber>1234</air:flightNumber>
         <air:date>2023-08-01</air:date>
         <air:passengerName>John Doe</air:passengerName>
      </air:BookFlightRequest>
   </soapenv:Body>
</soapenv:Envelope>
````

### RESTful Web Service
RESTful web servisleri, HTTP protokolü üzerinden çalışan ve REST (Representational State Transfer) mimarisine dayalı bir yaklaşımdır. RESTful servisler, belirli URL'ler üzerinden kaynaklara erişim sağlar ve genellikle JSON formatında veri döner.

Örnek:
Bir kitap yönetim sistemi için RESTful servisler:

````
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private Map<Integer, Book> bookStore = new HashMap<>();

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id) {
        return bookStore.get(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        bookStore.put(book.getId(), book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
        bookStore.put(id, book);
        return book;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookStore.remove(id);
    }
}

// Book.java
public class Book {
    private Integer id;
    private String title;
    private String author;
    private double price;

    // getters ve setters
}

````

### HTTP Metotları
HTTP yöntemleri, web servislerinin veri alışverişi yapmak için kullandığı temel işlemlerdir. Her bir HTTP yöntemi, belirli bir işlemi ifade eder:

**GET**: Sunucudan veri almak için kullanılır. 

**POST**: Sunucuya yeni veri oluşturmak için kullanılır. 

**PUT**: Var olan veriyi güncellemek için kullanılır. 

**DELETE**: Veriyi sunucudan silmek için kullanılır. 