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

##### Thread Pool

빈번한 Thread 의 생성을 방지 하기 위해 Thread Pool 은 작업 처리에 사용되는 스레드를 제한된 개수만큼 정해 놓고 작업 큐에 들어오는 작업들을 하나씩 스레드가 맡아 처리한다.
Java 에서는 ExecutorService Interface 와 Executors class 를 이용해 ThreadPool 을 만들 수 있다.

##### newCachedThreadPool vs newFixedThreadPool(nThreads)

* newCachedThreadPool : 초기 스레드 = 코어 스레드 = 0, 최대 스레드 수  = Integer.MAX_VALUE(머신의 성능에 따라 다름) 1개 이상의 스레드가 추가되었을 경우 60초 동안 추가된 스레드가 아무 작업을 하지 않으면 추가된 스레드를 종료하고 풀에서 제거
* newFixedThreadPool : 초기 스레드 = 0, 코어 스레드 = nThreads 최대 스레드 = nThreads

##### Runnable vs Callable

Thread 의 하나의 작업은 Runnable 과 Callable 의 구현 클래스로 표현하고, 차이점은 리턴값이 있는가 없는가 이다.

##### execute vs submit

둘 다 ExecutorService 의 작업 큐에 Runnable 또는 Callable 객체를 넣을때 사용하는 메서드 
* execute : 작업 처리 결과를 받지 못함, 작업 처리 도중 예외 발생 -> 스레드 종료 -> 스레드 풀에서 제거
* submit : 작업 처리 결과를 받을 수 있음, 작업 처리 도중 예외 발생 -> 스레드 종료 x -> 스레드 풀에서 제거 되지 않고 나중에 재사용
