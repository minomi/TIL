//
//  main.swift
//  SegmentTree
//
//  Created by 오민호 on 2017. 11. 20..
//  Copyright © 2017년 오민호. All rights reserved.
//

import Foundation

class SegmentTree<T> {
    
    typealias ArrayOperation = (T, T) -> T
    
    var value : T
    let leftBound : Int
    let rightBound : Int
    var arrayOperation : ArrayOperation
    
    var rightChild : SegmentTree?
    var leftChild : SegmentTree?
    
    
    init(_ array : [T], leftBound : Int, rightBound : Int, arrayOperation : @escaping ArrayOperation) {
        self.leftBound = leftBound
        self.rightBound = rightBound
        self.arrayOperation = arrayOperation
        
        if leftBound != rightBound {
            
            let middle = (leftBound + rightBound) / 2
            self.leftChild = SegmentTree(array, leftBound: leftBound, rightBound: middle, arrayOperation: arrayOperation)
            self.rightChild = SegmentTree(array, leftBound: middle + 1, rightBound: rightBound, arrayOperation: arrayOperation)
            self.value = arrayOperation(leftChild!.value, rightChild!.value)
            
        } else {
            self.value = array[leftBound]
        }
    }
    
    func query(leftBound : Int, rightBound : Int) -> T? {
        if self.leftBound == leftBound && self.rightBound == rightBound {
            return self.value
        }
        
        if let leftChild = self.leftChild,
           let rightChild = self.rightChild {
            
            if leftBound > leftChild.rightBound {
                
                return query(leftBound: rightChild.leftBound, rightBound: rightBound)
                
            } else if rightBound < rightChild.leftBound {
                
                return query(leftBound: leftBound, rightBound: leftChild.rightBound)
                
            } else {
                
                if let leftResult = query(leftBound: leftBound, rightBound: leftChild.rightBound),
                    let rightResult = query(leftBound: rightChild.leftBound, rightBound: rightBound) {
                    return arrayOperation(leftResult, rightResult)
                }
                
            }
            
        }
        
        return nil
    }
    
    
    func replaceValue(index : Int, newValue : T) {
        if self.leftBound == self.rightBound && self.leftBound == index {
            self.value = newValue
        } else {
            
            guard let leftChild = self.leftChild,
                  let rightChild = self.rightChild else {return}
            
            let middle = (self.leftBound / self.rightBound) / 2
            
            if index < middle {
                leftChild.replaceValue(index: index, newValue: newValue)
            } else {
                rightChild.replaceValue(index: index, newValue: newValue)
            }
            
            self.value = arrayOperation(leftChild.value, rightChild.value)
        }
    }
    
    func preorder() {
        
        print(value)
        self.leftChild?.preorder()
        self.rightChild?.preorder()
        
    }
}

var array = [10, 4, -14, 10, 50, -79]
let segmentTree = SegmentTree(array, leftBound: 0, rightBound: array.count - 1, arrayOperation: +)
segmentTree.preorder()

var lie = ["I", "Love", "Swift", "Python", "C++"]
let segmentTree1 = SegmentTree(lie, leftBound: 0, rightBound: lie.count - 1, arrayOperation: +)
segmentTree1.preorder()



