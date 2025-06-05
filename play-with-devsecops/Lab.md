

install maven in ubuntu

```bash
sudo apt update
sudo apt install maven
mvn -version
```

```bash
cd play-with-devsecops
mvn clean install
java -jar ./transfer-service/target/transfer-service-1.0-SNAPSHOT.jar
```


```bash
docker version
```

install docker in ubuntu

```bash
sudo apt update -y
sudo apt install apt-transport-https ca-certificates curl software-properties-common -y
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable"
apt-cache policy docker-ce
sudo apt install docker-ce -y
sudo systemctl status docker
sudo usermod -aG docker ${USER}
docker version
```

create postgres container

```bash
docker run --name postgres -e POSTGRES_PASSWORD=postgres -d -p 54322:5432 postgres
docker container ls
docker logs postgres
docker exec -it postgres psql -U postgres


create table accounts (
    number VARCHAR(20) PRIMARY KEY,
    balance NUMERIC(10,2) NOT NULL
);

insert into accounts (number, balance) values ('1234567890', 1000.00);
insert into accounts (number, balance) values ('0987654321', 500.00);
select * from accounts;

```

