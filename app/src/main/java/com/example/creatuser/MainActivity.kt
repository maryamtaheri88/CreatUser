package com.example.creatuser


import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.creatuser.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var prefs:SharedPreferences

    val fullNameKey ="fullNameKey"
    val userNameKey ="userNameKey"
    val emailKey ="emailKey"
    val passwordKey ="passwordKey"
    val repasswordKey ="repasswordKey"
    val genderfKey ="genderKey"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs=getSharedPreferences("preference", MODE_PRIVATE)
        listener()
    }

    private fun listener() {
        binding.buttonRegister.setOnClickListener{
            var fullName=binding.editName.text.toString()  //texi ke daroon edittext hast ra daroone fullname mirizim
            var username = binding.edituserName.text.toString()
            var email = binding.editemailAddress.text.toString()
            var password = binding.editPassword.text.toString()
            var repassword = binding.buttonRegister.text.toString()
            var genderf = binding.radioButtonFemale.isClickable

            var editor:SharedPreferences.Editor = prefs.edit()  //barai kar ba dadeha dar shareperferencese bayad yek editor besazim
            editor.putString(fullNameKey,fullName)   //barai ezafe kardane dade  dar shareperfernces az dastor put estefade mikonim m noe dadei ke mikhahim estefade konim ro bayad hatman moshakhas konim.
            editor.putString(userNameKey,username)  // agar var ma az noe Int bood: editor.putLong(nationalCodekey,nationalode.toLong())
            editor.putString(emailKey,email)
            editor.putString(passwordKey,password)
            editor.putString(repasswordKey,repassword)
            editor.putBoolean(genderfKey,genderf)
            editor.apply() // taghirat ra taiid mikonad

            Toast.makeText(this,"Data saved.",Toast.LENGTH_SHORT).show()
       }

        binding.buttonShowInfo.setOnClickListener{
             binding.fullName.text = prefs.getString(fullNameKey, " name???")
             binding.userName.text = prefs.getString(userNameKey, " username???")
             binding.email.text = prefs.getString(emailKey, " email???")
             binding.password.text = prefs.getString(passwordKey, "password???")
             binding.gendar.text = prefs.getString(genderfKey, " gender???")
        }

        binding.buttonRemoveInfo.setOnClickListener {

        }


//        binding.buttonShowInfo.setOnClickListener {
//        var data ="FullName:${prefs.getString(fullNameKey,null)}\n UserName:${prefs.getString(userNameKey,null)}\n " +
//                "Email:${prefs.getString(emailKey,null)}"
//           Toast.makeText(this,data,Toast.LENGTH_LONG).show()
//        }


    }
}