//
//  GraphView.swift
//  Flo
//
//  Created by 오민호 on 2017. 9. 6..
//  Copyright © 2017년 Minomi. All rights reserved.
//

import UIKit

private struct Constants {
    
    static let cornerRadiusSize = CGSize(width: 8.0, height: 8.0)
    static let margin : CGFloat = 20.0
    static let topBorder : CGFloat = 60
    static let bottomBorder : CGFloat = 50
    static let colorAlpha : CGFloat = 0.3
    static let circleDiameter : CGFloat = 5.0
    
}

@IBDesignable class GraphView: UIView {
    
    @IBInspectable var startColor : UIColor = .orange
    @IBInspectable var endColor : UIColor = .green

    var graphPoints = [4, 2, 6, 4, 5, 8, 3]
    
    // Only override draw() if you perform custom drawing.
    // An empty implementation adversely affects performance during animation.
    override func draw(_ rect: CGRect) {
        let path = UIBezierPath(roundedRect: rect,
                                byRoundingCorners: .allCorners,
                                cornerRadii: Constants.cornerRadiusSize)
        path.addClip()
        
        let width = rect.width
        let height = rect.height
        
        let margin = Constants.margin
        let graphWidth = width - 2 * margin - 4
        
        let columnXPoint = { (column : Int) -> CGFloat in
            let spacing = graphWidth / CGFloat(self.graphPoints.count - 1)
            return spacing * CGFloat(column) + margin + 2
        }
        
        let topBorder = Constants.topBorder
        let bottomBorder = Constants.bottomBorder
        
        let graphHeight = height - topBorder - bottomBorder
        let maxValue = graphPoints.max() ?? 0
        let columnYPoint = { (column : Int) -> CGFloat in
            let y = CGFloat(column) / CGFloat(self.graphPoints.count) * graphHeight
            return graphHeight + Constants.topBorder - y
        }
        
        
        let context = UIGraphicsGetCurrentContext()
        let colors  = [startColor.cgColor, endColor.cgColor]
        
        let colorSpace = CGColorSpaceCreateDeviceRGB()
        let colorLocations : [CGFloat] = [0, 1]
        
        let gradient = CGGradient(colorsSpace: colorSpace,
                                  colors: colors as CFArray,
                                  locations: colorLocations)
        
        let startPoint = CGPoint.zero
        let endPoint = CGPoint(x: 0, y: bounds.height)
        
        context?.drawLinearGradient(gradient!,
                                    start: startPoint,
                                    end: endPoint, options: [.drawsBeforeStartLocation])
        
        UIColor.white.setFill()
        UIColor.white.setStroke()
        
        let graphPath = UIBezierPath()
        graphPath.move(to: CGPoint(x: columnXPoint(0), y: columnYPoint(graphPoints[0])))
        
        for i in 1..<graphPoints.count {
            let nextPoint = CGPoint(x: columnXPoint(i), y: columnYPoint(graphPoints[i]))
            graphPath.addLine(to: nextPoint)
        }
        
        
        //Create the clipping path for the graph gradient
        
        //1 - save the state of the context (commented out for now)
        context?.saveGState()
        
        //2 - make a copy of the path
        let clippingPath = graphPath.copy() as! UIBezierPath
        
        //3 - add lines to the copied path to complete the clip area
        clippingPath.addLine(to: CGPoint(x: columnXPoint(graphPoints.count - 1), y:height))
        clippingPath.addLine(to: CGPoint(x:columnXPoint(0), y:height))
        clippingPath.close()
        
        //4 - add the clipping path to the context
        clippingPath.addClip()
        
        let highestYPoint = columnYPoint(maxValue)
        let graphStartPoint = CGPoint(x: margin, y: highestYPoint)
        let graphEndPoint = CGPoint(x: margin, y: bounds.height)
        
        context?.drawLinearGradient(gradient!,
                                    start: graphStartPoint,
                                    end: graphEndPoint,
                                    options: [])
        context?.restoreGState()
        
        graphPath.lineWidth = 2.0
        graphPath.stroke()
        
        for i in 0..<graphPoints.count {
            var point = CGPoint(x: columnXPoint(i), y: columnYPoint(graphPoints[i]))
            point.x -= Constants.circleDiameter / 2
            point.y -= Constants.circleDiameter / 2
            
            let circle = UIBezierPath(ovalIn: CGRect(origin: point,
                                                     size: CGSize(width: Constants.circleDiameter,
                                                                  height: Constants.circleDiameter)))
            circle.fill()
        }
        
        //Draw horizontal graph lines on the top of everything
        let linePath = UIBezierPath()
        
        //top line
        linePath.move(to: CGPoint(x: margin, y: topBorder))
        linePath.addLine(to: CGPoint(x: width - margin, y: topBorder))
        
        //center line
        linePath.move(to: CGPoint(x: margin, y: graphHeight/2 + topBorder))
        linePath.addLine(to: CGPoint(x: width - margin, y: graphHeight/2 + topBorder))
        
        //bottom line
        linePath.move(to: CGPoint(x: margin, y:height - bottomBorder))
        linePath.addLine(to: CGPoint(x:  width - margin, y: height - bottomBorder))
        let color = UIColor(white: 1.0, alpha: Constants.colorAlpha)
        color.setStroke()
        
        linePath.lineWidth = 1.0
        linePath.stroke()
        
    }
    
    
    

}
