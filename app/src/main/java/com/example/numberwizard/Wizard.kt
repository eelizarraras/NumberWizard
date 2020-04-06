package com.example.numberwizard
import android.util.Log

class Wizard {
   private var pivot : Int = 0
   private var firstIndex: Int = 1
   private var lastIndex : Int = 1000
   private var action: String = ""

    //Todo: establecer una lista que guarde la lista de numero disponibles para calcular
    init{
        Log.d("TAG","llamando a calculateMidlePoint" )
        calculateMidlePoint(1, 1000)
    }

//this function set the points
    public fun setIndices(action: String){
       if(action.equals("restart")){
           firstIndex = 1
           lastIndex = 1000
       }else  if (action.equals("up")){
           firstIndex = pivot
           Log.d("TAG-UP","firstIndex: "+firstIndex+ " lastIndex: "+lastIndex )
           calculateMidlePoint(firstIndex,lastIndex)
       }else if (action.equals("down")){
           lastIndex = pivot
           Log.d("TAG-DOWN","firstIndex: "+firstIndex+ " lastIndex: "+lastIndex )
           calculateMidlePoint(firstIndex,lastIndex)
       }
    }
//this function set the midle point
    public fun calculateMidlePoint(pointA: Int, pointB: Int){
        pivot = (pointA..pointB).shuffled().first().toInt()
        Log.d("TAG","resultado calculateMidlePoint " + pivot )
    }

    public fun getPivot(): Int {
        Log.d("TAG","resultado de pivot " + pivot)
        return pivot
    }

    public fun indexesAreEquals(): Boolean{
        return firstIndex == lastIndex
    }

    public fun restart(){
        calculateMidlePoint(1,1000)
        Log.d("TAG","nuevo pivot " + pivot)
        setIndices("restart")
    }

}