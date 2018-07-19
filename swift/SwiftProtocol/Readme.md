Swift의 Protocol 과 extension을 통한 기본구현이 다른 언어의 추상 클래스와 비슷한데, Swift만의 이점은 무엇일까

 * Swift의 Protocol은 열거형, 구조체, 클래스 모두 채택 가능하다.
 * 두 개 이상의 Protocol을 채택할 수 있으므로, 여러 Protocol의 기본동작으로 확장가능하다.

 ``` Swift
let numbers = [10,20,30,40,50,60]
let slice = numbers[1 ... 3]
let reversedSlice = slice.reversed()
let answer = reversedSlice.map{$0 * 10}
print(answer)
 ```

 위의 코드에서 slice 는 Array<Int> 타입이 아닌 **ArraySlice<Int>** 이다.
 이런 __wrapper type__ 은 원래 배열의 view 처럼 작동한다. 이는 값 비싼 메모리 할당을 피할 수 있다.

 마찬가지로 reversedSlice 도  __ReversedRandomAccessCollection<ArraySlice<Int>>__ 이고 원래 배열의 __wrapper type__ 이다.
