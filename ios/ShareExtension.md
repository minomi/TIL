# Share Extension 써보기

### 1차 목표 - safari share 을 통해 내 앱에 특정 Web page URL을 저장하자.

Xcode 프로젝트 오른쪽 상단 new -> target -> Share Extension 후 빌드,Safari 공유 버튼을 누르면 List에 내 App이 나오는거 까지는 너무 쉬웠음..

그렇다면 공유한 URL을 뽑아낼까?? -> JavaScript 파일을 실행 시켜서 해당 WebPage의 url, image 등 내가 필요한 것을 가져올 수 있음, info.list에서
NSExtension dictionary안 에 NSExtensionAttributes dictionary도
추가해 준다.

```xml
<key>NSExtension</key>
<dict>
  <key>NSExtensionAttributes</key>
  <dict>
    <key>NSExtensionActivationRule</key>
    <dict>
      <key>NSExtensionActivationSupportsWebURLWithMaxCount</key>
      <integer>1</integer>
    </dict>
    <key>NSExtensionJavaScriptPreprocessingFile</key>
    <string>GetURL</string>
  </dict>
  <key>NSExtensionMainStoryboard</key>
  <string>MainInterface</string>
  <key>NSExtensionPointIdentifier</key>
  <string>com.apple.share-services</string>
</dict>
```

그리고 Extension Group안에 URL을 파싱하는 코드를 작성하고

``` JavaScript
var GetURL = function() {};
GetURL.prototype = {
  run: function(arguments) {
    arguments.completionFunction({"URL": document.URL});
  }
};
var ExtensionPreprocessingJS = new GetURL;
```

ShareViewController 의 viewDidLoad() 에 아래 코드를 작성면 URL을 가져올 수 있었지만!!!!

```swift
let extensionItem = extensionContext?.inputItems.first as! NSExtensionItem
let itemProvider = extensionItem.attachments?.first as! NSItemProvider
let propertyList = String(kUTTypePropertyList)

if itemProvider.hasItemConformingToTypeIdentifier(propertyList) {
    itemProvider.loadItem(forTypeIdentifier: propertyList, options: nil, completionHandler: { (item, error) -> Void in
        guard let dictionary = item as? NSDictionary else { return }

        OperationQueue.main.addOperation {
            if let results = dictionary[NSExtensionJavaScriptPreprocessingResultsKey] as? NSDictionary,
                let urlString = results["URL"] as? String,
                let url = NSURL(string: urlString) {
                print("URL retrieved: \(urlString)")
            }
        }

    })
} else {
    print("error")
}
```

### 2차 목표 main app과 app extension 간의 데이터 공유

app group 이용!!
