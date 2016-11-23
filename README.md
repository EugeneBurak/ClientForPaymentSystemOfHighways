# ClientForPaymentSystemOfHighways

The Payment System Of Highways

About the project:

The payment system of Highways.
There is a central server, which receives the information from the check points on the highway. 
Its tasks include fee calculation at the moment of receiving the information that the driver has left the payable zone.
The highway includes 10 check points. It is supposed that the drivers, who are registered in the payment system, have got the unique number (viz. this number is included in the message from the check point), and an email.
After the calculation of the fee, the system sends a message to the driver with the information about the sum of payment and the direction, time of entrance and exit. 

Communication via sockets 
Storage of information: mongodb
Messaging: GMail

Work with project:

To begin working: launch in file MongoBD -> out -> artifacts -> MongoBD_jar -> MongoBD.jar
This command creates on the local machine a database. The database looks like: 
checkpoints
clients
system.indexes
{ "_id" : { "$oid" : "580e164959cedd733f6c321d"} , "clientNumber" : "01" , "clientName" : "Bob" , "clientMail" : "bea@sgsoft.com.ua"}
{ "_id" : { "$oid" : "580e16aa59cedd733f6c321e"} , "clientNumber" : "02" , "clientName" : "Candolina" , "clientMail" : "bea@sgsoft.com.ua"}
{ "_id" : { "$oid" : "580e16e659cedd733f6c321f"} , "clientNumber" : "03" , "clientName" : "Tom" , "clientMail" : "bea@sgsoft.com.ua"}
{ "_id" : { "$oid" : "580e18c059cedd733f6c3220"} , "clientNumber" : "04" , "clientName" : "Marta" , "clientMail" : "bea@sgsoft.com.ua"}
{ "_id" : { "$oid" : "580e192e59cedd733f6c3221"} , "clientNumber" : "05" , "clientName" : "Bender" , "clientMail" : "bea@sgsoft.com.ua"}
{ "_id" : { "$oid" : "580e1aea59cedd733f6c3222"} , "clientNumber" : "06" , "clientName" : "Jon" , "clientMail" : "bea@sgsoft.com.ua"}
{ "_id" : { "$oid" : "580e1b1159cedd733f6c3223"} , "clientNumber" : "07" , "clientName" : "Fray" , "clientMail" : "bea@sgsoft.com.ua"}
...
{ "_id" : { "$oid" : "580e1cc359cedd733f6c3224"} , "check-in" : "01" , "check-out-01" : "10" , "check-out-02" : "11" , "check-out-03" : "12" , "check-out-04" : "13" , "check-out-05" : "14" , "check-out-06" : "15" , "check-out-07" : "16" , "check-out-08" : "17" , "check-out-09" : "18" , "check-out-10" : "19"}
{ "_id" : { "$oid" : "580e1ece59cedd733f6c3225"} , "check-in" : "02" , "check-out-01" : "11" , "check-out-02" : "10" , "check-out-03" : "11" , "check-out-04" : "12" , "check-out-05" : "13" , "check-out-06" : "14" , "check-out-07" : "15" , "check-out-08" : "16" , "check-out-09" : "17" , "check-out-10" : "18"}
...
Done

In gmail personal account allow access to the mail box for unchecked applications.
Then launch the server in the file:
 ThePaymentSystemOfHighways -> out -> artifacts -> ThePaymentSystemOfHighways_jar -> ThePaymentSystemOfHighways.jar
- Enter your Google mail: <Your Google mail:> - the mail box, to which the access for unchecked applications was allowed
- Enter the password of your Google mail: <password> - password to the mail 
- Enter the recipient's address: <recipient's address> - mail address which will receive notifications 

Then the server waits for connection with remote devices:

To expect the connection of 10 remote devices
Port number - 8080
    Launch the remote devices (it is necessary to launch them on the same machine with the server or in): in the file:  ClientForPaymentSystemOfHighways -> out -> artifacts -> ClientForPaymentSystemOfHighways_jar -> ClientForPaymentSystemOfHighways.jar

There appears a message: Enter the terminal number (the numbers from 1 to 10): the numbers entered shouldn’t  be repeated or go beyond the limits.

The next message: Enter the ID of the new client (the numbers from 1 to 10): any number in the given limits. If the number has already been entered, the message including the sum of payment will be sent.

Launch the next remote device - ClientForPaymentSystemOfHighways -> out -> artifacts -> ClientForPaymentSystemOfHighways_jar -> ClientForPaymentSystemOfHighways.jar

It’s possible to launch from 1 till 10 remote devices. 
With the reentry of customer number -   the fee of the trip is calculated and is sent via email.
