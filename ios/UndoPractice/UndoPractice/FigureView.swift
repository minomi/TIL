//
//  FigureView.swift
//  UndoPractice
//
//  Created by 오민호 on 2017. 8. 12..
//  Copyright © 2017년 BoostCamp. All rights reserved.
//

import UIKit

class FigureView : UIView {
    
    var changeRecorder = Dictionary<String, AnyObject>()
    
    override init(frame: CGRect) {
        
        super.init(frame: frame)
        self.undoManager?.groupsByEvent = false
        
        let defaultColor = UIColor(white: 0.7, alpha: 1)
        self.backgroundColor = defaultColor
        self.layer.borderColor = defaultColor.cgColor
        self.layer.borderWidth = 1.0
        
    }
    
    var cornerRadius : NSNumber {
        
        set {
            self.layer.cornerRadius = CGFloat(newValue.floatValue)
        }
        
        get {
            return NSNumber(value : Float(self.layer.cornerRadius))
        }
        
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override var canBecomeFirstResponder: Bool {
        return true
    }
}
