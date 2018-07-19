//: Playground - noun: a place where people can play

import UIKit

// 1. Base class 없이 기본 '날다'와 '새'의 기능을 정의
protocol Bird : CustomStringConvertible {
    var name : String {get}
    var canFly : Bool {get}
}


extension CustomStringConvertible where Self : Bird {
    var description : String {
        return canFly ? "I can fly" : "Guess I'll just sit here :["
    }
}


protocol Flyable {
    var airspeedVelocity : Double {get}
}

// 2. Bird 와 Flyable protocol을 채택해서 FlabbyBird 구조체 정의
struct FlabbyBird : Bird, Flyable {
    let name: String
//    let canFly = true
    let flappyFrequency : Double
    let flappyAmplitude : Double
    
    var airspeedVelocity: Double {
        return 3 * flappyFrequency * flappyAmplitude
    }
}

// 3. Bird protocol만 채택해서 날지 못하는 펭귄의 특징을 살렸다.
struct Penguin : Bird {
    let name : String
//    let canFly: Bool = false
}

//  프로토콜을 기능적으로 분리해서 객체에 특징에 따라 적절하게 채택.
struct SwiftBird : Bird, Flyable {
    var name : String {return "Swift \(version)"}
    let version : Double
    let canFly: Bool = true
    
    var airspeedVelocity: Double {
        return version * 1000.0
    }
}

// 4. Bird 의 extension 을 통해서 Flyable을 채택한 객체는
//    canFly를 굳이 오버라이딩 하지 않게해서 중복 코드를 줄인다.
extension Bird {
    var canFly : Bool { return self is Flyable }
}

// 5. 구조체, 클래스 뿐만 아니라 열거형도 Protocol을 채택할 수 있다.
enum UnladenSwallow : Bird, Flyable {
    case african
    case european
    case unknown
    
    var name : String {
        switch self {
        case .african:
            return "African"
        case .european:
            return "European"
        case .unknown:
            return "What do you mean? African or European?"
        }
    }
    
    var airspeedVelocity: Double {
        switch self {
        case .african:
            return 10.0
        case .european :
            return 9.9
        case .unknown:
            fatalError("You are thrown from the bridge of death!")
        }
    }
}

extension UnladenSwallow {
    var canFly : Bool {
        return self != .unknown
    }
}

UnladenSwallow.unknown.canFly // false
UnladenSwallow.african.canFly // true
Penguin(name: "King Penguin").canFly // false

UnladenSwallow.african // "I can fly"


// Motorcycle 클래스는 Bird, Flying Protocol과는 관계 없는 클래스
class Motorcycle {
    init(name : String) {
        self.name = name
        speed = 200
    }
    
    var name : String
    var speed : Double
}

// Racer Protocol을 통해서 다른 타입들을 통합한다.
protocol Racer {
    var speed : Double {get}
}

extension FlabbyBird : Racer {
    var speed : Double {
        return airspeedVelocity
    }
}

extension SwiftBird : Racer {
    var speed : Double {
        return airspeedVelocity
    }
}

extension Penguin: Racer {
    var speed : Double {
        return 42
    }
}

extension UnladenSwallow : Racer {
    var speed : Double {
        return canFly ? airspeedVelocity : 0
    }
}

extension Motorcycle : Racer {}

//Racer Protocol 을 통해 모든 타입들을 하나의 배열에 통합시켰다.
let racers : [Racer] = [
    UnladenSwallow.african,
    UnladenSwallow.european,
    UnladenSwallow.unknown,
    Penguin(name: "King Penguin"),
    SwiftBird(version: 3.0),
    FlabbyBird(name: "Felipe", flappyFrequency: 3.0, flappyAmplitude: 20.0),
    Motorcycle(name: "Giacomo")
]

// Sequence Protocol을 extension 해서 최고 속력을 구하는 코드의 가독성을 높히고, 서브스크립팅의 연산도 가능하게 했다.
extension Sequence where Iterator.Element == Racer {
    func topSpeed() -> Double {
        return self.max(by: {$0.speed < $1.speed})?.speed ?? 0
    }
}

racers[1...3].topSpeed()
