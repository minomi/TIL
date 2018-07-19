//: Playground - noun: a place where people can play

import Cocoa

func insertSort<T : Comparable>(_ list : inout [T], order : (T ,T) -> Bool) {
    guard list.count > 1 else { return }
    
    for i in 1 ..< list.count {
        let target = list[i]
        var j = i
        
        while j >= 1 && order(list[j - 1], target) {
            list[j] = list[j - 1]
            j -= 1
        }
        
        list[j] = target
    }
}

var array = [5, 3, 4, 9, 1, -7, 0, 99, -98]

insertSort(&array) {
    return $0 > $1
}

array

//시간복잡도 O(n^2) 이지만 배열이 어느정도 정렬돼있거나,
//소규모 데이터일때는 병합정렬, 퀵정렬 보다 좋은 속도를 낸다.
