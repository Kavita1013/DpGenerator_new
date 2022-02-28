package kavita.myappcompany.dpgenerator.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import kavita.myappcompany.dpgenerator.Models.LoginRepo

class LoggedInViewModel: ViewModel() {

    private val repo: LoginRepo = LoginRepo()
    var userMutableLiveData: MutableLiveData<FirebaseUser> = repo.userMutableLiveData
    var loggedOutMutableLiveData: MutableLiveData<Boolean> = repo.loggedOutMutableLiveData

    fun logout(){
        repo.LogOut()
    }
}