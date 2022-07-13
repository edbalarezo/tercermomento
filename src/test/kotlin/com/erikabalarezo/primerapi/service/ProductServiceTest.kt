package com.erikabalarezo.primerapi.service
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTest {
    @Autowired
    lateinit var productService: ProductService


    @Test
    fun validateSerialIsInvalid(){
        val response =  productService.validateSerialNumber("47856958")
        Assertions.assertEquals(false,response)
    }

    @Test
    fun validateSerialIsBlank(){
        Assertions.assertThrows(Exception::class.java) {
            val response = productService.validateSerialNumber("")

        }
    }

    @Test
    fun validateSerialIsincomplete(){
        Assertions.assertThrows(Exception::class.java) {
            val response = productService.validateSerialNumber("1")

        }
    }

    @Test
    fun multiplicacionWhenLessThanTen (){
        val response= productService.multiplicacion(1,7)
        Assertions.assertEquals(7,response)
    }

    @Test
    fun multiplicacionWhenMajorLessThanTen (){
        val response= productService.multiplicacion(2,7)
        Assertions.assertEquals(5,response)
    }
    @Test
    fun validarSumaNui (){
        val response=productService.sumaValores("0301707030")
        Assertions.assertEquals(20,response)
    }
    @Test
    fun validarDecenaSuperiorCuandoNoesCero (){
        val response=productService.findDecenaSuperior(13)
        Assertions.assertEquals(7,response)
    }
    @Test
    fun validarDecenaSuperiorCuandoesCero (){
        val response=productService.findDecenaSuperior(80)
        Assertions.assertEquals(0,response)
    }

    @Test
    fun ultimoDigito (){
        val response=productService.ultimoDigito("0106430044")
        Assertions.assertEquals(4,response)
    }

    @Test
    fun ultimoDiigitoCedulaValid (){
        val response=productService.validarTotal("0106430044")
        Assertions.assertEquals(true,response)
    }
    @Test
    fun ultimoDigitInvalid (){
        val response=productService.validarTotal("0106430048")
        Assertions.assertEquals(false,response)
    }

    /*@Autowired
    lateinit var productService: ProductService

    @Test
    fun formatoPlacaValida(){
        val response = productService.formatoPlaca("AGD-0777")
        Assertions.assertEquals(true,response)
    }
    @Test
    fun formatoPlacaInValida(){
        val response = productService.formatoPlaca("AGDP-7788")
        Assertions.assertEquals(false,response)
    }
    @Test
    fun provinciaValida(){
        val response = productService.getProvincia("AAB-2478")
        Assertions.assertEquals("A",response)
    }
    @Test
    fun provinciaInvalida(){
        val response = productService.getProvincia("BAB-2474")
        Assertions.assertEquals("error",response)
    }
    @Test
    fun pagoBaseCorrecto(){
        val response=productService.getPagoBase("ABB-1827")
        Assertions.assertEquals(45,response)
    }

    @Test
    fun pagoBaseCorrectoProv(){
        val response=productService.getPagoBase("CBB-1827")
        Assertions.assertEquals(35,response)
    }

    @Test
    fun pagoBaseIncorrecto(){
        val response=productService.getPagoBase("BBB-1828")
        Assertions.assertEquals(0,response)
    }
    @Test
    fun pagoBaseContaminaCorrecto(){
        val response=productService.getPagoContaminacion("ABB-1827",2002)
        Assertions.assertEquals(55,response)
    }
    @Test
    fun pagoBaseContaminaIncorrecto(){
        val response=productService.getPagoContaminacion("ABB-1827",2022)
        Assertions.assertEquals(45,response)
    }
    @Test
    fun pagoBaseContaminaCorrectoCarchi(){
        val response=productService.getPagoContaminacion("CBB-1827",2015)
        Assertions.assertEquals(45,response)
    }

    @Test
    fun pagoBaseContaminaCorrectoLoja(){
        val response=productService.getPagoContaminacion("LBB-1827",2012)
        Assertions.assertEquals(45,response)
    }*/


}

