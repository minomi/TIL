//
//  SwipingController.swift
//  AutoLayout
//
//  Created by 오민호 on 2017. 11. 9..
//  Copyright © 2017년 오민호. All rights reserved.
//

import UIKit

class SwipingController : UICollectionViewController {
    
    let pages = [
        Page(imageName : "bear_first",
             headerText: "Join us today  in our fun and games!",
             bodyText: "Are you ready for loads and loads of fun? Don't wait any longer! We hope to see you in our stores soon."),
        
        Page(imageName : "heart_second",
             headerText: "Subscribe and get coupons on our daily events",
             bodyText: "Get notified of the savings immediately when we announce them on our website. Make sure to also give us any feedback you have."),
        
        Page(imageName : "leaf_third",
             headerText: "VIP memebers special services",
             bodyText: "")
    ]
    
    private let previousButton : UIButton = {
        let button = UIButton(type: .system)
        button.setTitle("Prev", for: .normal)
        button.titleLabel?.font = UIFont.boldSystemFont(ofSize: 14)
        button.setTitleColor(.gray, for: .normal)
        button.addTarget(self, action: #selector(touchUpPrev), for: .touchUpInside)
        return button
    }()
    
    @objc private func touchUpPrev() {
        let prevIndex = max(pageControl.currentPage - 1, 0)
        let indexPath = IndexPath(item: prevIndex, section: 0)
        pageControl.currentPage = prevIndex
        collectionView?.scrollToItem(at: indexPath, at: .centeredHorizontally, animated: true)
    }
    
    private let nextButton : UIButton = {
        let button = UIButton(type: .system)
        
        button.setTitleColor(.mainPink, for: .normal)
        button.setTitle("next", for: .normal)
        button.titleLabel?.font = UIFont.boldSystemFont(ofSize: 14)
        button.addTarget(self, action: #selector(touchUpNext), for: .touchUpInside)
        return button
        
    }()
    
    @objc private func touchUpNext() {
        let nextIndex = min(pageControl.currentPage + 1, pages.count - 1)
        let indexPath = IndexPath(item: nextIndex, section: 0)
        pageControl.currentPage = nextIndex
        collectionView?.scrollToItem(at: indexPath, at: .centeredHorizontally, animated: true)
    }
    
    private lazy var pageControl : UIPageControl = {
        let pc = UIPageControl()
        pc.currentPage = 0
        pc.numberOfPages = pages.count
        
        pc.currentPageIndicatorTintColor = .mainPink
        pc.pageIndicatorTintColor = UIColor(red: 249/255, green: 207/255, blue: 224/255, alpha: 1)
        return pc
    }()
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        setupBottomControls()
        
        collectionView?.backgroundColor = .white
        collectionView?.register(PageCell.self, forCellWithReuseIdentifier: "cellId")
        collectionView?.isPagingEnabled = true
        
    }

    override func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return pages.count
    }
    
    override func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "cellId", for: indexPath) as! PageCell
        
        let page = pages[indexPath.item]
        cell.page = page

        return cell
        
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
    
    override func scrollViewWillEndDragging(_ scrollView: UIScrollView, withVelocity velocity: CGPoint, targetContentOffset: UnsafeMutablePointer<CGPoint>) {
        let x = targetContentOffset.pointee.x
        print(x)
        
        pageControl.currentPage = Int(x / view.frame.width)
    }
    
}

extension SwipingController : UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: view.frame.width, height : view.frame.height)
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat {
        return 0
    }
}






