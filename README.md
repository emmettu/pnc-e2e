# pnc-e2e
End to end testing project for Project Newcastle.

<img src="http://i.imgur.com/nX2GA6C.jpg " width="250">

#Usage:
Edit the credentials.example.conf file to your requirements. 

If you are testing a local instance of pnc then you need to provide the url the credentials file example:
(base url=localhost:8080/pnc-web). 

The tests assume pnc is already running.

Once everything is set up cd into pnc-e2e and run:

```
mvn test
```

#Dependencies:
In order to run mvn test you must have phantomjs installed.
The phantomjs package for Fedora is available at: https://dcallagh.fedorapeople.org/phantomjs/phantomjs-1.9.7-1.fc20.x86_64.rpm.

#Credentials:

In order to access pnc-web non-locally you will have to login. An example credentials.conf file has been provided.
