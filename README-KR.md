# Network Security Scanner Service

![image](https://github.com/JiminByun0101/network-security-scanner-service/assets/111392426/04ba7800-a6ec-4331-b29c-59cc44d5f721)

## Table of contents

## 서비스 시나리오

### 요구사항

- Security Analyst가 취약점 스캔을 요청한다.
- 오픈소스 취약점 도구가 스캔을 실행한다.
- Security Analyst가 스캔을 취소할 수 있다.
- O오픈소스 취약점 도구의 스캔이 취소된다.

### 이벤트스토밍

#### Bounded Contexts:

1. 스캔 요청 관리 (Scan Request Management): 사용자의 스캔 요청 및 입력 유효성 검증을 처리하는 역할을 담당합니다.
2. 오픈 소스 도구 통합 (Open-source Tool Integration): Nmap 및 Nettacker와 같은 오픈 소스 스캔 도구를 통합하고 활용하여 스캔을 실행하는 역할을 담당합니다.

![image](https://github.com/JiminByun0101/network-security-scanner-service/assets/111392426/2f06456e-b8b4-4ffe-ac64-9239fd059f8a)

## 운영

1. 분산 메시지 큐 Kafka를 실행

```
cd kafka
docker-compose up -d                          # docker-compose 가 모든 kafka 관련 리소스를 받고 실행할 때까지 기다림
docker-compose logs kafka | grep -i started   # Kafka 정상 실행 확인
```

2. Scan Request Management 마이크로서비스 실행

```
cd scan-request-management/
mvn clean spring-boot:run
```

3. Open-source Tool Integration 마이크로서비스 실행

```
cd open-source-integration-tools/
mvn clean spring-boot:run
```

4. Kafka 이벤트 모니터링

### Kafka 서버에 접속

```
cd kafka
docker-compose exec -it kafka /bin/bash   # kafka docker container 내부 shell 로 진입
```

### Kafka 토픽 목록 조회 (Topic name : networksecurityscannerservice)

```
./kafka-topics --bootstrap-server http://localhost:9092 --list #
```

### Consumer 실행하여 퍼블리시된 이벤트 모니터링

```
./kafka-console-consumer --bootstrap-server http://localhost:9092 --topic networksecurityscannerservice --from-beginning
```

5. Scan Request Management 마이크로서비스에 POST로 메시지를 발행

```
http :8082/scanRequests/ hostname="server1.test.com" ipAddress="127.0.0.1" toolName="nmap"
http :8082/scanRequests/{id}/cancelscan
```

6. Kakfa Topic 메시지 수신 확인
   Kakfa 내 메시지 저장소인 Topic(name : networksecurityscannerservice)에 각각 커맨드

- ScanInitiated
- ScanExecuted
- ScanCanceled
  도메인 이벤트가 Publish됨을 확인한다.

![image](https://github.com/JiminByun0101/network-security-scanner-service/assets/111392426/16a4cd51-5fa9-40c6-9370-2901482fd8b4)

7. Kubernetes(EKS) Provisioning on AWS

### Prerequisite

- Install aws cli
- Install kubectl cli
- Configure the aws cli (using aws configure)
- Create EKS

### Kubernetes cluster connect and test

```
aws eks --region us-east-1 update-kubeconfig --name network-security-scanner-service-eks
kubectl get all
kubectl get node
```

![image](https://github.com/JiminByun0101/network-security-scanner-service/assets/111392426/a2c767f1-990e-4ed7-b6ad-8f87dd8c7875)

8.

### Order Microservice 실행

- 새로운 Terminal을 연다.

```
cd 06강_Sample-Order-Microservice
mvn spring-boot:run
```

```
http GET http://localhost:8081
http GET http://localhost:8081/orders
http POST http://localhost:8081/orders customerId=1000 productId=1000 productName=TV qty=10
http GET http://localhost:8081/orders
http DELETE http://localhost:8081/orders/1
http GET http://localhost:8081/orders
```

### Command로 인해 Publish된 Domain Events 확인

- Kafka consumer 접속 및 mall Topic 조회

```
docker-compose exec -it kafka /bin/bash   # kafka docker container 내부 shell 로 진입
[appuser@e23fbf89f899 bin]$ cd /bin
[appuser@e23fbf89f899 bin]$ ./kafka-console-consumer --bootstrap-server localhost:9092 --topic mall --from-beginning
```

## 구현

1. `docker-compose`를 실행하여 Kafka 서버를 실행한다.
2. 각 마이크로서비스를 실행하기 위해 Maven을 실행한다.
3. `httpie`를 사용하여 간단한 HTTP GET 및 POST 테스트를 수행한다.
