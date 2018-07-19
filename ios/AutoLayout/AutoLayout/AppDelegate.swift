//
//  AppDelegate.swift
//  AutoLayout
//
//  Created by 오민호 on 2017. 11. 9..
//  Copyright © 2017년 오민호. All rights reserved.
//

import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?) -> Bool {
        // Override point for customization after application launch.
        
        window = UIWindow()
        window?.makeKeyAndVisible()
        
        let layout = UICollectionViewFlowLayout()
        layout.scrollDirection = .horizontal
        let swipingController = SwipingController(collectionViewLayout: layout)
        window?.rootViewController = swipingController
        
        return true
    }




}

