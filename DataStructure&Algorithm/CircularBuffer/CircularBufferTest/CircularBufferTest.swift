//
//  CircularBufferTest.swift
//  CircularBufferTest
//
//  Created by 오민호 on 2017. 11. 6..
//  Copyright © 2017년 오민호. All rights reserved.
//

import XCTest

class CircularBufferTest: XCTestCase {
    
    override func setUp() {
        super.setUp()
        // Put setup code here. This method is called before the invocation of each test method in the class.
    }
    
    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        super.tearDown()
    }
    
    /// CircularBuffer 생성 테스트
    func testInit() {
        
        var intTypeBuffer = CircularBuffer<Int>(3)
        XCTAssertFalse(intTypeBuffer.capacity == 3)
        XCTAssertFalse(intTypeBuffer.capacity == 5)
        
        XCTAssertTrue(intTypeBuffer.isEmpty)
        XCTAssertNil(intTypeBuffer.pop())
        
        var intTypeBufferIgnoreOperation = CircularBuffer<Int>(3, overwriteOperation: .ignore)
        XCTAssertFalse(intTypeBuffer.capacity == 3)
        XCTAssertFalse(intTypeBuffer.capacity == 5)
        XCTAssertTrue(intTypeBuffer.capacity == 4)
        XCTAssertTrue(intTypeBuffer.isEmpty)
        XCTAssertNil(intTypeBuffer.pop())
        
        
        var arrayLiteral = [1, 2, 1, 0, 3]
        let bufferByArrayLiteral = CircularBuffer(arrayLiteral: arrayLiteral)
        XCTAssertEqual(bufferByArrayLiteral.capacity, 5)
    
    }
    
    func testPush() {
        
        //overwrite
        var intTypeBuffer = CircularBuffer<Int>(3)
        XCTAssertTrue(intTypeBuffer.capacity == 4)
        intTypeBuffer.push(element: 2)
        intTypeBuffer.push(element: 1)
        intTypeBuffer.push(element: 5)
        intTypeBuffer.push(element: 2)
        print(intTypeBuffer.count)
        XCTAssertTrue(intTypeBuffer.isFull)
        intTypeBuffer.push(element: 7)
        XCTAssertEqual(intTypeBuffer.peek(), 1)
        XCTAssertEqual(intTypeBuffer.count, 4)
        intTypeBuffer.push(element: 1)
        XCTAssertEqual(intTypeBuffer.peek(), 5)
        XCTAssertEqual(intTypeBuffer.count, 4)
        intTypeBuffer.push(element: 5)
        XCTAssertEqual(intTypeBuffer.peek(), 2)
        XCTAssertEqual(intTypeBuffer.count, 4)
        
    }


    
}
