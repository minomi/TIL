//
//  PushedViewController.swift
//  NavigationAnimation
//
//  Created by 오민호 on 2017. 12. 26..
//  Copyright © 2017년 오민호. All rights reserved.
//

import UIKit

class PushedViewController: UIViewController {

    let label : UILabel = {
        let label = UILabel()
        label.text = "pushed viewcontroller"
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 30)
        return label
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.view.backgroundColor = .white
        self.view.addSubview(label)
        label.translatesAutoresizingMaskIntoConstraints = false
        label.topAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.topAnchor).isActive = true
        label.centerXAnchor.constraint(equalTo: self.view.centerXAnchor).isActive = true
    }

}
