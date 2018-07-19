//
//  ViewController.swift
//  CustomControl
//
//  Created by 오민호 on 2017. 9. 11..
//  Copyright © 2017년 Minomi. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet var knobPlaceholder : UIView!
    @IBOutlet var slider : UISlider!
    @IBOutlet var button : UIButton!
    @IBOutlet var animateSwitch : UISwitch!
    @IBOutlet var valueLabel : UILabel!
    
    var knob : Knob!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        self.knob = Knob(frame: self.knobPlaceholder.bounds)
        knobPlaceholder.addSubview(knob)
        
        knob.lineWidth = 4.0
        knob.pointerLength = 12.0
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func didChangeSliderValue(_ sender : UISlider) {
        knob.value = sender.value
    }
    
    @IBAction func randomButtonTouched(button: UIButton) {
        let randomValue = Float(arc4random_uniform(101)) / 100.0
        knob.setValue(randomValue, animated: animateSwitch.isOn)
        slider.setValue(randomValue, animated: animateSwitch.isOn)
    }

}

