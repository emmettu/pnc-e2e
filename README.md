# pnc-e2e
End to end testing project for Project Newcastle.

#Usage:
Clone the repo
```
cd pnc-e2e
mvn test
```
Tests assume pnc is running, and attempts to access pnc-web at localhost:8080.

#Dependencies:
In order to run mvn test you must have phantomjs installed.
phantomjs package for Fedora is available at: https://dcallagh.fedorapeople.org/phantomjs/phantomjs-1.9.7-1.fc20.x86_64.rpm.
