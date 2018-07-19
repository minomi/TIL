//
//  TaskManager.swift
//  URLSessionHandling
//
//  Created by 오민호 on 2017. 11. 11..
//  Copyright © 2017년 오민호. All rights reserved.
//

import UIKit

class TaskManager {
    
    static let shared = TaskManager()
    
    let session = URLSession(configuration: .default)
    typealias completionHandler = (Data?, URLResponse? ,Error?) -> ()
    
    var tasks = [URL: [completionHandler]]()
    
    func dataTask(with url : URL?, completionHandler : @escaping completionHandler) {
        guard let url = url else {
            NSLog("유효하지 않은 url")
            return
        }
        
        guard !tasks.keys.contains(url) else {
            tasks[url]?.append(completionHandler)
            return
        }
        
        tasks[url] = [completionHandler]
        
        let _ = session.dataTask(with: url) { [weak self] data, response, error in
            print("네트워크 작업 완료")
            DispatchQueue.main.async {
                
                guard let completionHandlers = self?.tasks[url] else { return }
                
                for handler in completionHandlers {
                    print("completionHandlers 실행")
                    handler(data, response, error)
                }
                
            }
            
        }.resume()
        
    }
}
