package kavita.myappcompany.dpgenerator.ViewModels

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import kavita.myappcompany.dpgenerator.Models.LoginRepo

class LoginViewModel(): ViewModel(){
    var TAG="LoginViewModel"
   private  var  application: Application
    init {
        this.application= Application()
    }

    private val repo: LoginRepo = LoginRepo()
  var UserMutableLiveData: MutableLiveData<FirebaseUser> = repo.userMutableLiveData


    /*fun LoginViewModel( application : Application)
    {
       this.application=application
      //UserMutableLiveData=repo.userMutableLiveData
    }*/

    @RequiresApi(Build.VERSION_CODES.P)
    fun register(email:String, password:String){

        repo.Register(email, password)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun login(email: String, password: String){
        repo.Login(email, password)
    }
}