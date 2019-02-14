package br.com.ws;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import weblogic.jws.WLHttpTransport;
import weblogic.jws.WSDL;

@WebService(serviceName = "HelloWorldService", targetNamespace="http://www.alsb.com/")
@WLHttpTransport(portName="HelloWorldSoapPort", serviceUri = "HelloWorldServiceTransport")
@WSDL(exposed=true)
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
public class HelloWorldWS {
    private String nome;
    
    @WebMethod(operationName = "setHelloOperation")
    public void setName(@WebParam(name = "nameParam") String nameParam) {
        this.nome = nameParam;
        System.out.println("Method setName invoked. The param value is: " + nameParam );
    }
    
    @WebMethod(operationName = "getHelloOperation")
    public String getHello() {
        System.out.println("Method getName invoked. The param value is: " + this.nome );
        return "Hello2 " + this.nome + " !";
    }      
}
