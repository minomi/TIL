//: Playground - noun: a place where people can play

import UIKit

class User {
    var name : String
    var subscriptions : [CarrierSubscription] = []
    private(set) var phones : [Phone] = []
    
    init(name : String) {
        self.name = name
        print("User \(name) is initialized")
    }
    
    func add(phone : Phone) {
        self.phones.append(phone)
        phone.owner = self
    }
    
    deinit {
        print("User \(name) is being deallocated")
    }
}

class Phone {
    var model : String
    // reference cycle을 방지하기 위해 weak 으로 선언
    weak var owner : User?
    var carrierSubscription : CarrierSubscription?
    
    func provision(carrierSubscription : CarrierSubscription) {
        self.carrierSubscription = carrierSubscription
    }
    
    func decommission() {
        self.carrierSubscription = nil
    }
    
    init(model : String) {
        self.model = model
        print("Phone \(model) is initialized")
    }
    
    deinit {
        print("Phone \(model) is being deallocated")
    }
    
}

class CarrierSubscription {
    let name : String
    let countryCode : String
    let number : String
    // user 없이 CarrierSubscription은 있을 수 없다, 옵셔널로 정의할 수 없으므로 weak 사용불가.
    unowned let user : User
    
    lazy var completePhoneNumber : () -> String = { [unowned self] in
        self.countryCode + " " + self.number
    }
    
    init(name : String, countryCode : String, number : String, user : User) {
        self.name = name
        self.countryCode = countryCode
        self.number = number
        self.user = user
        
        user.subscriptions.append(self)
        print("CarrierSubscription \(name) is initialized")
        
    }
    
    deinit {
        print("CarrierSubscription \(name) is being deallocated")
    }
}

//  deinit이 호출되기 위해 새로운 scope를 만듬
do {
    let user1 = User(name: "minho")
    let iPhone8 = Phone(model: "iPhone 8")
    
    user1.add(phone: iPhone8)
    let subscription1 = CarrierSubscription(name: "TelBel", countryCode: "0082", number: "312324222", user: user1)
    iPhone8.provision(carrierSubscription: subscription1)
    
    print(subscription1.completePhoneNumber())
}

