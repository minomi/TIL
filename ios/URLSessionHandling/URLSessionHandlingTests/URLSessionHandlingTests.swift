//
//  URLSessionHandlingTests.swift
//  URLSessionHandlingTests
//
//  Created by 오민호 on 2017. 11. 11..
//  Copyright © 2017년 오민호. All rights reserved.
//

import XCTest
@testable import URLSessionHandling

class URLSessionHandlingTests: XCTestCase {

    
    func testTaskManager() {
        // This is an example of a functional test case.
        // Use XCTAssert and related functions to verify your tests produce the correct results.
        
        for _ in 0..<100 {
            let expect = expectation(description: "이미지 100장 가져와서 UIImage 객체 생성")
            
            TaskManager.shared.dataTask(with: URL(string: "https://i.redd.it/dj4bz294zqhz.png")) { (data, response, error) in
                
                let image = UIImage(data: data!)
                XCTAssertNotNil(image)
                expect.fulfill()
            
            }
            
        }
        
        waitForExpectations(timeout: 10, handler: nil)
    
    }

}
