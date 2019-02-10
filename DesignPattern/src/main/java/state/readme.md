### 상태 패턴

특정 객체의 상태마다 다른 동작을 해야한다면????
예를 들면 음료 자판기가 있는데 이 음료 자판기에서 음료를 선택했을때 자판기에 상태에 따라서 다른 동작을 해야할 것이다.
현재 자판기에 동전이 있을때, 동전이 없을때 등등..

이를 코드로 구현하면 

```java
class VendingMachine {

    enum State {
        NOCOIN, SELECTABLE
    }

    private State state = State.NOCOIN;
    private int currentCoin;

    void insertCoin(int coin) {
        switch (state) {
            // 코인이 없는 상태에서 코인을 삽입하면 자판기 상태를 선택가능 상태로 바꿈
            case NOCOIN:
                increaseCoin(coin);
                state = State.SELECTABLE;
                break;
            // 자판기 상태가 선택 가능 상태일때 동전을 넣으면 자판기 동전량 증가
            case SELECTABLE:
                increaseCoin(coin);
                break;
        }
    }

    void increaseCoin(int coin) {
        currentCoin += coin;
        System.out.println("현재 코인 : " + currentCoin);
    }

    void selectItem(int itemIdx) {
        switch (state) {
            // 자판기에 동전이 없는 상태에서 음료를 선택하면 아무 일도 없음
            case NOCOIN: break;
            // 자판기가 선택가능 상태에서 음료를 선택하면 음료 제공 후, 코인 상태를 확인하고 상태 바꿈
            case SELECTABLE:
                produceItem(itemIdx);
                if (!hasCoin()) {
                    state = State.NOCOIN;
                }
                break;
        }
    }
    
    boolean hasCoin() {
        return currentCoin > 0;
    }

    private void produceItem(int itemIdx) {
        System.out.println("idx : " + itemIdx + " 음료 제공");
    }
}
```

만약 자판기에 상태가 추가될 때 마다 다른 동작을 하는 요구사항이 추가 된다면, `insertCoin`, `selectItem` 에서 분기가 점점 추가 될 것이다.
예를 들어 음료가 없을때 (sold out) 상태가 추가 된다면 VendingMachine.State 에 SOLDOUT 을 추가한 다음 
`insertCoin`, `selecItem` 에서 SOLDOUT 상태 일때에 대한 코드를 작성할 것이다.  
이런식으로 상태가 추가 되고, 분기가 추가 되는 형식으로 진행이 되면 시간이 지나면 분기들 때문에 유지보수가 어려워 지는 코드가 탄생할 것이다.

상태 패턴은 VendingMachine 이 State 타입에 구현체를 주입 받고 
클라이언트로 부터 기능 요청이 들어오면 State 타입의 구현체에게 그 작업을 위임하는 식으로 진행이 된다.

```java
class VendingMachine {

    private int currentCoin;
    private State state;

    public VendingMachine(State state) {
        this.state = state;
    }

    void insertCoin(int coin) {
        state.insertCoin(coin, this);
    }

    void increaseCoin(int coin) {
        currentCoin += coin;
        System.out.println("현재 코인 : " + currentCoin);
    }

    void selectItem(int itemIdx) {
        state.selectItem(itemIdx, this);
    }

    void produceItem(int itemIdx) {
        System.out.println("idx : " + itemIdx + " 음료 제공");
    }

    void changeState(State state) {
        this.state = state;
    }

    boolean hasCoins() {
        return currentCoin > 0;
    }

}
```

VendingMachine 은 State 코드를 생성자, setter (changeState 메서드) 에서 주입 받을 수 있고, 
increaseCoin, selectItem 메시지가 오면 state 에게 그 작업을 위임한다.

```java
public interface State {
    void insertCoin(int coin, VendingMachine vendingMachine);
    void selectItem(int itemIdx, VendingMachine vendingMachine);
}
```

State 타입은 insertCoin, selectItem 메시지를 받을때 VendingMachine 에 참조를 같이 받아서 VendingMachine 에서 해야할 작업을 처리 한다.

```java
public class NoCoinState implements State {
    @Override
    public void insertCoin(int coin, VendingMachine vendingMachine) {
        vendingMachine.increaseCoin(coin);
        vendingMachine.changeState(new SelectableState());
    }

    @Override
    public void selectItem(int itemIdx, VendingMachine vendingMachine) {
        // 아무 동작 하지 않음
    }
}

public class SelectableState implements State {
    @Override
    public void insertCoin(int coin, VendingMachine vendingMachine) {
        vendingMachine.insertCoin(coin);
    }

    @Override
    public void selectItem(int itemIdx, VendingMachine vendingMachine) {
        vendingMachine.produceItem(itemIdx);
        if (!vendingMachine.hasCoins()) {
            vendingMachine.changeState(new NoCoinState());
        }
    }
}
``` 

상태 패턴을 적용할 경우 VendingMachine 에 복잡한 분기문이 사라진다.
그리고 각각의 상태에 대한 코드가 State 의 구현체에 모이기 때문에 코드의 응집력이 높아지는 이점이 있다.

#### 고려할 점
VendingMachine 같이 클라이언트의 요청을 받고 State 의 참조를 갖으며 State 에게 작업을 위임 하는 객체를 Context 객체라 하는데,
상태 패턴에서 이 Context 의 상태를 Context 객체 자신이 변경할 것인가, 아니면 위의 코드 처럼 State 객체에서 Context 객체의 상태를 변경해줄 것인가를 고려해 봐야 한다.

State 객체에서 Context 의 상태를 변경하면 Context 이 코드가 단순해지고, 여러 상태가 추가 될때 마다 Context 를 변경하지 않아도 되는 장점이 있지만
Context 에서 상태를 변경하기 위한 추가 정보를 State 에게 제공해야 하고, 상태 변경 코드가 분산이 되어 상태 변경 규칙을 파악하기 어렵다는 단점이 있다.

위의 예에서 SelectableState 는 vendingMachine 의 상태를 변경하기 위해 hasCoins 메서드를 호출하는 것 처럼 말이다.

만약 Context 에서 상태를 변경 한다면 다음과 같이 할 수 있겠다.

```java
public class SelectableState implements State {
    @Override
    public void insertCoin(int coin, VendingMachine vendingMachine) {
        vendingMachine.insertCoin(coin);
    }

    @Override
    public void selectItem(int itemIdx, VendingMachine vendingMachine) {
        vendingMachine.produceItem(itemIdx);
    }
}

public class VendingMachine {

    // ...
    
    // Context 객체에서 자신이 자신의 상태를 변경함
    void selectItem(int itemIdx) {
        state.selectItem(itemIdx, this);
        if (hasCoins()) {
            changeState(new NoCoinState());
        }
    }

    // 접근지시자 private 로 변경
    private void changeState(State state) {
        this.state = state;
    }

    // 접근지시자 private 로 변경
    private boolean hasCoins() {
        return currentCoin > 0;
    }
    
    // ...

}
```

만약 상태의 개수, 상태 변경 규칙이 적다면 Context 에서 자신의 상태를 변경하고
상태의 개수, 상태 변경 규칙이 많다면 State 객체에서 Context 의 상태를 변경하게 하는 방식으로 구현하면 좋을 것이다.