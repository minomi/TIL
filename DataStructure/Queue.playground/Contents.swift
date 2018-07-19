//: Playground - noun: a place where people can play

import Cocoa

public struct Queue<T> {
    
    public struct Iterator : IteratorProtocol {
        
        var currentElements : [T]
        
        init(elements : [T]) {
            currentElements = elements
        }
        
        public mutating func next() -> T? {
            return currentElements.popLast()
        }
        
    }
    
    private var elements = [T]()
    
    public init() {}
    
    public init<S : Sequence>(_ newElements : S) where S.Iterator.Element == T {
        elements.append(contentsOf: newElements)
    }
    
    var count : Int {
        return elements.count
    }
    
    var isEmpty : Bool {
        return elements.isEmpty
    }
    
    var isFull : Bool {
        return self.capacity == elements.count
    }
    
    var capacity : Int {
        get {
            return elements.capacity
        }
        set {
            self.elements.reserveCapacity(newValue)
        }
    }
    
    mutating func enqueue(element : T)  {
        elements.append(element)
    }
    
    mutating func dequeue() -> T? {
        return elements.removeFirst()
    }
    
    func peek() -> T? {
        return elements.first
    }
    
    mutating func clear() {
        elements.removeAll()
    }
    
    mutating func insert(_ newElement : T, at index : Int) {
        elements.insert(newElement, at: index)
    }
    
    mutating func remove(at index : Int) {
        elements.remove(at: index)
    }
    
}

extension Queue : Sequence {
    
    public func makeIterator() -> Queue<T>.Iterator {
        return Queue<T>.Iterator(elements: self.elements)
    }
    
}

extension Queue : ExpressibleByArrayLiteral {
    
    public init(arrayLiteral elements: T...) {
        self.init(elements)
    }
    
}

extension Queue : CustomDebugStringConvertible, CustomStringConvertible {
    
    public var debugDescription: String {
        return elements.debugDescription
    }
    
    public var description: String {
        return elements.description
    }
    
}

extension Queue : MutableCollection {
    public var startIndex: Queue<T>.Index {
        return 0
    }
    
    public var endIndex: Queue<T>.Index {
        return count - 1
    }
    
    public subscript(position: Int) -> MutableSlice<Queue<T>> {
        get {
            <#code#>
        }
        set(newValue) {
            <#code#>
        }
    }
    
    public subscript(position: Int) -> MutableSlice<Queue<T>> {
        return element`
    }

    public subscript(index : Int) -> T {
        get {
            return elements[index]
        }
        set {
            elements[index] = newValue
        }
    }
}

var queue = Queue<Int>()
queue.capacity = 100

queue.enqueue(element: 3)
queue.enqueue(element: 4)
queue.enqueue(element: 7)

print(queue.dequeue())
print(queue.dequeue())
print(queue.dequeue())

queue = [2, 3, 1, -2]
queue
queue.dequeue()
queue


