//: Playground - noun: a place where people can play

import Cocoa

struct Stack<T> {
    
    private var elements = [T]()
    
    // stack에 for..in 구문을 사용하기 위해 Sequence, IteratorProtocol을 적용
    struct Iterator : IteratorProtocol {
        var currentElement : [T]
        
        init(elements : [T]) {
            currentElement = elements
        }
        
        mutating func next() -> T? {
            return currentElement.popLast()
        }
    }
    
    // 또 다른 스택으로 초기화 하기 위한 이니셜라이져
    public init<S : Sequence>(_ s : S) where S.Iterator.Element == T {
        self.elements = Array(s.reversed())
    }
    
    public mutating func pop() -> T? {
        return elements.popLast()
    }
    
    public mutating func push(element : T) {
        elements.append(element)
    }
    
    public func peek() -> T? {
        return elements.last
    }
    
    public var isEmpty : Bool {
        return elements.isEmpty
    }
    
    public var count : Int {
        return elements.count
    }
    
}

// 타입 값을 출력할 때 좀 더 알아보기 쉬운 값으로 출력하기 위해 CustomStringConvertible, CustomDebugStringConvertible 적용
extension Stack : CustomStringConvertible, CustomDebugStringConvertible {
    
    var description: String {
        return self.elements.description
    }
    
    var debugDescription: String {
        return self.elements.debugDescription
    }
    
}

// 배열처럼 스택을 초기화 하기 위해 ExpressibleByArrayLiteral 적용
extension Stack : ExpressibleByArrayLiteral {
    
    init(arrayLiteral elements: T...) {
        self.init(elements)
    }
    
}


// stack에 for..in 구문을 사용하기 위해 Sequence, IteratorProtocol을 적용
extension Stack : Sequence {
    func makeIterator() -> Stack<T>.Iterator {
        return Stack<T>.Iterator(elements: self.elements)
    }
}

var stack = Stack<Int>()
stack.push(element: 3)
stack.push(element: 4)
stack.push(element: -2)
stack.pop()
stack.pop()
stack.pop()
stack.pop()

var stackByArrayLiteral : Stack<Int> = [2,5,4]
stackByArrayLiteral.push(element: 4)
stackByArrayLiteral.pop()

var otherStack = Stack<Int>(stackByArrayLiteral)

otherStack.pop()


for element in stackByArrayLiteral {
    element
}


