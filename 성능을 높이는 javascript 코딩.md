## try catch

자바에서는 빈번하게 사용하는 try catch를 javascript에서는 거의 사용하지 않는다. 
javascript에서는 성능최적화를 위해 브라우저의 javascript engine에서 코드 최적화를 진행한다. 
그러나, try catch 구문을 만나면 해당 코드의 경우 성능 최적화를 진행하지 않는다. 이유는 try catch에서 오류가 발생하여 catch문을 실행할 때, 해당 try catch
문을 찾아가는 경로를 유지해야 하기 때문이라고 한다.


## 지역변수 활용

javascript 함수 실행시에는 실행문맥이 생성된다. 실행문맥은 스코프체인이 있어서 전역객체와 활성화객체에 접근가능하다. 
활성화 객체는 지역변수 및 arguments, this등에 대한 참조이며, 전역객체는 windows, navigator와 같은 어떤 함수에서든지, global로 접근가능한 객체의 참조이다. 
함수 실행시에는 우선 스코프체인을 통해 활성화 객체를 먼저 탐색한다. 그리고, 전역객체를 제일 마지막에 탐색한다.
따라서, 중첩된 함수의 경우 최하단의 함수에서 호출된 함수내에서 전역객체를 호출한다면, 위 탐색방식에 의해 스코프체인 => 활성화 객체1 => 스코프체인 => 활성화 객체2 => 
스코프체인 => 전역객체의 접근 경로를 가지게 된다. 따라서, 성능 개선을 위해 활성화 객체의 참조내에 있는 지역변수에 window와 같은 전역객체의 참조를 할당하여
사용하면 성능이 개선된다.



출처: [https://12bme.tistory.com/134]
