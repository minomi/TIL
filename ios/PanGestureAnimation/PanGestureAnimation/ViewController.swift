//
//  ViewController.swift
//  PanGestureAnimation
//
//  Created by 오민호 on 2017. 11. 13..
//  Copyright © 2017년 오민호. All rights reserved.
//

import UIKit

enum AnimationState {
    case fullScreen
    case thumbnail
}

class ViewController: UIViewController {

    @IBOutlet weak var darkView: UIView!
    @IBOutlet weak var photoView: UIImageView!
    
    var animator : UIViewPropertyAnimator?
    var currentState : AnimationState = .thumbnail
    var thumbnailFrame : CGRect!
    var panGestureRecognizer : UIPanGestureRecognizer!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        panGestureRecognizer = UIPanGestureRecognizer(target: self, action: #selector(ViewController.handle(_:)))
        photoView.addGestureRecognizer(panGestureRecognizer)
        thumbnailFrame = photoView.frame
        currentState = .thumbnail
        
        
    }

    @objc func handle(_ panGesture: UIPanGestureRecognizer) {
        
        let translation = panGesture.translation(in: view.superview)
        switch panGesture.state {
        case .began:
            startPanning()
        case .changed:
            scrub(translation: translation)
        case .ended:
            let velocity = panGesture.velocity(in: self.view.superview)
            endAnimation(translation : translation, velocity : velocity)
            
        default:
            print("default : \(translation)")
        }
    }
    
    func startPanning() {
        var finalFrame = CGRect()
        var darkViewAlpha : CGFloat = 0
        
        switch currentState {
            
        case .fullScreen:
            finalFrame = thumbnailFrame
            darkViewAlpha = 0
        case .thumbnail :
            finalFrame = view.frame
            darkViewAlpha = 1

        }
        
        print(finalFrame)
        animator = UIViewPropertyAnimator(duration: 1,
                                          dampingRatio: 0.8,
                                          animations: {
                                            self.photoView.frame = finalFrame
                                            self.darkView.alpha = darkViewAlpha
        })
        
    }
    
    func scrub(translation : CGPoint) {
        
        if let animator = self.animator {
            let yTranslation = translation.y + view.center.y
            
            var progress : CGFloat = 0
            
            switch currentState {
                
            case .fullScreen:
                progress = (yTranslation / view.center.y) - 1
                
            case .thumbnail :
                progress = 1 - (yTranslation / view.center.y)
            }
            
            progress = max(0.0001, min(0.9999, progress))
//            print(progress)
            animator.fractionComplete = progress
        }
        
    }
    
    func endAnimation(translation : CGPoint, velocity : CGPoint) {
        guard let animator = self.animator else {
            return
        }
        
        let screenHeight = view.frame.height
        self.panGestureRecognizer.isEnabled = false
        
        switch currentState {
            
        case .fullScreen:
            if translation.y >= (screenHeight) / 3 || velocity.y <= 100 {
                animator.isReversed = false
                animator.addCompletion({ _ in
                    self.currentState = .thumbnail
                    self.panGestureRecognizer.isEnabled = true
                })
            } else {
                animator.isReversed = true
                animator.addCompletion({ _ in
                    self.currentState = .fullScreen
                    self.panGestureRecognizer.isEnabled = true
                })
            }
        case .thumbnail :
            if translation.y <= (-screenHeight) / 3 || velocity.y <= -100 {
                animator.isReversed = false
                animator.addCompletion({ _ in
                    self.currentState = .fullScreen
                    self.panGestureRecognizer.isEnabled = true
                })
            } else {
                animator.isReversed = true
                animator.addCompletion({ _ in
                    self.currentState = .thumbnail
                    self.panGestureRecognizer.isEnabled = true
                })
            }
            
        }
        
        let vector = CGVector(dx: velocity.x / 100, dy: velocity.y / 100)
        let springParameters = UISpringTimingParameters(dampingRatio: 0.8, initialVelocity: vector)
        
        animator.continueAnimation(withTimingParameters: springParameters, durationFactor: 1)
        
        
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}

