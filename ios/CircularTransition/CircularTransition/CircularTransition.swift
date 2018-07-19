//
//  CircularTransition.swift
//  CircularTransition
//
//  Created by 오민호 on 2017. 11. 10..
//  Copyright © 2017년 오민호. All rights reserved.
//

import UIKit

class CircularTransition: NSObject {
    var circle = UIView()
    
    var startingPoint :CGPoint = .zero {
        didSet {
            circle.center = startingPoint
        }
    }
    
    var circleColor : UIColor = .white
    let duration = 0.3
    
    enum CircularTransitionMode {
        case present, dismiss
    }
    
    var transitionMode : CircularTransitionMode = .present
    
}

extension CircularTransition : UIViewControllerAnimatedTransitioning {
    func transitionDuration(using transitionContext: UIViewControllerContextTransitioning?) -> TimeInterval {
        return duration
    }
    
    func animateTransition(using transitionContext: UIViewControllerContextTransitioning) {
        let containerView = transitionContext.containerView
        
        if transitionMode == .present {
            
            if let presentedView = transitionContext.view(forKey: UITransitionContextViewKey.to) {
                let viewCenter = presentedView.center
                let viewSize = presentedView.frame.size
                
                let shrinkTransform = CGAffineTransform(scaleX: 0.001, y: 0.001)
                let originTransform = CGAffineTransform.identity
                
                circle = UIView()
                circle.frame = frameForCircle(with: viewCenter, size: viewSize, startPoint: startingPoint)
                circle.layer.cornerRadius = circle.frame.size.height / 2
                circle.backgroundColor = circleColor
                circle.transform = shrinkTransform
                circle.center = startingPoint
                
                presentedView.alpha = 0
                presentedView.transform = shrinkTransform
                presentedView.center = startingPoint
                
                containerView.addSubview(circle)
                containerView.addSubview(presentedView)
                
                UIView.animate(withDuration: duration,
                               animations: { [weak self] in
                                
                                self?.circle.transform = originTransform
                                presentedView.transform = originTransform
                                
                                presentedView.alpha = 1
                                presentedView.center = viewCenter
                                
                    }, completion: { (success : Bool) in
                        transitionContext.completeTransition(success)
                })
                
            }
            
        } else {
            
            if let returningView = transitionContext.view(forKey: UITransitionContextViewKey.from) {
                
                let viewCenter = returningView.center
                let viewSize = returningView.frame.size
                
                let shrinkTransform = CGAffineTransform(scaleX: 0.001, y: 0.001)
                
                circle.frame = frameForCircle(with: viewCenter, size: viewSize, startPoint: startingPoint)
                circle.layer.cornerRadius = circle.frame.size.height / 2
                circle.center = startingPoint
                
                UIView.animate(withDuration: duration,
                               animations: { [weak self] in
                                
                                self?.circle.transform = shrinkTransform
                                returningView.transform = shrinkTransform
                                returningView.center = (self?.startingPoint)!
                                returningView.alpha = 0
                                
                }, completion: { (success : Bool) in
                    self.circle.removeFromSuperview()
                    returningView.removeFromSuperview()
                    transitionContext.completeTransition(success)
                })
            }
            
            
        }
        
        
    }
    
    func frameForCircle(with viewCenter : CGPoint, size viewSize : CGSize, startPoint : CGPoint) -> CGRect {
        let xLength = fmax(startPoint.x, viewSize.width - startPoint.x)
        let yLength = fmax(startPoint.y, viewSize.height - startPoint.y)
        
        let radius = sqrt(xLength * xLength + yLength * yLength) * 2
        let size = CGSize(width: radius, height: radius)
        
        return CGRect(origin: .zero, size: size)
    }
}
