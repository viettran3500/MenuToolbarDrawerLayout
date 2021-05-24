package com.viet.menutoolbardrawerlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationIcon(R.drawable.menu_512)
        toolbar.logo = getDrawable(R.mipmap.ic_launcher)
        toolbar.setNavigationOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }

        tv1.setOnClickListener {

        }
        tv2.setOnClickListener {
            drawer.closeDrawers()
            startActivity(Intent(this, Main2Activity::class.java))
        }
        tv3.setOnClickListener {
            drawer.closeDrawers()
            startActivity(Intent(this, Main3Activity::class.java))
        }

        registerForContextMenu(tv)

        btnPopup.setOnClickListener {
            var popupMenu = PopupMenu(this, btnPopup)
            popupMenu.menuInflater.inflate(R.menu.menu3, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                if (item != null) {
                    when(item.itemId){
                        R.id.popup1-> Toast.makeText(this, "Popup Menu", Toast.LENGTH_SHORT).show()
                        R.id.popup2-> Toast.makeText(this, "Popup Menu", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            })
            popupMenu.show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.help-> Toast.makeText(this, "Option Menu", Toast.LENGTH_SHORT).show()
            R.id.new_game-> Toast.makeText(this, "Option Menu", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        var inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu2, menu);
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.edit-> {
                Toast.makeText(this, "Context Menu", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.delete-> {
                Toast.makeText(this, "Context Menu", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}
