package com.sise.abner.abaselib.util

import android.graphics.Bitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder


/**
 * Created by Abner on 2018/3/2.
 */
class ZxingUtils {
    companion object {

        fun createBitmap(str: String): Bitmap? {
            var bitmap: Bitmap? = null
            var result: BitMatrix? = null
            val multiFormatWriter = MultiFormatWriter()
            try {
                result = multiFormatWriter.encode(str, BarcodeFormat.QR_CODE, 400, 400)
                val barcodeEncoder = BarcodeEncoder()
                bitmap = barcodeEncoder.createBitmap(result!!)
            } catch (e: WriterException) {
                e.printStackTrace()
            } catch (iae: IllegalArgumentException) { // ?
                return null
            }

            return bitmap
        }
    }
}