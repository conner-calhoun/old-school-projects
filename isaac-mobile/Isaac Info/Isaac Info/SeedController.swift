//
//  SeedController.swift
//  Isaac Info
//
//  Created by Conner Calhoun on 4/18/16.
//  Copyright © 2016 Conner Calhoun. All rights reserved.
//

import UIKit

class SeedController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    // These are reference outlets that allow you to use the
    // interactable things in the view such as the TextField, and the 
    // Table view
    @IBOutlet weak var AddSeedTextField: UITextField!
    @IBOutlet weak var seedTableView: UITableView!
    
    // Array that will hold the input seeds
    var seeds = [String]()
    
    // Code that is executed every time the view is loaded.
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Pulls the persisten data from NSUserDefaults, and stores is back into the seeds array.
        if let mySeed = NSUserDefaults.standardUserDefaults().arrayForKey("mySeed"){
        
            seeds = mySeed as! [String]
            
        }
    
    }

    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    

    }
    
    // This is basically the click listener for the button.
    
    @IBAction func addItem(sender: AnyObject) {
        
        // Validate text, put text in array, clear the text field!
        if AddSeedTextField.text?.characters.count == 8{
            
            seeds.insert(AddSeedTextField.text!, atIndex: 0)
            AddSeedTextField.text = ""
            self.view.endEditing(true)
            //print(seeds)
            
            seedTableView.reloadData()
            
        }
        else {
            AddSeedTextField.text = "Bad Seed"
            self.view.endEditing(true)
        }
        
        // Stores the seeds array into NSUserDefaults with a keyname "mySeed"
        NSUserDefaults.standardUserDefaults().setObject(seeds, forKey: "mySeed")
        NSUserDefaults.standardUserDefaults().synchronize()
        
    }
    
    // This function updates the table view with the Seeds Array
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
       
        let myCell = tableView.dequeueReusableCellWithIdentifier("cell", forIndexPath: indexPath) as! CustomCell
        myCell.seedLabel.text = seeds[indexPath.row]
        
        NSUserDefaults.standardUserDefaults().setObject(seeds, forKey: "mySeed")
        NSUserDefaults.standardUserDefaults().synchronize()
        
        return myCell
    }
    
    // Sets the number of rows in the table equal to the number of Seeds in the array.
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return seeds.count
    }
    
    // Allows the user to delete the seeds at will by sliding to the left.
    func tableView(tableView: UITableView, commitEditingStyle editingStyle: UITableViewCellEditingStyle, forRowAtIndexPath indexPath: NSIndexPath) {
        
        if editingStyle == UITableViewCellEditingStyle.Delete
        {
            seeds.removeAtIndex(indexPath.row)
            
            seedTableView.reloadData()
        }
    }
    
    
}

