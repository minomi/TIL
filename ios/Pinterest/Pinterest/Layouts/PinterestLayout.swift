//
//  PinterestLayout.swift
//  Pinterest
//
//  Created by 오민호 on 2017. 11. 15..
//  Copyright © 2017년 Razeware LLC. All rights reserved.
//


import UIKit

protocol PinterestLayoutDelegate: class {
  func collectionView(_ collectionView:UICollectionView, heightForPhotoAtIndexPath indexPath:IndexPath) -> CGFloat
}

class PinteraetLayout : UICollectionViewLayout {
  // 1
  weak var delegate: PinterestLayoutDelegate!
  
  // 2
  fileprivate var numberOfColumns = 2
  fileprivate var cellPadding: CGFloat = 6
  
  // 3
  fileprivate var cache = [UICollectionViewLayoutAttributes]()
  
  // 4
  fileprivate var contentHeight: CGFloat = 0
  
  fileprivate var contentWidth: CGFloat {
    
    guard let collectionView = collectionView else {
      return 0
    }
    
    let insets = collectionView.contentInset
    return collectionView.bounds.width - (insets.left + insets.right)
    
  }
  
  // 5
  override var collectionViewContentSize: CGSize {
    return CGSize(width: contentWidth, height: contentHeight)
  }
  
  override func prepare() {
    print(#function)
    guard cache.isEmpty == true , let collectionView = self.collectionView else {
      return
    }
    
    let columnsWidth = contentWidth / CGFloat(numberOfColumns)

    var xOffsets = [CGFloat]()
    var yOffsets = [CGFloat](repeating : 0, count : numberOfColumns)
    var column = 0
    
    for column in 0 ..< numberOfColumns {
      xOffsets += [CGFloat(column) * columnsWidth]
    }
    
    for item in 0 ..< collectionView.numberOfItems(inSection: 0) {
      
      let indexPath = IndexPath(item: item, section: 0)
      let photoHeight = delegate.collectionView(collectionView, heightForPhotoAtIndexPath: indexPath)
      let height = cellPadding * 2 + photoHeight
      
      let cellFrame = CGRect(x: xOffsets[column],
                             y: yOffsets[column],
                             width: columnsWidth,
                             height: height)
      
      let insetFrame = cellFrame.insetBy(dx: cellPadding, dy: cellPadding)
      
      let attributes = UICollectionViewLayoutAttributes(forCellWith: indexPath)
      attributes.frame = insetFrame
      
      cache += [attributes]
      
      contentHeight = max(contentHeight, cellFrame.maxY)
      yOffsets[column] += height
      column = (column < numberOfColumns - 1) ? numberOfColumns - 1 : 0
      
    }

  }
  
  override func layoutAttributesForElements(in rect: CGRect) -> [UICollectionViewLayoutAttributes]? {
    print(#function)
    return cache.filter {$0.frame.intersects(rect)}
  }
  
  override func layoutAttributesForItem(at indexPath: IndexPath) -> UICollectionViewLayoutAttributes? {
    print(#function)
    return cache[indexPath.item]
  }

}


