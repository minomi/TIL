//
//  PresentedViewController.swift
//  CircularTransition
//
//  Created by 오민호 on 2017. 11. 10..
//  Copyright © 2017년 오민호. All rights reserved.
//

import UIKit
import SnapKit

class PresentedViewController: UIViewController , UIViewControllerTransitioningDelegate {

    let imageView : UIImageView = {
        let imageView = UIImageView()
        imageView.contentMode = .scaleAspectFit
        imageView.image = #imageLiteral(resourceName: "bg")
        return imageView
    }()
    
    let presentButton : UIButton = {
        let button = UIButton(frame: .zero)
        button.setTitle("M", for: .normal)
        button.setTitleColor(.white, for: .normal)
        button.titleLabel?.font = UIFont.boldSystemFont(ofSize: 17)
        button.addTarget(self, action: #selector(touchUpPresentButton(_:)), for: .touchUpInside)
        button.backgroundColor = .red
        
        return button
    }()
    
    let transition = CircularTransition()
    
    @objc private func touchUpPresentButton(_ button : UIButton) {
        let presentingVC = PresentingViewController()
        
        presentingVC.transitioningDelegate = self
        presentingVC.modalPresentationStyle = .custom
        
        present(presentingVC, animated: true)
    }
    
    func animationController(forPresented presented: UIViewController, presenting: UIViewController, source: UIViewController) -> UIViewControllerAnimatedTransitioning? {
        
        transition.startingPoint = presentButton.center
        transition.circleColor = presentButton.backgroundColor!
        transition.transitionMode = .present
        return transition
        
    }
    
    func animationController(forDismissed dismissed: UIViewController) -> UIViewControllerAnimatedTransitioning? {
        
        transition.transitionMode = .dismiss
        transition.startingPoint = presentButton.center
        transition.circleColor = presentButton.backgroundColor!
        return transition
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        view.addSubview(presentButton)
        view.addSubview(imageView)
        setLayout()
        
    }
    
    override func viewDidLayoutSubviews() {
        super.viewDidLayoutSubviews()
        print(#function)
        setButtonLayer()
    }

    func setButtonLayer() {
        presentButton.layer.cornerRadius = presentButton.bounds.size.width / 2
    }
    
    func setLayout() {
        imageView.snp.makeConstraints { (constraintMaker) in
            constraintMaker.edges.equalTo(view)
        }
        
        presentButton.snp.makeConstraints { (constraintMaker) in
            
            constraintMaker.centerX.equalTo(view)
            constraintMaker.top.equalTo(view.safeAreaLayoutGuide.snp.top).offset(100)
            constraintMaker.size.equalTo(CGSize(width: 40, height: 40))
            
        }
    }

}
