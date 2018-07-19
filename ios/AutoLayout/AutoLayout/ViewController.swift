//
//  ViewController.swift
//  AutoLayout
//
//  Created by 오민호 on 2017. 11. 9..
//  Copyright © 2017년 오민호. All rights reserved.
//

import UIKit
import SnapKit

extension UIColor {
    static var mainPink = UIColor(red: 232/255, green: 68/255, blue: 133/255, alpha: 1)
}

class ViewController: UIViewController {

    let bearImageView : UIImageView = {
        let imageView = UIImageView(image: #imageLiteral(resourceName: "bear_first"))
        imageView.translatesAutoresizingMaskIntoConstraints = false
        imageView.contentMode = .scaleAspectFit
        return imageView
    }()
    
    let descriptionTextView : UITextView = {
        let textView = UITextView()
        
        let attributedText = NSMutableAttributedString(string: "Join us today  in our fun and games!",
                                                       attributes: [.font : UIFont.boldSystemFont(ofSize: 18)])
        let appendedText = NSAttributedString(string: "\n\n\nAre tou ready for loads and loads of fun? Don't wait any longer! We hope to see you in out stores soon.",
                                              attributes: [.font: UIFont.systemFont(ofSize: 13), .foregroundColor : UIColor.gray])
        
        attributedText.append(appendedText)
        textView.attributedText = attributedText
        textView.textAlignment = .center
        textView.isEditable = false
        textView.isScrollEnabled = false
        return textView
    }()
    
    private let previousButton : UIButton = {
        let button = UIButton(type: .system)
        button.setTitle("Prev", for: .normal)
        button.titleLabel?.font = UIFont.boldSystemFont(ofSize: 14)
        button.setTitleColor(.gray, for: .normal)
        return button
    }()
    
    private let nextButton : UIButton = {
        let button = UIButton(type: .system)
        
        button.setTitleColor(.mainPink, for: .normal)
        button.setTitle("next", for: .normal)
        button.titleLabel?.font = UIFont.boldSystemFont(ofSize: 14)
        return button
    }()
    
    private let pageControl : UIPageControl = {
        let pc = UIPageControl()
        pc.currentPage = 0
        pc.numberOfPages = 4
        
        pc.currentPageIndicatorTintColor = .mainPink
        pc.pageIndicatorTintColor = UIColor(red: 249/255, green: 207/255, blue: 224/255, alpha: 1)
        return pc
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        view.addSubview(descriptionTextView)
    
        setupBottomControls()
        setupLayout()
        
    }
    
    fileprivate func setupBottomControls() {
        
        let bottomControlsStackView = UIStackView(arrangedSubviews: [previousButton, pageControl, nextButton])
        
        bottomControlsStackView.translatesAutoresizingMaskIntoConstraints = false
        bottomControlsStackView.distribution = .fillEqually
        
        
        view.addSubview(bottomControlsStackView)
        
        bottomControlsStackView.snp.makeConstraints { (maker) in

            maker.bottom.equalTo(view.safeAreaLayoutGuide)
            maker.leading.equalTo(view.safeAreaLayoutGuide)
            maker.trailing.equalTo(view.safeAreaLayoutGuide)
            maker.height.equalTo(50)

        }
    }
    
    private func setupLayout() {
        
        let topImageContainerView = UIView()
        view.addSubview(topImageContainerView)
        
        topImageContainerView.snp.makeConstraints { (maker) in
            maker.height.equalTo(view).multipliedBy(0.5)
            maker.top.equalTo(view)
            maker.leading.equalTo(view)
            maker.trailing.equalTo(view)
        }
        
        topImageContainerView.addSubview(bearImageView)
        
        bearImageView.snp.makeConstraints { (maker) in
            maker.center.equalTo(topImageContainerView)
            maker.height.equalTo(topImageContainerView).multipliedBy(0.5)
        }
        
        descriptionTextView.snp.makeConstraints { maker in
            maker.top.equalTo(topImageContainerView.snp.bottom)
            maker.leading.equalTo(view).offset(24)
            maker.trailing.equalTo(view).offset(-24)
            maker.bottom.equalTo(view)
        }
        
    }

}

