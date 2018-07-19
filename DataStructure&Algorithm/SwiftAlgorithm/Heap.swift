//
//  Heap.swift
//  SwiftAlgorithm
//
//  Created by 오민호 on 2017. 9. 12..
//  Copyright © 2017년 Minomi. All rights reserved.
//

public struct Heap<T> {
    
    /// Heap의 노드 저장소
    var elements = [T]()
    
    
    /// min-Heap ,max-Heap 둘 중 결정
    var isOrderedBefore : (T, T) -> Bool
    
    
    /// 비어있는 Heap 생성하는 이니셜라이저
    ///
    /// - Parameter sort: 정렬 방법
    public init(sort: @escaping (T, T) -> Bool) {
        isOrderedBefore = sort
    }
    
    /// 인자로 넘어온 array를 가지고 Heap을 생성하는 이니셜라이저
    /// 배열의 순서는 중요하지 않고 sort 함수에 의해서 Heap이 구성된다.
    ///
    /// - Parameters:
    ///   - array: Heap을 만들 배열
    ///   - sort: 정렬 방법 선택
    public init(array: [T], sort: @escaping (T, T) -> Bool) {
        
        isOrderedBefore = sort
        buildHeap(from: array)
        
    }
    
    public var isEmpty : Bool {
        return elements.isEmpty
    }
    
    public var count : Int {
        return elements.count
    }
    
    
    @inline (__always) func leftChildIndex(of index: Int) -> Int {
        return 2 * index + 1
    }
    
    @inline (__always) func rightChildIndex(of index : Int) -> Int {
        return 2 * index + 2
    }
    
    @inline (__always) func parentIndex(of index : Int) -> Int {
        return (index - 1) / 2
    }
    
    
    ///  인자로 넘어온 array 로 부터 min-Heap or max-Heap 생성
    ///
    /// - Parameter array: Heap을 만들 array
    mutating fileprivate func buildHeap(from array: [T]) {
        
        elements = array
        
        for i in stride(from: elements.count / 2 - 1, through: 0, by: -1) {
            shiftDown(i, heapSize: elements.count)
        }
        
    }
    
    public func peek() -> T? {
        return elements.first
    }
    
    public mutating func replace (_ index : Int, value : T) {
        
        guard index < elements.count else {
            return
        }
        
        if(isOrderedBefore(value, elements[index])) {
            elements[index] = value
            shiftUp(index)
        } else {
            elements[index] = value
            shiftDown(index, heapSize: elements.count)
        }
        
    }
    
    mutating public func insert(_ value : T) {
    
        self.elements.append(value)
        self.shiftUp(elements.count - 1)
    
    }
    
    
    mutating public func remove() -> T? {
        
        if self.isEmpty {
            return nil
        } else if count == 1 {
            return elements.removeLast()
        } else {
            
            let value = elements.last
            elements[0] = elements.removeLast()
            shiftDown()
            return value
            
        }
        
    }
    
    
    /// index의 위치의 노드가 부모 노드보다 크거나(min-Heap) 작으면(max-Heap)
    /// 부모와 자식을 바꾸면서 힙을 재 구성한다.
    ///
    /// - Parameter index:
    mutating func shiftUp(_ index : Int) {
        
        var childIndex = index
        var parentIndex = self.parentIndex(of: childIndex)
        let child = elements[childIndex]
        
        while childIndex > 0 && self.isOrderedBefore(child, elements[parentIndex]) {
            
            elements[childIndex] = elements[parentIndex]
            childIndex = parentIndex
            parentIndex = self.parentIndex(of: childIndex)
            
        }
        
        elements[childIndex] = child
        
    }
    
    mutating func shiftDown() {
        self.shiftDown(0, heapSize: elements.count)
    }
    
    /// 힙 제약사항을 지키기 위해 자식노드들을 따라 내려가면서 힙을 재 구성
    ///
    /// - Parameters:
    ///   - index:
    ///   - heapSize: 힙의 크기
    mutating func shiftDown(_ index: Int, heapSize: Int) {
        
        var parentIndex = index
        
        while true {
            
            let leftChildIndex = self.leftChildIndex(of: parentIndex)
            let rightChildIndex = leftChildIndex + 1
            
            var first = parentIndex
            
            if leftChildIndex < heapSize && self.isOrderedBefore(elements[leftChildIndex], elements[first]) {
                first = leftChildIndex
            }
            
            if rightChildIndex < heapSize && self.isOrderedBefore(elements[rightChildIndex], elements[first]) {
                first = rightChildIndex
            }
            
            if first == parentIndex {
                return
            }
            
            swap(&elements[first], &elements[parentIndex])
            parentIndex = first
        }
        
    }
    
}

extension Heap where T : Equatable {
    
    /// heap 에서 주어진 element 의 index 검색
    ///
    /// - Parameter element: 찾고자 하는 element
    /// - Returns: element의 위치
    public func index(of element: T) -> Int? {
        return index(of: element, 0)
    }
    
    public func index(of element: T, _ i : Int) -> Int? {
        
        guard i < elements.count else {
            return nil
        }
        
        if isOrderedBefore(element, elements[i]) {
            return nil
        }
        
        if elements[i] == element {
            return i
        }
        
        if let idx = index(of: element, leftChildIndex(of: i)) {
            return idx
        }
        
        if let idx = index(of: element, rightChildIndex(of: i)) {
            return idx
        }
        
        return nil
        
    }
    
}
