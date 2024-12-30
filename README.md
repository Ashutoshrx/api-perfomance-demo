
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
* Total Response size --> 29.9 MB
```
CREATE INDEX idx_category_id ON category (id);
```
* Time Taken after indexing: 3.19s
* Total Response size --> 29.9 MB  
## Hardly made any sense right? Let's improve further.
### Use of Multi-threading(CompletableFuture<T>)
| Method        | Time Taken | Response Size | Threads Used | Curl path |
|----------------|------------|--------------|--------------|-----------|
| Sync          | 12.91s     | 376B         | 1            |   ```curl --location 'http://localhost:8080/api-performer-demo/v1/products/1/sync'```        |
| Async         | 03.85s     | 376B         | 4            |    ```curl --location 'http://localhost:8080/api-performer-demo/v1/products/1/async'```    |

## Problems faced while fetching huge response data through network:
* Fetching 29.9 MB of response payload via network was difficult.
* Even while integration call using webclient was throwing exception
* - Max-in-memory size for webclient call was set to 16MB

# Secret Recipe to fix Memory: 
## Use of GZIP compression
Add below properties to your configuration file and you are done.
```
# Enable the response gzip compression (Default: false)
server.compression.enabled=true
# List of supported mime types
server.compression.mime-types=text/html, text/xml, text/plain, text/css, text/javascript, application/javascript, application/json, application/xml
# Minimal response size to compress
server.compression.min-response-size= 1024
```
## Final Report

| Feature                    | Before GZIP Compression                                                      | After GZIP Compression |
|----------------------------|------------------------------------------------------------------------------|------------------------|
| Time Taken                 | 3.19s                                                                        | 2.17s                  |
| Response Size  (Around 2.9L rows)          | 29.9MB                                                                    | 1.46MB                 |
| WebClient Integration call | Throws DataBufferLimitException: <br/> Exceeded limit on max bytes to buffer | No Exception           |

* **We have successfully scaled the system by decreasing the download time and the network bandwidth.** </br>
* **We also overcome the DataBufferLimitException that was throwing while fetching huge data using webclient 
  integration call.**
