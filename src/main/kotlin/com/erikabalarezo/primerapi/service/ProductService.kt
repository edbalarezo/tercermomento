package com.erikabalarezo.primerapi.service

import org.springframework.stereotype.Service

@Service
class ProductService {
    fun validateSerialNumber (serial:String?): Boolean? {

        serial.takeIf { !it?.trim().isNullOrEmpty() }
                ?: throw Exception()

        if (serial?.substring(0, 3).equals("786"))
            return true

        return false


    }

    fun multiplicacion (coeficiente: Int, digito: Int): Int {
        val response= coeficiente*digito
        if(response>=10){
            return response-9
        }
        return response
    }


    fun sumaValores(nui: String):Long{

        var sum:Long=0
        for ( i in 0..8){
            val coeficiente = if( i % 2 ==0) 2 else 1
            sum  += multiplicacion(coeficiente,Integer.parseInt(nui[i].toString()) )
        }
        return sum
    }

    fun findDecenaSuperior (sum: Int): Int { // buscar la decena superior

        val division:Int = sum/10
        val decenaSuperior :Int = (division+1) * 10
        var response:Int=decenaSuperior-sum
        if (response==10)
            response=0
        return response


    }

    fun ultimoDigito(cedula:String):Int {
        val ultimo=cedula.last().toString()
        val response= Integer.parseInt(ultimo)
        return response
    }

    fun validarTotal(cedula: String):Boolean{
        val suma=sumaValores(cedula).toInt()
        val resto=findDecenaSuperior(suma)
        val ultimoDigito=ultimoDigito(cedula)

        return resto ==ultimoDigito

    }
}


    /*lateinit var pagoRepository: PagoRepository

    fun save (pago: Pago):Pago?{
        return pagoRepository.save(pago)
    }
    fun formatoPlaca(placa:String):Boolean{
        var response: Boolean= false
        if (placa.length==8){
            val arrayPlaca=placa.toCharArray()
            if (arrayPlaca[3]=='-'){
                response=true
            }
        }
        // El cuarto caracter siempre es "-"
        // No debe tener mas de ocho caracteres
        return response
    }

    fun getProvincia(placa:String):String{
        val placaValida: Boolean = formatoPlaca(placa)
        var prov: String="error"
        if (placaValida==true){
            val arrayPlaca=placa.toCharArray()
            if (arrayPlaca[0]=='A'){
                prov= "A"
            } else if (arrayPlaca[0]=='P'){
                prov="P"
            } else if (arrayPlaca[0]=='G'){
                prov="G"
            } else if (arrayPlaca[0]=='C'){
                prov="C"
            }
            } else if (arrayPlaca[0]=='L'){
            prov="L"


        }

        return prov
    }

    fun getPagoBase(placa:String ): Int {
        val prov: String=getProvincia(placa)
        var pago:Int=0
        if (prov!="error"){
            if (prov=="A"){
                pago=45
            }else if (prov=="P"){
                pago=55
            }else if (prov=="G"){
                pago=65
            }else if (prov=="C"){
                pago=35
            }
            else if (prov=="L") {
                pago = 35
            }
        }
        //getProvincia()
        //if (provincia=="A")
        //return 50
        return pago
    }

    fun getPagoContaminacion(placa:String, anio: Long ):Long{
        val pagoBase:Int = getPagoBase(placa)
        var pagoTotal:Long=0
        val anioCont=2022-anio
        if (pagoBase!=0){
            if (anioCont>5){
                pagoTotal=pagoBase.toLong()+10
            }else if (anioCont in 0..5){
                pagoTotal=pagoBase.toLong()
                return pagoTotal
            }
        }
        //val pagoBase=getPagoBase()
        //if ((2022-anio) > 5)
        //return pagoBase+10
        return pagoTotal

}*/
