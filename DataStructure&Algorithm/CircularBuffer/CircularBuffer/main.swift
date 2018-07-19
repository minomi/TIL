//
//  main.swift
//  CircularBuffer
//
//  Created by 오민호 on 2017. 11. 3..
//  Copyright © 2017년 오민호. All rights reserved.
//

import Foundation

struct Constants {
    static let defaultBufferCapacity = 8
}

struct CircularBuffer<T> {

    /// 순환버퍼가 꽉 찼을때 처리
    ///
    /// - ignore: 새로 추가되는 값을 무시한다.
    /// - overwrite: 새로 추가되는 값을 덮어씌운다.
    enum OverwriteOperation {
        case ignore
        case overwrite
    }
    
    //MARK:  stored property
    fileprivate var data: [T]
    fileprivate var head = 0, tail = 0
    fileprivate var internalCount = 0
    
    
    fileprivate var overwriteOperation : OverwriteOperation = .overwrite
    
    //MARK: computed property
    var isFull : Bool {
        return data.capacity == internalCount
    }
    
    var isEmpty : Bool {
        return internalCount < 1
    }
    
    //MARK: initializer
    
    public init() {
        data = [T]()
        data.reserveCapacity(Constants.defaultBufferCapacity)
    }
    
    public init(_ count : Int, overwriteOperation: OverwriteOperation = .overwrite) {
        var capacity = count
        
        if capacity < 1 {
            capacity = Constants.defaultBufferCapacity
        }
        
        // count에 가까운 수 만큼 2를 거듭제곱 한다.
        if (capacity & (~capacity + 1)) != capacity {
            var temp = 1
            
            while (temp < capacity) {
                temp <<= 1
            }
            
            capacity = temp
        }
        
        data = [T]()
        data.reserveCapacity(capacity)
        self.overwriteOperation = overwriteOperation
    }
    
    public init<S : Sequence>(_ elements : S, size : Int) where S.Element == T {
        
        self.init(size)
        elements.forEach { push(element : $0) }
        
    }
    
    //MARK: public method
    
    /// element를 버퍼 마지막에 추가 한다.
    /// 버퍼가 꽉 찼을 경우 OverwriteOpearation에 따라서 처리한다.
    ///
    /// - Parameter element: 추가될 데이터
    public mutating func push(element : T) {
        if self.isFull {
            
            switch overwriteOperation {
            case .ignore :
                return
            case .overwrite :
                let _ = pop()
            }
            
        }
        
        if data.endIndex < data.capacity {
            data.append(element)
        } else {
            data[tail] = element
        }
        
        tail = increament(pointer: tail)
        internalCount += 1
        
    }
    
    public func peek() -> T? {
        if isEmpty {
            return nil
        }
        
        return data[head]
    }
    
    /// 버퍼에서 첫 번째 요소를 삭제한 뒤 반환
    ///
    /// - Returns: 버퍼의 첫 번째 요소, 비어있다면 nil
    public mutating func pop() -> T? {
        if self.isEmpty {
            return nil
        }
        
        let popedData = data[head]
        head = increament(pointer: head)
        internalCount -= 1
        return popedData
        
    }
    
    public mutating func clear() {
        head = 0
        tail = 0
        internalCount = 0
        data.removeAll(keepingCapacity: true)
    }
    
    public var count : Int {
        return internalCount
    }
    
    public var capacity : Int {
        get {
            return data.capacity
        }
        set {
            data.reserveCapacity(newValue)
        }
    }
    
    
    
    //MARK: private method
    
    /// 내부 포인터 값을 1씩 증가 시킨다.
    /// 증가된 값이 배열의 마지막 요소를 넘을 경우를 대비함
    /// - Parameter pointer: 증가할 포인터
    /// - Returns: 증가된 포인터
    fileprivate func increament(pointer : Int) -> Int {
        return (pointer + 1) & (data.capacity - 1)
    }
    
}

extension CircularBuffer : Sequence {
    
    func makeIterator() -> AnyIterator<T> {
        var newData = [T]()
        
        if count > 0 {
            if head > tail {
                newData = [T](repeatElement(data[head], count: count))
                let front = data.capacity - head
                newData[0 ..< front] = data[head ..< data.capacity]
                if front < count {
                    newData[front + 1 ..< newData.capacity] = data[0 ..< count - front]
                }
            } else {
                newData[0 ..< tail - head] = data[head ..< tail]
            }
        }
        
        return AnyIterator(IndexingIterator(_elements: newData.lazy))
    }
    
}

extension CircularBuffer : ExpressibleByArrayLiteral {
    typealias ArrayLiteralElement = T
    
    init(arrayLiteral elements: T...) {
        self.init(elements, size: elements.count)
    }
    
}

print("Hello, World!")

