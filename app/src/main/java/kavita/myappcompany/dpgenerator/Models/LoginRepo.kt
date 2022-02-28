package kavita.myappcompany.dpgenerator.Models

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kavita.myappcompany.dpgenerator.Fragments.LoginFragment
import kavita.myappcompany.dpgenerator.Fragments.LoginFragment.Companion.appContext1
import kavita.myappcompany.dpgenerator.Fragments.SignUpFragment
import kavita.myappcompany.dpgenerator.Fragments.SignUpFragment.Companion.appContext
import kavita.myappcompany.dpgenerator.MainActivity2
import kavita.myappcompany.dpgenerator.ViewModels.LoginViewModel
import kavita.myappcompany.dpgenerator.MainActivity as MainActivity1

class LoginRepo() {
//private  var application: Context? = SignUpFragment.appContext
    @SuppressLint("RestrictedApi")
    //private var application: Application? =
  var firebaseAuth: FirebaseAuth=FirebaseAuth.getInstance()
      var userMutableLiveData:MutableLiveData<FirebaseUser> = MutableLiveData<FirebaseUser>()
    var loggedOutMutableLiveData:MutableLiveData<Boolean> = MutableLiveData<Boolean>()
//var status:Boolean=false
    @SuppressLint("RestrictedApi")
    @RequiresApi(Build.VERSION_CODES.P)
    fun Register(email:String, password: String){

firebaseAuth.createUserWithEmailAndPassword(email,password)
    .addOnCompleteListener((getActivity(appContext)!!.application).mainExecutor, OnCompleteListener {
     if(it.isSuccessful){
         SignUpFragment.firebaseAuth.currentUser!!.sendEmailVerification()
         userMutableLiveData.postValue(firebaseAuth.currentUser)
         FirebaseAuth.getInstance().signOut()

     }
        else{
            Toast.makeText(getActivity(appContext)?.application,"Registration Failed"+it.exception?.message,Toast.LENGTH_SHORT).show()
     }
    })
    }
@RequiresApi(Build.VERSION_CODES.P)
@SuppressLint("RestrictedApi")
fun Login(email:String, password: String){
    firebaseAuth.signInWithEmailAndPassword(email,password)
        .addOnCompleteListener((getActivity(appContext1)!!.application).mainExecutor, OnCompleteListener {
            if(it.isSuccessful){

                userMutableLiveData.postValue(firebaseAuth.currentUser)
                LoginFragment.status=true

            }
            else{
                Toast.makeText(getActivity(appContext1)?.application,"Sign In Failed"+it.exception?.message,Toast.LENGTH_SHORT).show()
            }
        })
}
fun LogOut(){
firebaseAuth.signOut()
    loggedOutMutableLiveData.postValue(true)
}

fun Check(){
    if (firebaseAuth.currentUser!=null){
        userMutableLiveData.postValue(firebaseAuth.currentUser)
        loggedOutMutableLiveData.postValue(false)
    }
}

}