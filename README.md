
## spring boot 란?

* * *

>Spring Boot는 자바 기반의 오픈 소스 프레임워크인 Spring Framework의 일종으로, 웹 애플리케이션 및 마이크로서비스를 빠르고 쉽게 개발할 수 있도록 도와주는 프로젝트입니다. Spring Boot는 Spring Framework를 기반으로 하지만, 애플리케이션을 구성하고 설정하는 데 있어서 더 간단하고 편리한 방법을 제공합니다.

* * *

### Spring Boot의 주요 특징과 장점
* * *
> 1. 자동 구성 (Auto-Configuration): Spring Boot는 애플리케이션에 필요한 설정을 대부분 자동으로 처리해줍니다. 이로써 개발자는 복잡한 설정 작업을 최소화하고 빠르게 애플리케이션을 개발할 수 있습니다.
 
* * *

> 2. 스타터 (Starters): Spring Boot는 다양한 프로젝트에서 자주 사용되는 설정과 라이브러리를 포함한 스타터 패키지를 제공합니다. 이 스타터 패키지를 추가하면 해당 기술 스택을 쉽게 사용할 수 있습니다.

* * *

> 3. 내장 웹 서버 지원: Spring Boot는 Tomcat, Jetty, Undertow와 같은 내장 웹 서버를 제공하므로 별도의 웹 서버 설정 없이도 웹 애플리케이션을 개발할 수 있습니다.

* * *

> 4. 마이크로서비스 지원: Spring Boot는 마이크로서비스 아키텍처를 구현하기에 적합한 기능을 제공하며, Spring Cloud와 통합하여 클라우드 환경에서의 마이크로서비스 개발을 지원합니다.

* * *

> 5. 통합 테스트 지원: Spring Boot는 애플리케이션의 통합 테스트를 위한 다양한 기능을 제공하여 테스트 주도 개발을 쉽게 할 수 있습니다.

* * *

> 6. 강력한 커뮤니티: Spring Boot는 활발한 커뮤니티와 다양한 레퍼런스 자료가 있어서 개발자들이 도움을 받기 쉽습니다.

* * *

> 7. Spring Boot를 사용하면 애플리케이션 개발 및 배포가 더 간단해지며, 개발자는 비즈니스 로직에 집중할 수 있습니다. 또한, Spring Boot는 다양한 데이터베이스, 보안, 웹 개발, 메시징, 스케줄링 등의 기술 스택을 지원하므로 다양한 종류의 애플리케이션을 개발할 수 있습니다.

<br/>

* * *

# Server Side Template Engine - 서버 사이드 렌더링 방식
### Thymeleaf
> [http://www.thymeleaf.org](http://www.thymeleaf.org)

### Thymeleaf 소개
> [thyme정의](https://github.com/kikuen/learn_boot/blob/master/mvc/thymeleaf.md)


# Spring Dev tools 
- Automatic Restart

 >  classpath에 있는 파일이 변경될 때마다 애플리케이션을 자동으로 재시작. 개발자가 소스 수정 후 애플리케이션을 재실행하는 과정을 줄일 수 있으므로 생산성을 향상 시킴

- Live Reload 
 > 정적 자원(html, css, js) 수정 시 재 시작 없이 바로 적용 할 수 있음.

- Property Defaults 

 > Thymeleaf는 기본적으로 성능을 향상시키기 위해서 캐싱 기능을 사용함.
   하지만 개발하는 과정에서 캐싱 기능을 사용한다면 수정한 소스가 제대로 반영되지 않을 수 있기 때문에 cache의 기본값을 false로 설정 할 수 있음.

> application.properties
>  > spring.thymeleaf.cache=false
 
<br/>

* * * 

# Spring Dev tools 적용
 > 1. shift key 두번 연속 - 항목을 검색 할 수 있는 검색창 오픈

 > 2. action tab에서 'registry' 검색  
 
 > 3. compiler.automake.allow.when.app.running check 
  
 > 3. 2021.2 버전부터 Registry가 아니라 Advacned Settings에서 설정
 >  > Setting > Advanced Settings
    > Allow auto-make to start even if developed application 체크
      

 > 4. File | Settings | Build, Execution, Deployment | Compiler 
 >  > "Build project automatically" check 

 > 4. File | Settings | Build, Execution, Deployment | Build Tools
 >  > Any Changes check

![image](https://github.com/kikuen/learn_boot/assets/13825751/61f976b9-11a6-4e5d-8e05-6917248ef310)

# 새로고침으로 확인하기
 > application.properties 설정파일에 설정 추가 
 >  > spring.devtools.livereload.enabled=true
 >  > spring.resources.static-locations=file:src/main/resources/static/
 >  > spring.thymeleaf.prefix=file:src/main/resources/templates/
 

# 내가 만든 lib 프로젝트에 추가
 > project 우클릭 libs 폴더 추가 > 추가하고자 하는 .jar 파일 추가

 > build.gradle dependencies 에 
 >  > implementation fileTree(dir: 'libs', include: ['*.jar'])    추가
 
 > rebuild module 로 적용 확인    ctrl + shift + F9
 


## Settings 단축키 ctrl + alt + s

## intelij console 에서 한글  깨질 시
> VM Options는 상단바 Help-Edit Custom VM Options

> -Dfile.encoding=UTF-8
> -Dconsole.encoding=UTF-8

> 추가 후 재 시작
