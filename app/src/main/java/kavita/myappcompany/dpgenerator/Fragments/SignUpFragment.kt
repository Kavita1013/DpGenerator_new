package kavita.myappcompany.dpgenerator.Fragments

import android.app.Application
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kavita.myappcompany.dpgenerator.Models.LoginRepo
import kavita.myappcompany.dpgenerator.R
import kavita.myappcompany.dpgenerator.ViewModels.LoginViewModel


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SignUpFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var Button:Button
    private lateinit var email:EditText
    private lateinit var password :EditText
private lateinit var login:TextView
    private var fragmentLoginFragment: Fragment? =  null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view= inflater.inflate(R.layout.fragment_sign_up, container, false)
        SignUpFragment.appContext = appContext
        firebaseAuth = FirebaseAuth.getInstance()
        Button=view.findViewById(R.id.button)
        email=view.findViewById(R.id.email)
        password=view.findViewById(R.id.password)
        login=view.findViewById(R.id.textView4)
        Button.setOnClickListener {
            signUp()
        }
        login.setOnClickListener { view ->
            fragmentLoginFragment =LoginFragment()
            val fragmentManager = parentFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.FrameLayout, fragmentLoginFragment as LoginFragment).commit()
            SharedPref.getInstance(context).setIsFirstLaunchToFalse()
        }
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)}
    companion object {
       lateinit var firebaseAuth: FirebaseAuth
        var appContext: Context? = null
        var idToken: String="--"
       val TAG="SignupFrag"
    }
    @RequiresApi(Build.VERSION_CODES.P)
    private fun signUp() {

        val email1: String =email.text.toString()
        val password1: String = password.text.toString()
appContext=context

        var viewmodel= ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)

        if (email1=="") {
            Toast.makeText(context , "Email can't be blank", Toast.LENGTH_SHORT).show()
        }

        if (password1=="") {
            Toast.makeText(context , "Password can't be blank", Toast.LENGTH_SHORT).show()
        }


        if(email1.indexOf('@')<0 && email1.indexOf('.')<0)
        {
            Toast.makeText(context, "Email is not formatted properly.",
                Toast.LENGTH_SHORT).show()
        }
        if(password1.length<6)
        {
            Toast.makeText(context, "Password legth should be greater than 6",
                Toast.LENGTH_SHORT).show()
        }


        //CREATING USER WITH EMAIL AND PASSWORD


                                viewmodel.register(email1,password1)                               //GETTING TOKEN

                                viewmodel.UserMutableLiveData.observe(viewLifecycleOwner,Observer<FirebaseUser>(){
    if (it!=null){
        Toast.makeText(context,"Check Mail",Toast.LENGTH_SHORT).show()
        toLogin()
    }
})





                            }





    private fun toLogin()
    {

        var fr = getFragmentManager()?.beginTransaction()
        fr?.replace(R.id.FrameLayout, LoginFragment())
        fr?.commit()
    }

}