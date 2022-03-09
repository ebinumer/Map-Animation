package com.ebinumer.mapanimation.utils

import android.content.Context
import android.graphics.*
import com.ebinumer.mapanimation.R
import com.google.android.gms.maps.model.LatLng
import kotlin.math.abs
import kotlin.math.atan

object MapUtils {

    fun getCarBitmap(context: Context): Bitmap {
        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.ic_car)
        return Bitmap.createScaledBitmap(bitmap, 50, 100, false)
    }

    fun getOriginDestinationMarkerBitmap(): Bitmap {
        val height = 20
        val width = 20
        val bitmap = Bitmap.createBitmap(height, width, Bitmap.Config.RGB_565)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
        canvas.drawRect(0F, 0F, width.toFloat(), height.toFloat(), paint)
        return bitmap
    }

    fun getRotation(start: LatLng, end: LatLng): Float {
        val latDifference: Double = abs(start.latitude - end.latitude)
        val lngDifference: Double = abs(start.longitude - end.longitude)
        var rotation = -1F
        when {
            start.latitude < end.latitude && start.longitude < end.longitude -> {
                rotation = Math.toDegrees(atan(lngDifference / latDifference)).toFloat()
            }
            start.latitude >= end.latitude && start.longitude < end.longitude -> {
                rotation = (90 - Math.toDegrees(atan(lngDifference / latDifference)) + 90).toFloat()
            }
            start.latitude >= end.latitude && start.longitude >= end.longitude -> {
                rotation = (Math.toDegrees(atan(lngDifference / latDifference)) + 180).toFloat()
            }
            start.latitude < end.latitude && start.longitude >= end.longitude -> {
                rotation =
                    (90 - Math.toDegrees(atan(lngDifference / latDifference)) + 270).toFloat()
            }
        }
        return rotation
    }

    /**
     * This function returns the list of locations of Car during the trip i.e. from Origin to Destination
     */
    fun getListOfLocations(): ArrayList<LatLng> {
        val locationList = ArrayList<LatLng>()
        locationList.add(LatLng(9.952335, 76.330216))
        locationList.add(LatLng(9.951363,  76.330774))
        locationList.add(LatLng(9.949883, 76.331719))
        locationList.add(LatLng(9.950940, 76.334897))
        locationList.add(LatLng(9.952166, 76.338418))
        locationList.add(LatLng(9.953387, 76.342022))
        locationList.add(LatLng(9.953937, 76.344255))
        locationList.add(LatLng(9.954444, 76.346102))
        locationList.add(LatLng(9.955078, 76.348764))
        locationList.add(LatLng(9.955163, 76.349881))
        locationList.add(LatLng(9.954064, 76.350396))
        locationList.add(LatLng(9.953134, 76.350911))
        return locationList
    }

}