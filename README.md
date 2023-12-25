# android 设计架构MVC MVP MVVM
## MVC
架构介绍
Model：数据模型，负责处理数据的加载或存储，比如我们从数据库或者网络获取数据
View：视图，负责界面数据的展示，与用户进行交互，也就是我们的xml布局文件
Controller：控制器，负责逻辑业务的处理，也就是我们的Activity
MVC优点
1.View 接受用户的请求，然后将请求传递给 Controller
2.Controller 进行业务逻辑处理后，通知 Model去更新
Model 数据更新后，通知 View 去更新界面显示
这里容易发生耦合
View --> Controller，也就是反应 View 的一些用户事件（点击触摸事件）到Activity上
Controller --> Model, 也就是 Activity 去读写一些我们需要的数据
Controller --> View, 也就是 Activity 在获取数据之后，将更新内容反映到View上
MVC缺点
Android中使用了Activity来充当Controller，但实际上一些UI也是由Activity来控制的，比如进度条等。因此部分视图
就会跟 Controller 捆绑在同一个类了。同时，由于 Activity 的职责过大，Activity 类的代码也会迅速膨胀
主要表现就是我们的 Activity 太重了，经常一写就是几百上千行了。造成这种问题的原因就是Controller层和View层的
关系太过紧密，也就是Activity中有太多操作View的代码了
MVC还有一个重要的缺陷就是View跟Model是有交互的，没有做到完全的分离，这就会产生耦合。
PS: 但是！但是！其实Android这种并称不上传统的MVC结构，因为Activity又可以叫View层又可以叫Controller层，所以
我觉得这种Android默认的开发结构，其实称不上什么MVC项目架构，因为他本身就是Android一开始默认的开发形式，所有
东西都往Activity中丢，然后能封装的封装一下，根本分不出来这些层

2. MVP
PS：之前不就是因为Activity中有操作view，又做Controller工作吗。所以其实MVP架构就是从原来的Activity层把view
和Controller区分开，单独抽出来一层Presenter作为原来Controller的职位。
然后最后演化成，将View层写成接口的形式，然后Activity去实现View接口，最后在Presenter类中去实现方法
总之呢，就是解决：将 Controller 与 View彻底分离。解决 MVC 中 Activity 职责过多，代码臃肿的问题。

Model：数据模型，比如我们从数据库或者网络获取数据
跟 MVC不同的地方在于Model不会跟View发生交互，只会跟Presenter交互
View：视图，也就是我们的xml布局文件和Activity
MVP在实现上来说可以有多种思路，不同的实现方式其优缺点也是不同的，具体问题具体分析
eg: 也有场景下 Activity 作为 Presenter 会更好一些
Presenter：主持人，单独的类，只做调度工作。
View --> Presenter，反应 View 的一些用户事件到 Presenter上。
Presenter --> Model, Presenter去读写操作一些我们需要的数据。
Presenter--> View, Presenter在获取数据之后，将更新内容反馈给 Activity，进行 view 更新。
通常View与Presenter是一对一的，但复杂的View可以绑定多个Presenter来处理逻辑。

MVP 优点
这种的优点就是确实大大减少了 Activity 的负担，让Activity主要承担一个更新View的工作，然后把跟Model交互的工作
转移给了 Presenter，从而由Presenter方来控制和交互 Model方以及 View。所以让项目更加明确简单，顺序性思维开发。

