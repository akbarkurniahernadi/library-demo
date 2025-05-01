# library-demo
library demo for test

if you want to use this service
please set up the database, for credential in application.properties
then just run the service, i have already add schema and seeder in migration.

----- FOR TESTING IN POSTMAN--------

To get all books with pagination
curl --location 'http://localhost:8080/api/books?page=0&size=5' \
--header 'Accept: application/json'

to post book
curl --location 'http://localhost:8080/api/books/register' \
--header 'Content-Type: application/json' \
--data '{
"title": "Clean Architecture",
"publicationYear": 2017,
"authorId": 1
}'

to post borrowing
curl --location 'http://localhost:8080/api/borrowings/register' \
--header 'Content-Type: application/json' \
--data '{
"borrowerId": 1,
"bookId": 1,
"borrowDate": "2025-05-01",
"returnDate": "2025-05-15"
}'
