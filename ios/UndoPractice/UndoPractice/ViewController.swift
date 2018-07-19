//
//  ViewController.swift
//  UndoPractice
//
//  Created by 오민호 on 2017. 8. 12..
//  Copyright © 2017년 BoostCamp. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var undoButton: UIButton!
    @IBOutlet weak var redoButton: UIButton!
    
    var figureViews = [FigureView]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        NotificationCenter.default.addObserver(self, selector: <#T##Selector#>, name: <#T##NSNotification.Name?#>, object: <#T##Any?#>)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func touchUpAddRectangle(_ sender: Any) {
        
    }

}

