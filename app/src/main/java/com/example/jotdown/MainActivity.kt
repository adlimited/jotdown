package com.example.jotdown

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import com.example.jotdown.Adapter.ListPersonAdapter
import com.example.jotdown.DBHelper.DBHelper
import com.example.jotdown.DBHelper.DBHelper2
import com.example.jotdown.Model.Person
import com.example.jotdown.databinding.ActivityMainBinding
import com.huawei.agconnect.config.AGConnectServicesConfig
import com.huawei.hms.aaid.HmsInstanceId
import com.huawei.hms.common.ApiException
import com.huawei.hms.hmsscankit.ScanUtil
import com.huawei.hms.hmsscankit.ScanUtil.RESULT
import com.huawei.hms.ml.scan.HmsScan
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    internal lateinit var db: DBHelper
    internal lateinit var db2: DBHelper2
    internal var lstPerson: List<Person> = ArrayList<Person>()
    private lateinit var binding: ActivityMainBinding
    val DEFINED_CODE = 222
    val REQUEST_CODE_SCAN = 111

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = DBHelper(this)
        db2 = DBHelper2(this)
        refreshData()
        getToken()

        val lv = list_persons
        val emptyText = binding.hint
        lv.emptyView = emptyText

        //binding.hint.visibility = View.GONE

        binding.add.setOnClickListener {

            startActivity(Intent(this, Example7Fragment::class.java))
        }

        binding.chip2.setOnClickListener {
            refreshData2()
        }

        binding.chip1.setOnClickListener {
            refreshData()
        }

        binding.qrcode.setOnClickListener {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                this.requestPermissions(
                    arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE),
                    DEFINED_CODE)
            }

        }

    }


    override fun onRequestPermissionsResult(requestCode:Int, permissions:Array<out String>, grantResults:IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.size < 2 || grantResults[0] != PackageManager.PERMISSION_GRANTED || grantResults[1] != PackageManager.PERMISSION_GRANTED) {
            return
        }

        if (requestCode == DEFINED_CODE) {
            // Go to the customized scanning UI DefinedActivity.
            ScanUtil.startScan(this, REQUEST_CODE_SCAN, HmsScanAnalyzerOptions.Creator().create())
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_OK || data == null) {
            return
        }
        //Default View
        if (requestCode == REQUEST_CODE_SCAN) {
            val obj: HmsScan? = data.getParcelableExtra(ScanUtil.RESULT)
            if (obj != null) {
                val intent = Intent(this, DisPlayActivity::class.java)
                intent.putExtra(RESULT, obj)
                startActivity(intent)
            }
        }
    }
    



    private fun refreshData2() {
        lstPerson = db2.allPerson
        val adapter = ListPersonAdapter(this@MainActivity, lstPerson)
        list_persons.adapter = adapter

    }

    private fun refreshData() {
        lstPerson = db.allPerson
        val adapter = ListPersonAdapter(this@MainActivity, lstPerson)
        list_persons.adapter = adapter
    }

    private fun getToken() {
        object : Thread() {
            override fun run() {
                try {
                    val appId =
                        AGConnectServicesConfig.fromContext(this@MainActivity)
                            .getString("client/app_id")
                    val token = HmsInstanceId.getInstance(this@MainActivity)
                        .getToken(appId, "HCM")
                    Log.i("PUSH", "getToken() token: $token")
                } catch (e: ApiException) {
                    Log.e("PUSH", "getToken() failure: " + e.message)
                }
            }
        }.start()
    }

}