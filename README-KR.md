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

## 구현

1. `docker-compose`를 실행하여 Kafka 서버를 실행한다.
2. 각 마이크로서비스를 실행하기 위해 Maven을 실행한다.
3. `httpie`를 사용하여 간단한 HTTP GET 및 POST 테스트를 수행한다.
