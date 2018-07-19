//
//  SearchVC+URLSessionDelegate.swift
//  HalfTunes
//
//  Created by 오민호 on 2017. 10. 18..
//  Copyright © 2017년 Ray Wenderlich. All rights reserved.
//

import UIKit

extension SearchViewController: URLSessionDownloadDelegate {
  func urlSession(_ session: URLSession, downloadTask: URLSessionDownloadTask,
                  didFinishDownloadingTo location: URL) {
    guard let sourceURL = downloadTask.originalRequest?.url else {return}
    let download = downloadService.activeDownloads[sourceURL]
    downloadService.activeDownloads[sourceURL] = nil
    
    let destinationURL = localFilePath(for: sourceURL)
    print(destinationURL)
    
    let fileManager = FileManager.default
    try? fileManager.removeItem(at: destinationURL)
    
    do {
      try fileManager.copyItem(at: location, to: destinationURL)
      download?.track.downloaded = true
    } catch let error {
      print("Could not copy file to disk: \(error.localizedDescription)")
    }
    
    if let index = download?.track.index {
      DispatchQueue.main.async { [weak self] in
        self?.tableView.reloadRows(at: [IndexPath(row : index, section : 0)], with: .automatic)
      }
    }
    
    print("Finished downloading to \(location).")
  }
  
  func urlSessionDidFinishEvents(forBackgroundURLSession session: URLSession) {
    DispatchQueue.main.async {
      
      if let appDelegate = UIApplication.shared.delegate as? AppDelegate,
        let completionHandler = appDelegate.backgroundSessionCompletionHandler {
        appDelegate.backgroundSessionCompletionHandler = nil
        completionHandler()
      }
      
    }
  }
}
