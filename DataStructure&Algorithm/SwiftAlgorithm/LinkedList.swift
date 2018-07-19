//
//  LinkedList.swift
//  SwiftAlgorithm
//
//  Created by 오민호 on 2017. 9. 14..
//  Copyright © 2017년 Minomi. All rights reserved.
//

public final class LinkedList<T> {
    
    public class LinkedListNode<T> {
        
        var value : T
        
        weak var previous : LinkedListNode?
        var next : LinkedListNode?
        
        public init(value : T) {
            self.value = value
        }
        
    }
    
    public typealias Node = LinkedListNode<T>
    
    fileprivate var head : Node?
    
    public init() {}
    
    public var isEmpty : Bool {
        return head == nil
    }
    
    public var first : Node? {
        return head
    }
    
    public var last : Node? {
        
        if var node = head {
            
            while let next = node.next {
                node = next
            }
            
            return node
            
        } else {
            return nil
        }
        
    }
    
    public var count : Int {
        
        if var node = head {
            
            var c = 1
            
            while let next = node.next {
                
                node = next
                c += 1
                
            }
            
            return c
            
        } else {
            return 0
        }
        
    }
    
    public func node(at index: Int) -> Node? {
        
        if index >= 0 {
            
            var node = head
            var i = index
            
            while node != nil {
                
                if i == 0 { return node }
                i -= 1
                node = node?.next
                
            }
            
        }
        
        return nil
        
    }
    
    public subscript(index: Int) -> T {
        
        let node = self.node(at: index)
        assert(node != nil)
        return node!.value
        
    }
    
    public func append(_ value : T) {
        
        let newNode = Node(value: value)
        append(newNode)
        
    }
    
    public func append(_ node : Node) {
        
        let newNode = Node(value: node.value)
        
        if let last = self.last {
            
            last.next = newNode
            node.previous = last
            
        } else {
            self.head = newNode
        }
        
    }
    
    public func append(_ list : LinkedList) {
        
        var nodeToCopy = list.head
        
        while let node = nodeToCopy {
            
            self.append(node)
            nodeToCopy = node.next
            
        }
        
    }
    
    private func nodesBeforeAndAfter(index: Int) -> (Node?, Node?) {
        assert(index >= 0)
        
        var i = index
        var next = head
        var prev: Node?
        
        while next != nil && i > 0 {
            
            i -= 1
            prev = next
            next = next!.next
            
        }
        
        assert(i == 0)  // if > 0, then specified index was too large
        return (prev, next)
    }
    
    public func insert(_ value: T, at index: Int) {
        
        let newNode = Node(value: value)
        self.insert(newNode, at: index)
        
    }
    
    public func insert(_ node: Node, at index: Int) {
        
        let (prev, next) = nodesBeforeAndAfter(index: index)
        let newNode = LinkedListNode(value: node.value)
        
        newNode.previous = prev
        newNode.next = next
        prev?.next = newNode
        next?.previous = newNode
        
        if prev == nil {
            head = newNode
        }
        
    }
    
    public func remove(_ node : Node) -> T {
        
        let prev = node.previous
        let next = node.next
        
        if let prev = prev {
            prev.next = next
        } else {
            head = next
        }
        
        next?.previous = prev
        
        node.previous = nil
        node.next = nil
        
        return node.value
        
    }
    
    public func remove(_ index : Int) -> T {
        
        let node = self.node(at: index)
        assert(node != nil)
        return remove(node!)
        
    }
    
}
