### Prueba realiza con Spring Boot

#### Version del lenguaje

- Java 8

#### Levantar el proyecto

``` bash
    ./gradlew clean bootRun
```

#### Ramificación del proyecto

```bash
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── demo
    │   │               ├── Application.java
    │   │               ├── controllers
    │   │               │   ├── HtmlController.java
    │   │               │   ├── SupplierController.java
    │   │               │   └── TradeController.java
    │   │               ├── data
    │   │               │   ├── SupplierRepository.java
    │   │               │   └── TradeRepository.java
    │   │               ├── error
    │   │               │   └── ResourceNotFoundException.java
    │   │               ├── model
    │   │               │   ├── SupplierCommand.java
    │   │               │   ├── Supplier.java
    │   │               │   ├── TradeCommand.java
    │   │               │   └── Trade.java
    │   │               └── service
    │   │                   ├── SupplierService.java
    │   │                   └── TradeService.java
    │   └── resources
    │       ├── application.yml
    │       ├── db
    │       │   └── migration
    │       │       ├── V001__add_tables.sql
    │       │       └── V002__add_values_for_supplies.sql
    │       ├── static
    │       └── templates
    │           ├── add-supplier.html
    │           ├── add-trade.html
    │           ├── edit-trade.html
    │           └── trade-page.html
    └── test
        └── java
            └── com
                └── example
                    └── demo
                        └── ApplicationTests.java
```