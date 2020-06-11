//
//  ViewController.swift
//  Isaac Info
//
//  Created by Conner Calhoun on 4/3/16.
//  Copyright © 2016 Conner Calhoun. All rights reserved.
//

import UIKit
import Foundation

class ViewController: UIViewController {

    // This controls the main menu. Not much here is worth noting. It does contain the 
    // Code that requests data from the web, however, it isn't used here.
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
      
    }
    
    
    //--------------------------------------------------------------------------------------------------------------|
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    //--------------------------------------------------------------------------------------------------------------|

    
    
    // HTTPsendRequest ---------------------------------------------------------------------------------------|
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
    
    
    
    // Request HTTP Data-------------------------------------------------------------------------------------------------------|
    func HTTPGet(url: String, callback: (String, String?) -> Void) {
        let request = NSMutableURLRequest(URL: NSURL(string: url)!) //To get the URL of the receiver , var URL: NSURL? is used
        HTTPsendRequest(request, callback: callback)
    }
    //--------------------------------------------------------------------------------------------------------------|
    
    
    
    // Parse JSON to Dictionary--------------------------------------------------------------------------|
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
    

    
    // Get JSON Data ------------------------------------------------------------------------------------------------------|
    func HTTPGetJSON(
        url: String,
        callback: (Dictionary<String, AnyObject>, String?) -> Void) {
        
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
    
    
}



