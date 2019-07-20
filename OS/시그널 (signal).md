### 시그널 (signal)
커널 또는 프로세스에서 또 다른 프로세스에 어떤 이벤트가 발생했는지 알려주는 기법
> ctrl + c = SIGINT 시그널이 OS -> 프로세스로 전달, 프로세스는 SIGINT 에 대한 디폴트 처리(종료)를 함

### SIGUSR1, SIGUSR2
SIGUSR1, SGIUSR2 시그널은 우리가 프로그램 내에서 핸들러를 재등록 할 수 있고, 이를  IPC 기법으로 활용할 수도 있다.

### 특정 시그널을 무시할 수도 있고, 핸들러를 재정의 할 수 있음
```
signal(SIGINT, SIG_IGN) // SIG_IGN 시그널 무시
signal(SIGINT, (void *)signal_handler); 
```

### int kill(pid_t pid, int sig)
특정 프로세스에 특정 시그널을 보내는 시스템 API

### 시그널 처리
process 는 process 의 대한 정보를 담고 있는 PCB (Process Control Block) 가 있다. <br>
PCB 에 는 시그널 관련 자료구조들이 있다
* 프로세스가 받은 시그널들을 담고 있는 리스트 (pending)
* 블록된 시그널은 무엇인가를 담고 있는 비트마스크 (block)
* 특정 시그널에 대한 핸들러를 저장하는 변수 (sig)
등등

프로세스가 커널모드 -> 사용자모드로 올때 이 자료구조들을 확인하여 process 가 받은 signal 에 대한 적절한 처리를 한다.