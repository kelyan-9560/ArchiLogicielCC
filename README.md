`CC1 Architecture logiciel | Kélyan BERVIN | ESGI 4ème Année`
_________________________________________________
Architecture used : _**Messaging**_
_________________________________________________
`# Program functionality`

* User verifiaction 
* Credit Card verification 
* User registration 
* Send mail to user 
* Adding user 
* Payment
_________________________________________________
`## User(firstname, lastname, email, creditcard) :`

- **Firstname :**
    - mustn't be null
- **Lastname :**
    - mustn't be null
- **Email :**
  - must respect the regex

`## Credit Card (number, expiration date, owner name)`

- **Number :**
  - must have 18 digits
  - mustn't be null

- **Expireation Date :** 
  - must be before the system date
  - mustn't be null

- **Owner Name :** 
  - must be the same as the user's
  - mustn't be null
_______________________________________________