//
//  main.swift
//  MergeSort
//
//  Created by 오민호 on 2017. 11. 12..
//  Copyright © 2017년 오민호. All rights reserved.
//

import Foundation

func mergeSort<T : Comparable>(_ list : [T], _ order : (T, T) -> Bool ) -> [T] {
    guard list.count >= 2 else { return list }
    
    let half = list.count / 2
    
    return merge(leftList: mergeSort([T](list[0 ..< half]), order),
                 rightList: mergeSort([T](list[half ..< list.count]), order),
                 order)
    
}

func merge<T : Comparable> (leftList : [T], rightList : [T], _ order : (T, T) -> Bool) -> [T] {
    var leftIdx = 0, rightIdx = 0
    
    var tempArray = [T]()
    tempArray.reserveCapacity(leftList.count + rightList.count)

    
    while leftIdx < leftList.count && rightIdx < rightList.count {
        
        let left = leftList[leftIdx]
        let right = rightList[rightIdx]
        
        if left == right {
            tempArray.append(left)
            tempArray.append(right)
            leftIdx += 1
            rightIdx += 1
        } else if order(left, right) {
            tempArray.append(left)
            leftIdx += 1
        } else {
            tempArray.append(right)
            rightIdx += 1
        }
        
    }
    
    tempArray += [T](leftList[leftIdx ..< leftList.count])
    tempArray += [T](rightList[rightIdx ..< rightList.count])
    
    return tempArray
}
