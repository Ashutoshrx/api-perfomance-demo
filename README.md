# api-perfomance-demo
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
