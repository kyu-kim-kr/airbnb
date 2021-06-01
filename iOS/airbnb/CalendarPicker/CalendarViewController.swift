//
//  CalendarViewController.swift
//  airbnb
//
//  Created by 박혜원 on 2021/05/25.
//

import UIKit

enum CalendarDataError: Error {
    case metadataGeneration
}

class CalendarViewController: UIViewController {
    
    @IBOutlet weak var collection: UICollectionView!
    
    // MARK: - Properties
    
    private let flowLayout : UICollectionViewFlowLayout = {
        let layout = UICollectionViewFlowLayout()
        layout.sectionHeadersPinToVisibleBounds = true
        layout.minimumLineSpacing = 0
        layout.minimumInteritemSpacing = 0
        return layout
    }()
    
    private let calendar = Calendar(identifier: .gregorian)
    private var baseDate = Date()
    private var dataSource : CalenderColleectionDataSource?
    private var numberOfWeeksInBaseDate: Int {
        calendar.range(of: .weekOfMonth, in: .month, for: baseDate)?.count ?? 0
    }
    
    // MARK: - View Life Cycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let days = CalendarDateCalculator().generateDaysInMonth(for: baseDate)
        self.dataSource = CalenderColleectionDataSource(with: days)
        collection.dataSource = dataSource
        collection.delegate = self
        collection.collectionViewLayout = flowLayout
    }
}

extension CalendarViewController: UICollectionViewDelegateFlowLayout {
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        let width = Int(collectionView.frame.width / 7)
        let height = Int(collectionView.frame.height) / numberOfWeeksInBaseDate - 10
        return CGSize(width: width, height: height)
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, referenceSizeForHeaderInSection section: Int) -> CGSize {
        return CGSize(width: collectionView.frame.width, height: 50.0)
    }
}