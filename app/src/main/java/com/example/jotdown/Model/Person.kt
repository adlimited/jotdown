package com.example.jotdown.Model

class Person {

    var id:Int=0
    var name:String?=null
    var email:String?=null
    var sdate:String?=null

    constructor(){}

    constructor(id:Int,name:String,email:String,sdate:String)
    {
        this.id=id
        this.name=name
        this.email=email
        this.sdate=sdate
    }

}