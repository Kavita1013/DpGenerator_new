package kavita.myappcompany.dpgenerator.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kavita.myappcompany.dpgenerator.MainActivity
import kavita.myappcompany.dpgenerator.MainActivity2
import kavita.myappcompany.dpgenerator.R
import kavita.myappcompany.dpgenerator.ViewModels.LoggedInViewModel
import kavita.myappcompany.dpgenerator.ViewModels.LoginViewModel

class ProfileFragment : Fragment() {
private lateinit var LogOut: TextView
    private lateinit var email: TextView
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        firebaseAuth = FirebaseAuth.getInstance()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
email=view.findViewById(R.id.textView10)
        LogOut=view.findViewById(R.id.textView15)
        var viewmodel= ViewModelProvider(requireActivity()).get(LoggedInViewModel::class.java)
        viewmodel.userMutableLiveData.observe(viewLifecycleOwner, Observer<FirebaseUser>(){
            if (it!=null){
                Toast.makeText(context,"Check Mail", Toast.LENGTH_SHORT).show()
               email.text=it.email
            }
        })
        LogOut.setOnClickListener {
viewmodel.logout()
            //firebaseAuth.signOut()

        }
        viewmodel.loggedOutMutableLiveData.observe(viewLifecycleOwner, Observer<Boolean>() {
            if(it){
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters

    }
}