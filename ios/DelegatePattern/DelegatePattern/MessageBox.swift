//
//  MessageBox.swift
//  DelegatePattern
//
//  Created by 오민호 on 2017. 9. 30..
//  Copyright © 2017년 Minomi. All rights reserved.
//

import UIKit

@objc protocol MessageBoxDelegate : NSObjectProtocol {
    @objc optional func messageBox(_ messageBox : MessageBox, touchedButton : UIButton)
}

class MessageBox: UIView {

    weak var deleage : MessageBoxDelegate?
    
    var messageLabel : UILabel?
    var oKButton: UIButton?
    var cancelButton: UIButton?
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        setMessageBox()
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        
        setMessageBox()
    }
    
    private func setMessageBox() {
        
        self.messageLabel = {
            
            let label = UILabel(frame: CGRect(x: 0, y: 0, width: self.bounds.width, height: self.bounds.height * 0.5))
            label.text = "Simple Message"
            label.textAlignment = .center
            self.addSubview(label)
            return label
            
        }()
        
        self.oKButton = {
            
            let button = UIButton(type : .system)
            button.setTitle("OK", for: .normal)
            button.frame = CGRect(x: self.bounds.width * 0.5,
                                  y: self.bounds.height * 0.5,
                                  width: self.bounds.width * 0.5,
                                  height: self.bounds.height * 0.5)
            button.addTarget(self, action: #selector(touchUpButton(_:)), for: .touchUpInside)
            self.addSubview(button)
            
            return button
            
        }()
        
        self.cancelButton = {
            
            let button = UIButton(type : .system)
            button.setTitle("Cancel", for: .normal)
            button.frame = CGRect(x: 0,
                                  y: self.bounds.height * 0.5,
                                  width: self.bounds.width * 0.5,
                                  height: self.bounds.height * 0.5)
            button.addTarget(self, action: #selector(touchUpButton(_:)), for: .touchUpInside)
            self.addSubview(button)
            
            return button
            
        }()
        
    }

    @objc private func touchUpButton(_ button : UIButton) {
        self.deleage?.messageBox!(self, touchedButton: button)
    }
}
