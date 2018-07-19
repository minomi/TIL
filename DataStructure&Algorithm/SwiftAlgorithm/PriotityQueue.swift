//
//  PriotityQueue.swift
//  SwiftAlgorithm
//
//  Created by 오민호 on 2017. 9. 14..
//  Copyright © 2017년 Minomi. All rights reserved.
//

public struct PriorityQueue<T> {
    
    fileprivate var heap : Heap<T>
    
    public init(sort : @escaping (T, T) -> Bool) {
        heap = Heap<T>(sort : sort)
    }
    
    public func peek() -> T? {
        return heap.peek()
    }
    
    public mutating func enqueue(_ priority : T) {
        heap.insert(priority)
    }
    
    public mutating func dequeue() -> T? {
        return heap.remove()
    }
    
    public mutating func changePriority(_ index : Int, value : T) {
        heap.replace(index, value: value)
    }
    
}

extension PriorityQueue where T: Equatable {
    
    public func index(of element : T) -> Int? {
        return heap.index(of: element)
    }
    
}

