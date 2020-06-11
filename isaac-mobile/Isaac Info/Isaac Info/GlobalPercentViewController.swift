//
//  GlobalPercentViewController.swift
//  Isaac Info
//
//  Created by Conner Calhoun on 4/18/16.
//  Copyright © 2016 Conner Calhoun. All rights reserved.
//

import UIKit

// Arrays that store the JSON Data
var names = [String]()
var percents = [Double]()
var nameArray = [String]()
var percentArray = [Double]()

class GlobalPercentViewController: UIViewController, UITableViewDataSource{

    // Reference outlet to the Table
    @IBOutlet weak var GlobalPercentTable: UITableView!
    let textCellIdentifier = "TextCell"
    
    // Code executes when the view is loaded
    // Basically will store the correct data into the correct arrays.
    override func viewDidLoad() {
        super.viewDidLoad()
        
        GlobalPercentTable.reloadData()
        
        // Adding the correct values to the names array
        if let myNames = NSUserDefaults.standardUserDefaults().arrayForKey("names"){
            nameArray = myNames as! [String]
        }
        
        // Adds the correct values to the percents array
        if let myPercents = NSUserDefaults.standardUserDefaults().arrayForKey("percents"){
            percentArray = myPercents as! [Double]
        }
        
    }
    
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // Another necessary tableview function. This one will populate the cells.
    // Populates the cells with the data from both arrays: nameArray, and percentArray
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        
        let myCell = tableView.dequeueReusableCellWithIdentifier("cell", forIndexPath: indexPath) as! CustomCell
        
        myCell.percentLabel.text = nameArray[indexPath.row] + ": " + String(format: "%.2f", percentArray[indexPath.row]) + "%"

        return myCell
    }
    
    // Sets the number of rows in the table to the number of achievements
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return nameArray.count
    }
    
    
   
// JSON Functions Below Here: These complex puppies execute all of the web calls.
    // No OKHTTP here.
    // Parse JSON to Dictionary--------------------------------------------------------------------------|
    // This function will take the JSON data pulled from the web, and convert it into a string.
    func JSONParseDict(jsonString:String) -> Dictionary<String, AnyObject> {
        
        if let data: NSData = jsonString.dataUsingEncoding(
            NSUTF8StringEncoding){
            
            do{
                if let jsonObj = try NSJSONSerialization.JSONObjectWithData(
                    data,
                    options: NSJSONReadingOptions(rawValue: 0)) as? Dictionary<String, AnyObject>{
                    return jsonObj
                }
            }catch{
                print("Error")
            }
        }
        return [String: AnyObject]()
    }
    //--------------------------------------------------------------------------------------------------------------|
    
    // HTTPsendRequest ---------------------------------------------------------------------------------------|
    // This will actually send out the request to the input URL, will see that down below
    func HTTPsendRequest(request: NSMutableURLRequest,callback: (String, String?) -> Void) {
        
        let task = NSURLSession.sharedSession().dataTaskWithRequest(request,completionHandler :
            {
                data, response, error in
                if error != nil {
                    callback("", (error!.localizedDescription) as String)
                } else {
                    callback(NSString(data: data!, encoding: NSUTF8StringEncoding) as! String,nil)
                }
        })
        
        task.resume() //Tasks are called with .resume()
    }
    //--------------------------------------------------------------------------------------------------------------|
    
    // Get JSON Data ------------------------------------------------------------------------------------------------------|
    // This will gather the JSON data from the URL. 
    // Implements previous functions
    func HTTPGetJSON(url: String, callback: (Dictionary<String, AnyObject>, String?) -> Void)
    {
        
        let request = NSMutableURLRequest(URL: NSURL(string: url)!)
        request.setValue("application/json", forHTTPHeaderField: "Accept")
        HTTPsendRequest(request) {
            (data: String, error: String?) -> Void in
            if error != nil {
                callback(Dictionary<String, AnyObject>(), error)
            } else {
                let jsonObj = self.JSONParseDict(data)
                callback(jsonObj, nil)
            }
        }
        
    }
    //--------------------------------------------------------------------------------------------------------------|
    
    
    // Perform JSON Action and store into Global Arrays
    // This took a while.
    func doJSONStuff(){
        HTTPGetJSON("http://api.steampowered.com/ISteamUserStats/GetGlobalAchievementPercentagesForApp/v0002/?gameid=250900&format=json")
        {
            (data: Dictionary<String, AnyObject>, error: String?) -> Void in
            if error != nil
            {
                print(error)
            } else
            {
                if let achievementpercentages = data["achievementpercentages"] as? NSDictionary ,let percentages = achievementpercentages["achievements"] as? NSArray
                {
                    for elem: AnyObject in percentages
                    {
                       
                        if let dict = elem as? NSDictionary ,let name = dict["name"] as? String , let percent = dict["percent"] as? Double
                        {
                            
                                names.append(name)
                                percents.append(percent)
                            
                        }
                        
                    }
                
                }
            
            }
            
        }
        
        // Setting the name&percent arrays equal each other.
        nameArray = names
        percentArray = percents
        
        // This printout is the location of the correct names array
        //print(names)
        // Trying the store names as a Default User Loadout thingy it WORKED I AM THE MASTER!!!!!!!!!!!!!
        NSUserDefaults.standardUserDefaults().setObject(nameArray, forKey: "names")
        //NSUserDefaults.standardUserDefaults().synchronize()
        // This printout is the location of the correct percents array
        //print(percents)
        NSUserDefaults.standardUserDefaults().setObject(percentArray, forKey: "percents")
        //NSUserDefaults.standardUserDefaults().synchronize()
        
    }
    
}
