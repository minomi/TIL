//
//  ViewController.swift
//  DrawingApp
//
//  Created by 오민호 on 2017. 11. 10..
//  Copyright © 2017년 오민호. All rights reserved.
//

import UIKit

class DrawingViewController: UIViewController {

    var drawingView : DrawingView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        drawingView = DrawingView(frame: self.view.frame)
        view.addSubview(drawingView)
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

