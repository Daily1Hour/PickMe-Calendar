# 면접 캘린더 서비스

> API를 통해 사용자가 면접 일정 캘린더를 관리할 수 있도록 지원하는 서비스

## 🛠️ 기술 스택

![Java](https://img.shields.io/badge/Java-007396?style=flat&logo=Java&logoColor=white)
![SpringBoot](https://img.shields.io/badge/SpringBoot-6DB33F?style=flat&logo=springboot&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-47A248?style=flat&logo=MongoDB&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat&logo=Docker&logoColor=white)

## 📄 API 명세서

[![Swagger](https://img.shields.io/badge/Swagger-Green?style=flat&logo=swagger&logoColor=white)](https://daily1hour.github.io/PickMe-Calendar-Service/)

| Method | URI                  | Request Header                     | Query String                                                                 | Request Body                                                                 | Code                                                |
|--------|----------------------|------------------------------------|-----------------------------------------------------------------------------|------------------------------------------------------------------------------|-----------------------------------------------------|
| GET    | /calendar/interviews | Authorization:<br> Bearer \<token> | interviewDetailId?: string <br> name?: string <br> yearMonth?: string       |                                                                              | 200: 성공 <br> 400: 잘못된 요청 <br> 401: 권한 없음 <br> 404: 면접 일정 없음 |
| POST   | /calendar/interviews | Authorization:<br> Bearer \<token> |                                                                             | name: string <br> date: date <br> location: string                           | 200: 성공 <br> 400: 잘못된 요청 <br> 401: 권한 없음 <br> 404: 면접 일정 없음 |
| DELETE | /calendar/interviews | Authorization:<br> Bearer \<token> | interviewDetailId: string                                                   |                                                                              | 200: 성공 <br> 400: 잘못된 요청 <br> 401: 권한 없음 <br> 404: 면접 일정 없음 |
| PUT    | /calendar/interviews | Authorization:<br> Bearer \<token> | interviewDetailId: string                                                   | name?: string <br> date?: date <br> location?: string                        | 200: 성공 <br> 400: 잘못된 요청 <br> 401: 권한 없음 <br> 404: 면접 일정 없음 |


## 🚀 실행 방법

### 도커환경

```sh
# build
$ docker build -t my-image .

# run
$ docker run --env-file .env -p 8080:8080 my-image:latest
```

### 로컬환경

```sh
# Gradle 빌드 수행 (테스트 제외하고 빌드)
$ ./gradlew clean build -x test --no-daemon

# 빌드된 JAR 파일을 실행
$ java -jar build/libs/calendar-0.0.1-SNAPSHOT.jar
```

## 🖧 배치 다이어그램


## 📂 폴더 구조

> Layered Architecture

```python
calendar
├─ .devcontainer
│  ├─ .dockerignore
│  └─ Dockerfile
├─ .gitattributes
├─ .gitconfig
├─ .github
│  ├─ auto-assign-config.yml
│  ├─ rulesets
│  │  └─ Main-Rule.json
│  ├─ swagger-index.html
│  └─ workflows
│     ├─ auto-assign.yml
│     ├─ generate-swagger.yml
│     └─ gradle-build.yml
├─ .gitignore
├─ .gitmessage
├─ Dockerfile
├─ gradle
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
├─ gradlew
├─ gradlew.bat
├─ README.md
├─ setup.ps1
├─ setup.zsh
└─ src
   ├─ .gitkeep
   ├─ main
   │  ├─ java
   │  │  └─ com
   │  │     └─ pickme
   │  │        └─ calendar
   │  │           ├─ CalendarApplication.java
   │  │           ├─ config
   │  │           │  ├─ MongodbConfig.java
   │  │           │  ├─ security
   │  │           │  │  └─ JwtInterceptor.java
   │  │           │  ├─ SwaggerConfig.java
   │  │           │  └─ WebConfig.java
   │  │           ├─ controller
   │  │           │  └─ CalendarController.java
   │  │           ├─ dto
   │  │           │  ├─ get
   │  │           │  │  ├─ GetCalendarDTO.java
   │  │           │  │  ├─ GetCompanyDTO.java
   │  │           │  │  └─ GetInterviewDetailDTO.java
   │  │           │  ├─ post
   │  │           │  │  ├─ PostCompanyDTO.java
   │  │           │  │  └─ PostInterviewDetailDTO.java
   │  │           │  └─ put
   │  │           │     ├─ PutCompanyDTO.java
   │  │           │     └─ PutInterviewDetailDTO.java
   │  │           ├─ entity
   │  │           │  └─ Calendar.java
   │  │           ├─ exception
   │  │           │  ├─ CustomException.java
   │  │           │  ├─ ErrorCode.java
   │  │           │  └─ GlobalExceptionHandler.java
   │  │           ├─ repository
   │  │           │  ├─ CalendarMongoQueryProcessor.java
   │  │           │  └─ CalendarRepository.java
   │  │           └─ service
   │  │              ├─ CalendarService.java
   │  │              ├─ JwtService.java
   │  │              └─ mapper
   │  │                 └─ CalendarMapper.java
   │  └─ resources
   │     ├─ application-mongodb.properties
   │     ├─ application-mysql.properties
   │     ├─ application.properties
   │     ├─ static
   │     └─ templates
   └─ test
      └─ java
         └─ com
            └─ pickme
               └─ calendar
                  └─ CalendarApplicationTests.java
```