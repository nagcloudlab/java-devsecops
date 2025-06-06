

### install openjdk-17 on ubuntu

```bash
sudo apt update
sudo apt install openjdk-17-jdk
java -version
```

### install maven on ubuntu

```bash
sudo apt update
sudo apt install maven
mvn -version
```

### build the application
```bash
cd play-with-devsecops
mvn clean install
```


### install docker on ubuntu

```bash
docker --version
sudo apt update -y
sudo apt install apt-transport-https ca-certificates curl software-properties-common -y
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable"
apt-cache policy docker-ce
sudo apt install docker-ce -y
sudo systemctl status docker
sudo usermod -aG docker ${USER}
docker --version
```


### create PostgreSQL database container

```bash
docker run --name postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
docker container ls
docker exec -it postgres psql -U postgres

CREATE TABLE ACCOUNTS (
    number VARCHAR(100) NOT NULL,
    balance DECIMAL(10, 2) NOT NULL
);

INSERT INTO ACCOUNT (number, balance) VALUES ('1234567890', 1000.00);
INSERT INTO ACCOUNT (number, balance) VALUES ('0987654321', 500.00);

```



### create sonarqube container

```bash
docker run -d --name sonarqube -p 9000:9000 sonarqube:lts
```

### submit the project to sonarqube

```bash
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=play-with-devsecops \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=sqa_9f1c7a4e32b56e932d0136136ceab01af973e951
```  


### run the application
```bash
java -jar transfer-service/target/transfer-service-0.0.1-SNAPSHOT.jar
```


