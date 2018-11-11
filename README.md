# Web app for all employees of Logistic company 
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/9f6f781467354a908c3710b2883332a8)](https://www.codacy.com/app/Dilschat/Logistic-company-employees-app?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=OmOmTeam/Logistic-company-employees-app&amp;utm_campaign=Badge_Grade)

## Quickstart

Install Maven and JDK 8.

+ **Install Maven:**

1. Search
```
apt-cache search maven
```
 2. Install
```
sudo apt-get install maven
```
3. Verify
```
mvn -version
```
+ **Install JDK 8:**
[Link to installation instructures](https://medium.com/coderscorner/installing-oracle-java-8-in-ubuntu-16-10-845507b13343)

+ **Install Python3:**
[Link to installation instructures](https://tecadmin.net/install-python-3-7-on-ubuntu-linuxmint/)

+ **Install flask and flask-restful in Python3**

+ **Clone repo:**
```
git clone https://github.com/OmOmTeam/Logistic-company-employees-app.git
```

+ **Build jar**
Run in the project root:
```
mvn clean package -DskipTests
```
.jar file (Employee_app-0.0.1-SNAPSHOT.jar) will be stored in generated in the root of project `target` folder .
### Running
+ **Due to datacluster is not finished you need to run  our "fake" flask server.**

```
+ **For running Webapp server run in root of project:**
```
java -jar Employee_app-0.0.1-SNAPSHOT.jar
```



