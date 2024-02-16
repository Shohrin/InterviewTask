package com.fininfo.interviewtask.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.fininfo.interviewtask.R
import com.fininfo.interviewtask.objmodel.UserInfo
import com.fininfo.interviewtask.util.Constants
import io.realm.Realm
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        insertDummyUserData()
        initViews()
    }

    /**
     * below function is use to insert dummy data into Realm database
     */
    private fun insertDummyUserData() {
        //below is to inser dummy data inro realm database

        val userInfoList = ArrayList<UserInfo>()
        userInfoList.add(UserInfo("Deepthie", 35, "Hyderabad"))
        userInfoList.add(UserInfo("Dillesh", 54, "Orisa"))
        userInfoList.add(UserInfo("Amulya", 20, "Nizamabad"))
        userInfoList.add(UserInfo("Harika", 22, "Ongole"))
        userInfoList.add(UserInfo("Satvika", 30, "VijatWada"))
        userInfoList.add(UserInfo("Vaishnavi", 56, "Karnul"))
        userInfoList.add(UserInfo("Vibha", 21, "Nagpur"))
        userInfoList.add(UserInfo("Monika", 32, "Pune"))
        userInfoList.add(UserInfo("Bhavani", 36, "Raipur"))
        userInfoList.add(UserInfo("BhagyaShree", 45, "Surat"))
        userInfoList.add(UserInfo("Gunjan", 60, "Mumbai"))
        userInfoList.add(UserInfo("Priya", 87, "Kolhapur"))


        var realm: Realm = Realm.getDefaultInstance()
        for (i in userInfoList) {
            realm.executeTransaction {
                try {
                    realm.insert(i)
                } catch (e: Exception) {
                   e.printStackTrace()
                }
            }
        }


    }

    /**
     * This function is use to initialize UI element and handling validations for the same
     */

    private fun initViews() {
        val etForUserName = findViewById<EditText>(R.id.etUserName)
        val etForPassword = findViewById<EditText>(R.id.etUserPassword)

        val userName = etForUserName.text
        val passWord = etForPassword.text

        val USER_NAME_REGAX = Pattern.compile(Constants.USERNAME_REGAX).toRegex()
        val PASSWORD_REGAX =
            Pattern.compile(Constants.PASSWORD_REGAX).toRegex()


        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {

            if (!USER_NAME_REGAX.matches(userName)) {
                etForUserName.setError(getString(R.string.user_name_error))
            } else if (!PASSWORD_REGAX.matches(passWord)) {
                etForPassword.setError(getString(R.string.password_hint))
            } else {

                val sharedPreferences = getSharedPreferences(
                    Constants.USER_LOGIN_DETSILS,
                    MODE_PRIVATE
                )
                var editor = sharedPreferences.edit()
                editor.putBoolean(Constants.ONE_TIME_LOGIN_DETAILS, true)
                editor.commit()


                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }
}