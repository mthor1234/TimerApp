package mjthornton.com.timerapp.util

import android.content.Context
import android.preference.PreferenceManager
import mjthornton.com.timerapp.TimerActivity

/**
 * Created by mitchthornton on 9/3/18.
 */
class PrefUtil {
    companion object {

        fun getTimerLength(context: Context): Int{

            // PlaceHolder
            return 1
        }

        private const val PREVIOUS_TIMER_LENGTH_SECONDS_ID =   "com.mjthornton.timer.previous_timer_length_seconds"

        fun getPreviousTimerLengthSeconds(context:Context) : Long{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getLong(PREVIOUS_TIMER_LENGTH_SECONDS_ID, 0)

        }

        fun setPreviousTimerLengthSeconds(seconds : Long, context : Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putLong(PREVIOUS_TIMER_LENGTH_SECONDS_ID, seconds)
        }

        private const val TIMER_STATE_ID =   "com.mjthornton.timer.timer_state"

        fun getTimerState(context:Context) : TimerActivity.TimerState{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            val ordinal =  preferences.getInt(TIMER_STATE_ID, 0)
            return TimerActivity.TimerState.values()[ordinal]
        }

        fun setTimerState(state : TimerActivity.TimerState, context : Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            val ordinal = state.ordinal
            editor.putInt(TIMER_STATE_ID, ordinal)
            editor.apply()
        }

        private const val SECONDS_REMAINING_ID =   "com.mjthornton.timer.seconds_remaining"

        fun getSecondsRemaining(context:Context) : Long{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getLong(SECONDS_REMAINING_ID, 0)
        }

        fun setSecondsRemaining(secondsRemaining : Long, context : Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putLong(SECONDS_REMAINING_ID, secondsRemaining)
            editor.apply()
        }

    }

}