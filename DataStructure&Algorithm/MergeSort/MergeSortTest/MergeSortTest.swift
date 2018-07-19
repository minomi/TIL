//
//  MergeSortTest.swift
//  MergeSortTest
//
//  Created by 오민호 on 2017. 11. 12..
//  Copyright © 2017년 오민호. All rights reserved.
//

import XCTest

class MergeSortTest: XCTestCase {
    
    func testMerge() {
        // This is an example of a functional test case.
        // Use XCTAssert and related functions to verify your tests produce the correct results.
        
        let left1 = [2, 3]
        let right1 = [-1, 2, 3]
        let merged1 = merge(leftList: left1, rightList: right1) { $0 < $1 }
        XCTAssertEqual([-1, 2, 2, 3, 3], merged1)
        
        let left2 = [2, 4, 2]
        let right2 = [2, 6, -2]
        let merged2 = merge(leftList: left2, rightList: right2) { $0 > $1 }
        XCTAssertEqual([2, 2, 6, 4, 2, -2 ], merged2)
        
        let left3 = [1]
        let right3 = [6]
        let merged3 = merge(leftList: left3, rightList: right3) { $0 < $1 }
        XCTAssertEqual([1, 6], merged3)

    }

    func testMergeSort() {
        let array = [2, 1, 2, -2, 0, 100]
        let sorted = mergeSort(array) { $0 < $1 }
        XCTAssertEqual([-2, 0, 1, 2, 2, 100], sorted)
        
        let array1 = [0, 0, 0, 0]
        let sorted1 = mergeSort(array1) { $0 < $1 }
        XCTAssertEqual([0, 0, 0, 0], sorted1)
        
        let array2 = [5, 4, 3, 2, 1]
        let sorted2 = mergeSort(array2) { $0 < $1 }
        XCTAssertEqual([1, 2, 3 ,4 ,5], sorted2)

    }
    
}
