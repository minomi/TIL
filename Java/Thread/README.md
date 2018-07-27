### Java Thread 

##### Thread 생성
1. Runnable Interface 를 이용
2. Thread class 를 상속
3. Lambda 식 이용
    
##### Thread 이름
* Thread 의 이름을 변경할 수 있음 (디버깅용)
* default 는 "Thread-n" (Main Thread 는 "main")
    
##### Java 의 Thread 스케쥴링 방식 
* 우선순위 방식 : Thread 에 우선순위가 높으면 실행 상태를 더 많이 가지도록 함
* 라운드 로빈 방식 : Time-Slice 을 정해서 그 시간 만큼 스레드를 실행하고 다시 Time-Slice 만큼 다른 스레드를 실행함
        
##### Thread 우선순위        
* Thread 의 수 > Core 의 수 일 때, Core 들이 어떤 순서에 의해 동시성을 실행할 것인가를 결정할때 영향을 미침
* Thread 의 수 <= Core 의 수 일 때, 별 영향을 미치지 못함
    
##### Thread 동기화
* 임계영역 (critical section) : 단 하나의 스레드만 실행할 수 있는 코드 영역
* synchronized block : 임계영역을 감싸는 block
    ``` Java
    public synchronized void method() {
        // 임계 영역
    }
    
    
    public void method() {
        // 여러 스레드가 실행할 수 있는 영역
        ...
        synchronized(공유객체) {
            // 임계 영역 
        }
    }
    ``` 
    
    스레드가 동기화 블록으로 진입하면 공유객체에 대한 잠금을 얻고, 동기화 블록을 실행한다. 블록을 모두 실행할 때까지 *다른 스레드들은 공유객체의 모든 동기화 메소드 또는 동기화 블록을 실행할 수 없게 된다.*
 
##### Thread 상태

Thread 생성 후 start() 메서드를 호출했다고 해서 바로 Thread 가 실행되는 것이 아니고 `대기 상태(Runnable)`에 진입 한다.

* New : Thread 객체 생성 (start() 메서드가 실행되기전)
* Runnable : Thread가 JVM에 의해 스케쥴링 되기를 기다리고 있는 상태
* Wating : 다른 스레드가 통지할 때까지 기다리는 상태 (통지 후, Runnable 상태로 진입)
* Timed_wating: 주어진 시간 동안 기다리는 상태 (기다린 후, Runnable 상태로 진입)
* Block : 사용하고자 하는 객체의 락이 풀릴때 까지 기다리는 상태 (락이 풀린 후, Runnable 상태로 진입)
* Running : 스케쥴링으로 선택된 스레드가 CPU가 점유하고 있는 상태 (run() 실행, 언제든지 스케쥴링에 의해 wating, timed_wating, block 상태로 돌아갈 수 있다.)
* Terminated :  run() 메소드가 종료되어, 더 이상 실행할 코드가 없는 상태
    
##### Java Thread API

* sleep() : Thread.sleep() 을 호출한 스레드는 주어진 시간동안 일시 정지 상태가 됨 
* yield() : 스레드안에 무의미한 루프를 줄이기 위해 사용, Thread.yield() 를 호출하면 호출한 스레드는 Runnable 상태가 되고, 동일하거나 더 높은 우선순위의 스레드가 실행할 기회가 주어진다. 
* join() : A 스레드가 B 스레드의 join() 를 호출하면 A 스레드는 B 스레드가 종료될때 까지 일시 정지 상태가 된다.
* notify() : 공유객체의 동기화 메서드(블록) 내에서 호출하면 공유객체를 기다리고 있던 스레드가 하나가 실행대기 상태가 된다.
* notifyAll() : 공유객체의 동기화 메서드(블록) 내에서 호출하면 공유객체를 기다리고 있던 스레드가 모두가 실행대기 상태가 된다.
* wait() : 공유객체의 동기화 메서드(블록) 내에서 호출하면 호출한 스레드는 일시 정지 상태가 된다.  
* interrupt() : A 스레드의 interrupt() 를 호출하면 A 스레드가 일시 정지 상태가 될 때 A 스레드가 종료된다.
* interrupted : Thread.interrupted() 를 호출하면 현재 스레드가 interrupted 됐는지 체크한다.


    
