## Spring Boot REST API

### Description

이 프로젝트는 스프링 기반 외부 라이브러리와 데이터베이스를 학습/테스트 목적으로 활용하는 전역적인 프로젝트입니다.


-----

### Module

> gradle multi-module 기반으로 모듈러 형식의 프로젝트 구조를 학습합니다.

- https://techblog.woowahan.com/2637/
- https://hudi.blog/why-use-multi-module/
- https://f-lab.kr/insight/understanding-multi-module-architecture

-----

### Local Cache (로컬 캐시)

> 로컬 캐시는 메모리에 데이터를 저장하는 방식으로, 데이터를 빠르게 조회할 수 있습니다. 하지만, 서버가 종료되면 데이터가 사라지기 때문에, 데이터를 영구적으로 저장할 수 있는 방법이 필요합니다.

- https://80000coding.oopy.io/d2d626ba-6f4f-4684-8f4d-5603da6c3f56
- https://junuuu.tistory.com/776
- https://www.baeldung.com/spring-cache-tutorial

### S3

> S3는 AWS에서 제공하는 객체 스토리지 서비스로, 파일을 저장하고 관리할 수 있습니다. S3를 사용하면 파일을 서버에 저장하지 않고, 클라우드에 저장할 수 있습니다.

- https://docs.aws.amazon.com/ko_kr/AmazonS3/latest/userguide/Welcome.html

----

### Event ListenerEvent Listener (이벤트 리스너)

> 이벤트 리스너는 특정 이벤트가 발생했을 때, 특정 동작을 수행할 수 있도록 하는 방법입니다. 스프링에서는 ApplicationListener 인터페이스를 구현하여 이벤트 리스너를 생성할 수 있습니다.

- https://www.baeldung.com/spring-events
