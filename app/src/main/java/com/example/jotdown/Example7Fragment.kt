package com.example.jotdown

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.jotdown.Adapter.ListPersonAdapter
import com.example.jotdown.DBHelper.DBHelper
import com.example.jotdown.Model.Date
import com.example.jotdown.Model.Person
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import com.kizitonwose.calendarview.utils.Size
import kotlinx.android.synthetic.main.example_7_fragment.*
import com.example.jotdown.databinding.Example7CalendarDayBinding
import com.example.jotdown.databinding.Example7FragmentBinding
import com.huawei.hms.ads.AdParam
import com.huawei.hms.ads.BannerAdSize
import com.huawei.hms.ads.HwAds
import com.huawei.hms.ads.banner.BannerView
import kotlinx.android.synthetic.main.activity_add.*

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class Example7Fragment : AppCompatActivity() {

    internal var selectedDate = LocalDate.now()

    private val dateFormatter = DateTimeFormatter.ofPattern("dd")
    private val dayFormatter = DateTimeFormatter.ofPattern("EEE")
    private val monthFormatter = DateTimeFormatter.ofPattern("MMM")

    private lateinit var binding: Example7FragmentBinding

    internal lateinit var db: DBHelper
    internal var lstPerson: List<Person> = ArrayList<Person>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Example7FragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DBHelper(this)


        val dm = DisplayMetrics()
        val wm = getSystemService(WINDOW_SERVICE) as WindowManager
        wm.defaultDisplay.getMetrics(dm)



        HwAds.init(this)

        val bottomBannerView = findViewById<BannerView>(R.id.hw_banner_view)
        val adParam = AdParam.Builder().build()
        bottomBannerView.adId = "testw6vs28auh3"
        bottomBannerView.bannerAdSize = BannerAdSize.BANNER_SIZE_SMART
        bottomBannerView.loadAd(adParam)


        binding.add.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }



        binding.add.setOnClickListener {

            val sdate = selectedDate.toString()
            val intent = Intent(this, AddActivity::class.java)
            //startActivity(Intent(this, AddActivity::class.java))
            intent.putExtra(AddActivity.SDATE, sdate)
            startActivity(intent)
            finish()

        }




        binding.exSevenCalendar.apply {
            val dayWidth = dm.widthPixels / 5
            val dayHeight = (dayWidth * 1.25).toInt()
            daySize = Size(dayWidth, dayHeight)
        }

        class DayViewContainer(view: View) : ViewContainer(view) {
            val bind = Example7CalendarDayBinding.bind(view)
            lateinit var day: CalendarDay

            init {
                view.setOnClickListener {
                    val firstDay = binding.exSevenCalendar.findFirstVisibleDay()
                    val lastDay = binding.exSevenCalendar.findLastVisibleDay()
                    if (firstDay == day) {
                        // If the first date on screen was clicked, we scroll to the date to ensure
                        // it is fully visible if it was partially off the screen when clicked.
                        binding.exSevenCalendar.smoothScrollToDate(day.date)
                    } else if (lastDay == day) {
                        // If the last date was clicked, we scroll to 4 days ago, this forces the
                        // clicked date to be fully visible if it was partially off the screen.
                        // We scroll to 4 days ago because we show max of five days on the screen
                        // so scrolling to 4 days ago brings the clicked date into full visibility
                        // at the end of the calendar view.
                        binding.exSevenCalendar.smoothScrollToDate(day.date.minusDays(4))
                    }

                    // Example: If you want the clicked date to always be centered on the screen,
                    // you would use: exSevenCalendar.smoothScrollToDate(day.date.minusDays(2))

                    if (selectedDate != day.date) {
                        val oldDate = selectedDate
                        selectedDate = day.date

                        //val date = Date(selectedDate.toString())
                        //db.passdate(date)

                        binding.exSevenCalendar.notifyDateChanged(day.date)
                        oldDate?.let { binding.exSevenCalendar.notifyDateChanged(it) }

                    }
                }
            }


            fun bind(day: CalendarDay) {
                this.day = day
                bind.exSevenDateText.text = dateFormatter.format(day.date)
                bind.exSevenDayText.text = dayFormatter.format(day.date)
                bind.exSevenMonthText.text = monthFormatter.format(day.date)

                bind.exSevenDateText.setTextColor(view.context.getColorCompat(if (day.date == selectedDate) R.color.blue else R.color.example_4_grey))
                bind.exSevenSelectedView.isVisible = day.date == selectedDate


                if (day.date == selectedDate) {

                    Date(selectedDate.toString())
                    /* val selectQuery = "SELECT * FROM ${DBHelper.TABLE_NAME} WHERE ${DBHelper.SDATE} = '$selectedDate'"
                     DBHelper.selectQuery = selectQuery

                     */
                    //Toast.makeText(applicationContext, sdate, Toast.LENGTH_LONG).show()
                }


            }
        }

        binding.exSevenCalendar.dayBinder = object : DayBinder<DayViewContainer> {
            override fun create(view: View) = DayViewContainer(view)
            override fun bind(container: DayViewContainer, day: CalendarDay) = container.bind(day)
        }

        val currentMonth = YearMonth.now()
        // Value for firstDayOfWeek does not matter since inDates and outDates are not generated.
        binding.exSevenCalendar.setup(
            currentMonth,
            currentMonth.plusMonths(3),
            DayOfWeek.values().random()
        )
        binding.exSevenCalendar.scrollToDate(LocalDate.now())

    }

    private fun refreshData() {
        lstPerson = db.allPerson
        val adapter = ListPersonAdapter(this@Example7Fragment, lstPerson)
        // list_persons.adapter = adapter
    }


}
