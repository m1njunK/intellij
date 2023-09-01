# Thymeleaf 란?

> Thymeleaf는 웹 애플리케이션 개발을 위한 자바 템플릿 엔진입니다. Thymeleaf는 HTML, XML, JavaScript, CSS 등의 마크업 언어와 서버 측 Java 코드를 조합하여 동적 웹 페이지를 생성하는 데 사용됩니다. 이것은 주로 웹 애플리케이션의 사용자 인터페이스(UI)를 개발하는 데 사용되며, Java 개발자와 웹 디자이너 간의 협업을 용이하게 만들어줍니다.

## Thymeleaf의 몇 가지 주요 특징과 장점

> 템플릿 엔진: Thymeleaf는 서버 측에서 실행되는 템플릿 엔진으로, 웹 페이지를 동적으로 생성하기 위해 서버 측 로직과 마크업을 통합할 수 있습니다.

* * *

> 자연스러운 문법: Thymeleaf는 표준 HTML 또는 XML 문서에 삽입되는 속성과 태그를 사용하여 템플릿을 정의합니다. 이러한 문법은 자연스럽게 읽히며 이해하기 쉽습니다.

***

> 다국어 지원: 다국어 웹 애플리케이션을 개발할 때 Thymeleaf는 다국어 메시지를 처리하는 기능을 내장하고 있어서 다국어 지원이 간편합니다.

***

> 스프링 프레임워크와 통합: Thymeleaf는 스프링 프레임워크와 잘 통합되어 스프링 기반 웹 애플리케이션 개발에 특히 유용합니다.


***

> 템플릿 리소스 캐싱: Thymeleaf는 템플릿 리소스를 캐싱하여 웹 페이지 생성 속도를 향상시킵니다.


***

> 플러그인 확장: Thymeleaf는 다양한 플러그인을 제공하므로 웹 애플리케이션에 필요한 기능을 확장할 수 있습니다.


***

> Thymeleaf를 사용하면 웹 애플리케이션의 프론트 엔드와 백 엔드를 연결하고 동적으로 콘텐츠를 생성할 수 있으며, 개발자와 디자이너 간의 협업을 원활하게 할 수 있습니다. 특히 스프링 기반 웹 애플리케이션 개발에 매우 인기가 있으며, 다른 자바 웹 프레임워크와도 통합하여 사용할 수 있습니다.


# 기초 문법

## html xmlns:th="http://www.thyeleaf.org"
> Thymeleaf를 지정하는 기본 문법 html 문서의 template engine이 thymeleaf 임을 명시

## HTML 문서에 xml namespace를 자동으로 추가 하는 plugin 
> 문법 자동 완성은 ultimate version 에서만 사용 가능하다.

> File | Settings | Plugins 에서 thymeleaf 검색 후 
> JBLHtmlToThymeleaf 설치 



## 표현식 (Expression):

> 1. ${...}
 - 가장 기본적인 표현식으로, 변수 값을 출력하거나 계산된 결과를 표시할 때 사용됩니다. 예를 들어 ${user.name}은 "user" 객체의 "name" 속성을 표시합니다.


* * *

> 2. #... : 템플릿 변수 (Thymeleaf Context Variables) 
  - Thymeleaf 컨텍스트 변수를 사용하여 제어 구조를 정의합니다. 예를 들어 th:each로 반복문을 만들거나 th:if로 조건문을 만들 수 있습니다.


* * *

> 3. th:attr: 속성 바인딩 (Attribute Binding) 
  - HTML 요소의 속성에 값을 설정합니다. 예를 들어 th:src, th:href, th:value 등을 사용하여 속성을 바인딩할 수 있습니다.
텍스트 바인딩 (Text Binding):

* * *

> 3. th:text: 텍스트 내용 바인딩 

  ~~~ 
    <span th:text="${user.name}"></span> 은 "user" 
    객체의 "name" 속성을 해당  <span> 요소의 텍스트로 출력합니다.
  ~~~


* * *

> 4. th:if, th:unless, th:switch, th:case : 조건문 (Conditional Statements) 
 - 조건부로 요소를 렌더링하거나 선택적으로 속성을 설정할 수 있음

* * *

> 5. th:each : 반복문 (Iteration): 
 - 컬렉션을 반복하고 템플릿을 생성하는 데 사용

* * *

> 6. Fragment와 레이아웃 (Fragments and Layouts): Thymeleaf는 레이아웃과 프래그먼트를 정의하고 사용하는 방법을 제공합니다. 이를 통해 웹 페이지의 일부를 재사용하고 템플릿을 분할하여 관리

* * * 
> 7. th:onclick, th:onsubmit : 이벤트 핸들링 (Event Handling): 이벤트 핸들러를 설정
 - JavaScript 함수 호출과 연결할 수 있음
 
* * *
> 8. 메시지 국제화 (Message Internationalization) 
 - 다국어 지원을 위해 #{...} 표현식을 사용하여 메시지를 가져올 수 있습니다.

* * * 
> 9. spring security 지원 
 - https://github.com/thymeleaf/thymeleaf-extras-springsecurity

 
> 넘겨 받은 Vo를 함수 호출 시에 파라미터로 넘겨줄 경우
model에 담은 Vo Class의 변수명이 list인 경우의 예시다.
th:onclick="fnDetail([[${list.notiSeq}]]);"

> location.href 할때는 | 로 깜싸야됨 세미콜론 들어가면 안됨.


> # <th:block>은 HTML 태그가 아닌 타임리프의 유일한 자체 태그이다.
> 타임리프의 특성상 HTML 태그 안에 속성으로 기능을 정의해서 사용한다. 만약 태그가 따로 없을 때 블록을 사용한다.
