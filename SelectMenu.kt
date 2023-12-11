package com.example.mykioskproject

// 해당 경로에 있는 모든 클래스 가져오기
import com.example.mykioskproject.menu.*

class SelectMenu: DisplayMenu(){ //DisplayMenu를 상속받는 클래스
    val burgerList = ArrayList<Burgers>() //버거 메뉴를 저장할 리스트
    val chickenList = ArrayList<Chicken>() //치킨 메뉴를 저장할 리스트
    val setMenuList = ArrayList<SetMenu>() //세트 메뉴를 저장할 리스트
    val sideMenuList = ArrayList<SideMenu>() //사이드 메뉴를 저장할 리스트
    val drinksList = ArrayList<Drinks>() //음료 메뉴를 저장할 리스트

    var basket = ArrayList<Any>() //장바구니 역할로 다른 객체 저장할 리스트

    private val dataInputClass = Input() //데이터 입력받는 클래스 객체

    fun selectMainMenu(){
        var commend = "" //커맨드 입력받을 변수
        var intCommend = 0

//        setBurgerList(burgerList)
//        setChickenList(chickenList)
//        setSetMenuList(setMenuList)

        displayInfo(0) //소개문 출력
        while(true){
            displayInfo(1) //메인 메뉴 출력
            if(basket.size != 0){ //장바구니에 뭔가가 들어있다면 주문 메뉴 띄우기
                displayInfo(2)
            }
            commend = dataInputClass.input() ?: continue //입력한 값이 null이 아니면 입력한 값 대입, null이면 continue
            intCommend = commend.toInt()
            when(intCommend){
                1 -> {
//                    println("[ 버거 메뉴 ]")
//                    for((idx,burger) in burgerList.withIndex()){
//                        println("${idx+1}. ${burger.name}\t|\t${burger.price}원\t|\t${burger.explanation}")
//                    }
//
//                    println("0. 메인 메뉴로 돌아가기")
//                    commend = dataInputClass.input() ?: continue //입력한 값이 null이 아니면 입력한 값 대입, null이면 continue
//                    intCommend = commend.toInt()
//                    when(intCommend){
//                        0 -> continue //메인 메뉴로 되돌아가기
//                        in 1..burgerList.size -> {
//                            burgerList[intCommend-1].displayInfo()
//                            println("위 메뉴를 장바구니에 추가하시겠습니까?")
//                            println("1. 확인\t2. 취소")
//                            var tmpCommend = dataInputClass.input() ?: continue //입력한 값이 null이 아니면 입력한 값 대입, null이면 continue
//                            when(tmpCommend.toInt()){
//                                1 -> {
//                                    basket.add(burgerList[intCommend-1])
//                                    println("${burgerList[intCommend-1].name}가 장바구니에 추가되었습니다.")
//                                }
//                                2 ->{
//                                    println("${burgerList[intCommend-1].name}를 장바구니에 넣지 않았습니다.")
//                                    continue
//                                }
//                            }
//                        }
//                    }
                }

                2 -> {
//                    println("[ 치킨 메뉴 ]")
//                    for((idx,chicken) in chickenList.withIndex()){
//                        println("${idx+1}. ${chicken.name}\t|\t${chicken.price}원\t|\t${chicken.explanation}")
//                    }
//
//                    println("0. 메인 메뉴로 돌아가기")
//                    commend = dataInputClass.input() ?: continue //입력한 값이 null이 아니면 입력한 값 대입, null이면 continue
//
//                    when(commend.toInt()){
//                        0 -> continue //메인 메뉴로 되돌아가기
//                    }
                }

                3->{
//                    println("[ 세트 메뉴 ]")
//                    for((idx,setMenu) in setMenuList.withIndex()){
//                        println("${idx+1}. ${setMenu.name}\t|\t${setMenu.price}원\t|\t${setMenu.explanation}")
//                    }
//
//                    println("0. 메인 메뉴로 돌아가기")
//                    commend = dataInputClass.input() ?: continue //입력한 값이 null이 아니면 입력한 값 대입, null이면 continue
//
//                    when(commend.toInt()){
//                        0 -> continue //메인 메뉴로 되돌아가기
//                    }
                }

                4 -> {

                }

                5 -> {

                }

                0 -> {
                    println("\n프로그램을 종료합니다.")
                    break
                }

                6->{
                    if(basket.size > 0){
                        println("")
                    }
                    else{
                        println("\n지원하지 않는 기능입니다.\n")
                        continue
                    }

                }

                7 ->{
                    if(basket.size > 0){
                        println("")
                    }
                    else{
                        println("\n지원하지 않는 기능입니다.\n")
                        continue
                    }
                }

                else -> {
                    println("\n지원하지 않는 기능입니다.\n")
                    continue
                }
            }
        }
    }

//    fun setBurgerList(burgerList: ArrayList<Burgers>){
//        burgerList.add(Burgers("싸이버거", 4600, "바삭하고 매콤한 치킨 패티와 신선한 양상추가 조화를 이루는 맘스터치 시그니처 버거"))
//        burgerList.add(Burgers("싸이플렉스버거", 7700, "통다리살 싸이패티가 2장! 압도적 사이즈의 FLEX, 리얼 입찢버거 싸이플렉스버거"))
//        burgerList.add(Burgers("인크레더블버거", 5700, "프리미엄 더블햄, 에그프라이, 통다리살 패티에 아삭아삭한 양상추와 양파까지, 풍성한 버거."))
//        burgerList.add(Burgers("언빌리버블버거", 6200, "통새우, 에그프라이, 통가슴살 패티에 매콤한 스리라차 마요 소스를 더한 대확행 버거."))
//    }
//
//    fun setChickenList(chickenList: ArrayList<Chicken>){
//        chickenList.add(Chicken("후라이드치킨", 16900, "싸이버거 스타일 케이준 양념레시피로 더 바삭하고 스파이시한 핫크리스피 치킨"))
//        chickenList.add(Chicken("간장마늘치킨", 18900, "알싸한 마늘 향의 매콤함, 특제 간장소스의 단짠이 조화로운 치킨"))
//        chickenList.add(Chicken("맘스양념치킨", 18900, "국내산 벌꿀이 함유된 매콤달콤 특제 양념소스로 꿀맛나는 엄마표 맘스양념치킨"))
//        chickenList.add(Chicken("치즈뿌치(체다)", 18900, "체다치즈 고소함과 짭잘한 시즈닝이 중독적인 치킨"))
//    }
//
//    fun setSetMenuList(setMenuList: ArrayList<SetMenu>){
//        setMenuList.add(SetMenu("싸이버거 세트", 6900, "매콤한 통다리살 패티가 통째로~ 양파와 양상추가 조화를 이루는 맘스터치 시그니처 버거"))
//        setMenuList.add(SetMenu("싸이플렉스버거 세트", 10000, "통다리살 싸이패티가 2장! 압도적 사이즈의 FLEX, 리얼 입찢버거 싸이플렉스버거"))
//        setMenuList.add(SetMenu("인크레더블버거 세트", 8000, "에그프라이, 프리미엄 더블햄, 통다리살 패티에 신선한 양상추까지! 크고 확실한 행복을 즐길 수 있는 대확행 버거"))
//        setMenuList.add(SetMenu("언빌리버블 세트", 8500, "통새우, 에그프라이, 통가슴살 패티에 매콤한 스리라차 마요 소스를 더한 대확행 버거."))
//    }
}