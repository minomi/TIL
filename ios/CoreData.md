### Core Data

#### NsPersistentContainer
Xcode 프로젝트 생성시 코어데이터 체크박스에 체크를 하고 프로젝트를 생성하면 AppDelegate.swift 파일에 Core Data stack 과 Core Data Saving support 로 마크된 코드가 생성된다. 그 코드의 핵심 클래스 NsPersistentContainer는 코어데이터에서 데이터를 저장하고 가져오기 쉽게 해주는 객체들의 집합으로 구성되있고 코어 데이터 상태를 관리하는 객체, 데이터 모델을 나타내는 객체 등이있다.

#### 데이터 모델링

기본적으로 코어데이터는 내부적으로 SQLite를 사용하고 있고, Data Model 은 DB 스키마 처럼 생각하면 될 것이다.

* Entity : 코어 데이터에서 클래스 정의 관계형 데이터베이스에서 Table 같은 것
* Attribute : 특정 Entity 와 관련된 데이터들 관계형 데이터베이스의 Field
* Relationship : 다수 Entity 간 관계

#### Core Data Stack
![](https://nol2soft.files.wordpress.com/2011/10/6.png)

보통 가장 상단에 있는 Managed Object Context와 Managed Object를 많이 사용해서 데이터들을 다룬다. Managed Object Context의 가장 큰 역활은 Managed Object들의 집합을 관리하는 것, App의 생존주기 관리에서 객체들의 관계 유지, undo, redo를 책임진다.

#### NSManagedObject

NSManagedObject는 코어데이터내에 하나의 객체를 나타낸다. 코어데이터의 persistent 저장소에 데이터를 생성, 편집, 저장, 삭제하려면 이 객체를 사용해야한다.NSManagedObject는 정의된 relationship, Attribute가 무엇이든간에 Data Model의 Entity를 취할수 있다. NSManagedObject는 KVC를 사용하여 Entity의 Attribute에 접근한다.

#### NSManagedObjectContext
NSManagedObject를 통해 객체를 저장하고, 가져올때 필요한 객체이다. NSManagedObject를 객체를 NSManagedObjectContext객체에 insert하고 NSManagedObjectContext의 변화를 commit 시키는 방식으로 disk에 저장하고 싶은 데이터를 저장한다.

#### NSEntityDescription
Entity를 설명하는 객체 (이름, 클래스의 이름, Attributes)

Entity Description, 데이터베이스 내의 테이블, managed object 의 관계
![](https://nol2soft.files.wordpress.com/2011/10/8.png)


만약 Person 이라는 Entity를 생성하고 name 이라는 String Type Attribute를 할당했다고 가정

```swift
//코어데이터를 사용해서 disk에 데이터 저장하는 코드
guard let appDelegate = UIApplication.shared.delegate as? AppDelegate else {
            return
        }

let name = "이름"
// NSManagedObjectContext를 가져온다.
let managedContext = appDelegate.persistentContainer.viewContext

if let entity = NSEntityDescription.entity(forEntityName: "Person", in: managedContext) {

    //NSManagedObjectContext에 insert할 NSMagagedObject 객체 생성,
    let person = NSManagedObject(entity: entity, insertInto: managedContext)
    // KVC를 이용해서 name 저장
    person.setValue(name, forKey: "name")

    do {
        // disk 에 commit
        try managedContext.save()
        people.append(person)
    } catch let error as NSError {
        print("Could not save. \(error), \(error.userInfo)")
    }
}

```

#### NSFetchRequest
코어데이터를 사용해서 데이터를 가져올때는 NSFetchRequest 클래스를 사용한다. 이 클래스를 사용하면 특정 조건을 만족하는 데이터 집합을 가져올 수 있다 (DB 쿼리 기능)

```swift
guard let appDelegate = UIApplication.shared.delegate as? AppDelegate else {return}

let managedContext = appDelegate.persistentContainer.viewContext

let fetchRequest = NSFetchRequest<NSManagedObject>(entityName: "Person")

do {
    people = try managedContext.fetch(fetchRequest)
} catch let error as NSError {
    print("Could not fetch. \(error), \(error.userInfo)")
}
```

#### 그 밖에
코어 데이터는 데이터를 persistent하게 저장하고 fetch하는 것 의외에 많은 기능을 제공한다.

* Model의 변경을 관리하기 위한 인프라 제공 (ex, undo, redo, 객체 사이이 관계 유지)
* 어느 때건, 특정 시점에 메모리 내 모델 객체의 일부를 유지할 수 있음
