package kavita.myappcompany.dpgenerator.Fragments

import android.app.Application
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
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
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import kavita.myappcompany.dpgenerator.MainActivity
import kavita.myappcompany.dpgenerator.MainActivity2
import kavita.myappcompany.dpgenerator.Models.LoginRepo
import kavita.myappcompany.dpgenerator.R
import kavita.myappcompany.dpgenerator.ViewModels.LoginViewModel


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class LoginFragment : Fragment() {
    lateinit var firebaseAuth: FirebaseAuth
    //private lateinit var binding: FragmentLoginBinding
    private lateinit var viewmodel: LoginViewModel
private lateinit var signup:TextView
    private lateinit var button : Button
    private lateinit var email:EditText
    private lateinit var password :EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewmodel= ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_login, container, false)


        //binding = FragmentLoginBinding.bind(view)

        firebaseAuth = FirebaseAuth.getInstance()

return view

    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button=view.findViewById(R.id.button)
        button.setOnClickListener{view ->
            signIn()
        }
       LoginFragment.appContext1 = appContext1

        email=view.findViewById(R.id.emailLogin)
        password=view.findViewById(R.id.passwordLogin)
signup = view.findViewById(R.id.textView4)
        signup.setOnClickListener { view ->
            var fr = getFragmentManager()?.beginTransaction()
            fr?.replace(R.id.FrameLayout, SignUpFragment())
            fr?.commit()
        }
    }
    companion object {
var status:Boolean= false
        var idTokenLogin: String="---"
        var appContext1: Context? = null
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun signIn() {
        appContext1 =context
        val email1: String =email.text.toString()
        val password1: String = password.text.toString()
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
      viewmodel.login(email1,password1)
if(Companion.status){
    next1()
}

        }

    fun next1(){
        val intent = Intent(context,MainActivity2::class.java)
        startActivity(intent)
    }
    }

    private fun forgotPass()
    {
/*
        val email: String = binding.emailField.text.toString()
        if(email=="")
        {
            Toast.makeText(context, "Enter Your Mail ID", Toast.LENGTH_SHORT).show()
        }
        else
        {
            firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(context, "Mail sent to you , recover your password", Toast.LENGTH_LONG).show()
                        Log.d("forgotpass-", "Email sent.")
                    }
                }
        }
    }

    private fun toSignUp()
    {
        var fr = getFragmentManager()?.beginTransaction()
        fr?.replace(R.id.FrameLayout, SignUpFragment())
        fr?.commit()
    }

    private fun toHome()
    {
        firebaseAuth.currentUser!!.getIdToken(true)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    idTokenLogin = task.result!!.token!!
                    Log.e(TAG, "token is " +idTokenLogin)
                    //Log.d(SignupFragment.TAG, "Token successful"+task.result.toString())
                   /* Intent(requireActivity(), HomeActivity::class.java)
                        .also {
                            it.putExtra("idToken", task.result!!.token!!)
                            startActivity(it)
                            requireActivity().finish()
                        }*/
                }
                else{
                    Log.e(TAG, "No Token ", )
                }
            }

    }
*/


}