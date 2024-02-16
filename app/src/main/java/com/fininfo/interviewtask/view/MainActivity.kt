package com.fininfo.interviewtask.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fininfo.interviewtask.R
import com.fininfo.interviewtask.adapter.UserListAdapter
import com.fininfo.interviewtask.objmodel.UserInfo
import io.realm.Realm

class MainActivity : AppCompatActivity() {
    lateinit var rlPopupMenu: RelativeLayout
    lateinit var rvForUserList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayUserList()
    }

    /**
     * The private function is used to initialize UI components, fetch the data from Realm database and display.
     */
    private fun displayUserList() {

        //setting up the custom action bar
        val myToolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.tbUserList);
        setSupportActionBar(myToolbar);

        //Realm database initialization and fetching user data
        val realm = Realm.getDefaultInstance()
        val tUsersListFromDb = realm.where(UserInfo::class.java).findAll()
        val tUsersArrayList = ArrayList<UserInfo>()
        tUsersArrayList.addAll(tUsersListFromDb)

        //recycler view initialization and setting custom adapter with users data
        rvForUserList = findViewById<RecyclerView>(R.id.rvUserList)
        rvForUserList.layoutManager = LinearLayoutManager(this)
        val mUserListAdapter = UserListAdapter(tUsersArrayList)
        rvForUserList.adapter = mUserListAdapter
        mUserListAdapter.notifyDataSetChanged()

        //Option menu for sorting using name, age, city
        rlPopupMenu = findViewById(R.id.rlPopupMenu)

        createOptionMenuForSorting(tUsersArrayList)
    }

    /**
     * this function is use to create option menu for sorting and handling click events for the same
     */
    private fun createOptionMenuForSorting(tUsersArrayList: ArrayList<UserInfo>) {
        rlPopupMenu.setOnClickListener {
            val popupMenu = PopupMenu(this, rlPopupMenu)
            popupMenu.menu.add(R.string.sort_by_name)
            popupMenu.menu.add(R.string.sort_by_age)
            popupMenu.menu.add(R.string.sort_by_city)

            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when (item.title.toString()) {
                    getString(R.string.sort_by_name) ->
                        sortListByName(tUsersArrayList)
                    getString(R.string.sort_by_age) ->
                        sortListByAge(tUsersArrayList)
                    getString(R.string.sort_by_city) ->
                        sortListByCity(tUsersArrayList)
                }
                true
            })
            popupMenu.show()
        }

    }

    /**
     * This function is use to sort the users list according to city in ascending order.
     */
    private fun sortListByCity(mUserList: ArrayList<UserInfo>) {
        var sortedUsersListWithCity =
            mUserList.sortedWith(compareBy({ it.city.toString().toLowerCase() }))
        val sortedUsersArrayListWithCity = ArrayList<UserInfo>();
        sortedUsersArrayListWithCity.addAll(sortedUsersListWithCity)
        val mUserListAdapter = UserListAdapter(sortedUsersArrayListWithCity)
        rvForUserList?.adapter = mUserListAdapter
        mUserListAdapter.notifyDataSetChanged()

    }

    /**
     * This function is use to sort the users list according to age in ascending order.
     */
    private fun sortListByAge(
        mUserList: java.util.ArrayList<UserInfo>
    ) {
        var sortedUsersListWithAge = mUserList.sortedWith(compareBy({ it.age }))
        val sortedArrayListWithCity = ArrayList<UserInfo>();
        sortedArrayListWithCity.addAll(sortedUsersListWithAge)
        val mUserListAdapter = UserListAdapter(sortedArrayListWithCity)
        rvForUserList?.adapter = mUserListAdapter
        mUserListAdapter.notifyDataSetChanged()
    }

    /**
     * This function is use to sort the users list according to name in ascending order.
     */
    private fun sortListByName(mUserList: ArrayList<UserInfo>) {
        var sortedUsersListWithName = mUserList.sortedWith(compareBy({ it.name }))
        val sortedUsersArrayListWithName = ArrayList<UserInfo>();
        sortedUsersArrayListWithName.addAll(sortedUsersListWithName)
        val mUserListAdapter = UserListAdapter(sortedUsersArrayListWithName)
        rvForUserList.adapter = mUserListAdapter
        mUserListAdapter.notifyDataSetChanged()
    }
}