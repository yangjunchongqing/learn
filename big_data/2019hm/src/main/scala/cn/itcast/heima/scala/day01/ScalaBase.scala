package cn.itcast.heima.scala.day01

object ScalaBase {

  def main(args: Array[String]): Unit = {
    functionCode8
    println("end")
  }

  def variable01{
  // 1.变量 1.1 可变变量和不可变变量（var/val(一般)）；1.2 惰性赋值
  // 1.1
  var vName = "dog"
  vName = "cat"
  val vSize = 20
//  vSize = 30 错误不可修改
  //1.2
  lazy val lSql = "insert into table a select * from tableb"
  println(lSql)
  }

  def str02={
  // 1字符串使用双引号 2使用插值表达式 3使用三引号
  val a = "dog"
  val b = s"cat is like ${a}"
  val c = """gogogo "kill"""
  println(a,b,c)
}

  def dataType03={
    println("dataType")
//    Byte 8位带符号整数
//      Short 16位带符号整数
//      Int 32位带符号整数
//      Long 64位带符号整数
//      Char 16位无符号Unicode字符
//      String Char类型的序列（字符串）
//    Float 32位单精度浮点数
//      Double 64位双精度浮点数
//      Boolean true或false

  }

  def conditionExpretion03={
    // 1带返回值 2 块表达式
    val a = "male"
    val result = if (a == "male") 0 else 1
    println(result)
    if (a == "male"){
      var c = 0
      c = c + 1

    }
  }

  def circle04: Unit ={
//    1.for表达式 简单循环 嵌套循环 守卫for推导式
//    2.while循环
    for(i <- 1.to(10)){
      println(i)
    }
    for(i<-1.to(3);j <- 1.to(5)){
      if (j == 5) println("")
      else print("*")
    }
    for(i<-1.to(10);if i % 2 == 0) println(s"${i}整除2")

    var i = 0
    while(i < 10){
      i += 1
      println(s"${i} while circle")
    }
  }

  // 5method
  //5.1方法定义方法 5.2方法参数默认参数 带名参数 变长参数
  // 5.3方法返回值类型推断
  // 5.4方法调用方式 后缀调用法 中缀调用法 花括号调用法 无括号调用法
  //变长参数
  def varParameterMethod5(str:String*){
    val str1: Seq[String] = str
    println(str(1),str(2), str(0))
    for (elem <- str) {println(s"${elem}+hkhkhk")}

  }

  // 6.函数function
  // 1.函数定义函数 2.方法和函数的区别 3.方法转换为函数a
  def functionTransfer(x:Int, y:Int)={x+y}
  // 代码放到mian方法才能运行
  val b = (x: Int, y: Int) => {x+y}
  println(b(11,22))
  val c = functionTransfer _
  println(c(55, 66))

  def dataVariableType7={
    //  数组，元组，列表，集，映射
    // 7.1 数组（不可变，可变）
    var a = new Array[Int](3)
    a(0) = 11
    a(1) = 22
    for(i <- a){println(i)}
//    val b = Array("zs", "ls", "ww",333)
//    println(b)
    import scala.collection.mutable.ArrayBuffer
    val aVArray = ArrayBuffer[String]()
    aVArray += "111"
    aVArray += "2222"
    println(aVArray)

    //添加/修改/删除元素
    // 使用 += 添加元素
    // 使用 -= 删除元素
    aVArray -= "2222"
    // 使用 ++= 追加一个数组到变长数组
    aVArray ++= Array("33", "44")
    println(aVArray)

    // 7.2 元组 小标从1开始
    val abc = (1,2,"String")
    println(abc._1)

    // 7.3 列表 不可变，可变；基本操作
//    val aList = List(11, 22, "ddd")
//    val aEmpty = Nil

    import scala.collection.mutable.ListBuffer
    var aVList = ListBuffer[String]()
//    获取元素（使用括号访问 (索引值) ）
//    添加元素（ += ）
//    追加一个列表（ ++= ）
//    更改元素（ 使用括号获取元素，然后进行赋值 ）
//    删除元素（ -= ）
//    转换为List（ toList ）
//    转换为Array（ toArray ）
    aVList += "111"
    aVList ++= List("aaa", "bbb")
    aVList -= "111"
    if(aVList.isEmpty){
      println("空的列表集合")
    } else{println("列表非空")}
    val aList = List(2,4,2,7,3)
    println(aList.sorted.reverse)
//    判断列表是否为空（ isEmpty ）
//    拼接两个列表（ ++ ）
//    获取列表的首个元素（ head ）
//    和剩余部分( tail )
//    反转列表（ reverse ）
//    获取前缀（ take ）
//    获取后缀（ drop ）
//    扁平化（ flaten ）
//    拉链（ zip ）和拉开（ unzip ）
//    转换字符串（ toString ）
//    生成字符串（ mkString ）
//    并集（ union ）
//    交集（ intersect ）
//    差集（ diff ）

    // 7.4 集 不可变/可变
    //不可变
//    获取集的大小（ size ）
//    遍历集（ 和遍历数组一致 ）
//    添加一个元素，生成一个Set（ + ）
//    拼接两个集，生成一个Set（ ++ ）
//    拼接集和列表，生成一个Set（ ++ ）
    var aSet = Set[String]()
    aSet = aSet ++ Set("111")
    aSet ++ List("2222")
    println(aSet)
// 可变
    import scala.collection.mutable.Set
    val aVSet = Set(1,2,3,4)
    aVSet += 10
    aVSet -= 1
    println(aVSet)

    // 7.5 映射 不可变，可变，操作
    // 不可变
    val aMap = Map("zs" -> 99,"ls" -> 100)
    // 可变
//    获取值( map(key) )
//    获取所有key（ map.keys ）
//    获取所有value（ map.values ）
//    遍历map集合 getOrElse
//    增加key,value对 删除key
    import scala.collection.mutable.Map
    val aVMap = Map[String, Int]()
    aVMap += "ww" -> 91
    aVMap.getOrElse("ss", 100)
    for((x,y)<- aVMap){
      println(s"${x}  ${y}")

    }
    aVMap += "zl" -> 100
    aVMap -= "zl"
    println(aVMap)

  }
  def functionCode8: Unit ={
    //      遍历（ foreach ）
    //      映射（ map ）
    //      映射扁平化（ flatmap ）
    //      过滤（ filter ）
    //      是否存在（ exists ）
    //      排序（ sorted 、 sortBy 、 sortWith ）
    //      分组（ groupBy ）
    //      聚合计算（ reduce ）
    //      折叠（ fold ）
    val a = List(1,2,3,4,10,8,6,9)
    a.foreach(println(_))
    a.map(_*10).foreach(println(_))
    val b = List("hadoop 1", "scala 10","java 2")
    b.flatMap(_.split(" ")).foreach(println(_))
    a.filter(_ % 2 == 0).foreach(println(_))
    println(a.sorted.reverse)
    println(b.sortBy(_.split(" ")(0)).reverse)
    a.sortWith((x,y) =>if (x<y) true else false)
    val aGroupBy = List("张三"->"男", "李四"->"女", "王五"->"男")
    println(aGroupBy.groupBy(_._2).map(x => (x._1, x._2.size)))
    a.reduce(_+_)

  }



  }
