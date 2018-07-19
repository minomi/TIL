https://www.raywenderlich.com/164608/uicollectionview-custom-layout-tutorial-pinterest-2 이 글을 공부하며 번역했습니다.

![](https://koenig-media.raywenderlich.com/uploads/2017/08/pinterest-layout-updated-initial.png)

기본 UICollectionViewLayout 을 이용해서 격자모양으로 구현한 갤러리 이다. 괜찮아 보이지만, 사진들이 완전히 보이지 않고 사진의 대한 글들이 잘려있다. 이 문제들은 collection view의 custom layout을 통해 해결할 수 있다.

Collection view layout 객체는 UICollectionViewLayout 의 서브클래스 이고, Collection View 의 모든 cell들의 비쥬얼적인 속성으로 정의 되어 있다. 그 아이템 하나하나의 속성들은 UICollectionViewLayoutAttributes 의 인스턴스 이고, frame과 transform 같은 collection view item 의 속성들로 이루어져 있다.

### Core Layout Process

Collection View는 item들을 어떠한 프로세스로 화면에 그리는지 알아보자, collection view 는 item 에 대한 레이아웃 정보가 필요하면 그 정보를 UICollectionViewLayout 객체에 물어본다.
 (UICollectionViewLayout에 정의 되어 있는 메서드 들을 특정한 순서대로 호출하여, 레이아웃에 대한 정보를 알아내는 식이다. collection view datasource 와 delegate 와 비슷한 느낌이다.)

![](https://koenig-media.raywenderlich.com/uploads/2015/05/layout-lifecycle-667x500.png)

layout subclass는 아래의 메소드들을 꼭 구현해야 한다.

* __collectionViewContentSize__ : 이름에서 의도하는 봐아 같이 이 메서드는 collection view의 content size 를 리턴한다. 단지 보이는 content가 아니다. 전체 content의 width 와 height를 리턴해 scroll view의 content size로 사용한다.

* __prepare()__: 이 메서드는 collection view의 사이즈와 아이템들의 위치를 결정하는데 필요한 계산을 한다.

* __layoutAttributesForElements(in:)__ : 이 메서드는 지정된 사각형 내부의 모든 item들의 대한 layout attribute를 반환한다.

* __layoutAttributesForItem(at:)__ : 주어진 indexPath의 item들에 대한 layout attribute를 리턴한다.

prepare 함수에서 collectionView의 indexPath에 해당하는 item들의 frame을 계산해서 UICollectionViewLayoutAttributes에 저장해 놓고, layoutAttributesForElements 메서드에서 저장해 놓은 frame을 리턴한다.

``` swift
override func layoutAttributesForElements(in rect: CGRect) -> [UICollectionViewLayoutAttributes]? {
    return cache.filter {$0.frame.intersects(rect)}
  }
```

![](https://koenig-media.raywenderlich.com/uploads/2017/08/pinterest-layout-updated-final.png)
