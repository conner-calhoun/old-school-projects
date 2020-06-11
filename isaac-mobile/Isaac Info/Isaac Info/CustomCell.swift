//
//  CustomCell.swift
//  Isaac Info
//
//  Created by Conner Calhoun on 4/26/16.
//  Copyright © 2016 Conner Calhoun. All rights reserved.
//

import UIKit

class CustomCell: UITableViewCell {

    @IBOutlet var seedLabel: UILabel!
    @IBOutlet var percentLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
