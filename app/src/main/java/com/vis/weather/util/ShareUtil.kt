/*
 * Copyright (C) 2013 litesuits.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.vis.weather.util

import android.content.Context
import android.content.SharedPreferences
import android.util.Base64
import android.util.Log
import java.io.*


/**

 */
class ShareUtil(internal var context:


                Context?) {
    internal var name = "veather"

    /**
     * 存储boolean类型的值

     * @param key
     * *
     * @param value
     * *
     * @return
     */
    fun put(key: String, value: Boolean) {
        val sp = this.context!!.getSharedPreferences(this.name, Context.MODE_PRIVATE)

        sp.edit().putBoolean(key, value).commit()

    }

    /**
     * 获取boolean值

     * @param key
     * *
     * @param defValue
     * *
     * @return String
     */
    operator fun get(key: String, defValue: Boolean): Boolean {
        val sp = this.context!!.getSharedPreferences(this.name, Context.MODE_PRIVATE)
        return sp.getBoolean(key, defValue)
    }


    /**
     * 存储String类型的值

     * @param key
     * *
     * @param value
     * *
     * @return
     */
    fun put(key: String, value: String?) {
        val sp = this.context!!.getSharedPreferences(this.name, Context.MODE_PRIVATE)
        if (value == null) {
            sp.edit().remove(key).commit()
        } else {
            sp.edit().putString(key, value).commit()
        }
    }


    /**
     * 获取String值

     * @param key
     * *
     * @param defValue
     * *
     * @return String
     */
    operator fun get(key: String, defValue: String): String {
        val sp = this.context!!.getSharedPreferences(this.name, Context.MODE_PRIVATE)
        return sp.getString(key, defValue)
}

    /**
     * 根据key和预期的value类型获取value的值

     * @param key
     * *
     * @param clazz
     * *
     * @return
     */
    fun <T> getValue(key: String, clazz: Class<T>): T? {
        if (context == null) {
            throw RuntimeException("请先调用带有context，name参数的构造！")
        }
        val sp = this.context!!.getSharedPreferences(this.name, Context.MODE_PRIVATE)
        return getValue(key, clazz, sp)
    }


    /**
     * 针对复杂类型存储

     * @param key
     * *
     * @param object
     */
    fun putObject(key: String, `object`: Any) {
        val sp = this.context!!.getSharedPreferences(this.name, Context.MODE_PRIVATE)

        val baos = ByteArrayOutputStream()
        var out: ObjectOutputStream? = null
        try {

            out = ObjectOutputStream(baos)
            out.writeObject(`object`)
            val objectVal = String(Base64.encode(baos.toByteArray(), Base64.DEFAULT))
            val editor = sp.edit()
            editor.putString(key, objectVal)
            editor.commit()

        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                baos?.close()
                if (out != null) {
                    out.close()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
    }

    @SuppressWarnings("unchecked")
    fun <T> getObject(key: String, clazz: Class<T>): T? {
        val sp = this.context!!.getSharedPreferences(this.name, Context.MODE_PRIVATE)
        if (sp.contains(key)) {
            val objectVal = sp.getString(key, null)
            val buffer = Base64.decode(objectVal, Base64.DEFAULT)
            val bais = ByteArrayInputStream(buffer)
            var ois: ObjectInputStream? = null
            try {
                ois = ObjectInputStream(bais)
                val t = ois.readObject() as T
                return t
            } catch (e: StreamCorruptedException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } finally {
                try {
                    bais?.close()
                    if (ois != null) {
                        ois.close()
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
        }
        return null
    }


    @SuppressWarnings("unchecked")
    fun <T> getObject(key: String, clazz: List<T>): List<T>? {
        val sp = this.context!!.getSharedPreferences(this.name, Context.MODE_PRIVATE)
        if (sp.contains(key)) {
            val objectVal = sp.getString(key, null)
            val buffer = Base64.decode(objectVal, Base64.DEFAULT)
            val bais = ByteArrayInputStream(buffer)
            var ois: ObjectInputStream? = null
            try {
                ois = ObjectInputStream(bais)
                val t = ois.readObject() as List<T>
                return t
            } catch (e: StreamCorruptedException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } finally {
                try {
                    bais?.close()
                    if (ois != null) {
                        ois.close()
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
        }
        return null
    }


    /**
     * 对于外部不可见的过渡方法

     * @param key
     * *
     * @param clazz
     * *
     * @param sp
     * *
     * @return
     */
    @SuppressWarnings("unchecked")
    private fun <T> getValue(key: String, clazz: Class<T>, sp: SharedPreferences): T? {
        val t: T
        try {

            t = clazz.newInstance()

            if (t is Int) {
                return Integer.valueOf(sp.getInt(key, 0)) as T
            } else if (t is String) {
                return sp.getString(key, "") as T
            } else if (t is Boolean) {
                return java.lang.Boolean.valueOf(sp.getBoolean(key, false)) as T
            } else if (t is Long) {
                return java.lang.Long.valueOf(sp.getLong(key, 0L)) as T
            } else if (t is Float) {
                return java.lang.Float.valueOf(sp.getFloat(key, 0f)) as T
            }
        } catch (e: InstantiationException) {
            e.printStackTrace()
            Log.e("system", "类型输入错误或者复杂类型无法解析[" + e.message + "]")
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
            Log.e("system", "类型输入错误或者复杂类型无法解析[" + e.message + "]")
        }

        Log.e("system", "无法找到" + key + "对应的值")
        return null
    }
}
