//
//  FilckerPhotosViewController.swift
//  CollectionViewPractice
//
//  Created by 오민호 on 2017. 9. 18..
//  Copyright © 2017년 Minomi. All rights reserved.
//

import UIKit

class FilckerPhotosViewController: UICollectionViewController {

    fileprivate let reuseIdentifier = "FilckerCell"
    fileprivate let sectionInsets = UIEdgeInsets(top: 50, left: 20, bottom: 50, right: 20)
    
    fileprivate var searches = [FlickrSearchResults]()
    fileprivate let flicker = Flickr()
    
    fileprivate let itemsPerRow : CGFloat = 3
    
}

private extension FilckerPhotosViewController {
    
    func photoForIndexPath(indexPath : IndexPath) -> FlickrPhoto {
        return searches[indexPath.section].searchResults[indexPath.row]
    }
    
}

extension FilckerPhotosViewController {
    
    override func numberOfSections(in collectionView: UICollectionView) -> Int {
        return searches.count
    }
    
    override func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return searches[section].searchResults.count
    }
    
    override func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        
        switch kind {
        case UICollectionElementKindSectionHeader:
            let headerView = collectionView.dequeueReusableSupplementaryView(ofKind: kind,
                                                                             withReuseIdentifier: "FlickrPhotoHeaderView",
                                                                             for: indexPath) as! FlickrPhotoHeaderView
            
            headerView.title.text = searches[indexPath.section].searchTerm
            return headerView
        default:
            assert(false)
        }
        
    }
    
    
    override func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: reuseIdentifier, for: indexPath) as! FlickerPhotoCell
        
        let flickerPhoto = photoForIndexPath(indexPath: indexPath)
        cell.backgroundColor = .white
        
        cell.imageView.image = flickerPhoto.thumbnail
        
        return cell
        
    }
    
}

extension FilckerPhotosViewController : UICollectionViewDelegateFlowLayout {
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        
        let paddingSpace = sectionInsets.left * (itemsPerRow + 1)
        let availableWidth = view.frame.width - paddingSpace
        let widthPerItem = availableWidth / itemsPerRow
        
        return CGSize(width: widthPerItem, height: widthPerItem)
        
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, insetForSectionAt section: Int) -> UIEdgeInsets {
        return sectionInsets
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat {
        return sectionInsets.left
    }
    
}

extension FilckerPhotosViewController : UITextFieldDelegate {
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        
        let activityIndicator = UIActivityIndicatorView(activityIndicatorStyle: .gray)
        textField.addSubview(activityIndicator)
        activityIndicator.frame = textField.bounds
        activityIndicator.startAnimating()
        
        flicker.searchFlickrForTerm(textField.text!) { results, error in
            
            activityIndicator.stopAnimating()
            
            if let error = error {
                print("error 발생 : ", error)
                return
            }
            
            if let results = results {
                
                print("\(results.searchTerm)의 결과로 \(results.searchResults.count) 개의 검색결과" )
                
                self.searches.insert(results, at: 0)
                self.collectionView?.reloadData()
                
            }
            
        }
        
        textField.text = nil
        textField.resignFirstResponder()
        
        return true
        
    }
    
}

