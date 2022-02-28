package kavita.myappcompany.dpgenerator.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import kavita.myappcompany.dpgenerator.Adapters.SlideAdapter
import kavita.myappcompany.dpgenerator.R
import me.relex.circleindicator.CircleIndicator3

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class OnBoarding1Fragment : Fragment() {

    private var ImageList = mutableListOf<Int>()
    private var DescriptionList = mutableListOf<String>()
    private var aList = mutableListOf<Int>()
    private var bList = mutableListOf<Int>()
    private var cList = mutableListOf<Int>()
    private var dList = mutableListOf<Int>()
    private lateinit var indicator: CircleIndicator3
    private lateinit var button2 : Button
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var slider: ViewPager2
   private var fragmentSignUpFragment: Fragment? =  null
    private var fragmentLoginFragment: Fragment? =  null
    private lateinit var  slideadapter : SlideAdapter

    private lateinit var layouts :Array<Int>
    private val slideChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            TODO("Not yet implemented")
        }

        override fun onPageSelected(position: Int) {
             //addBottomDots(position)
             if (position == layouts.size.minus(1)) {

             } else {

             }
         }


         override fun onPageScrollStateChanged(state: Int) {

         }

          fun onPageScrolled(
             position: Int,
             //positionOffset: Float,
             //positionOffsetPixels: Int
         ) {
             TODO("Not yet implemented")
         }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding1, container, false)


        //init()
        //dataset()
        //interaction()


       // val indicator = view?.findViewById<CircleIndicator3>(R.id.indicator)
        //indicator?.setViewPager(slider)
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isFirstLaunch()) {
            fragmentLoginFragment =LoginFragment()
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.FrameLayout, fragmentLoginFragment as LoginFragment).commit()
            SharedPref.getInstance(context).setIsFirstLaunchToFalse()
        }

        postToList()
        slider= view.findViewById(R.id.slider)
         indicator = view.findViewById(R.id.indicator)
        slider.adapter= SlideAdapter(ImageList,DescriptionList,aList,bList,cList,dList)
        slider.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        indicator.setViewPager(slider)
        SharedPref.getInstance(context).setIsFirstLaunchToFalse()
        val Next =view.findViewById<Button>(R.id.button2)
Next.setOnClickListener{view->
    fragmentSignUpFragment =SignUpFragment()
    val fragmentManager = parentFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.FrameLayout, fragmentSignUpFragment as SignUpFragment).commit()
    SharedPref.getInstance(context).setIsFirstLaunchToFalse()
}
    }

    private fun isFirstLaunch(): Boolean {

        return SharedPref.getInstance(context).isFirstLaunch()

    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OnBoarding1Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    //New Approach Code

private fun addToList(image:Int,description:String,a:Int,b:Int,c:Int,d:Int){
    ImageList.add(image)
    DescriptionList.add(description)
    aList.add(a)
    bList.add(b)
    cList.add(c)
    dList.add(d)
}

    private fun postToList(){
        for (i in 1..4) {
            when (i) {
                1 -> addToList(R.drawable.ic_onboarding1,getString(R.string.Onboarding_src1),0,40,0,0)
                2 -> addToList(R.drawable.ic_group_2,getString(R.string.Onboarding_src2),0,0,0,120)
                3 -> addToList(R.drawable.ic_frame_onboarding2,getString(R.string.Onboarding_src3),0,0,0,130)
                4 -> addToList(R.drawable.ic_onboarding3,getString(R.string.Onboarding_src4),0,0,0,300)
            }
        }
    }


}




