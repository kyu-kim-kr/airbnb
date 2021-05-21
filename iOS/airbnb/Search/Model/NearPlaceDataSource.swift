//
//  NearPlaceDataSource.swift
//  airbnb
//
//  Created by 박혜원 on 2021/05/21.
//

import UIKit

class NearPlaceDataSource: NSObject, UICollectionViewDataSource {
    var list : [NearPlaceDTO] = [
        NearPlaceDTO(imageURL: nil, localName: "서울", distance: 0.5),
        NearPlaceDTO(imageURL: nil, localName: "부산", distance: 6),
        NearPlaceDTO(imageURL: nil, localName: "강남", distance: 2)
    ]
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return list.count
    }
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let item = list[indexPath.row]
        
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: NearPlaceCell.reuseIdentifier, for: indexPath) as! NearPlaceCell
        cell.areaTitle.text = item.localName
//        cell.thumbnail.image
        cell.timeRequired.text = "차로 \(item.distance) 시간 거리"
        return cell
    }
}