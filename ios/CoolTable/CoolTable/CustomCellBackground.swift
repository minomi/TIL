//
//  CustomCellBackground.swift
//  CoolTable
//
//  Created by 오민호 on 2017. 10. 1..
//  Copyright © 2017년 Minomi. All rights reserved.
//

import UIKit

class CustomCellBackground: UIView {

    
    // Only override draw() if you perform custom drawing.
    // An empty implementation adversely affects performance during animation.
    override func draw(_ rect: CGRect) {
        // Drawing code
        let context = UIGraphicsGetCurrentContext()
        let redColor = UIColor.red.cgColor
        let blueColor = UIColor.blue.cgColor
        
        drawLinearGradient(context: context!, rect: self.bounds, start: redColor, end: blueColor)
        
        let strokeRect = self.bounds.insetBy(dx: 5, dy: 5)
        context?.setStrokeColor(UIColor.black.cgColor)
        context?.setLineWidth(1)
        context?.stroke(strokeRect)
    }
 

}
