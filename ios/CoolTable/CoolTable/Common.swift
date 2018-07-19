//
//  Common.swift
//  CoolTable
//
//  Created by 오민호 on 2017. 10. 1..
//  Copyright © 2017년 Minomi. All rights reserved.
//

import CoreGraphics

func drawLinearGradient(context : CGContext, rect : CGRect, start : CGColor, end : CGColor) {
    
    let colorSpace = CGColorSpaceCreateDeviceRGB()
    let location : [CGFloat] = [0, 1]
    
    let colors = [start, end] as CFArray
    let gradient = CGGradient(colorsSpace: colorSpace, colors: colors, locations: location)
    
    let startPoint = CGPoint(x: rect.midX, y: rect.minY)
    let endPoint = CGPoint(x: rect.midX, y: rect.maxY)
    
    context.saveGState()
    context.addRect(rect)
    context.clip()
    context.drawLinearGradient(gradient!, start: startPoint, end: endPoint, options: .drawsBeforeStartLocation)
    context.restoreGState()
    
}

