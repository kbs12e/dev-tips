# Vuejs 기초

* Vuejs를 처음 사용하여 front end 개발을 진행했을 때 주로 사용한 방식임.

## *XXX*.vue 파일 기본 구조

```
<template>
</template>
<script>
</script>
<style scope>
</style>
```

## 자식 <-> 부모 component 통신 

* props

자식 component에 속성 전달하는 방식

부모는 v-bind로 동적으로 prop을 전달하거나, html의 attribute 형식으로 전달할 수 있는데, 대부분 전자의 방식으로 이용한다. 

* emit

자식이 callback 방식으로 부모 component의 event callback함수를 호출

* store

전역으로 접근 가능하다. 즉, 부모든 자식이든 store의 state 값을 get/set 하는 것이 가능함. data를 한곳에서 관리하는 장점이 있어서

이 방식을 주로 사용한다.

## 이벤트

* template내 html에 직접 v-on 사용. methods 내 핸들러에서 처리

## vue 지시어

주로 사용한 vue 지시어

* v-if

* v-on

* v-for

* v-model

* v-bind

## Life-cycle 함수

주로 사용한 life-cycle 메소드. 렌더 이후 초기화하는 등의 작업을 위해 보통 mounted()를 많이 사용함.

* created()

* mounted()

* updated()

* destroyed()


## 주요 Libs

* vue-router

* vue-i18n

* axios

* vuex

* sockjs-client

* webstomp-client

## Vue에서 다른 lib 사용

* index.html에 직접 style, script 추가하는 방식

* package에 정의하고, script태그 안에서 import 하여 사용하는 방식
