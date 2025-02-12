# 🐋 Docker-Compose를 사용하여 개발환경 구축하기
Docker-Compose를 사용하여 개발환경을 구축하는 방법을 알아봅니다. 밑의 Docker와 Docker-Compose에 대한 설명은 이해를 돕기 위한 설명이지만 스킵하셔도 좋습니다.

---

## 🐋 Docker란?
Docker는 컨테이너 기반의 오픈소스 가상화 플랫폼입니다. 컨테이너는 격리된 공간에서 프로세스가 동작하는 기술입니다. 이를 통해 프로세스를 격리된 공간에서 실행할 수 있습니다. Docker는 이러한 컨테이너 기술을 사용하여 애플리케이션을 더 쉽게 만들고 배포할 수 있습니다. Docker에 대한 자세한 내용은 [생활코딩](https://opentutorials.org/course/128/8657)을 참고하세요.

## 🐋 Docker-Compose란?
Docker-Compose는 여러 개의 컨테이너를 정의하고 실행하는 도구입니다. Docker-Compose를 사용하면 여러 개의 컨테이너를 하나의 서비스로 정의하고 실행할 수 있습니다. Docker-Compose에 대한 자세한 내용은 [생활코딩](https://www.youtube.com/watch?v=EK6iYRCIjYs)을 참고하세요.

---
## 🐋 Docker-Compose로 서비스 실행하기
Docker-Compose를 사용하여 서비스를 실행하는 방법을 알아봅니다.

### 📦 Docker-Compose 설치하기
Docker-Compose를 설치합니다. Docker-Compose는 Docker Desktop을 설치하면 함께 설치됩니다. [Docker Desktop](https://www.docker.com/products/docker-desktop)을 설치하세요.

### 📦 Docker-Compose 파일 작성하기
Docker-Compose 파일을 작성합니다. Docker-Compose 파일은 `docker-compose.yml` 파일로 작성합니다. 이 프로젝트의 `spring-boot` 모듈에 작성해둔 `docker-compose.yml` 파일을 참고하세요.

### 📦 서비스 실행하기
Docker-Compose를 사용하여 서비스를 실행합니다. PowerShell에서 `docker-compose up` 명령어를 실행하여 서비스를 실행합니다.

```powershell
docker-compose up
```

### 📦 서비스 종료하기
서비스를 종료하려면 PowerShell에서 `docker-compose down` 명령어를 실행합니다.

```powershell
docker-compose down
``` 


