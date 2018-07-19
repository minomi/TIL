//
//  LinkedListTest.swift
//  SwiftAlgorithm
//
//  Created by 오민호 on 2017. 9. 14..
//  Copyright © 2017년 Minomi. All rights reserved.
//

import XCTest

class LinkedListTest: XCTestCase {

    let numbers = [8, 2, 10, 9, 7, 5]
    
    fileprivate func buildList() -> LinkedList<Int> {
        
        let list = LinkedList<Int>()
        
        for number in numbers {
            list.append(number)
        }
        
        return list
        
    }
    
    func testEmpty() {
        
        let list = LinkedList<Int>()
        XCTAssertEqual(list.count, 0)
        XCTAssertTrue(list.isEmpty)
        XCTAssertNil(list.first)
        XCTAssertNil(list.last)
        
    }
    
    func testAppend() {
        
        let list = LinkedList<Int>()
        list.append(1)
        XCTAssertEqual(list.count, 1)
        XCTAssertFalse(list.isEmpty)
        
        XCTAssertNotNil(list.first)
        XCTAssertNil(list.first?.previous)
        XCTAssertNil(list.first?.next)
        XCTAssertEqual(list.first?.value, 1)
        
        XCTAssertTrue(list.first === list.last)
        
        list.append(2)
        XCTAssertEqual(list.count, 2)
        XCTAssertNotNil(list.first?.next)
        XCTAssertEqual(list.first?.value, 1)
        
        XCTAssertNotNil(list.last)
        XCTAssertEqual(list.last?.value, 2)
        XCTAssertFalse(list.first === list.last)
        XCTAssertTrue(list.first?.next === list.last)
        XCTAssertNil(list.last?.next)
        
        list.append(3)
        XCTAssertEqual(list.count, 3)
        XCTAssertTrue(list.first?.next !== list.last)
        XCTAssertTrue(list.first?.next?.next === list.last)
        XCTAssertEqual(list.last?.value, 3)
        XCTAssertNil(list.last?.next)
        
    }

}
