package kr.co.hanbit.customview

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kr.co.hanbit.customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //val customView = CustomView(this) //"안녕하세요"
        val customView = CustomView("안녕 코틀린!", this)

        binding.frameLayout.addView(customView) //frameLayout에 customView 삽입(addView() 메서드를 사용하면 소스 코드에서 생성한 뷰를 레이아웃에 삽입 할 수 있음)
    }
}

class CustomView(text: String, context: Context): View(context) { //View는 컨텍스트를 생성자에서 입력받아야 하므로 CustomView에는 컨텍스트를 입력받는 생성자가 하나 꼭 있어야함
    val text: String
    init {
        this.text = text //생성자를 통해 넘어온 문자열 저장
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        /* 뷰에 텍스트 출력하기 */
        val paint = Paint() //drawText() 메서드는 출력할 문자열, 가로세로 좌표, 글자의 색과 두꼐 정보를 가지고 있는 Paint 필요
        paint.color = Color.BLACK
        paint.textSize = 100f //float
        //canvas?.drawText("안녕하세요", 20f, 300f, paint) //텍스트 그리기
        canvas?.drawText(text, 20f, 300f, paint) //텍스트 그리기
        /* 파라미터 1: 출력할 글자
           파라미터 2: x좌표
           파라미터 3: y좌표
           파라미터 4: 색상 정보
         */

        /* 뷰에 도형 그리기 */
        val blue = Paint()
        blue.style = Paint.Style.FILL
        blue.color = Color.BLUE
        canvas?.drawCircle(150f, 800f, 100f, blue) //x축 줌심, y축 중심, 반지름, 페인트

        val red = Paint()
        red.style = Paint.Style.STROKE
        red.color = Color.RED
        canvas?.drawCircle(400f, 800f, 100f, red)

        val green = Paint()
        green.style = Paint.Style.STROKE
        green.strokeWidth = 20f //외곽선의 두꼐
        green.color = Color.GREEN
        val rect = Rect(50, 450, 250, 650)
        canvas?.drawRect(rect, green)

        val cyan = Paint()
        cyan.style = Paint.Style.FILL
        cyan.color = Color.GREEN
        val rectF = RectF(300f, 450f, 500f, 650f)
        canvas?.drawRoundRect(rectF, 50f, 50f, cyan)
    }
}