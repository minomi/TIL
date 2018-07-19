//
//  ViewController.swift
//  CircularTransition
//
//  Created by 오민호 on 2017. 11. 10..
//  Copyright © 2017년 오민호. All rights reserved.
//

import UIKit
import SnapKit

class PresentingViewController: UIViewController {
    
    let presentButton : UIButton = {
        let button = UIButton(frame: .zero)
        button.setTitle("M", for: .normal)
        button.setTitleColor(.red, for: .normal)
        button.titleLabel?.font = UIFont.boldSystemFont(ofSize: 17)
        button.addTarget(self, action: #selector(touchUpDismissButton(_:)), for: .touchUpInside)
        button.backgroundColor = .white
        return button
    }()
    
    @objc private func touchUpDismissButton(_ button : UIButton) {
        self.dismiss(animated: true, completion: nil)
    }

    override func viewDidLayoutSubviews() {
        super.viewDidLayoutSubviews()
        print(#function)
        setButtonLayer()
    }
    
    func setButtonLayer() {
        presentButton.layer.cornerRadius = presentButton.bounds.size.width / 2
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        view.backgroundColor = .red
        view.addSubview(presentButton)
        presentButton.snp.makeConstraints { (constraintMaker) in
            
            constraintMaker.centerX.equalTo(view)
            constraintMaker.top.equalTo(view.safeAreaLayoutGuide.snp.top).offset(100)
            constraintMaker.size.equalTo(CGSize(width: 40, height: 40))
            
        }
    }
    
    


}

