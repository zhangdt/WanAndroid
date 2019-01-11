package com.sise.abner.abaselib.util

class PhoneCheckUtil {
    companion object {
        fun phoneCheck(mobiles:String):Boolean
        {
            if (mobiles.isEmpty()) return false
            val telRegex = "[1][358]\\d{9}" //"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
            return mobiles.matches(telRegex.toRegex())
        }
    }
}