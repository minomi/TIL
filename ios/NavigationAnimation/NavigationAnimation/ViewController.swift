//
//  ViewController.swift
//  NavigationAnimation
//
//  Created by 오민호 on 2017. 12. 26..
//  Copyright © 2017년 오민호. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    let label : UILabel = {
        let label = UILabel()
        label.text = "root viewcontroller"
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 30)
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    let buttonContainer : UIStackView = {
        let button1 = UIButton()
        button1.backgroundColor = .black
        let button2 = UIButton()
        button2.backgroundColor = .red
        let button3 = UIButton()
        button3.backgroundColor = .gray
        
        button1.addTarget(self, action: #selector(touchUpButton1(_ :)) , for: .touchUpInside)
        button2.addTarget(self, action: #selector(touchUpButton2(_ :)) , for: .touchUpInside)
        button3.addTarget(self, action: #selector(touchUpButton3(_ :)) , for: .touchUpInside)
        
        let stackView = UIStackView(arrangedSubviews: [button1, button2, button3])
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.axis = .horizontal
        stackView.distribution = .fillEqually
        return stackView
        
    }()
    
    let contentView : UIView = {
        let view = UIView()
        view.translatesAutoresizingMaskIntoConstraints = false
        view.backgroundColor = .orange
        return view
    }()

    override func viewDidLoad() {
        super.viewDidLoad()
        self.view.backgroundColor = .white
        // Do any additional setup after loading the view, typically from a nib.
        self.view.addSubview(label)
        self.view.addSubview(buttonContainer)
        self.view.addSubview(contentView)
        
        label.topAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.topAnchor).isActive = true
        label.centerXAnchor.constraint(equalTo: self.view.centerXAnchor).isActive = true
        
        buttonContainer.topAnchor.constraint(equalTo: self.label.bottomAnchor).isActive = true
        buttonContainer.widthAnchor.constraint(equalTo: self.view.widthAnchor, multiplier: 1).isActive = true
        buttonContainer.heightAnchor.constraint(equalToConstant: 80).isActive = true
        
        contentView.topAnchor.constraint(equalTo: buttonContainer.bottomAnchor).isActive = true
        contentView.bottomAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.bottomAnchor).isActive = true
        contentView.leadingAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.leadingAnchor).isActive = true
        contentView.trailingAnchor.constraint(equalTo: self.view.safeAreaLayoutGuide.trailingAnchor).isActive = true
        
        self.navigationItem.rightBarButtonItem = UIBarButtonItem(title: "Push",
                                                                 style: .plain,
                                                                 target: self,
                                                                 action: #selector(touchUpRightBarButton(_ :)))
        
    }
    
    @objc func touchUpButton1(_ sender : UIButton) {
        print(#function)
    }
    @objc func touchUpButton2(_ sender : UIButton) {
        print(#function)
    }
    @objc func touchUpButton3(_ sender : UIButton) {
        print(#function)
    }
    @objc func touchUpRightBarButton(_ sender : UIBarButtonItem) {
        let transition = CATransition()
        transition.duration = 0.5
        transition.timingFunction = CAMediaTimingFunction(name: kCAMediaTimingFunctionEaseInEaseOut)
        transition.type = kCATransitionFade
        self.navigationController?.view.layer.add(transition, forKey: nil)
        
        let pushedViewController = PushedViewController()
        self.navigationController?.pushViewController(pushedViewController, animated: true)
    }
}

