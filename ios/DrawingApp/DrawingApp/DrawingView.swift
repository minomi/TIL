//
//  DrawingView.swift
//  DrawingApp
//
//  Created by 오민호 on 2017. 11. 10..
//  Copyright © 2017년 오민호. All rights reserved.
//

import UIKit

class DrawingView : UIView {
    
    var drawColor : UIColor = .white
    var lineWidth : CGFloat = 5
    
    private var lastPoint : CGPoint!
    private var bezierPath : UIBezierPath!
    private var pointCounter = 0
    private let pointLimit = 128
    private var preRenderImage : UIImage!
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setBezierPath()
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        setBezierPath()
    }
    
    override func draw(_ rect: CGRect) {
        super.draw(rect)
        
        if let preRenderImage = self.preRenderImage {
            preRenderImage.draw(in: self.bounds)
        }
        
        bezierPath.lineWidth = lineWidth
        drawColor.setFill()
        drawColor.setStroke()
        bezierPath.stroke()
        
        preRenderImage = UIGraphicsGetImageFromCurrentImageContext()
        
    }
    
    func setBezierPath() {
        bezierPath = UIBezierPath()
        bezierPath.lineCapStyle = .round
        bezierPath.lineJoinStyle = .round
    }
    
    func renderToImage() {
        UIGraphicsBeginImageContextWithOptions(bounds.size, false, 0.0)
        
        if let preRenderImage = self.preRenderImage {
             preRenderImage.draw(in: self.bounds)
        }
        
        bezierPath.lineWidth = lineWidth
        drawColor.setFill()
        drawColor.setStroke()
        bezierPath.stroke()
        
        preRenderImage = UIGraphicsGetImageFromCurrentImageContext()
        UIGraphicsEndImageContext()
        
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        guard let touch = touches.first else {return}
        lastPoint = touch.location(in: self)
        pointCounter = 0
    }
    
    override func touchesMoved(_ touches: Set<UITouch>, with event: UIEvent?) {
        guard let touch = touches.first else {return}
        let newPoint = touch.location(in: self)
        
        bezierPath.move(to: lastPoint)
        bezierPath.addLine(to: newPoint)
        lastPoint = newPoint
        
        pointCounter += 1
        
        setNeedsDisplay()
        
    }
    
    override func touchesEnded(_ touches: Set<UITouch>, with event: UIEvent?) {
        pointCounter = 0
        renderToImage()
        setNeedsDisplay()
        bezierPath.removeAllPoints()
    }
    
    override func touchesCancelled(_ touches: Set<UITouch>, with event: UIEvent?) {
        touchesEnded(touches, with: event)
    }
    
    func clear() {
        preRenderImage = nil
        bezierPath.removeAllPoints()
        setNeedsDisplay()
    }
    
    func hasLines() -> Bool {
        return preRenderImage != nil || !bezierPath.isEmpty
    }
    
}
