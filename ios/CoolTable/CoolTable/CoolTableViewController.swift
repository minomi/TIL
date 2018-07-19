//
//  ViewController.swift
//  CoolTable
//
//  Created by 오민호 on 2017. 10. 1..
//  Copyright © 2017년 Minomi. All rights reserved.
//

import UIKit

class CoolTableViewController: UITableViewController {

    var thingsToLearn = [String]()
    var thingsLearned = [String]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        self.title = "Core Graphic 101"
        thingsToLearn = ["Drawing Rect","Drawing Arc","Drawing Gradient"]
        thingsLearned = ["swift"]
    }

    override func numberOfSections(in tableView: UITableView) -> Int {
        return 2
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return section == 0 ? self.thingsToLearn.count : self.thingsLearned.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cellId = "CoolCell"
        let cell = tableView.dequeueReusableCell(withIdentifier: cellId, for: indexPath)

        if let isKind = cell.backgroundView?.isKind(of: CustomCellBackground.self) {
            if !isKind {
                cell.backgroundView = CustomCellBackground()
            }
        }
        
        if let isKind = cell.selectedBackgroundView?.isKind(of: CustomCellBackground.self) {
            if !isKind {
                cell.selectedBackgroundView = CustomCellBackground()
            }
        }

        var entry = ""
        
        if indexPath.section == 0 {
            entry = self.thingsToLearn[indexPath.row]
        } else {
            entry = self.thingsLearned[indexPath.row]
        }
     
        cell.textLabel?.text = entry
        cell.textLabel?.backgroundColor = .clear
        
        return cell
        
    }
    
    override func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        return section == 0 ? "Things We'll Learn" : "Things Already Covered"
    }

}

