package com.example.creatuser

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class userViewModel :ViewModel(){
   var userName = MutableLiveData<String>()     //live data: negahdarande etelaat ke companent hai app mitavanand an ra observe konand va  be mahz taghir dar dadeha copmponentha ra refresh konand.  // mutablelivedata: dadehai ghabele taghir
    var password = MutableLiveData<String>()


    private var userMutableLiveData:MutableLiveData<userModel>? = null  //

        //metod barai get user
        fun getUser():MutableLiveData<userModel>?{
            if (userMutableLiveData ==null){//agar userMutableLiveData null bood an ra meghdardehi konad va dar gheir in sorat ham ra rutern konad
                userMutableLiveData =   MutableLiveData<userModel>()
        }
            return   userMutableLiveData
        }

        fun onClick(view :View?){  //
            val loginUser = userModel(userName.value.toString(),password.value.toString())
            userMutableLiveData?.value = loginUser
        }

}