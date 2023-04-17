run Application.java file

we can get the response through swagger url http://localhost:8085/swagger-ui/index.html

attaching the postman collection as well for testing the api 

1. get the supervisor :- http://localhost:8085/api/supervisors
2. submit the data :- http://localhost:8085/api/submit

{
    "phoneNumber": "204-798-9969",
    "supervisor": {
        "firstName": "Karson",
        "lastName": "Olson",
        "jurisdiction": "u"
    },
    "firstName": "Karson",
    "lastName": "Olson",
    "email": "abc@gmail.com"
}