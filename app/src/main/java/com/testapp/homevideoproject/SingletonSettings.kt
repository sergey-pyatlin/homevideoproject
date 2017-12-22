package com.testapp.homevideoproject

/**
 * Created by sergey.pyatlin on 06.12.2017.
 */
public class SingletonSettings private constructor(){
    init {println(">>> This ($this) is a singleton")}

    private object Holder {val INSTANCE = SingletonSettings()}

    companion object {
        val instance: SingletonSettings by lazy {Holder.INSTANCE}
    }

    var b:String? = "OpaЖопа"
}