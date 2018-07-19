### Isolation Level (격리 수준)

트랜잭션의 4가지 특성 중에 Isolation (고립성) 이란 특성이 있습니다.
고립성은 연속적인 수정 작업을 복수의 사용자가 동시에 실행이 됐을때 모순이 없어야함을 보증하는 것입니다. 모순이 없다는 뜻은 복수의 사용자가 트랜잭션을 동시에 실행을 해도 그 결과는 동시가 아닌 순서대로 처리된 결과와 같다는 것을 의미합니다.

이를 구현하기 위해 MySQL은 Serializable(직렬화 가능)이라는 사양을 제공합니다. 하지만 Serializable 에서는 항상 동시에 동작하는 트랜잭션이 1개의 이미지가 되어 성능면에서는 실용적이지 않습니다. 이 때문에 'ANSI' 라는 규격 단체에서 Serializable 로 부터 격리 수준을 완화해서 Serializable 이외 자신이 아닌 다른 트랜잭션의 영향을 받는 것을 허용하는 4 단계를 정의했습니다.

1. Read Uncommitted (RU)
2. Read Committed (RC)
3. Repeatable Read (RR)
4. Serializable

이 중 4. Serializable 이 가장 엄격하고, 숫자가 작아질수록 완화되어서 Serializable 일때 발생하지 않았던 현상이 낮은 격리수준(1, 2, 3) 에 생깁니다.

1. Dirty Read : 어떤 트랜잭션이 커밋되기 전에 다른 트랜잭션에서 데이터를 읽을때 발생하는 현상입니다. 사용자 A가 값을 변경하고 커밋을 하지 않아도, 사용자 B는 사용가 A가 커밋되지 않은 변경 값을 읽는 것을 가르킵니다.
2. Fuzzy / NonRepeatable Read : 어떤 트랜잭션이 이전에 읽어 들인 데이터를 다시 읽어 들일 때 두번째 읽어 들인 결과가 첫번째 읽어 들인 결과와 달라지는 현상입니다.
3. Phantom Read : 어떤 트랜잭션을 읽을 때 선택할 수 있는 데이터가 나타나거나 사라지는 현상입니다.

3가지 현상과 격리 수준의 관계 입니다.

|격리수준| Dirty Read | NonRepeatable Read | Phantom Read |
|:------:|:----------:|:--------:|:------:|
|RU| o | o | o |
|RC| x | o | o |
|RR| x | x | o |
|Serializable| x | x| x|

MySQL의 격리 수준의 기본값은 Read Committed 입니다.
