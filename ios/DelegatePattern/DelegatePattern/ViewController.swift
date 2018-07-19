//
//  ViewController.swift
//  DelegatePattern
//
//  Created by 오민호 on 2017. 9. 30..
//  Copyright © 2017년 Minomi. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    var messageBox : MessageBox?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.messageBox = MessageBox(frame: CGRect(x: 0,
                                                   y: 100,
                                                   width: self.view.frame.width,
                                                   height: self.view.frame.height * 0.5))
        self.messageBox?.deleage = self
        self.messageBox?.backgroundColor = .gray
        self.view.addSubview(messageBox!)
    
    }

}

extension ViewController: MessageBoxDelegate {
    
    func messageBox(_ messageBox: MessageBox, touchedButton: UIButton) {
        print(touchedButton.title(for: .normal)! + "touched")
    }
    
}