View 与 Model 完全分离，我们可以修改视图而不影响模型。
可以更高效地使用模型，因为所有的交互都发生 Presenter 中
Presenter 与 View 的交互是通过接口来进行的，有利于添加单元测试。
MVP 缺点
缺点也很明显：
首先就是代码量大大增加了，每个页面或者说功能点，都要专门写一个Presenter类，并且由于是面向接口编程，需要增加大量接口，会有大量繁琐的回调。
页面逻辑复杂的话，相应的接口也会变多，增加维护成本
其次，由于 Presenter 里持有了 Activity 对象，所以可能会导致内存泄漏或者view 空指针，这也是需要注意的地方。
系统内存不足时，系统会回收 Activity。一般我们都是用OnSaveInstanceState() 去保存状态，用 OnRestoreInstanceState()
去恢复状态。但是在我们的MVP中，View层是不应该去直接操作 Model的，所以这样做不合理，同时也增大了M 与 V的耦合。
解决办法是不要将 Activity 作为View 层，可以把Activity当Presenter来处理。具体实现这里就不分析了，有兴趣的可以研究一下
UI 改变的话，比如 TextView 替换 EditText，可能导致 Presente 的一些更新UI 的接口也跟着需要更改，存在一定的耦合
3. MVVM
MVVM 概念
有 Google 官方加持，更新了 Jetpack 中很多架构组件，比如 ViewModel，Livedata，DataBinding等等，所以这个是现在的主流框架和官方推崇的框架。
Model：数据模型，比如我们从数据库或者网络获取数据。View：视图，也就是我们的xml布局文件和Activity。ViewModel：关联层，将Model和View绑定，使他们之间可以相互绑定实时更新
Model：模型层，负责处理数据的加载或存储。与 MVP中的M一样。
View：视图层，负责界面数据的展示，与用户进行交互。与MVP中的V一样。
ViewModel：视图模型，负责完成 View 于 Model 间的交互,负责业务逻辑。
View 与 ViewModel 进行绑定，能够实现双向的交互
ViewModel数据改变时，View 会相应变动 UI，反之亦然
ViewModel 进行业务逻辑处理，通知 Model 去更新
可以与 View 实现 databinding 双向绑定 ， 使他们之间可以相互绑定实时更新
Model 数据更新后，把新数据传递给 ViewModel
eg: Activity 中监听 viewModel.value 变化，监听到之后改变 view 的值
View --> ViewModel -->View，双向绑定，数据改动可以反映到界面，界面的修改可以反映到数据
ViewModel --> Model, 操作一些我们需要的数据
MVVM 优点
MVVM 已经被实践证明是一种优秀的设计模式。能很好地将 UI 、交互逻辑、业务逻辑 和 数据 解耦

降低 View和 Controller 的耦合，减轻了视图的压力
Activity 代码不会像 MVC 那样那么臃肿，方便维护
相比于 MVP 中 Presente 与 View 存在耦合。ViewModel 与 View 的耦合则更低，ViewModel 只负责处理和提供数据，UI的改变，比如TextView 替换 EditText，ViewModel 几乎不需要更改任何代码，只需专注于数据处理就可以了。
ViewModel 里面只包含数据和业务逻辑，没有UI的东西，方便单元测试。
MVVM 缺点
数据绑定使得程序较难调试
界面出现异常时，有可能是 View 的代码有问题，也可能是 Model 的代码有问题。
由于数据绑定使得数据能够快速传递到其他位置，因此要定位出异常就比较有难度了。

# 列表显示数据，包括activity和fragment


# 参考文档
https://www.pudn.com/news/6228df3e9ddf223e1ad2c847.html
https://zhuanlan.zhihu.com/p/400738449
https://www.bbsmax.com/A/obzb0AR05E/


# 框架图
Activity 直接使用
          IBaseMvpView                    BaseMvpActivity                    BaseMvpPresenter
              ^                                 ^                                   ^
              |                                 |                                   |
              |                                 |                                   |
     ITestMvpActivityView                 TestMvpActivity                 TestMvpActivityPresenter

Fragment 直接使用
          IBaseMvpView                    BaseMvpFragment                    BaseMvpPresenter
              ^                                 ^                                   ^
              |                                 |                                   |
              |                                 |                                   |
     ITestMvpFragmentView                 TestMvpFragment                 TestMvpFragmentPresenter

Activity 多模块使用
          IBaseMvpView                    BaseMvpActivity                    BaseMvpPresenter
              ^                                 ^                                   ^
              |                                 |                                   |
              |                                 |                                   |
                                                                          BaseMultiPartMvpPresenter
                                                                                    ^
                                                                                    |
                                                                                    |
     IBaseMultiPartMvpView            BaseMultiPartMvpActivity             MultiPartyMvpPresenter
              ^                                 ^                                   ^
              |                                 |                                   |
              |                                 |                                   |
  ITestMultiPartMvpActivityView        TestMultiPartyActivity          TestMultiPartMvpActivityPresenter

Fragment 多模块使用
          IBaseMvpView                    BaseMvpFragment                    BaseMvpPresenter
              ^                                 ^                                   ^
              |                                 |                                   |
              |                                 |                                   |
                                                                          BaseMultiPartMvpPresenter
                                                                                    ^
                                                                                    |
                                                                                    |
     IBaseMultiPartMvpView             BaseMultiPartMvpFragment            MultiPartMvpPresenter
              ^                                 ^                                   ^
              |                                 |                                   |
              |                                 |                                   |
  ITestMultiPartMvpFragmentView        TestMultiPartMvpFragment        TestMultiPartMvpFragmentPresenter






























