# share-schedule

## 개발관련

- github : https://github.com/woorung-ymseo/share-schedule/
- swagger(local) : http://localhost:8080/swagger-ui/index.html

---

## 패키지 구조
```text
share-schedule
├── db                      ### 초기 db 폴더  
│   └──  initdb.d           ### 초기 sql
└── docker-compose.yml     ### 로컬 셋팅 docker-compose

--- 

com.schedule.share
├── calendar                 ### 메인 도메인 ( calendar )
│   ├── adaptor              ### in/out 어뎁터                    
│   │   ├── inbound          ### 외부 -> 서버 (구현부)              
│   │   │   └── api          ### api ( http controller )                        
│   │   │       └── dto      ### 외부 -> api 요청/응답 DTO                            
│   │   │       └── mapper   ### 외부 -> api 요청/응답 객체 전용 mapper (converter)                                 
│   │   └── outbound         ### 서버 -> 외부 (구현부)                           
│   ├── application          ### 서버 동작 관련                        
│   │   ├── port             ### in/Out port                         
│   │   │   ├── inbound      ### 외부 -> 서버 (interface)                            
│   │   │   └── outbound     ### 서버 -> 외부 (interface)                                
│   │   └── service          ### 비즈니스 로직                        
│   │       └── {domain}     ### 서브 도메인                                 
│   │           └── vo       ### 서브 도메인 request/response VO                            
│   └── domain               ### 도메인 객체 모음                    
│       └── mapper           ### 도메인 객체 전용 mapper (converter)                        
├── common                   ### 공통 설정 및 유틸 등           
│   └── config               ### 설정                     
│   └── enum                 ### enum                 
│   └── utils                ### 유틸                    
└── infra                    ### 인프라 관련 (rdb, queue, webclient 등)           
    └── rdb                  ### rdb           
        └── entity           ### 엔티티                        
        └── repository       ### 레포지토리                 

```

---

### 로컬 rdb (mysql) 환경 설정

```shell
docker-compose up -d
```

---

### git branch 

```text
feature/share-{yyyyMMddHHmmss}      ### 기능 관련 (api 개발, 수정 등)
infra/share-{yyyyMMddHHmmss}        ### 인프라 관련 (docker, sql 등)
bugfix/share-{yyyyMMddHHmmss}       ### 버그 픽스 관련 (버그 수정)

ex) feature/share-20240629112315
```

---

### git comment

```text
[feat] {브런치명} | 내용
[infra] {브런치명} | 내용
[bug] {브런치명} | 내용

eX) [feat] feature/share-20240629112315 | 테스트
```

