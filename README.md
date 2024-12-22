
## Database's ER Diagram

    Category ||--|{ Product : "has many"}
    Product  ||--|{ Inventory : "has many"}
    Product  ||--|{ Price : "has many"}

    Category {
        id PK
        name
        type
        status
    }

    Product {
        id PK
        category_id FK
        name
        description
        status
    }

    Inventory {
        id PK
        product_id FK
        ware_house_id
        available_quantity
        reserved_quantity
        status
    }

    Price {
        id PK
        product_id FK
        price
        valid_from
        valid_to
        status
    }

## Some Hit & Trials to improve from DB's level
### Total Records present in category table: 2,92820
### Time taken to fetch all categories
* Time taken before indexing: 3.24s 
```
CREATE INDEX idx_category_id ON category (id);
```
* Time Taken after indexing: 3.19s
## Hardly made any sense right? Let's improve further.