//
//  PageCell.swift
//  AutoLayout
//
//  Created by 오민호 on 2017. 11. 9..
//  Copyright © 2017년 오민호. All rights reserved.
//

import UIKit

class PageCell : UICollectionViewCell {
    
    var page : Page? {
        didSet {
            
            guard let unwrappedPage = page else {return}
            
            bearImageView.image = UIImage(named: unwrappedPage.imageName)
            
            let attributedText = NSMutableAttributedString(string: unwrappedPage.headerText,
                                                           attributes: [.font : UIFont.boldSystemFont(ofSize: 18)])
            
            let appendedText = NSAttributedString(string: "\n\n\n\(unwrappedPage.bodyText)",
                                                  attributes: [.font: UIFont.systemFont(ofSize: 13), .foregroundColor : UIColor.gray])
            attributedText.append(appendedText)

            descriptionTextView.attributedText = attributedText
        }
    }
    
    private let bearImageView : UIImageView = {
        let imageView = UIImageView(image: #imageLiteral(resourceName: "bear_first"))
        imageView.translatesAutoresizingMaskIntoConstraints = false
        imageView.contentMode = .scaleAspectFit
        return imageView
    }()
    
    private let descriptionTextView : UITextView = {
        let textView = UITextView()

        textView.textAlignment = .center
        textView.isEditable = false
        textView.isScrollEnabled = false
        return textView
        
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupLayout()
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
    }
    
    private func setupLayout() {
        
        let topImageContainerView = UIView()
        addSubview(topImageContainerView)
        addSubview(descriptionTextView)
        
        topImageContainerView.snp.makeConstraints { (maker) in
            maker.height.equalTo(self).multipliedBy(0.5)
            maker.top.equalTo(self)
            maker.leading.equalTo(self)
            maker.trailing.equalTo(self)
        }
        
        topImageContainerView.addSubview(bearImageView)
        
        bearImageView.snp.makeConstraints { (maker) in
            maker.center.equalTo(topImageContainerView)
            maker.height.equalTo(topImageContainerView).multipliedBy(0.5)
        }
        
        descriptionTextView.snp.makeConstraints { maker in
            maker.top.equalTo(topImageContainerView.snp.bottom)
            maker.leading.equalTo(self).offset(24)
            maker.trailing.equalTo(self).offset(-24)
            maker.bottom.equalTo(self)
        }
        
    }
    
}
